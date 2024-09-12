package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda25 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ Tracks f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda25(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        this.f$0 = eventTime;
        this.f$1 = tracks;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTracksChanged(this.f$0, this.f$1);
    }
}
