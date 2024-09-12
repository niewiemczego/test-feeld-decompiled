package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.internal.events.DefaultEventProcessor;
import com.launchdarkly.sdk.internal.events.EventSender;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda1 implements DefaultEventProcessor.EventResponseListener {
    public final /* synthetic */ DefaultEventProcessor.EventDispatcher f$0;

    public /* synthetic */ DefaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda1(DefaultEventProcessor.EventDispatcher eventDispatcher) {
        this.f$0 = eventDispatcher;
    }

    public final void handleResponse(EventSender.Result result) {
        this.f$0.handleResponse(result);
    }
}
