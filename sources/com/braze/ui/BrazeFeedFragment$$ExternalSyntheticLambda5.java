package com.braze.ui;

import android.widget.ListView;
import com.braze.events.FeedUpdatedEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeFeedFragment$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ BrazeFeedFragment f$0;
    public final /* synthetic */ FeedUpdatedEvent f$1;
    public final /* synthetic */ ListView f$2;

    public /* synthetic */ BrazeFeedFragment$$ExternalSyntheticLambda5(BrazeFeedFragment brazeFeedFragment, FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        this.f$0 = brazeFeedFragment;
        this.f$1 = feedUpdatedEvent;
        this.f$2 = listView;
    }

    public final void run() {
        this.f$0.m167lambda$onViewCreated$2$combrazeuiBrazeFeedFragment(this.f$1, this.f$2);
    }
}
