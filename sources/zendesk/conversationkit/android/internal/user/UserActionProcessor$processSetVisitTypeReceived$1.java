package zendesk.conversationkit.android.internal.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.conversationkit.android.internal.Action;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.user.UserActionProcessor", f = "UserActionProcessor.kt", i = {}, l = {158}, m = "processSetVisitTypeReceived", n = {}, s = {})
/* compiled from: UserActionProcessor.kt */
final class UserActionProcessor$processSetVisitTypeReceived$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionProcessor$processSetVisitTypeReceived$1(UserActionProcessor userActionProcessor, Continuation<? super UserActionProcessor$processSetVisitTypeReceived$1> continuation) {
        super(continuation);
        this.this$0 = userActionProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processSetVisitTypeReceived((Action.SetVisitType) null, this);
    }
}
