package com.launchdarkly.sdk.android;

import com.launchdarkly.eventsource.EventSource;
import okhttp3.Request;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class StreamingDataSource$$ExternalSyntheticLambda1 implements EventSource.RequestTransformer {
    public final /* synthetic */ StreamingDataSource f$0;

    public /* synthetic */ StreamingDataSource$$ExternalSyntheticLambda1(StreamingDataSource streamingDataSource) {
        this.f$0 = streamingDataSource;
    }

    public final Request transformRequest(Request request) {
        return this.f$0.m452lambda$start$0$comlaunchdarklysdkandroidStreamingDataSource(request);
    }
}
