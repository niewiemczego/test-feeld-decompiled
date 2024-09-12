package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda22 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ MediaItem f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda22(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
        this.f$0 = eventTime;
        this.f$1 = mediaItem;
        this.f$2 = i;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMediaItemTransition(this.f$0, this.f$1, this.f$2);
    }
}
