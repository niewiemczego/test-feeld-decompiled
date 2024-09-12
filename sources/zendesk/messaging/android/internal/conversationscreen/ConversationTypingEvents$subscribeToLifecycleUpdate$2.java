package zendesk.messaging.android.internal.conversationscreen;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import zendesk.android.messaging.MessagingScreen;
import zendesk.messaging.android.internal.ScreenStateStore;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationTypingEvents$subscribeToLifecycleUpdate$2", f = "ConversationTypingEvents.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationTypingEvents.kt */
final class ConversationTypingEvents$subscribeToLifecycleUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ ConversationTypingEvents this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationTypingEvents$subscribeToLifecycleUpdate$2(ConversationTypingEvents conversationTypingEvents, String str, Continuation<? super ConversationTypingEvents$subscribeToLifecycleUpdate$2> continuation) {
        super(2, continuation);
        this.this$0 = conversationTypingEvents;
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationTypingEvents$subscribeToLifecycleUpdate$2(this.this$0, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationTypingEvents$subscribeToLifecycleUpdate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<MessagingScreen> currentlyVisibleScreen$zendesk_messaging_messaging_android = ScreenStateStore.INSTANCE.getCurrentlyVisibleScreen$zendesk_messaging_messaging_android();
            final ConversationTypingEvents conversationTypingEvents = this.this$0;
            final String str = this.$conversationId;
            this.label = 1;
            if (currentlyVisibleScreen$zendesk_messaging_messaging_android.collect(new FlowCollector() {
                public final Object emit(MessagingScreen messagingScreen, Continuation<? super Unit> continuation) {
                    if (messagingScreen == null && conversationTypingEvents.canSendTypingStop()) {
                        conversationTypingEvents.sendTypingStopEvent(str);
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
