package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda8(VideoRendererEventListener.EventDispatcher eventDispatcher, int i, long j) {
        this.f$0 = eventDispatcher;
        this.f$1 = i;
        this.f$2 = j;
    }

    public final void run() {
        this.f$0.m551lambda$droppedFrames$3$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(this.f$1, this.f$2);
    }
}
