package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$3", f = "ConversationKitStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationKitStore.kt */
final class ConversationKitStore$dispatch$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EffectProcessorResult $effectResult;
    int label;
    final /* synthetic */ ConversationKitStore this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationKitStore$dispatch$3(ConversationKitStore conversationKitStore, EffectProcessorResult effectProcessorResult, Continuation<? super ConversationKitStore$dispatch$3> continuation) {
        super(2, continuation);
        this.this$0 = conversationKitStore;
        this.$effectResult = effectProcessorResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationKitStore$dispatch$3(this.this$0, this.$effectResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationKitStore$dispatch$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.notifyAllEventListeners$zendesk_conversationkit_conversationkit_android(this.$effectResult.getEvents());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
