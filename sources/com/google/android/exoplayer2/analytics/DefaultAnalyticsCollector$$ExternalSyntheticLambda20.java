package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda20 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda20(AnalyticsListener.EventTime eventTime, String str) {
        this.f$0 = eventTime;
        this.f$1 = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioDecoderReleased(this.f$0, this.f$1);
    }
}
