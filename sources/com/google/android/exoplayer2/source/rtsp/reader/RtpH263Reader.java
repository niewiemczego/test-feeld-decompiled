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

final class RtpH263Reader implements RtpPayloadReader {
    private static final int I_VOP = 0;
    private static final long MEDIA_CLOCK_FREQUENCY = 90000;
    private static final int PICTURE_START_CODE = 128;
    private static final String TAG = "RtpH263Reader";
    private long firstReceivedTimestamp = C.TIME_UNSET;
    private int fragmentedSampleSizeBytes;
    private int height;
    private boolean isKeyFrame;
    private boolean isOutputFormatSet;
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber = -1;
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;
    private int width;

    public void onReceivingFirstPacket(long j, int i) {
    }

    public RtpH263Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 2);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i2 = i;
        Assertions.checkStateNotNull(this.trackOutput);
        int position = parsableByteArray.getPosition();
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        boolean z2 = (readUnsignedShort & 1024) > 0;
        if ((readUnsignedShort & 512) == 0 && (readUnsignedShort & 504) == 0 && (readUnsignedShort & 7) == 0) {
            if (!z2) {
                int nextSequenceNumber = RtpPacket.getNextSequenceNumber(this.previousSequenceNumber);
                if (i2 != nextSequenceNumber) {
                    Log.w(TAG, Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(nextSequenceNumber), Integer.valueOf(i)));
                    return;
                }
            } else if ((parsableByteArray.peekUnsignedByte() & 252) < 128) {
                Log.w(TAG, "Picture start Code (PSC) missing, dropping packet.");
                return;
            } else {
                parsableByteArray.getData()[position] = 0;
                parsableByteArray.getData()[position + 1] = 0;
                parsableByteArray2.setPosition(position);
            }
            if (this.fragmentedSampleSizeBytes == 0) {
                parseVopHeader(parsableByteArray2, this.isOutputFormatSet);
                if (!this.isOutputFormatSet && this.isKeyFrame) {
                    if (!(this.width == this.payloadFormat.format.width && this.height == this.payloadFormat.format.height)) {
                        this.trackOutput.format(this.payloadFormat.format.buildUpon().setWidth(this.width).setHeight(this.height).build());
                    }
                    this.isOutputFormatSet = true;
                }
            }
            int bytesLeft = parsableByteArray.bytesLeft();
            this.trackOutput.sampleData(parsableByteArray2, bytesLeft);
            this.fragmentedSampleSizeBytes += bytesLeft;
            if (z) {
                long j2 = j;
                if (this.firstReceivedTimestamp == C.TIME_UNSET) {
                    this.firstReceivedTimestamp = j2;
                }
                this.trackOutput.sampleMetadata(toSampleUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp), this.isKeyFrame ? 1 : 0, this.fragmentedSampleSizeBytes, 0, (TrackOutput.CryptoData) null);
                this.fragmentedSampleSizeBytes = 0;
                this.isKeyFrame = false;
            }
            this.previousSequenceNumber = i2;
            return;
        }
        Log.w(TAG, "Dropping packet: video reduncancy coding is not supported, packet header VRC, or PLEN or PEBIT is non-zero");
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.fragmentedSampleSizeBytes = 0;
        this.startTimeOffsetUs = j2;
    }

    private void parseVopHeader(ParsableByteArray parsableByteArray, boolean z) {
        int position = parsableByteArray.getPosition();
        boolean z2 = false;
        if (((parsableByteArray.readUnsignedInt() >> 10) & 63) == 32) {
            int peekUnsignedByte = parsableByteArray.peekUnsignedByte();
            int i = (peekUnsignedByte >> 1) & 1;
            if (!z && i == 0) {
                int i2 = (peekUnsignedByte >> 2) & 7;
                if (i2 == 1) {
                    this.width = 128;
                    this.height = 96;
                } else {
                    int i3 = i2 - 2;
                    this.width = 176 << i3;
                    this.height = 144 << i3;
                }
            }
            parsableByteArray.setPosition(position);
            if (i == 0) {
                z2 = true;
            }
            this.isKeyFrame = z2;
            return;
        }
        parsableByteArray.setPosition(position);
        this.isKeyFrame = false;
    }

    private static long toSampleUs(long j, long j2, long j3) {
        return j + Util.scaleLargeTimestamp(j2 - j3, 1000000, MEDIA_CLOCK_FREQUENCY);
    }
}
