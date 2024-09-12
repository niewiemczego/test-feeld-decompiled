package zendesk.conversationkit.android.internal.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.conversationkit.android.internal.Action;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.user.UserActionProcessor", f = "UserActionProcessor.kt", i = {0, 0, 1, 2}, l = {409, 417, 418, 438}, m = "processGetConversation", n = {"this", "action", "this", "this"}, s = {"L$0", "L$1", "L$0", "L$0"})
/* compiled from: UserActionProcessor.kt */
final class UserActionProcessor$processGetConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionProcessor$processGetConversation$1(UserActionProcessor userActionProcessor, Continuation<? super UserActionProcessor$processGetConversation$1> continuation) {
        super(continuation);
        this.this$0 = userActionProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processGetConversation((Action.GetConversation) null, this);
    }
}
