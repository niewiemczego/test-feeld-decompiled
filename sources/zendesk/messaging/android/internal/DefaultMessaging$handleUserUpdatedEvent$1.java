package zendesk.messaging.android.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.conversationkit.android.ConversationKitEvent;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.DefaultMessaging", f = "DefaultMessaging.kt", i = {}, l = {156}, m = "handleUserUpdatedEvent", n = {}, s = {})
/* compiled from: DefaultMessaging.kt */
final class DefaultMessaging$handleUserUpdatedEvent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultMessaging this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultMessaging$handleUserUpdatedEvent$1(DefaultMessaging defaultMessaging, Continuation<? super DefaultMessaging$handleUserUpdatedEvent$1> continuation) {
        super(continuation);
        this.this$0 = defaultMessaging;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleUserUpdatedEvent((ConversationKitEvent.UserUpdated) null, this);
    }
}
