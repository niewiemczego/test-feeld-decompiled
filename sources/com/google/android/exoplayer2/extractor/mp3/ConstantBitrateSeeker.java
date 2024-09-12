package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;

final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public long getDataEndPosition() {
        return -1;
    }

    public ConstantBitrateSeeker(long j, long j2, MpegAudioUtil.Header header, boolean z) {
        super(j, j2, header.bitrate, header.frameSize, z);
    }

    public long getTimeUs(long j) {
        return getTimeUsAtPosition(j);
    }
}
