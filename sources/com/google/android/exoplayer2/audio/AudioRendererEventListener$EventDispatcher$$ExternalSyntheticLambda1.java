package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ Format f$1;
    public final /* synthetic */ DecoderReuseEvaluation f$2;

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1(AudioRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f$0 = eventDispatcher;
        this.f$1 = format;
        this.f$2 = decoderReuseEvaluation;
    }

    public final void run() {
        this.f$0.m476lambda$inputFormatChanged$2$comgoogleandroidexoplayer2audioAudioRendererEventListener$EventDispatcher(this.f$1, this.f$2);
    }
}
