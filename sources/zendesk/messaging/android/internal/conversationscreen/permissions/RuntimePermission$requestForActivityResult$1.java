package zendesk.messaging.android.internal.conversationscreen.permissions;

import android.content.Intent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import zendesk.messaging.android.internal.model.UploadFile;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lzendesk/messaging/android/internal/model/UploadFile;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission$requestForActivityResult$1", f = "RuntimePermission.kt", i = {0}, l = {134, 135}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: RuntimePermission.kt */
final class RuntimePermission$requestForActivityResult$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends UploadFile>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RuntimePermission this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RuntimePermission$requestForActivityResult$1(Intent intent, RuntimePermission runtimePermission, Continuation<? super RuntimePermission$requestForActivityResult$1> continuation) {
        super(2, continuation);
        this.$intent = intent;
        this.this$0 = runtimePermission;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RuntimePermission$requestForActivityResult$1 runtimePermission$requestForActivityResult$1 = new RuntimePermission$requestForActivityResult$1(this.$intent, this.this$0, continuation);
        runtimePermission$requestForActivityResult$1.L$0 = obj;
        return runtimePermission$requestForActivityResult$1;
    }

    public final Object invoke(FlowCollector<? super List<UploadFile>> flowCollector, Continuation<? super Unit> continuation) {
        return ((RuntimePermission$requestForActivityResult$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
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
            if (r1 == 0) goto L_0x0023
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0097
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0086
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            android.content.Intent r7 = r6.$intent
            java.lang.String r7 = r7.getAction()
            if (r7 == 0) goto L_0x0072
            int r4 = r7.hashCode()
            r5 = -1960745709(0xffffffff8b216513, float:-3.1083512E-32)
            if (r4 == r5) goto L_0x0057
            r5 = -229513525(0xfffffffff251e6cb, float:-4.1575282E30)
            if (r4 == r5) goto L_0x0042
            goto L_0x0072
        L_0x0042:
            java.lang.String r4 = "android.intent.action.OPEN_DOCUMENT"
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L_0x004b
            goto L_0x0072
        L_0x004b:
            zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission r7 = r6.this$0
            androidx.activity.result.ActivityResultLauncher r7 = r7.startActivityForFileResult
            android.content.Intent r4 = r6.$intent
            r7.launch(r4)
            goto L_0x0072
        L_0x0057:
            java.lang.String r4 = "android.media.action.IMAGE_CAPTURE"
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L_0x0060
            goto L_0x0072
        L_0x0060:
            zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission r7 = r6.this$0
            android.net.Uri r7 = r7.getTempCapturedImageUri()
            zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission r4 = r6.this$0
            r4.latestTempUri = r7
            androidx.activity.result.ActivityResultLauncher r4 = r4.startActivityForCameraResult
            r4.launch(r7)
        L_0x0072:
            zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission r7 = r6.this$0
            kotlinx.coroutines.CompletableDeferred r7 = r7.activityResultCompleteDeferred
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.await(r4)
            if (r7 != r0) goto L_0x0086
            return r0
        L_0x0086:
            java.util.List r7 = (java.util.List) r7
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r1.emit(r7, r3)
            if (r7 != r0) goto L_0x0097
            return r0
        L_0x0097:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission$requestForActivityResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
