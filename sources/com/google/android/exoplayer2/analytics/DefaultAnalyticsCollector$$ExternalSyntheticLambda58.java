package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda58 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ PlaybackParameters f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda58(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.f$0 = eventTime;
        this.f$1 = playbackParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaybackParametersChanged(this.f$0, this.f$1);
    }
}
