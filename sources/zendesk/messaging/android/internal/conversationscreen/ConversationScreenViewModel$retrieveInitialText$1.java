package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel", f = "ConversationScreenViewModel.kt", i = {}, l = {450}, m = "retrieveInitialText", n = {}, s = {})
/* compiled from: ConversationScreenViewModel.kt */
final class ConversationScreenViewModel$retrieveInitialText$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationScreenViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenViewModel$retrieveInitialText$1(ConversationScreenViewModel conversationScreenViewModel, Continuation<? super ConversationScreenViewModel$retrieveInitialText$1> continuation) {
        super(continuation);
        this.this$0 = conversationScreenViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.retrieveInitialText((String) null, this);
    }
}
