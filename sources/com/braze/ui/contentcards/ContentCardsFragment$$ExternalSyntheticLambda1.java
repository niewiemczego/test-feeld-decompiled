package com.braze.ui.contentcards;

import com.braze.events.IEventSubscriber;
import com.braze.events.SdkDataWipeEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContentCardsFragment$$ExternalSyntheticLambda1 implements IEventSubscriber {
    public final /* synthetic */ ContentCardsFragment f$0;

    public /* synthetic */ ContentCardsFragment$$ExternalSyntheticLambda1(ContentCardsFragment contentCardsFragment) {
        this.f$0 = contentCardsFragment;
    }

    public final void trigger(Object obj) {
        ContentCardsFragment.onResume$lambda$2(this.f$0, (SdkDataWipeEvent) obj);
    }
}
