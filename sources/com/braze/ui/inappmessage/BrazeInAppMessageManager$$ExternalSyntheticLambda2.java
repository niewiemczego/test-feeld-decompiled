package com.braze.ui.inappmessage;

import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeInAppMessageManager$$ExternalSyntheticLambda2 implements IEventSubscriber {
    public final /* synthetic */ BrazeInAppMessageManager f$0;

    public /* synthetic */ BrazeInAppMessageManager$$ExternalSyntheticLambda2(BrazeInAppMessageManager brazeInAppMessageManager) {
        this.f$0 = brazeInAppMessageManager;
    }

    public final void trigger(Object obj) {
        BrazeInAppMessageManager.createInAppMessageEventSubscriber$lambda$8(this.f$0, (InAppMessageEvent) obj);
    }
}
