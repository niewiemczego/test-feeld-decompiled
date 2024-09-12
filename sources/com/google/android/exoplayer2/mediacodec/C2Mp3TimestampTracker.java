package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.nio.ByteBuffer;

final class C2Mp3TimestampTracker {
    private static final long DECODER_DELAY_FRAMES = 529;
    private static final String TAG = "C2Mp3TimestampTracker";
    private long anchorTimestampUs;
    private long processedFrames;
    private boolean seenInvalidMpegAudioHeader;

    C2Mp3TimestampTracker() {
    }

    public void reset() {
        this.anchorTimestampUs = 0;
        this.processedFrames = 0;
        this.seenInvalidMpegAudioHeader = false;
    }

    public long updateAndGetPresentationTimeUs(Format format, DecoderInputBuffer decoderInputBuffer) {
        if (this.processedFrames == 0) {
            this.anchorTimestampUs = decoderInputBuffer.timeUs;
        }
        if (this.seenInvalidMpegAudioHeader) {
            return decoderInputBuffer.timeUs;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
        byte b = 0;
        for (int i = 0; i < 4; i++) {
            b = (b << 8) | (byteBuffer.get(i) & 255);
        }
        int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(b);
        if (parseMpegAudioFrameSampleCount == -1) {
            this.seenInvalidMpegAudioHeader = true;
            this.processedFrames = 0;
            this.anchorTimestampUs = decoderInputBuffer.timeUs;
            Log.w(TAG, "MPEG audio header is invalid.");
            return decoderInputBuffer.timeUs;
        }
        long bufferTimestampUs = getBufferTimestampUs((long) format.sampleRate);
        this.processedFrames += (long) parseMpegAudioFrameSampleCount;
        return bufferTimestampUs;
    }

    public long getLastOutputBufferPresentationTimeUs(Format format) {
        return getBufferTimestampUs((long) format.sampleRate);
    }

    private long getBufferTimestampUs(long j) {
        return this.anchorTimestampUs + Math.max(0, ((this.processedFrames - DECODER_DELAY_FRAMES) * 1000000) / j);
    }
}
