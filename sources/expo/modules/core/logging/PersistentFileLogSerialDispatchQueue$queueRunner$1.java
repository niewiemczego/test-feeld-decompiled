package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "expo.modules.core.logging.PersistentFileLogSerialDispatchQueue$queueRunner$1", f = "PersistentFileLogSerialDispatchQueue.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PersistentFileLogSerialDispatchQueue.kt */
final class PersistentFileLogSerialDispatchQueue$queueRunner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PersistentFileLogSerialDispatchQueue this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersistentFileLogSerialDispatchQueue$queueRunner$1(PersistentFileLogSerialDispatchQueue persistentFileLogSerialDispatchQueue, Continuation<? super PersistentFileLogSerialDispatchQueue$queueRunner$1> continuation) {
        super(2, continuation);
        this.this$0 = persistentFileLogSerialDispatchQueue;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PersistentFileLogSerialDispatchQueue$queueRunner$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PersistentFileLogSerialDispatchQueue$queueRunner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            kotlin.ResultKt.throwOnFailure(r6)
            r1 = r0
            r0 = r5
            goto L_0x0033
        L_0x0011:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
        L_0x001d:
            expo.modules.core.logging.PersistentFileLogSerialDispatchQueue r1 = r6.this$0
            kotlinx.coroutines.channels.Channel r1 = r1.channel
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.label = r2
            java.lang.Object r1 = r1.receive(r3)
            if (r1 != r0) goto L_0x002f
            return r0
        L_0x002f:
            r4 = r0
            r0 = r6
            r6 = r1
            r1 = r4
        L_0x0033:
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r6.invoke()
            r6 = r0
            r0 = r1
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.core.logging.PersistentFileLogSerialDispatchQueue$queueRunner$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
