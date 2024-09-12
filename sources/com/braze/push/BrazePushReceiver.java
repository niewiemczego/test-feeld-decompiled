package com.braze.push;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/braze/push/BrazePushReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazePushReceiver.kt */
public class BrazePushReceiver extends BroadcastReceiver {
    private static final String ADM_ERROR_DESCRIPTION_KEY = "error_description";
    private static final String ADM_ERROR_KEY = "error";
    private static final String ADM_RECEIVE_INTENT_ACTION = "com.amazon.device.messaging.intent.RECEIVE";
    private static final String ADM_REGISTRATION_ID_KEY = "registration_id";
    private static final String ADM_REGISTRATION_INTENT_ACTION = "com.amazon.device.messaging.intent.REGISTRATION";
    private static final String ADM_UNREGISTERED_KEY = "unregistered";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DELETED_MESSAGES_KEY = "deleted_messages";
    public static final String FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION = "firebase_messaging_service_routing_action";
    public static final String HMS_PUSH_SERVICE_ROUTING_ACTION = "hms_push_service_routing_action";
    private static final String MESSAGE_TYPE_KEY = "message_type";
    private static final String NUMBER_OF_MESSAGES_DELETED_KEY = "total_deleted";

    @JvmStatic
    public static final BrazeNotificationPayload createPayload(Context context, BrazeConfigurationProvider brazeConfigurationProvider, Bundle bundle, Bundle bundle2) {
        return Companion.createPayload(context, brazeConfigurationProvider, bundle, bundle2);
    }

    @JvmStatic
    public static final boolean handleAdmRegistrationEventIfEnabled(BrazeConfigurationProvider brazeConfigurationProvider, Context context, Intent intent) {
        return Companion.handleAdmRegistrationEventIfEnabled(brazeConfigurationProvider, context, intent);
    }

    @JvmStatic
    public static final boolean handleAdmRegistrationIntent(Context context, Intent intent) {
        return Companion.handleAdmRegistrationIntent(context, intent);
    }

    @JvmStatic
    public static final boolean handlePushNotificationPayload(Context context, Intent intent) {
        return Companion.handlePushNotificationPayload(context, intent);
    }

    @JvmStatic
    public static final void handleReceivedIntent(Context context, Intent intent) {
        Companion.handleReceivedIntent(context, intent);
    }

    @JvmStatic
    public static final void handleReceivedIntent(Context context, Intent intent, boolean z) {
        Companion.handleReceivedIntent(context, intent, z);
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Companion.handleReceivedIntent$default(Companion, context, intent, false, 4, (Object) null);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\"\u0010 \u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u0019H\u0007J\u001d\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0010H\u0001¢\u0006\u0002\b$R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/braze/push/BrazePushReceiver$Companion;", "", "()V", "ADM_ERROR_DESCRIPTION_KEY", "", "ADM_ERROR_KEY", "ADM_RECEIVE_INTENT_ACTION", "ADM_REGISTRATION_ID_KEY", "ADM_REGISTRATION_INTENT_ACTION", "ADM_UNREGISTERED_KEY", "DELETED_MESSAGES_KEY", "FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION", "HMS_PUSH_SERVICE_ROUTING_ACTION", "MESSAGE_TYPE_KEY", "NUMBER_OF_MESSAGES_DELETED_KEY", "createPayload", "Lcom/braze/models/push/BrazeNotificationPayload;", "context", "Landroid/content/Context;", "appConfigurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "notificationExtras", "Landroid/os/Bundle;", "brazeExtras", "handleAdmRegistrationEventIfEnabled", "", "intent", "Landroid/content/Intent;", "handleAdmRegistrationIntent", "handlePush", "", "handlePushNotificationPayload", "handleReceivedIntent", "runOnThread", "logNotificationMetadata", "payload", "logNotificationMetadata$android_sdk_ui_release", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazePushReceiver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void handleReceivedIntent(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            handleReceivedIntent$default(this, context, intent, false, 4, (Object) null);
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void handlePush(Context context, Intent intent) {
            Context applicationContext = context.getApplicationContext();
            String action = intent.getAction();
            try {
                handlePush$performWork(action, applicationContext, intent, context);
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new BrazePushReceiver$Companion$handlePush$1(action, intent));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
            if (r8.equals(com.braze.push.BrazePushReceiver.HMS_PUSH_SERVICE_ROUTING_ACTION) == false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
            if (r8.equals(com.braze.push.BrazePushReceiver.ADM_RECEIVE_INTENT_ACTION) == false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
            if (r8.equals(com.braze.Constants.BRAZE_STORY_TRAVERSE_CLICKED_ACTION) == false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ac, code lost:
            if (r8.equals(com.braze.push.BrazePushReceiver.FIREBASE_MESSAGING_SERVICE_ROUTING_ACTION) == false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00af, code lost:
            com.braze.push.BrazePushReceiver.Companion.handlePushNotificationPayload(r9, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
            com.braze.support.BrazeLogger.brazelog$default(com.braze.support.BrazeLogger.INSTANCE, (java.lang.Object) com.braze.push.BrazePushReceiver.Companion, com.braze.support.BrazeLogger.Priority.W, (java.lang.Throwable) null, (kotlin.jvm.functions.Function0) com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$3.INSTANCE, 2, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static final void handlePush$performWork(java.lang.String r8, android.content.Context r9, android.content.Intent r10, android.content.Context r11) {
            /*
                com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.push.BrazePushReceiver$Companion r1 = com.braze.push.BrazePushReceiver.Companion
                com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.I
                com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$1 r3 = new com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$1
                r3.<init>(r10)
                r4 = r3
                kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
                r3 = 0
                r5 = 2
                r6 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
                r0 = r8
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                if (r0 == 0) goto L_0x0022
                int r0 = r0.length()
                if (r0 != 0) goto L_0x0020
                goto L_0x0022
            L_0x0020:
                r0 = 0
                goto L_0x0023
            L_0x0022:
                r0 = 1
            L_0x0023:
                if (r0 == 0) goto L_0x003a
                com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.push.BrazePushReceiver$Companion r2 = com.braze.push.BrazePushReceiver.Companion
                com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
                r4 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$2 r8 = new com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$2
                r8.<init>(r10)
                r5 = r8
                kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                r6 = 2
                r7 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
                return
            L_0x003a:
                java.lang.String r0 = "applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
                com.braze.BrazeInternal.applyPendingRuntimeConfiguration(r9)
                int r0 = r8.hashCode()
                switch(r0) {
                    case -2147185193: goto L_0x00c2;
                    case -1799205286: goto L_0x00b5;
                    case -1584985748: goto L_0x00a6;
                    case -1249868226: goto L_0x0099;
                    case -743092218: goto L_0x0085;
                    case -711830027: goto L_0x007c;
                    case -559929808: goto L_0x006e;
                    case 34673601: goto L_0x005f;
                    case 1060266838: goto L_0x0055;
                    case 1740454061: goto L_0x004b;
                    default: goto L_0x0049;
                }
            L_0x0049:
                goto L_0x00cf
            L_0x004b:
                java.lang.String r11 = "hms_push_service_routing_action"
                boolean r8 = r8.equals(r11)
                if (r8 != 0) goto L_0x00af
                goto L_0x00cf
            L_0x0055:
                java.lang.String r11 = "com.amazon.device.messaging.intent.RECEIVE"
                boolean r8 = r8.equals(r11)
                if (r8 != 0) goto L_0x00af
                goto L_0x00cf
            L_0x005f:
                java.lang.String r9 = "com.braze.action.BRAZE_STORY_CLICKED"
                boolean r8 = r8.equals(r9)
                if (r8 != 0) goto L_0x0069
                goto L_0x00cf
            L_0x0069:
                com.braze.push.BrazeNotificationUtils.handlePushStoryPageClicked(r11, r10)
                goto L_0x00e0
            L_0x006e:
                java.lang.String r11 = "com.braze.action.BRAZE_PUSH_DELETED"
                boolean r8 = r8.equals(r11)
                if (r8 != 0) goto L_0x0077
                goto L_0x00cf
            L_0x0077:
                com.braze.push.BrazeNotificationUtils.handleNotificationDeleted(r9, r10)
                goto L_0x00e0
            L_0x007c:
                java.lang.String r11 = "com.braze.action.STORY_TRAVERSE"
                boolean r8 = r8.equals(r11)
                if (r8 != 0) goto L_0x00af
                goto L_0x00cf
            L_0x0085:
                java.lang.String r11 = "com.amazon.device.messaging.intent.REGISTRATION"
                boolean r8 = r8.equals(r11)
                if (r8 != 0) goto L_0x008e
                goto L_0x00cf
            L_0x008e:
                com.braze.push.BrazePushReceiver$Companion r8 = com.braze.push.BrazePushReceiver.Companion
                com.braze.configuration.BrazeConfigurationProvider r11 = new com.braze.configuration.BrazeConfigurationProvider
                r11.<init>(r9)
                r8.handleAdmRegistrationEventIfEnabled(r11, r9, r10)
                goto L_0x00e0
            L_0x0099:
                java.lang.String r9 = "com.braze.action.BRAZE_PUSH_CLICKED"
                boolean r8 = r8.equals(r9)
                if (r8 != 0) goto L_0x00a2
                goto L_0x00cf
            L_0x00a2:
                com.braze.push.BrazeNotificationUtils.handleNotificationOpened(r11, r10)
                goto L_0x00e0
            L_0x00a6:
                java.lang.String r11 = "firebase_messaging_service_routing_action"
                boolean r8 = r8.equals(r11)
                if (r8 != 0) goto L_0x00af
                goto L_0x00cf
            L_0x00af:
                com.braze.push.BrazePushReceiver$Companion r8 = com.braze.push.BrazePushReceiver.Companion
                r8.handlePushNotificationPayload(r9, r10)
                goto L_0x00e0
            L_0x00b5:
                java.lang.String r9 = "com.braze.action.BRAZE_ACTION_CLICKED"
                boolean r8 = r8.equals(r9)
                if (r8 != 0) goto L_0x00be
                goto L_0x00cf
            L_0x00be:
                com.braze.push.BrazeNotificationActionUtils.handleNotificationActionClicked(r11, r10)
                goto L_0x00e0
            L_0x00c2:
                java.lang.String r11 = "com.braze.action.CANCEL_NOTIFICATION"
                boolean r8 = r8.equals(r11)
                if (r8 != 0) goto L_0x00cb
                goto L_0x00cf
            L_0x00cb:
                com.braze.push.BrazeNotificationUtils.handleCancelNotificationAction(r9, r10)
                goto L_0x00e0
            L_0x00cf:
                com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.push.BrazePushReceiver$Companion r1 = com.braze.push.BrazePushReceiver.Companion
                com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.W
                r3 = 0
                com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$3 r8 = com.braze.push.BrazePushReceiver$Companion$handlePush$performWork$3.INSTANCE
                r4 = r8
                kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
                r5 = 2
                r6 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            L_0x00e0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazePushReceiver.Companion.handlePush$performWork(java.lang.String, android.content.Context, android.content.Intent, android.content.Context):void");
        }

        public static /* synthetic */ void handleReceivedIntent$default(Companion companion, Context context, Intent intent, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            companion.handleReceivedIntent(context, intent, z);
        }

        @JvmStatic
        public final void handleReceivedIntent(Context context, Intent intent, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            if (z) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BrazePushReceiver$Companion$handleReceivedIntent$1(context, intent, (Continuation<? super BrazePushReceiver$Companion$handleReceivedIntent$1>) null), 3, (Object) null);
            } else {
                handlePush(context, intent);
            }
        }

        @JvmStatic
        public final boolean handleAdmRegistrationEventIfEnabled(BrazeConfigurationProvider brazeConfigurationProvider, Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$1(intent), 2, (Object) null);
            if (!Constants.isAmazonDevice() || !brazeConfigurationProvider.isAdmMessagingRegistrationEnabled()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3.INSTANCE, 2, (Object) null);
                return false;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$2.INSTANCE, 3, (Object) null);
            handleAdmRegistrationIntent(context, intent);
            return true;
        }

        @JvmStatic
        public final boolean handleAdmRegistrationIntent(Context context, Intent intent) {
            Context context2 = context;
            Intent intent2 = intent;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(intent2, SDKConstants.PARAM_INTENT);
            String stringExtra = intent2.getStringExtra("error");
            String stringExtra2 = intent2.getStringExtra("error_description");
            String stringExtra3 = intent2.getStringExtra(BrazePushReceiver.ADM_REGISTRATION_ID_KEY);
            String stringExtra4 = intent2.getStringExtra(BrazePushReceiver.ADM_UNREGISTERED_KEY);
            if (stringExtra != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$1(stringExtra, stringExtra2), 2, (Object) null);
                return true;
            } else if (stringExtra3 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$2(stringExtra3), 2, (Object) null);
                Braze.Companion.getInstance(context2).setRegisteredPushToken(stringExtra3);
                return true;
            } else if (stringExtra4 != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handleAdmRegistrationIntent$3(stringExtra4), 2, (Object) null);
                return true;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazePushReceiver$Companion$handleAdmRegistrationIntent$4.INSTANCE, 2, (Object) null);
                return false;
            }
        }

        @JvmStatic
        public final boolean handlePushNotificationPayload(Context context, Intent intent) {
            Context context2 = context;
            Intent intent2 = intent;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(intent2, SDKConstants.PARAM_INTENT);
            if (!BrazeNotificationUtils.isBrazePushMessage(intent)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$1.INSTANCE, 3, (Object) null);
                return false;
            } else if (Intrinsics.areEqual((Object) "deleted_messages", (Object) intent2.getStringExtra("message_type"))) {
                int intExtra = intent2.getIntExtra(BrazePushReceiver.NUMBER_OF_MESSAGES_DELETED_KEY, -1);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handlePushNotificationPayload$2(intExtra), 2, (Object) null);
                return false;
            } else {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    return false;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handlePushNotificationPayload$3(extras), 2, (Object) null);
                Bundle attachedBrazeExtras = BrazeNotificationPayload.Companion.getAttachedBrazeExtras(extras);
                extras.putBundle("extra", attachedBrazeExtras);
                if (!extras.containsKey(Constants.BRAZE_PUSH_RECEIVED_TIMESTAMP_MILLIS)) {
                    extras.putLong(Constants.BRAZE_PUSH_RECEIVED_TIMESTAMP_MILLIS, System.currentTimeMillis());
                }
                BrazeConfigurationProvider brazeConfigurationProvider = new BrazeConfigurationProvider(context2);
                BrazeNotificationPayload createPayload = createPayload(context2, brazeConfigurationProvider, extras, attachedBrazeExtras);
                if (createPayload.isUninstallTrackingPush()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$4.INSTANCE, 2, (Object) null);
                    return false;
                }
                String pushUniqueId = createPayload.getPushUniqueId();
                if (pushUniqueId == null || BrazeInternal.INSTANCE.validateAndStorePushId(context2, pushUniqueId)) {
                    BrazeNotificationUtils.handleContentCardsSerializedCardIfPresent(createPayload);
                    if (createPayload.getShouldFetchTestTriggers() && brazeConfigurationProvider.isInAppMessageTestPushEagerDisplayEnabled() && BrazeInAppMessageManager.Companion.getInstance().getActivity() != null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$6.INSTANCE, 3, (Object) null);
                        BrazeInternal.handleInAppMessageTestPush(context, intent);
                        return false;
                    } else if (BrazeNotificationUtils.isNotificationMessage(intent)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$7.INSTANCE, 3, (Object) null);
                        int notificationId = BrazeNotificationUtils.getNotificationId(createPayload);
                        extras.putInt(Constants.BRAZE_PUSH_NOTIFICATION_ID, notificationId);
                        if (createPayload.isPushStory()) {
                            if (Constants.isAmazonDevice()) {
                                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$8.INSTANCE, 3, (Object) null);
                                return false;
                            } else if (!extras.containsKey(Constants.BRAZE_PUSH_STORY_IS_NEWLY_RECEIVED)) {
                                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$9.INSTANCE, 3, (Object) null);
                                extras.putBoolean(Constants.BRAZE_PUSH_STORY_IS_NEWLY_RECEIVED, true);
                            }
                        }
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handlePushNotificationPayload$10(createPayload), 2, (Object) null);
                        Notification createNotification = BrazeNotificationUtils.getActiveNotificationFactory().createNotification(createPayload);
                        if (createNotification == null) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$11.INSTANCE, 3, (Object) null);
                            return false;
                        }
                        NotificationManagerCompat from = NotificationManagerCompat.from(context);
                        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handlePushNotificationPayload$12(from), 3, (Object) null);
                        from.notify(Constants.BRAZE_PUSH_NOTIFICATION_TAG, notificationId, createNotification);
                        BrazeNotificationUtils.sendPushMessageReceivedBroadcast(context2, extras, createPayload);
                        BrazeNotificationUtils.wakeScreenIfAppropriate(context2, brazeConfigurationProvider, extras);
                        Integer pushDuration = createPayload.getPushDuration();
                        if (pushDuration != null) {
                            BrazeNotificationUtils.setNotificationDurationAlarm(context2, BrazePushReceiver.class, notificationId, pushDuration.intValue());
                        }
                        logNotificationMetadata$android_sdk_ui_release(context2, createPayload);
                        return true;
                    } else {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazePushReceiver$Companion$handlePushNotificationPayload$14.INSTANCE, 3, (Object) null);
                        BrazeNotificationUtils.sendPushMessageReceivedBroadcast(context2, extras, createPayload);
                        BrazeNotificationUtils.requestGeofenceRefreshIfAppropriate(createPayload);
                        BrazeNotificationUtils.refreshFeatureFlagsIfAppropriate(createPayload);
                        return false;
                    }
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) BrazePushReceiver.Companion, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazePushReceiver$Companion$handlePushNotificationPayload$5$1(pushUniqueId), 2, (Object) null);
                    return false;
                }
            }
        }

        @JvmStatic
        public final BrazeNotificationPayload createPayload(Context context, BrazeConfigurationProvider brazeConfigurationProvider, Bundle bundle, Bundle bundle2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
            Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
            Intrinsics.checkNotNullParameter(bundle2, "brazeExtras");
            if (Constants.isAmazonDevice()) {
                return new BrazeNotificationPayload(bundle, BrazeNotificationPayload.Companion.getAttachedBrazeExtras(bundle), context, brazeConfigurationProvider);
            }
            return new BrazeNotificationPayload(bundle, bundle2, context, brazeConfigurationProvider);
        }

        public final void logNotificationMetadata$android_sdk_ui_release(Context context, BrazeNotificationPayload brazeNotificationPayload) {
            String campaignId;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
            if (brazeNotificationPayload.isPushDeliveryEnabled() && (campaignId = brazeNotificationPayload.getCampaignId()) != null) {
                long coerceAtLeast = RangesKt.coerceAtLeast(brazeNotificationPayload.getFlushMinMinutes(), 0);
                long coerceAtLeast2 = RangesKt.coerceAtLeast(brazeNotificationPayload.getFlushMaxMinutes(), coerceAtLeast);
                long millis = TimeUnit.MINUTES.toMillis(coerceAtLeast);
                if (coerceAtLeast2 > coerceAtLeast) {
                    millis = Random.Default.nextLong(millis, TimeUnit.MINUTES.toMillis(coerceAtLeast2));
                }
                BrazeInternal.INSTANCE.logPushDelivery(context, campaignId, millis);
            }
            String campaignId2 = brazeNotificationPayload.getCampaignId();
            if (campaignId2 != null) {
                BrazeInternal.INSTANCE.logPushCampaign(context, campaignId2);
            }
        }
    }
}
