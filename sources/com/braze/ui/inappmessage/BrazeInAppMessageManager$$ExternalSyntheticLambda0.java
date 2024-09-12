package com.braze.ui.inappmessage;

import com.braze.events.IEventSubscriber;
import com.braze.events.SdkDataWipeEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeInAppMessageManager$$ExternalSyntheticLambda0 implements IEventSubscriber {
    public final /* synthetic */ BrazeInAppMessageManager f$0;

    public /* synthetic */ BrazeInAppMessageManager$$ExternalSyntheticLambda0(BrazeInAppMessageManager brazeInAppMessageManager) {
        this.f$0 = brazeInAppMessageManager;
    }

    public final void trigger(Object obj) {
        BrazeInAppMessageManager.ensureSubscribedToInAppMessageEvents$lambda$1(this.f$0, (SdkDataWipeEvent) obj);
    }
}
