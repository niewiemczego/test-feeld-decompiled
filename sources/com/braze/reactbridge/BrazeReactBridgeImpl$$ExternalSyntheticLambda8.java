package com.braze.reactbridge;

import com.braze.enums.CardCategory;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.facebook.react.bridge.Callback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeReactBridgeImpl$$ExternalSyntheticLambda8 implements IEventSubscriber {
    public final /* synthetic */ BrazeReactBridgeImpl f$0;
    public final /* synthetic */ Callback f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ CardCategory f$3;

    public /* synthetic */ BrazeReactBridgeImpl$$ExternalSyntheticLambda8(BrazeReactBridgeImpl brazeReactBridgeImpl, Callback callback, String str, CardCategory cardCategory) {
        this.f$0 = brazeReactBridgeImpl;
        this.f$1 = callback;
        this.f$2 = str;
        this.f$3 = cardCategory;
    }

    public final void trigger(Object obj) {
        BrazeReactBridgeImpl.m153getCardCountForTag$lambda20(this.f$0, this.f$1, this.f$2, this.f$3, (FeedUpdatedEvent) obj);
    }
}
