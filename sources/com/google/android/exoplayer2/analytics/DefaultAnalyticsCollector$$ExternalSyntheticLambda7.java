package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda7 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda7(AnalyticsListener.EventTime eventTime, Object obj, long j) {
        this.f$0 = eventTime;
        this.f$1 = obj;
        this.f$2 = j;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onRenderedFirstFrame(this.f$0, this.f$1, this.f$2);
    }
}
