package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda33 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda33(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        this.f$0 = eventTime;
        this.f$1 = i;
        this.f$2 = j;
        this.f$3 = j2;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioUnderrun(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
