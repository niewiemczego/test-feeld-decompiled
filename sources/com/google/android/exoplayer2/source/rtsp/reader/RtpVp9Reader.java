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

final class RtpVp9Reader implements RtpPayloadReader {
    private static final long MEDIA_CLOCK_FREQUENCY = 90000;
    private static final int SCALABILITY_STRUCTURE_SIZE = 4;
    private static final String TAG = "RtpVp9Reader";
    private long firstReceivedTimestamp = C.TIME_UNSET;
    private int fragmentedSampleSizeBytes;
    private boolean gotFirstPacketOfVP9Frame = false;
    private int height = -1;
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber = -1;
    private boolean reportedOutputFormat = false;
    private long startTimeOffsetUs = 0;
    private TrackOutput trackOutput;
    private int width = -1;

    public void onReceivingFirstPacket(long j, int i) {
    }

    public RtpVp9Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 2);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        int i2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i3 = i;
        Assertions.checkStateNotNull(this.trackOutput);
        if (validateVp9Descriptor(parsableByteArray2, i3)) {
            int i4 = (this.fragmentedSampleSizeBytes == 0 && this.gotFirstPacketOfVP9Frame && (parsableByteArray.peekUnsignedByte() & 4) == 0) ? 1 : 0;
            if (!(this.reportedOutputFormat || (i2 = this.width) == -1 || this.height == -1)) {
                if (!(i2 == this.payloadFormat.format.width && this.height == this.payloadFormat.format.height)) {
                    this.trackOutput.format(this.payloadFormat.format.buildUpon().setWidth(this.width).setHeight(this.height).build());
                }
                this.reportedOutputFormat = true;
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            this.trackOutput.sampleData(parsableByteArray2, bytesLeft);
            this.fragmentedSampleSizeBytes += bytesLeft;
            if (z) {
                long j2 = j;
                if (this.firstReceivedTimestamp == C.TIME_UNSET) {
                    this.firstReceivedTimestamp = j2;
                }
                this.trackOutput.sampleMetadata(toSampleUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp), i4, this.fragmentedSampleSizeBytes, 0, (TrackOutput.CryptoData) null);
                this.fragmentedSampleSizeBytes = 0;
                this.gotFirstPacketOfVP9Frame = false;
            }
            this.previousSequenceNumber = i3;
        }
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.fragmentedSampleSizeBytes = 0;
        this.startTimeOffsetUs = j2;
    }

    private boolean validateVp9Descriptor(ParsableByteArray parsableByteArray, int i) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if (this.gotFirstPacketOfVP9Frame) {
            int nextSequenceNumber = RtpPacket.getNextSequenceNumber(this.previousSequenceNumber);
            if (i != nextSequenceNumber) {
                Log.w(TAG, Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(nextSequenceNumber), Integer.valueOf(i)));
                return false;
            }
        } else if ((readUnsignedByte & 8) == 0) {
            Log.w(TAG, "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
            return false;
        } else {
            this.gotFirstPacketOfVP9Frame = true;
        }
        if ((readUnsignedByte & 128) != 0 && (parsableByteArray.readUnsignedByte() & 128) != 0 && parsableByteArray.bytesLeft() < 1) {
            return false;
        }
        int i2 = readUnsignedByte & 16;
        Assertions.checkArgument(i2 == 0, "VP9 flexible mode is not supported.");
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(1);
            if (parsableByteArray.bytesLeft() < 1) {
                return false;
            }
            if (i2 == 0) {
                parsableByteArray.skipBytes(1);
            }
        }
        if ((readUnsignedByte & 2) != 0) {
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int i3 = (readUnsignedByte2 >> 5) & 7;
            if ((readUnsignedByte2 & 16) != 0) {
                int i4 = i3 + 1;
                if (parsableByteArray.bytesLeft() < i4 * 4) {
                    return false;
                }
                for (int i5 = 0; i5 < i4; i5++) {
                    this.width = parsableByteArray.readUnsignedShort();
                    this.height = parsableByteArray.readUnsignedShort();
                }
            }
            if ((readUnsignedByte2 & 8) != 0) {
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                if (parsableByteArray.bytesLeft() < readUnsignedByte3) {
                    return false;
                }
                for (int i6 = 0; i6 < readUnsignedByte3; i6++) {
                    int readUnsignedShort = (parsableByteArray.readUnsignedShort() & 12) >> 2;
                    if (parsableByteArray.bytesLeft() < readUnsignedShort) {
                        return false;
                    }
                    parsableByteArray.skipBytes(readUnsignedShort);
                }
            }
        }
        return true;
    }

    private static long toSampleUs(long j, long j2, long j3) {
        return j + Util.scaleLargeTimestamp(j2 - j3, 1000000, MEDIA_CLOCK_FREQUENCY);
    }
}
