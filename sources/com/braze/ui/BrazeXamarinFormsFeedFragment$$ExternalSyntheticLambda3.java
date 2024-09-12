package com.braze.ui;

import android.widget.ListView;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda3 implements IEventSubscriber {
    public final /* synthetic */ BrazeXamarinFormsFeedFragment f$0;
    public final /* synthetic */ ListView f$1;

    public /* synthetic */ BrazeXamarinFormsFeedFragment$$ExternalSyntheticLambda3(BrazeXamarinFormsFeedFragment brazeXamarinFormsFeedFragment, ListView listView) {
        this.f$0 = brazeXamarinFormsFeedFragment;
        this.f$1 = listView;
    }

    public final void trigger(Object obj) {
        this.f$0.m171lambda$onActivityCreated$3$combrazeuiBrazeXamarinFormsFeedFragment(this.f$1, (FeedUpdatedEvent) obj);
    }
}
