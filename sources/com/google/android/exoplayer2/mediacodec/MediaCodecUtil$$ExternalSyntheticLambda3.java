package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaCodecUtil$$ExternalSyntheticLambda3 implements MediaCodecUtil.ScoreProvider {
    public final /* synthetic */ Format f$0;

    public /* synthetic */ MediaCodecUtil$$ExternalSyntheticLambda3(Format format) {
        this.f$0 = format;
    }

    public final int getScore(Object obj) {
        return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(this.f$0, (MediaCodecInfo) obj);
    }
}
