package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.BandwidthMeter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BandwidthMeter$EventListener$EventDispatcher$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ BandwidthMeter$EventListener$EventDispatcher$$ExternalSyntheticLambda0(BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i, long j, long j2) {
        this.f$0 = handlerAndListener;
        this.f$1 = i;
        this.f$2 = j;
        this.f$3 = j2;
    }

    public final void run() {
        this.f$0.listener.onBandwidthSample(this.f$1, this.f$2, this.f$3);
    }
}
