package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "expo.modules.core.logging.PersistentFileLogSerialDispatchQueue$add$1", f = "PersistentFileLogSerialDispatchQueue.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PersistentFileLogSerialDispatchQueue.kt */
final class PersistentFileLogSerialDispatchQueue$add$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $block;
    int label;
    final /* synthetic */ PersistentFileLogSerialDispatchQueue this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersistentFileLogSerialDispatchQueue$add$1(PersistentFileLogSerialDispatchQueue persistentFileLogSerialDispatchQueue, Function0<Unit> function0, Continuation<? super PersistentFileLogSerialDispatchQueue$add$1> continuation) {
        super(2, continuation);
        this.this$0 = persistentFileLogSerialDispatchQueue;
        this.$block = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersistentFileLogSerialDispatchQueue$add$1(this.this$0, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PersistentFileLogSerialDispatchQueue$add$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.channel.send(this.$block, this) == coroutine_suspended) {
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
