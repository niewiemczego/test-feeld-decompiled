package com.braze.reactbridge;

import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda4 implements IEventSubscriber {
    public final /* synthetic */ BrazeReactBridgeImpl f$0;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda4(BrazeReactBridgeImpl brazeReactBridgeImpl) {
        this.f$0 = brazeReactBridgeImpl;
    }

    public final void trigger(Object obj) {
        BrazeReactBridgeImpl.m161subscribeToNewsFeedCardsUpdatedEvent$lambda6(this.f$0, (FeedUpdatedEvent) obj);
    }
}
