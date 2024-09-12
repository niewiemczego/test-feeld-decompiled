package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.common.base.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda21 implements Supplier {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda21(Context context) {
        this.f$0 = context;
    }

    public final Object get() {
        return DefaultBandwidthMeter.getSingletonInstance(this.f$0);
    }
}
