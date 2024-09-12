package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;
import java.io.IOException;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda48 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ LoadEventInfo f$1;
    public final /* synthetic */ MediaLoadData f$2;
    public final /* synthetic */ IOException f$3;
    public final /* synthetic */ boolean f$4;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda48(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.f$0 = eventTime;
        this.f$1 = loadEventInfo;
        this.f$2 = mediaLoadData;
        this.f$3 = iOException;
        this.f$4 = z;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadError(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
