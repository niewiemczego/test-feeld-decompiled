package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$setupScreenEvents$1", f = "ConversationScreenCoordinator.kt", i = {}, l = {481}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$setupScreenEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConversationScreenViewModel $conversationScreenViewModel;
    int label;
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$setupScreenEvents$1(ConversationScreenViewModel conversationScreenViewModel, ConversationScreenCoordinator conversationScreenCoordinator, Continuation<? super ConversationScreenCoordinator$setupScreenEvents$1> continuation) {
        super(2, continuation);
        this.$conversationScreenViewModel = conversationScreenViewModel;
        this.this$0 = conversationScreenCoordinator;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenCoordinator$setupScreenEvents$1(this.$conversationScreenViewModel, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationScreenCoordinator$setupScreenEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$conversationScreenViewModel.conversationId$zendesk_messaging_messaging_android(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        this.this$0.conversationTypingEvents.subscribeToLifecycleUpdate(str);
        this.$conversationScreenViewModel.dispatchAction(new ConversationScreenAction.SendActivityData(ActivityData.CONVERSATION_READ, str));
        return Unit.INSTANCE;
    }
}
