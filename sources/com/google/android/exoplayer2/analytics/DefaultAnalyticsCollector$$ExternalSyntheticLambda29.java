package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda29 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ AudioAttributes f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda29(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        this.f$0 = eventTime;
        this.f$1 = audioAttributes;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioAttributesChanged(this.f$0, this.f$1);
    }
}
