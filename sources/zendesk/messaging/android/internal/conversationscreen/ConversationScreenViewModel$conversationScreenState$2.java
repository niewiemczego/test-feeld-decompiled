package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel$conversationScreenState$2", f = "ConversationScreenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationScreenViewModel.kt */
final class ConversationScreenViewModel$conversationScreenState$2 extends SuspendLambda implements Function2<FlowCollector<? super ConversationScreenState>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationScreenViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenViewModel$conversationScreenState$2(ConversationScreenViewModel conversationScreenViewModel, Continuation<? super ConversationScreenViewModel$conversationScreenState$2> continuation) {
        super(2, continuation);
        this.this$0 = conversationScreenViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenViewModel$conversationScreenState$2(this.this$0, continuation);
    }

    public final Object invoke(FlowCollector<? super ConversationScreenState> flowCollector, Continuation<? super Unit> continuation) {
        return ((ConversationScreenViewModel$conversationScreenState$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Logger.d("ConversationScreenStore", "Starting to observe a new conversationScreenState.", new Object[0]);
            this.this$0.conversationKit.addEventListener(this.this$0.eventListener);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
