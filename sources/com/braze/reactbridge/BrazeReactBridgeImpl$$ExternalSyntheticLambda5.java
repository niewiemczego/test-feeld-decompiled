package com.braze.reactbridge;

import com.braze.events.BrazePushEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda5 implements IEventSubscriber {
    public final /* synthetic */ BrazeReactBridgeImpl f$0;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda5(BrazeReactBridgeImpl brazeReactBridgeImpl) {
        this.f$0 = brazeReactBridgeImpl;
    }

    public final void trigger(Object obj) {
        BrazeReactBridgeImpl.m162subscribeToPushNotificationEvents$lambda14(this.f$0, (BrazePushEvent) obj);
    }
}
