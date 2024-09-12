package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;
import zendesk.messaging.android.internal.model.LoadMoreStatus;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$handleConnectionStatusChanged$1", f = "ConversationScreenViewModel.kt", i = {}, l = {222, 234}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationScreenViewModel.kt */
final class ConversationScreenViewModel$handleConnectionStatusChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationScreenViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenViewModel$handleConnectionStatusChanged$1(ConversationScreenViewModel conversationScreenViewModel, Continuation<? super ConversationScreenViewModel$handleConnectionStatusChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationScreenViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenViewModel$handleConnectionStatusChanged$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationScreenViewModel$handleConnectionStatusChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Conversation conversation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.refreshState(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!(((ConversationScreenState) this.this$0.conversationScreenStateFlow.getValue()).getLoadMoreStatus() == null || ((ConversationScreenState) this.this$0.conversationScreenStateFlow.getValue()).getLoadMoreStatus() != LoadMoreStatus.FAILED || (conversation = ((ConversationScreenState) this.this$0.conversationScreenStateFlow.getValue()).getConversation()) == null)) {
            ConversationScreenViewModel conversationScreenViewModel = this.this$0;
            ConversationScreenAction.LoadMoreMessages loadMoreMessages = new ConversationScreenAction.LoadMoreMessages(conversation.getId(), ((Message) CollectionsKt.first(conversation.getMessages())).getBeforeTimestamp());
            this.label = 2;
            if (conversationScreenViewModel.loadMoreMessages(loadMoreMessages, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
