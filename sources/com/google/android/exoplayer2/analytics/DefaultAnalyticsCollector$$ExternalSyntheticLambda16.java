package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda16 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda16(AnalyticsListener.EventTime eventTime, long j) {
        this.f$0 = eventTime;
        this.f$1 = j;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMaxSeekToPreviousPositionChanged(this.f$0, this.f$1);
    }
}
