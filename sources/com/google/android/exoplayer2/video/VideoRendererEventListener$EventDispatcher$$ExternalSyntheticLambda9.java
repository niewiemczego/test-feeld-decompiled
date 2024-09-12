package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda9(VideoRendererEventListener.EventDispatcher eventDispatcher, String str, long j, long j2) {
        this.f$0 = eventDispatcher;
        this.f$1 = str;
        this.f$2 = j;
        this.f$3 = j2;
    }

    public final void run() {
        this.f$0.m548lambda$decoderInitialized$1$comgoogleandroidexoplayer2videoVideoRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
    }
}
