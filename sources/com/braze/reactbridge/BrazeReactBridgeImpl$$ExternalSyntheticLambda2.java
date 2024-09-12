package com.braze.reactbridge;

import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda2 implements IEventSubscriber {
    public final /* synthetic */ BrazeReactBridgeImpl f$0;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda2(BrazeReactBridgeImpl brazeReactBridgeImpl) {
        this.f$0 = brazeReactBridgeImpl;
    }

    public final void trigger(Object obj) {
        BrazeReactBridgeImpl.m160subscribeToFeatureFlagsUpdatedEvent$lambda8(this.f$0, (FeatureFlagsUpdatedEvent) obj);
    }
}
