package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda43 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda43(AnalyticsListener.EventTime eventTime, int i, int i2) {
        this.f$0 = eventTime;
        this.f$1 = i;
        this.f$2 = i2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSurfaceSizeChanged(this.f$0, this.f$1, this.f$2);
    }
}
