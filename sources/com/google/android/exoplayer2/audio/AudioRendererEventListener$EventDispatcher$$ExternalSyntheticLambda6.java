package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda6(AudioRendererEventListener.EventDispatcher eventDispatcher, int i, long j, long j2) {
        this.f$0 = eventDispatcher;
        this.f$1 = i;
        this.f$2 = j;
        this.f$3 = j2;
    }

    public final void run() {
        this.f$0.m479lambda$underrun$4$comgoogleandroidexoplayer2audioAudioRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
    }
}
