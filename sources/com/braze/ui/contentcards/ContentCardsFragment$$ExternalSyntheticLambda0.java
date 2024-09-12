package com.braze.ui.contentcards;

import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ContentCardsFragment$$ExternalSyntheticLambda0 implements IEventSubscriber {
    public final /* synthetic */ ContentCardsFragment f$0;

    public /* synthetic */ ContentCardsFragment$$ExternalSyntheticLambda0(ContentCardsFragment contentCardsFragment) {
        this.f$0 = contentCardsFragment;
    }

    public final void trigger(Object obj) {
        ContentCardsFragment.onResume$lambda$0(this.f$0, (ContentCardsUpdatedEvent) obj);
    }
}
