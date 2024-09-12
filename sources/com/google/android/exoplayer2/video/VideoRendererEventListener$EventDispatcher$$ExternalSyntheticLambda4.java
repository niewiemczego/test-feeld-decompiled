package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda4(VideoRendererEventListener.EventDispatcher eventDispatcher, long j, int i) {
        this.f$0 = eventDispatcher;
        this.f$1 = j;
        this.f$2 = i;
    }

    public final void run() {
        this.f$0.m555lambda$reportVideoFrameProcessingOffset$4$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(this.f$1, this.f$2);
    }
}
