package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.f$0 = eventDispatcher;
        this.f$1 = z;
    }

    public final void run() {
        this.f$0.m478lambda$skipSilenceEnabledChanged$7$comgoogleandroidexoplayer2audioAudioRendererEventListener$EventDispatcher(this.f$1);
    }
}
