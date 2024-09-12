package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.base.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda11 implements Function {
    public final /* synthetic */ AnalyticsCollector f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda11(AnalyticsCollector analyticsCollector) {
        this.f$0 = analyticsCollector;
    }

    public final Object apply(Object obj) {
        return ExoPlayer.Builder.lambda$setAnalyticsCollector$21(this.f$0, (Clock) obj);
    }
}
