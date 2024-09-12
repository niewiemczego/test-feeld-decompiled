package com.braze.ui;

import android.widget.ListView;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeFeedFragment$$ExternalSyntheticLambda2 implements IEventSubscriber {
    public final /* synthetic */ BrazeFeedFragment f$0;
    public final /* synthetic */ ListView f$1;

    public /* synthetic */ BrazeFeedFragment$$ExternalSyntheticLambda2(BrazeFeedFragment brazeFeedFragment, ListView listView) {
        this.f$0 = brazeFeedFragment;
        this.f$1 = listView;
    }

    public final void trigger(Object obj) {
        this.f$0.m168lambda$onViewCreated$3$combrazeuiBrazeFeedFragment(this.f$1, (FeedUpdatedEvent) obj);
    }
}
