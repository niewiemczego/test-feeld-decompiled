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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationTypingEvents$subscribeToLifecycleUpdate$1", f = "ConversationTypingEvents.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationTypingEvents.kt */
final class ConversationTypingEvents$subscribeToLifecycleUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ ConversationTypingEvents this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationTypingEvents$subscribeToLifecycleUpdate$1(ConversationTypingEvents conversationTypingEvents, String str, Continuation<? super ConversationTypingEvents$subscribeToLifecycleUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationTypingEvents;
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationTypingEvents$subscribeToLifecycleUpdate$1(this.this$0, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationTypingEvents$subscribeToLifecycleUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Boolean> isInForeground = this.this$0.processLifecycleObserver.isInForeground();
            final ConversationTypingEvents conversationTypingEvents = this.this$0;
            final String str = this.$conversationId;
            this.label = 1;
            if (isInForeground.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    if (!z && conversationTypingEvents.canSendTypingStop()) {
                        conversationTypingEvents.sendTypingStopEvent(str);
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
