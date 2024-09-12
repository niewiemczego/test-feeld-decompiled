package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class RtpVp8Reader implements RtpPayloadReader {
    private static final long MEDIA_CLOCK_FREQUENCY = 90000;
    private static final String TAG = "RtpVP8Reader";
    private long firstReceivedTimestamp = C.TIME_UNSET;
    private int fragmentedSampleSizeBytes = -1;
    private long fragmentedSampleTimeUs = C.TIME_UNSET;
    private boolean gotFirstPacketOfVp8Frame = false;
    private boolean isKeyFrame = false;
    private boolean isOutputFormatSet = false;
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber = -1;
    private long startTimeOffsetUs = 0;
    private TrackOutput trackOutput;

    public RtpVp8Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 2);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void onReceivingFirstPacket(long j, int i) {
        Assertions.checkState(this.firstReceivedTimestamp == C.TIME_UNSET);
        this.firstReceivedTimestamp = j;
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        Assertions.checkStateNotNull(this.trackOutput);
        if (validateVp8Descriptor(parsableByteArray, i)) {
            if (this.fragmentedSampleSizeBytes == -1 && this.gotFirstPacketOfVp8Frame) {
                this.isKeyFrame = (parsableByteArray.peekUnsignedByte() & 1) == 0;
            }
            if (!this.isOutputFormatSet) {
                int position = parsableByteArray.getPosition();
                parsableByteArray.setPosition(position + 6);
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort() & 16383;
                int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort() & 16383;
                parsableByteArray.setPosition(position);
                if (!(readLittleEndianUnsignedShort == this.payloadFormat.format.width && readLittleEndianUnsignedShort2 == this.payloadFormat.format.height)) {
                    this.trackOutput.format(this.payloadFormat.format.buildUpon().setWidth(readLittleEndianUnsignedShort).setHeight(readLittleEndianUnsignedShort2).build());
                }
                this.isOutputFormatSet = true;
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            this.trackOutput.sampleData(parsableByteArray, bytesLeft);
            int i2 = this.fragmentedSampleSizeBytes;
            if (i2 == -1) {
                this.fragmentedSampleSizeBytes = bytesLeft;
            } else {
                this.fragmentedSampleSizeBytes = i2 + bytesLeft;
            }
            this.fragmentedSampleTimeUs = toSampleUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp);
            if (z) {
                outputSampleMetadataForFragmentedPackets();
            }
            this.previousSequenceNumber = i;
        }
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.fragmentedSampleSizeBytes = -1;
        this.startTimeOffsetUs = j2;
    }

    private boolean validateVp8Descriptor(ParsableByteArray parsableByteArray, int i) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 16) == 16 && (readUnsignedByte & 7) == 0) {
            if (this.gotFirstPacketOfVp8Frame && this.fragmentedSampleSizeBytes > 0) {
                outputSampleMetadataForFragmentedPackets();
            }
            this.gotFirstPacketOfVp8Frame = true;
        } else if (this.gotFirstPacketOfVp8Frame) {
            int nextSequenceNumber = RtpPacket.getNextSequenceNumber(this.previousSequenceNumber);
            if (i < nextSequenceNumber) {
                Log.w(TAG, Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(nextSequenceNumber), Integer.valueOf(i)));
                return false;
            }
        } else {
            Log.w(TAG, "RTP packet is not the start of a new VP8 partition, skipping.");
            return false;
        }
        if ((readUnsignedByte & 128) != 0) {
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            if (!((readUnsignedByte2 & 128) == 0 || (parsableByteArray.readUnsignedByte() & 128) == 0)) {
                parsableByteArray.skipBytes(1);
            }
            if ((readUnsignedByte2 & 64) != 0) {
                parsableByteArray.skipBytes(1);
            }
            if (!((readUnsignedByte2 & 32) == 0 && (readUnsignedByte2 & 16) == 0)) {
                parsableByteArray.skipBytes(1);
            }
        }
        return true;
    }

    private void outputSampleMetadataForFragmentedPackets() {
        long j = this.fragmentedSampleTimeUs;
        boolean z = this.isKeyFrame;
        ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleMetadata(j, z ? 1 : 0, this.fragmentedSampleSizeBytes, 0, (TrackOutput.CryptoData) null);
        this.fragmentedSampleSizeBytes = 0;
        this.fragmentedSampleTimeUs = C.TIME_UNSET;
        this.gotFirstPacketOfVp8Frame = false;
    }

    private static long toSampleUs(long j, long j2, long j3) {
        return j + Util.scaleLargeTimestamp(j2 - j3, 1000000, MEDIA_CLOCK_FREQUENCY);
    }
}
