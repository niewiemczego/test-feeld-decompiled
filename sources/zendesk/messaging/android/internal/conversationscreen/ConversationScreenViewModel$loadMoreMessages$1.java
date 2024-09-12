package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel", f = "ConversationScreenViewModel.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {587, 593, 594, 601, 604}, m = "loadMoreMessages", n = {"this", "conversationId", "beforeTimestamp", "this", "conversationId", "beforeTimestamp", "this", "conversationId"}, s = {"L$0", "L$1", "D$0", "L$0", "L$1", "D$0", "L$0", "L$1"})
/* compiled from: ConversationScreenViewModel.kt */
final class ConversationScreenViewModel$loadMoreMessages$1 extends ContinuationImpl {
    double D$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationScreenViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenViewModel$loadMoreMessages$1(ConversationScreenViewModel conversationScreenViewModel, Continuation<? super ConversationScreenViewModel$loadMoreMessages$1> continuation) {
        super(continuation);
        this.this$0 = conversationScreenViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadMoreMessages((ConversationScreenAction.LoadMoreMessages) null, this);
    }
}
