package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel", f = "ConversationScreenViewModel.kt", i = {0, 1, 2, 2}, l = {459, 460, 461}, m = "refreshState", n = {"this", "this", "this", "conversation"}, s = {"L$0", "L$0", "L$0", "L$1"})
/* compiled from: ConversationScreenViewModel.kt */
final class ConversationScreenViewModel$refreshState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationScreenViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenViewModel$refreshState$1(ConversationScreenViewModel conversationScreenViewModel, Continuation<? super ConversationScreenViewModel$refreshState$1> continuation) {
        super(continuation);
        this.this$0 = conversationScreenViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshState(this);
    }
}
