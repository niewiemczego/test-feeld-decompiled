package com.braze.ui;

import android.widget.ListView;
import com.braze.events.FeedUpdatedEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ BrazeXamarinFormsFeedFragment f$0;
    public final /* synthetic */ FeedUpdatedEvent f$1;
    public final /* synthetic */ ListView f$2;

    public /* synthetic */ BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda4(BrazeXamarinFormsFeedFragment brazeXamarinFormsFeedFragment, FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        this.f$0 = brazeXamarinFormsFeedFragment;
        this.f$1 = feedUpdatedEvent;
        this.f$2 = listView;
    }

    public final void run() {
        this.f$0.m170lambda$onActivityCreated$2$combrazeuiBrazeXamarinFormsFeedFragment(this.f$1, this.f$2);
    }
}
