package zendesk.android;

import kotlinx.coroutines.channels.ProducerScope;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.events.ZendeskEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskExtensions$eventFlow$1$$ExternalSyntheticLambda0 implements ZendeskEventListener {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ ZendeskExtensions$eventFlow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    public final void onEvent(ZendeskEvent zendeskEvent) {
        ZendeskExtensions$eventFlow$1.m2747invokeSuspend$lambda0(this.f$0, zendeskEvent);
    }
}
