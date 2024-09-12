package zendesk.conversationkit.android;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.DefaultConversationKit", f = "ConversationKit.kt", i = {0, 0, 0, 1}, l = {403, 337}, m = "loginUser", n = {"this", "jwt", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: ConversationKit.kt */
final class DefaultConversationKit$loginUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultConversationKit this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultConversationKit$loginUser$1(DefaultConversationKit defaultConversationKit, Continuation<? super DefaultConversationKit$loginUser$1> continuation) {
        super(continuation);
        this.this$0 = defaultConversationKit;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loginUser((String) null, this);
    }
}
