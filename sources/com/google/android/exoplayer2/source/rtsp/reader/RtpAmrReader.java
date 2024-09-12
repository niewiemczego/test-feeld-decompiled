package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class RtpAmrReader implements RtpPayloadReader {
    private static final int[] AMR_NB_FRAME_TYPE_INDEX_TO_FRAME_SIZE = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] AMR_WB_FRAME_TYPE_INDEX_TO_FRAME_SIZE = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final String TAG = "RtpAmrReader";
    private long firstReceivedTimestamp = C.TIME_UNSET;
    private final boolean isWideBand;
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber = -1;
    private final int sampleRate;
    private long startTimeOffsetUs = 0;
    private TrackOutput trackOutput;

    public RtpAmrReader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
        this.isWideBand = MimeTypes.AUDIO_AMR_WB.equals(Assertions.checkNotNull(rtpPayloadFormat.format.sampleMimeType));
        this.sampleRate = rtpPayloadFormat.clockRate;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 1);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void onReceivingFirstPacket(long j, int i) {
        this.firstReceivedTimestamp = j;
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        int nextSequenceNumber;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i2 = i;
        Assertions.checkStateNotNull(this.trackOutput);
        int i3 = this.previousSequenceNumber;
        boolean z2 = false;
        if (!(i3 == -1 || i2 == (nextSequenceNumber = RtpPacket.getNextSequenceNumber(i3)))) {
            Log.w(TAG, Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(nextSequenceNumber), Integer.valueOf(i)));
        }
        parsableByteArray2.skipBytes(1);
        int frameSize = getFrameSize((parsableByteArray.peekUnsignedByte() >> 3) & 15, this.isWideBand);
        int bytesLeft = parsableByteArray.bytesLeft();
        if (bytesLeft == frameSize) {
            z2 = true;
        }
        Assertions.checkArgument(z2, "compound payload not supported currently");
        this.trackOutput.sampleData(parsableByteArray2, bytesLeft);
        this.trackOutput.sampleMetadata(toSampleTimeUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp, this.sampleRate), 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
        this.previousSequenceNumber = i2;
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.startTimeOffsetUs = j2;
    }

    public static int getFrameSize(int i, boolean z) {
        Assertions.checkArgument((i >= 0 && i <= 8) || i == 15, "Illegal AMR " + (z ? "WB" : "NB") + " frame type " + i);
        if (z) {
            return AMR_WB_FRAME_TYPE_INDEX_TO_FRAME_SIZE[i];
        }
        return AMR_NB_FRAME_TYPE_INDEX_TO_FRAME_SIZE[i];
    }

    private static long toSampleTimeUs(long j, long j2, long j3, int i) {
        return j + Util.scaleLargeTimestamp(j2 - j3, 1000000, (long) i);
    }
}
