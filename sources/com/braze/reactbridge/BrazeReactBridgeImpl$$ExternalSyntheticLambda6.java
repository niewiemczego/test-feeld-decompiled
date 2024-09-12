package com.braze.reactbridge;

import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda6 implements IEventSubscriber {
    public final /* synthetic */ BrazeReactBridgeImpl f$0;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda6(BrazeReactBridgeImpl brazeReactBridgeImpl) {
        this.f$0 = brazeReactBridgeImpl;
    }

    public final void trigger(Object obj) {
        BrazeReactBridgeImpl.m163subscribeToSdkAuthenticationErrorEvents$lambda9(this.f$0, (BrazeSdkAuthenticationErrorEvent) obj);
    }
}
