package zendesk.messaging.android.internal.conversationscreen.permissions;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermissionState;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission$requestRuntimePermission$1", f = "RuntimePermission.kt", i = {0}, l = {110, 112}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: RuntimePermission.kt */
final class RuntimePermission$requestRuntimePermission$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends RuntimePermissionState>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $permissionsToRequest;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RuntimePermission this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RuntimePermission$requestRuntimePermission$1(RuntimePermission runtimePermission, List<String> list, Continuation<? super RuntimePermission$requestRuntimePermission$1> continuation) {
        super(2, continuation);
        this.this$0 = runtimePermission;
        this.$permissionsToRequest = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RuntimePermission$requestRuntimePermission$1 runtimePermission$requestRuntimePermission$1 = new RuntimePermission$requestRuntimePermission$1(this.this$0, this.$permissionsToRequest, continuation);
        runtimePermission$requestRuntimePermission$1.L$0 = obj;
        return runtimePermission$requestRuntimePermission$1;
    }

    public final Object invoke(FlowCollector<? super List<RuntimePermissionState>> flowCollector, Continuation<? super Unit> continuation) {
        return ((RuntimePermission$requestRuntimePermission$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0072
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0057
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission r7 = r6.this$0
            androidx.activity.result.ActivityResultLauncher r7 = r7.requestForMultiplePermissions
            java.util.List<java.lang.String> r4 = r6.$permissionsToRequest
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = 0
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r4 = r4.toArray(r5)
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r5)
            r7.launch(r4)
            zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission r7 = r6.this$0
            kotlinx.coroutines.CompletableDeferred r7 = r7.runtimePermissionStateCompletableDeferred
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.await(r4)
            if (r7 != r0) goto L_0x0057
            return r0
        L_0x0057:
            java.util.List r7 = (java.util.List) r7
            r4 = r7
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0072
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r1.emit(r7, r3)
            if (r7 != r0) goto L_0x0072
            return r0
        L_0x0072:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission$requestRuntimePermission$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
