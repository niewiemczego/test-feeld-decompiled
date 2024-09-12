package zendesk.messaging.android.push;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.push.PushNotifications$displayNotification$1", f = "PushNotifications.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PushNotifications.kt */
final class PushNotifications$displayNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Map<String, String> $messageData;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushNotifications$displayNotification$1(Context context, Map<String, String> map, Continuation<? super PushNotifications$displayNotification$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$messageData = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushNotifications$displayNotification$1(this.$context, this.$messageData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PushNotifications$displayNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0047
        L_0x000f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r9)
            zendesk.messaging.android.push.internal.NotificationProcessor r1 = zendesk.messaging.android.push.PushNotifications.notificationProcessor
            if (r1 == 0) goto L_0x004a
            android.content.Context r9 = r8.$context
            java.util.Map<java.lang.String, java.lang.String> r3 = r8.$messageData
            zendesk.messaging.android.push.internal.NotificationBuilder r4 = new zendesk.messaging.android.push.internal.NotificationBuilder
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r6 = r8.$context
            java.lang.String r7 = "MESSAGING_NOTIFICATION_CHANNEL_ID"
            r5.<init>((android.content.Context) r6, (java.lang.String) r7)
            android.content.Context r6 = r8.$context
            r4.<init>(r5, r6)
            zendesk.messaging.android.push.PushNotifications r5 = zendesk.messaging.android.push.PushNotifications.INSTANCE
            int r5 = r5.getSmallNotificationIconId$zendesk_messaging_messaging_android()
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.label = r2
            r2 = r9
            java.lang.Object r9 = r1.displayPushNotification(r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0047
            return r0
        L_0x0047:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x004b
        L_0x004a:
            r9 = 0
        L_0x004b:
            if (r9 != 0) goto L_0x0057
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r0 = "PushNotifications"
            java.lang.String r1 = "Cannot display notification because internal push setup has not completed"
            zendesk.logger.Logger.w(r0, r1, r9)
        L_0x0057:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.push.PushNotifications$displayNotification$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
