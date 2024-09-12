package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.NetworkTypeObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultBandwidthMeter$$ExternalSyntheticLambda0 implements NetworkTypeObserver.Listener {
    public final /* synthetic */ DefaultBandwidthMeter f$0;

    public /* synthetic */ DefaultBandwidthMeter$$ExternalSyntheticLambda0(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f$0 = defaultBandwidthMeter;
    }

    public final void onNetworkTypeChanged(int i) {
        this.f$0.onNetworkTypeChanged(i);
    }
}
