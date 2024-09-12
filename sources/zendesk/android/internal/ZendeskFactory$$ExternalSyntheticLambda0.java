package zendesk.android.internal;

import kotlinx.coroutines.CoroutineScope;
import zendesk.android.internal.di.ZendeskComponent;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ZendeskFactory$$ExternalSyntheticLambda0 implements ConversationKitEventListener {
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ ZendeskComponent f$1;

    public /* synthetic */ ZendeskFactory$$ExternalSyntheticLambda0(CoroutineScope coroutineScope, ZendeskComponent zendeskComponent) {
        this.f$0 = coroutineScope;
        this.f$1 = zendeskComponent;
    }

    public final void onEvent(ConversationKitEvent conversationKitEvent) {
        ZendeskFactory.m2749create$lambda0(this.f$0, this.f$1, conversationKitEvent);
    }
}
