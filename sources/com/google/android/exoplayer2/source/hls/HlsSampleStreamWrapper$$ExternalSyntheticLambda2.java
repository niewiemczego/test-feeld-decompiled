package com.google.android.exoplayer2.source.hls;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HlsSampleStreamWrapper$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ HlsSampleStreamWrapper f$0;

    public /* synthetic */ HlsSampleStreamWrapper$$ExternalSyntheticLambda2(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.f$0 = hlsSampleStreamWrapper;
    }

    public final void run() {
        this.f$0.onTracksEnded();
    }
}
