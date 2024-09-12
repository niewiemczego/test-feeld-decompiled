package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda14 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda14(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
        this.f$0 = eventTime;
        this.f$1 = str;
        this.f$2 = j;
        this.f$3 = j2;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onAudioDecoderInitialized$4(this.f$0, this.f$1, this.f$2, this.f$3, (AnalyticsListener) obj);
    }
}
