package com.braze.reactbridge;

import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IFireOnceEventSubscriber;
import com.facebook.react.bridge.Promise;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda10 implements IFireOnceEventSubscriber {
    public final /* synthetic */ Promise f$0;
    public final /* synthetic */ BrazeReactBridgeImpl f$1;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda10(Promise promise, BrazeReactBridgeImpl brazeReactBridgeImpl) {
        this.f$0 = promise;
        this.f$1 = brazeReactBridgeImpl;
    }

    public final void trigger(Object obj) {
        BrazeReactBridgeImpl.m157getNewsFeedCards$lambda0(this.f$0, this.f$1, (FeedUpdatedEvent) obj);
    }
}
