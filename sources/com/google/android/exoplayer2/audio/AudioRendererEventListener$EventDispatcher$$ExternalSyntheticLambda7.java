package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ Exception f$1;

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f$0 = eventDispatcher;
        this.f$1 = exc;
    }

    public final void run() {
        this.f$0.m471lambda$audioSinkError$8$comgoogleandroidexoplayer2audioAudioRendererEventListener$EventDispatcher(this.f$1);
    }
}
