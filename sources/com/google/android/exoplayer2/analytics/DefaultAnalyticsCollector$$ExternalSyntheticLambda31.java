package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda31 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ MediaLoadData f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda31(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f$0 = eventTime;
        this.f$1 = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDownstreamFormatChanged(this.f$0, this.f$1);
    }
}
