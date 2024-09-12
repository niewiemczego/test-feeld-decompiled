package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel", f = "ConversationScreenViewModel.kt", i = {0}, l = {695}, m = "hideLoadMoreMessagesProgressBar", n = {"this"}, s = {"L$0"})
/* compiled from: ConversationScreenViewModel.kt */
final class ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationScreenViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1(ConversationScreenViewModel conversationScreenViewModel, Continuation<? super ConversationScreenViewModel$hideLoadMoreMessagesProgressBar$1> continuation) {
        super(continuation);
        this.this$0 = conversationScreenViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.hideLoadMoreMessagesProgressBar((String) null, this);
    }
}
