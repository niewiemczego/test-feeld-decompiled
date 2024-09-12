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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationTypingEvents$onTyping$1", f = "ConversationTypingEvents.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: ConversationTypingEvents.kt */
final class ConversationTypingEvents$onTyping$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConversationTypingEvents this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationTypingEvents$onTyping$1(ConversationTypingEvents conversationTypingEvents, String str, Continuation<? super ConversationTypingEvents$onTyping$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationTypingEvents;
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConversationTypingEvents$onTyping$1 conversationTypingEvents$onTyping$1 = new ConversationTypingEvents$onTyping$1(this.this$0, this.$conversationId, continuation);
        conversationTypingEvents$onTyping$1.L$0 = obj;
        return conversationTypingEvents$onTyping$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationTypingEvents$onTyping$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (DelayKt.delay(10000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            this.this$0.sendTypingStopEvent(this.$conversationId);
        }
        return Unit.INSTANCE;
    }
}
