package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationActivity", f = "ConversationActivity.kt", i = {0}, l = {201}, m = "setupConversationScreenViewModel", n = {"this"}, s = {"L$0"})
/* compiled from: ConversationActivity.kt */
final class ConversationActivity$setupConversationScreenViewModel$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationActivity$setupConversationScreenViewModel$1(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$setupConversationScreenViewModel$1> continuation) {
        super(continuation);
        this.this$0 = conversationActivity;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setupConversationScreenViewModel(this);
    }
}
