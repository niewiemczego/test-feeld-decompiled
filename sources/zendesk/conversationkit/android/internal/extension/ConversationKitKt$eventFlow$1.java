package zendesk.conversationkit.android.internal.extension;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.conversationkit.android.ConversationKitEvent;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lzendesk/conversationkit/android/ConversationKitEvent;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.extension.ConversationKitKt$eventFlow$1", f = "ConversationKit.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationKit.kt */
final class ConversationKitKt$eventFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super ConversationKitEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConversationKit $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationKitKt$eventFlow$1(ConversationKit conversationKit, Continuation<? super ConversationKitKt$eventFlow$1> continuation) {
        super(2, continuation);
        this.$this_eventFlow = conversationKit;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ConversationKitKt$eventFlow$1 conversationKitKt$eventFlow$1 = new ConversationKitKt$eventFlow$1(this.$this_eventFlow, continuation);
        conversationKitKt$eventFlow$1.L$0 = obj;
        return conversationKitKt$eventFlow$1;
    }

    public final Object invoke(ProducerScope<? super ConversationKitEvent> producerScope, Continuation<? super Unit> continuation) {
        return ((ConversationKitKt$eventFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final ConversationKitKt$eventFlow$1$$ExternalSyntheticLambda0 conversationKitKt$eventFlow$1$$ExternalSyntheticLambda0 = new ConversationKitKt$eventFlow$1$$ExternalSyntheticLambda0(producerScope);
            this.$this_eventFlow.addEventListener(conversationKitKt$eventFlow$1$$ExternalSyntheticLambda0);
            final ConversationKit conversationKit = this.$this_eventFlow;
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() {
                public final void invoke() {
                    conversationKit.removeEventListener(conversationKitKt$eventFlow$1$$ExternalSyntheticLambda0);
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

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m2756invokeSuspend$lambda0(ProducerScope producerScope, ConversationKitEvent conversationKitEvent) {
        producerScope.m2546trySendJP2dKIU(conversationKitEvent);
    }
}
