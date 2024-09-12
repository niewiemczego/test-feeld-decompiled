package zendesk.android.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.internal.di.ZendeskComponent;
import zendesk.conversationkit.android.ConversationKitEvent;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.ZendeskFactory$create$2$1", f = "ZendeskFactory.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ZendeskFactory.kt */
final class ZendeskFactory$create$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConversationKitEvent $conversationKitEvent;
    final /* synthetic */ ZendeskComponent $zendeskComponent;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZendeskFactory$create$2$1(ZendeskComponent zendeskComponent, ConversationKitEvent conversationKitEvent, Continuation<? super ZendeskFactory$create$2$1> continuation) {
        super(2, continuation);
        this.$zendeskComponent = zendeskComponent;
        this.$conversationKitEvent = conversationKitEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZendeskFactory$create$2$1(this.$zendeskComponent, this.$conversationKitEvent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZendeskFactory$create$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$zendeskComponent.zendeskEventDispatcher().notifyEventListeners(new ZendeskEvent.AuthenticationFailed(((ConversationKitEvent.UserAccessRevoked) this.$conversationKitEvent).getCause()), this) == coroutine_suspended) {
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
