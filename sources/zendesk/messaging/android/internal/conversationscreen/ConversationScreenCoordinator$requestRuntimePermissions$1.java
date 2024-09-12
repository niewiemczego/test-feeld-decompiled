package zendesk.messaging.android.internal.conversationscreen;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1", f = "ConversationScreenCoordinator.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$requestRuntimePermissions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $requestedPermissions;
    final /* synthetic */ RuntimePermission $runtimePermission;
    int label;
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$requestRuntimePermissions$1(RuntimePermission runtimePermission, List<String> list, ConversationScreenCoordinator conversationScreenCoordinator, Continuation<? super ConversationScreenCoordinator$requestRuntimePermissions$1> continuation) {
        super(2, continuation);
        this.$runtimePermission = runtimePermission;
        this.$requestedPermissions = list;
        this.this$0 = conversationScreenCoordinator;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationScreenCoordinator$requestRuntimePermissions$1(this.$runtimePermission, this.$requestedPermissions, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationScreenCoordinator$requestRuntimePermissions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<List<RuntimePermissionState>> requestRuntimePermission$zendesk_messaging_messaging_android = this.$runtimePermission.requestRuntimePermission$zendesk_messaging_messaging_android(this.$requestedPermissions);
            final List<String> list = this.$requestedPermissions;
            final ConversationScreenCoordinator conversationScreenCoordinator = this.this$0;
            final RuntimePermission runtimePermission = this.$runtimePermission;
            this.label = 1;
            if (requestRuntimePermission$zendesk_messaging_messaging_android.collect(new FlowCollector() {
                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
                    if (r7.equals("android.permission.READ_MEDIA_VIDEO") == false) goto L_0x00f7;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
                    if (r7.equals("android.permission.READ_MEDIA_AUDIO") == false) goto L_0x00f7;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b2, code lost:
                    if (r7.equals("android.permission.READ_MEDIA_IMAGES") == false) goto L_0x00f7;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b5, code lost:
                    r2 = r1.attachmentIntents.getAttachmentIntent();
                    r5.label = 3;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c3, code lost:
                    if (r1.requestForMultiplePermissions$zendesk_messaging_messaging_android(r11, r12, r2, r5) != r0) goto L_0x00f7;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
                    return r0;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(java.util.List<zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1
                        if (r0 == 0) goto L_0x0014
                        r0 = r12
                        zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L_0x0014
                        int r12 = r0.label
                        int r12 = r12 - r2
                        r0.label = r12
                        goto L_0x0019
                    L_0x0014:
                        zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1$1$emit$1
                        r0.<init>(r10, r12)
                    L_0x0019:
                        r5 = r0
                        java.lang.Object r12 = r5.result
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r5.label
                        r2 = 4
                        r3 = 3
                        r4 = 2
                        r6 = 1
                        if (r1 == 0) goto L_0x003e
                        if (r1 == r6) goto L_0x0039
                        if (r1 == r4) goto L_0x0039
                        if (r1 == r3) goto L_0x0039
                        if (r1 != r2) goto L_0x0031
                        goto L_0x0039
                    L_0x0031:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L_0x0039:
                        kotlin.ResultKt.throwOnFailure(r12)
                        goto L_0x00f7
                    L_0x003e:
                        kotlin.ResultKt.throwOnFailure(r12)
                        r12 = r11
                        java.lang.Iterable r12 = (java.lang.Iterable) r12
                        java.util.List<java.lang.String> r1 = r3
                        java.util.Iterator r12 = r12.iterator()
                    L_0x004a:
                        boolean r7 = r12.hasNext()
                        if (r7 == 0) goto L_0x0067
                        java.lang.Object r7 = r12.next()
                        r8 = r7
                        zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState r8 = (zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState) r8
                        java.lang.String r8 = r8.getPermission()
                        r9 = 0
                        java.lang.Object r9 = r1.get(r9)
                        boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
                        if (r8 == 0) goto L_0x004a
                        goto L_0x0068
                    L_0x0067:
                        r7 = 0
                    L_0x0068:
                        zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState r7 = (zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermissionState) r7
                        if (r7 == 0) goto L_0x00f7
                        zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator r1 = r4
                        zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission r12 = r5
                        java.lang.String r7 = r7.getPermission()
                        if (r7 == 0) goto L_0x00f7
                        int r8 = r7.hashCode()
                        switch(r8) {
                            case -1925850455: goto L_0x00e0;
                            case -406040016: goto L_0x00c6;
                            case 175802396: goto L_0x00ac;
                            case 463403621: goto L_0x0092;
                            case 691260818: goto L_0x0089;
                            case 710297143: goto L_0x007f;
                            default: goto L_0x007d;
                        }
                    L_0x007d:
                        goto L_0x00f7
                    L_0x007f:
                        java.lang.String r2 = "android.permission.READ_MEDIA_VIDEO"
                        boolean r2 = r7.equals(r2)
                        if (r2 != 0) goto L_0x00b5
                        goto L_0x00f7
                    L_0x0089:
                        java.lang.String r2 = "android.permission.READ_MEDIA_AUDIO"
                        boolean r2 = r7.equals(r2)
                        if (r2 != 0) goto L_0x00b5
                        goto L_0x00f7
                    L_0x0092:
                        java.lang.String r2 = "android.permission.CAMERA"
                        boolean r2 = r7.equals(r2)
                        if (r2 != 0) goto L_0x009b
                        goto L_0x00f7
                    L_0x009b:
                        zendesk.messaging.android.internal.AttachmentIntents r2 = r1.attachmentIntents
                        android.content.Intent r2 = r2.getCameraIntent()
                        r5.label = r6
                        java.lang.Object r11 = r1.requestForMultiplePermissions$zendesk_messaging_messaging_android(r11, r12, r2, r5)
                        if (r11 != r0) goto L_0x00f7
                        return r0
                    L_0x00ac:
                        java.lang.String r2 = "android.permission.READ_MEDIA_IMAGES"
                        boolean r2 = r7.equals(r2)
                        if (r2 != 0) goto L_0x00b5
                        goto L_0x00f7
                    L_0x00b5:
                        zendesk.messaging.android.internal.AttachmentIntents r2 = r1.attachmentIntents
                        android.content.Intent r2 = r2.getAttachmentIntent()
                        r5.label = r3
                        java.lang.Object r11 = r1.requestForMultiplePermissions$zendesk_messaging_messaging_android(r11, r12, r2, r5)
                        if (r11 != r0) goto L_0x00f7
                        return r0
                    L_0x00c6:
                        java.lang.String r2 = "android.permission.READ_EXTERNAL_STORAGE"
                        boolean r2 = r7.equals(r2)
                        if (r2 != 0) goto L_0x00cf
                        goto L_0x00f7
                    L_0x00cf:
                        zendesk.messaging.android.internal.AttachmentIntents r2 = r1.attachmentIntents
                        android.content.Intent r2 = r2.getAttachmentIntent()
                        r5.label = r4
                        java.lang.Object r11 = r1.requestForMultiplePermissions$zendesk_messaging_messaging_android(r11, r12, r2, r5)
                        if (r11 != r0) goto L_0x00f7
                        return r0
                    L_0x00e0:
                        java.lang.String r3 = "android.permission.POST_NOTIFICATIONS"
                        boolean r3 = r7.equals(r3)
                        if (r3 != 0) goto L_0x00e9
                        goto L_0x00f7
                    L_0x00e9:
                        r4 = 0
                        r6 = 4
                        r7 = 0
                        r5.label = r2
                        r2 = r11
                        r3 = r12
                        java.lang.Object r11 = zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator.requestForMultiplePermissions$zendesk_messaging_messaging_android$default(r1, r2, r3, r4, r5, r6, r7)
                        if (r11 != r0) goto L_0x00f7
                        return r0
                    L_0x00f7:
                        kotlin.Unit r11 = kotlin.Unit.INSTANCE
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenCoordinator$requestRuntimePermissions$1.AnonymousClass1.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
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
}
