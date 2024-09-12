package com.braze.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.braze.Braze;
import com.braze.Constants;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¨\u0006\u0014"}, d2 = {"Lcom/braze/push/BrazeNotificationActionUtils;", "", "()V", "addNotificationAction", "", "notificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "payload", "Lcom/braze/models/push/BrazeNotificationPayload;", "actionButton", "Lcom/braze/models/push/BrazeNotificationPayload$ActionButton;", "addNotificationActions", "handleNotificationActionClicked", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "logNotificationActionClicked", "actionType", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationActionUtils.kt */
public final class BrazeNotificationActionUtils {
    public static final BrazeNotificationActionUtils INSTANCE = new BrazeNotificationActionUtils();

    private BrazeNotificationActionUtils() {
    }

    @JvmStatic
    public static final void addNotificationActions(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (brazeNotificationPayload.getContext() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationActionUtils$addNotificationActions$1.INSTANCE, 3, (Object) null);
            return;
        }
        List<BrazeNotificationPayload.ActionButton> actionButtons = brazeNotificationPayload.getActionButtons();
        if (actionButtons.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationActionUtils$addNotificationActions$2.INSTANCE, 3, (Object) null);
            return;
        }
        for (BrazeNotificationPayload.ActionButton next : actionButtons) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationActionUtils brazeNotificationActionUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationActionUtils, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationActionUtils$addNotificationActions$3(next), 2, (Object) null);
            brazeNotificationActionUtils.addNotificationAction(builder, brazeNotificationPayload, next);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023 A[Catch:{ Exception -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[Catch:{ Exception -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097 A[Catch:{ Exception -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ca A[Catch:{ Exception -> 0x00ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ce A[Catch:{ Exception -> 0x00ee }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void handleNotificationActionClicked(android.content.Context r11, android.content.Intent r12) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "braze_action_type"
            java.lang.String r0 = r12.getStringExtra(r0)     // Catch:{ Exception -> 0x00ee }
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00ee }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0020
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch:{ Exception -> 0x00ee }
            if (r1 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r1 = r2
            goto L_0x0021
        L_0x0020:
            r1 = r3
        L_0x0021:
            if (r1 == 0) goto L_0x0035
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00ee }
            com.braze.push.BrazeNotificationActionUtils r5 = INSTANCE     // Catch:{ Exception -> 0x00ee }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00ee }
            r7 = 0
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$1 r11 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$1.INSTANCE     // Catch:{ Exception -> 0x00ee }
            r8 = r11
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8     // Catch:{ Exception -> 0x00ee }
            r9 = 2
            r10 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x00ee }
            return
        L_0x0035:
            java.lang.String r1 = "nid"
            r4 = -1
            int r1 = r12.getIntExtra(r1, r4)     // Catch:{ Exception -> 0x00ee }
            com.braze.push.BrazeNotificationActionUtils r5 = INSTANCE     // Catch:{ Exception -> 0x00ee }
            r5.logNotificationActionClicked(r11, r12, r0)     // Catch:{ Exception -> 0x00ee }
            if (r0 == 0) goto L_0x00de
            int r4 = r0.hashCode()     // Catch:{ Exception -> 0x00ee }
            r6 = -1424488370(0xffffffffab18084e, float:-5.4012773E-13)
            java.lang.String r7 = "ab_uri"
            if (r4 == r6) goto L_0x0072
            r6 = -1209677674(0xffffffffb7e5c896, float:-2.7392332E-5)
            if (r4 == r6) goto L_0x0063
            r6 = -1209647192(0xffffffffb7e63fa8, float:-2.7447779E-5)
            if (r4 == r6) goto L_0x005a
            goto L_0x00de
        L_0x005a:
            java.lang.String r4 = "ab_open"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x00ee }
            if (r4 == 0) goto L_0x00de
            goto L_0x0079
        L_0x0063:
            java.lang.String r12 = "ab_none"
            boolean r12 = r0.equals(r12)     // Catch:{ Exception -> 0x00ee }
            if (r12 != 0) goto L_0x006d
            goto L_0x00de
        L_0x006d:
            com.braze.push.BrazeNotificationUtils.cancelNotification(r11, r1)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00fe
        L_0x0072:
            boolean r4 = r0.equals(r7)     // Catch:{ Exception -> 0x00ee }
            if (r4 != 0) goto L_0x0079
            goto L_0x00de
        L_0x0079:
            com.braze.push.BrazeNotificationUtils.cancelNotification(r11, r1)     // Catch:{ Exception -> 0x00ee }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r1 = "uri"
            if (r0 == 0) goto L_0x00b9
            android.os.Bundle r0 = r12.getExtras()     // Catch:{ Exception -> 0x00ee }
            java.lang.String r4 = "braze_action_uri"
            if (r0 == 0) goto L_0x0094
            boolean r0 = r0.containsKey(r4)     // Catch:{ Exception -> 0x00ee }
            if (r0 != r3) goto L_0x0094
            r0 = r3
            goto L_0x0095
        L_0x0094:
            r0 = r2
        L_0x0095:
            if (r0 == 0) goto L_0x00b9
            java.lang.String r0 = r12.getStringExtra(r4)     // Catch:{ Exception -> 0x00ee }
            r12.putExtra(r1, r0)     // Catch:{ Exception -> 0x00ee }
            android.os.Bundle r0 = r12.getExtras()     // Catch:{ Exception -> 0x00ee }
            java.lang.String r1 = "braze_action_use_webview"
            if (r0 == 0) goto L_0x00ad
            boolean r0 = r0.containsKey(r1)     // Catch:{ Exception -> 0x00ee }
            if (r0 != r3) goto L_0x00ad
            r2 = r3
        L_0x00ad:
            if (r2 == 0) goto L_0x00bc
            java.lang.String r0 = "ab_use_webview"
            java.lang.String r1 = r12.getStringExtra(r1)     // Catch:{ Exception -> 0x00ee }
            r12.putExtra(r0, r1)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00bc
        L_0x00b9:
            r12.removeExtra(r1)     // Catch:{ Exception -> 0x00ee }
        L_0x00bc:
            com.braze.push.BrazeNotificationUtils.sendNotificationOpenedBroadcast(r11, r12)     // Catch:{ Exception -> 0x00ee }
            com.braze.configuration.BrazeConfigurationProvider r0 = new com.braze.configuration.BrazeConfigurationProvider     // Catch:{ Exception -> 0x00ee }
            r0.<init>(r11)     // Catch:{ Exception -> 0x00ee }
            boolean r0 = r0.getDoesHandlePushDeepLinksAutomatically()     // Catch:{ Exception -> 0x00ee }
            if (r0 == 0) goto L_0x00ce
            com.braze.push.BrazeNotificationUtils.routeUserWithNotificationOpenedIntent(r11, r12)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00fe
        L_0x00ce:
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00ee }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.I     // Catch:{ Exception -> 0x00ee }
            r7 = 0
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$2 r11 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$2.INSTANCE     // Catch:{ Exception -> 0x00ee }
            r8 = r11
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8     // Catch:{ Exception -> 0x00ee }
            r9 = 2
            r10 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00fe
        L_0x00de:
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x00ee }
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x00ee }
            r7 = 0
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$3 r11 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$3.INSTANCE     // Catch:{ Exception -> 0x00ee }
            r8 = r11
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8     // Catch:{ Exception -> 0x00ee }
            r9 = 2
            r10 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00fe
        L_0x00ee:
            r11 = move-exception
            com.braze.support.BrazeLogger r12 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.push.BrazeNotificationActionUtils r0 = INSTANCE
            com.braze.support.BrazeLogger$Priority r1 = com.braze.support.BrazeLogger.Priority.E
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$4 r2 = com.braze.push.BrazeNotificationActionUtils$handleNotificationActionClicked$4.INSTANCE
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r12.brazelog((java.lang.Object) r0, (com.braze.support.BrazeLogger.Priority) r1, (java.lang.Throwable) r11, (kotlin.jvm.functions.Function0<java.lang.String>) r2)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazeNotificationActionUtils.handleNotificationActionClicked(android.content.Context, android.content.Intent):void");
    }

    public final void addNotificationAction(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload, BrazeNotificationPayload.ActionButton actionButton) {
        PendingIntent pendingIntent;
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Intrinsics.checkNotNullParameter(actionButton, "actionButton");
        Context context = brazeNotificationPayload.getContext();
        if (context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationActionUtils$addNotificationAction$1.INSTANCE, 3, (Object) null);
            return;
        }
        Bundle bundle = new Bundle(brazeNotificationPayload.getNotificationExtras());
        actionButton.putIntoBundle(bundle);
        String type = actionButton.getType();
        int immutablePendingIntentFlags = 134217728 | IntentUtils.getImmutablePendingIntentFlags();
        if (Intrinsics.areEqual((Object) Constants.BRAZE_PUSH_ACTION_TYPE_NONE, (Object) type)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationActionUtils$addNotificationAction$2(type), 2, (Object) null);
            Intent intent = new Intent(Constants.BRAZE_ACTION_CLICKED_ACTION).setClass(context, BrazeNotificationUtils.getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_A…ceiverClass\n            )");
            intent.putExtras(bundle);
            pendingIntent = PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, immutablePendingIntentFlags);
            Intrinsics.checkNotNullExpressionValue(pendingIntent, "getBroadcast(\n          …IntentFlags\n            )");
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationActionUtils$addNotificationAction$3(type), 2, (Object) null);
            Intent intent2 = new Intent(Constants.BRAZE_ACTION_CLICKED_ACTION).setClass(context, NotificationTrampolineActivity.class);
            Intrinsics.checkNotNullExpressionValue(intent2, "Intent(Constants.BRAZE_A…lineActivity::class.java)");
            intent2.setFlags(intent2.getFlags() | BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_ACTION_WITH_DEEPLINK));
            intent2.putExtras(bundle);
            pendingIntent = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent2, immutablePendingIntentFlags);
            Intrinsics.checkNotNullExpressionValue(pendingIntent, "getActivity(\n           …IntentFlags\n            )");
        }
        NotificationCompat.Action.Builder builder2 = new NotificationCompat.Action.Builder(0, (CharSequence) actionButton.getText(), pendingIntent);
        builder2.addExtras(new Bundle(bundle));
        builder.addAction(builder2.build());
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationActionUtils$addNotificationAction$4(bundle), 2, (Object) null);
    }

    public final void logNotificationActionClicked(Context context, Intent intent, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Braze.Companion.getInstance(context).logPushNotificationActionClicked(intent.getStringExtra(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY), intent.getStringExtra(Constants.BRAZE_ACTION_ID_KEY), str);
    }
}
