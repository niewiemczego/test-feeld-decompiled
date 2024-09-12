package zendesk.conversationkit.android.internal.proactivemessaging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage$clearProactiveMessage$2", f = "ProactiveMessagingStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProactiveMessagingStorage.kt */
final class ProactiveMessagingStorage$clearProactiveMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $proactiveMessageId;
    int label;
    final /* synthetic */ ProactiveMessagingStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingStorage$clearProactiveMessage$2(ProactiveMessagingStorage proactiveMessagingStorage, int i, Continuation<? super ProactiveMessagingStorage$clearProactiveMessage$2> continuation) {
        super(2, continuation);
        this.this$0 = proactiveMessagingStorage;
        this.$proactiveMessageId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProactiveMessagingStorage$clearProactiveMessage$2(this.this$0, this.$proactiveMessageId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProactiveMessagingStorage$clearProactiveMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.storage.remove(String.valueOf(this.$proactiveMessageId));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
