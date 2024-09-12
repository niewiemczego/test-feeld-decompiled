package zendesk.conversationkit.android.internal.extension;

import kotlinx.coroutines.channels.ProducerScope;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConversationKitKt$eventFlow$1$$ExternalSyntheticLambda0 implements ConversationKitEventListener {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ ConversationKitKt$eventFlow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    public final void onEvent(ConversationKitEvent conversationKitEvent) {
        ConversationKitKt$eventFlow$1.m2756invokeSuspend$lambda0(this.f$0, conversationKitEvent);
    }
}
