package zendesk.conversationkit.android.internal.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.conversationkit.android.model.Conversation;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.user.UserActionProcessor", f = "UserActionProcessor.kt", i = {0, 0}, l = {959, 970}, m = "saveConversation", n = {"this", "conversation"}, s = {"L$0", "L$1"})
/* compiled from: UserActionProcessor.kt */
final class UserActionProcessor$saveConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionProcessor$saveConversation$1(UserActionProcessor userActionProcessor, Continuation<? super UserActionProcessor$saveConversation$1> continuation) {
        super(continuation);
        this.this$0 = userActionProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveConversation((Conversation) null, this);
    }
}
