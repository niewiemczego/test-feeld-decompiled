package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda9(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j, long j2) {
        this.f$0 = eventDispatcher;
        this.f$1 = str;
        this.f$2 = j;
        this.f$3 = j2;
    }

    public final void run() {
        this.f$0.m472lambda$decoderInitialized$1$comgoogleandroidexoplayer2audioAudioRendererEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
    }
}
