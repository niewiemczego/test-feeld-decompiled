package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda64 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Player.PositionInfo f$2;
    public final /* synthetic */ Player.PositionInfo f$3;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda64(AnalyticsListener.EventTime eventTime, int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f$0 = eventTime;
        this.f$1 = i;
        this.f$2 = positionInfo;
        this.f$3 = positionInfo2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onPositionDiscontinuity$43(this.f$0, this.f$1, this.f$2, this.f$3, (AnalyticsListener) obj);
    }
}
