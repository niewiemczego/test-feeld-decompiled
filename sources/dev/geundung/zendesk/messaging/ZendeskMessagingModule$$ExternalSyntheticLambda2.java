package dev.geundung.zendesk.messaging;

import zendesk.android.events.ZendeskEvent;
import zendesk.android.events.ZendeskEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskMessagingModule$$ExternalSyntheticLambda2 implements ZendeskEventListener {
    public final /* synthetic */ ZendeskMessagingModule f$0;

    public /* synthetic */ ZendeskMessagingModule$$ExternalSyntheticLambda2(ZendeskMessagingModule zendeskMessagingModule) {
        this.f$0 = zendeskMessagingModule;
    }

    public final void onEvent(ZendeskEvent zendeskEvent) {
        ZendeskMessagingModule.m678setupEventObserver$lambda0(this.f$0, zendeskEvent);
    }
}
