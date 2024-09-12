package com.braze.reactbridge;

import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda1 implements IEventSubscriber {
    public final /* synthetic */ BrazeReactBridgeImpl f$0;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda1(BrazeReactBridgeImpl brazeReactBridgeImpl) {
        this.f$0 = brazeReactBridgeImpl;
    }

    public final void trigger(Object obj) {
        BrazeReactBridgeImpl.m159subscribeToContentCardsUpdatedEvent$lambda5(this.f$0, (ContentCardsUpdatedEvent) obj);
    }
}
