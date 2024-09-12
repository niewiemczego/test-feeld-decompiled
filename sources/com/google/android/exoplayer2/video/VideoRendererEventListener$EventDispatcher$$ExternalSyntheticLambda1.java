package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ DecoderCounters f$1;

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f$0 = eventDispatcher;
        this.f$1 = decoderCounters;
    }

    public final void run() {
        this.f$0.m552lambda$enabled$0$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(this.f$1);
    }
}
