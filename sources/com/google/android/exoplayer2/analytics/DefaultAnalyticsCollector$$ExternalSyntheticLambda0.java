package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda0 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ Metadata f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda0(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        this.f$0 = eventTime;
        this.f$1 = metadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMetadata(this.f$0, this.f$1);
    }
}
