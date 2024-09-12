package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ VideoSize f$1;

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda3(VideoRendererEventListener.EventDispatcher eventDispatcher, VideoSize videoSize) {
        this.f$0 = eventDispatcher;
        this.f$1 = videoSize;
    }

    public final void run() {
        this.f$0.m557lambda$videoSizeChanged$5$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(this.f$1);
    }
}
