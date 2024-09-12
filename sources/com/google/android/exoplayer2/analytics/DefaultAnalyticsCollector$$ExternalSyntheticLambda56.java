package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda56 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda56(AnalyticsListener.EventTime eventTime) {
        this.f$0 = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmKeysRestored(this.f$0);
    }
}
