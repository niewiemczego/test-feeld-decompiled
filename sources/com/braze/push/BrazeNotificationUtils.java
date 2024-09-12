package com.braze.push;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.Constants;
import com.braze.IBrazeNotificationFactory;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.Channel;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.push.support.HtmlUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.support.JsonUtils;
import com.braze.support.PermissionUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.UriAction;
import com.braze.ui.support.UriUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001TB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0007J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0007J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010+\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0013H\u0007J\u001c\u0010.\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u00101\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u00102\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u00103\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0007J\u0018\u00104\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0007J\"\u00105\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00106\u001a\u00020$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J.\u00105\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00107\u001a\u0002082\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J \u00109\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010=\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010>\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\"\u0010?\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\"\u0010@\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0018\u0010A\u001a\u00020*2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010B\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J.\u0010C\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010E\u001a\u00020\u0013H\u0007J\u0018\u0010F\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010G\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010H\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020K2\u0006\u0010;\u001a\u00020<H\u0007J\u0018\u0010L\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010M\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010N\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010O\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010P\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\"\u0010Q\u001a\u00020*2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010R\u001a\u00020K2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010Q\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\f\u0010S\u001a\u00020**\u00020$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006U"}, d2 = {"Lcom/braze/push/BrazeNotificationUtils;", "", "()V", "SOURCE_KEY", "", "TAG", "activeNotificationFactory", "Lcom/braze/IBrazeNotificationFactory;", "getActiveNotificationFactory", "()Lcom/braze/IBrazeNotificationFactory;", "notificationReceiverClass", "Ljava/lang/Class;", "getNotificationReceiverClass", "()Ljava/lang/Class;", "cancelNotification", "", "context", "Landroid/content/Context;", "notificationId", "", "getNotificationId", "payload", "Lcom/braze/models/push/BrazeNotificationPayload;", "getNotificationPriority", "getOrCreateNotificationChannelId", "getPushActionPendingIntent", "Landroid/app/PendingIntent;", "action", "notificationExtras", "Landroid/os/Bundle;", "getValidNotificationChannel", "Landroid/app/NotificationChannel;", "notificationManager", "Landroid/app/NotificationManager;", "handleCancelNotificationAction", "intent", "Landroid/content/Intent;", "handleContentCardsSerializedCardIfPresent", "handleNotificationDeleted", "handleNotificationOpened", "handlePushStoryPageClicked", "isNotificationMessage", "", "isUninstallTrackingPush", "isValidNotificationVisibility", "visibility", "logBaiduNotificationClick", "customContentString", "prefetchBitmapsIfNewlyReceivedStoryPush", "refreshFeatureFlagsIfAppropriate", "requestGeofenceRefreshIfAppropriate", "routeUserWithNotificationOpenedIntent", "sendNotificationOpenedBroadcast", "sendPushActionIntent", "pushIntent", "broadcastType", "Lcom/braze/push/BrazeNotificationUtils$BrazeNotificationBroadcastType;", "sendPushMessageReceivedBroadcast", "setAccentColorIfPresentAndSupported", "notificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "setCategoryIfPresentAndSupported", "setContentIfPresent", "setContentIntentIfPresent", "setDeleteIntent", "setLargeIconIfPresentAndSupported", "setNotificationBadgeNumberIfPresent", "setNotificationDurationAlarm", "thisClass", "durationInMillis", "setPriorityIfPresentAndSupported", "setPublicVersionIfPresentAndSupported", "setSetShowWhen", "setSmallIcon", "appConfigurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "setSoundIfPresentAndSupported", "setSummaryTextIfPresentAndSupported", "setTickerIfPresent", "setTitleIfPresent", "setVisibilityIfPresentAndSupported", "wakeScreenIfAppropriate", "configurationProvider", "isBrazePushMessage", "BrazeNotificationBroadcastType", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeNotificationUtils.kt */
public final class BrazeNotificationUtils {
    public static final BrazeNotificationUtils INSTANCE = new BrazeNotificationUtils();
    private static final String SOURCE_KEY = "source";
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazeNotificationUtils.class);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeNotificationUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.braze.push.BrazeNotificationUtils$BrazeNotificationBroadcastType[] r0 = com.braze.push.BrazeNotificationUtils.BrazeNotificationBroadcastType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.push.BrazeNotificationUtils$BrazeNotificationBroadcastType r1 = com.braze.push.BrazeNotificationUtils.BrazeNotificationBroadcastType.OPENED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.push.BrazeNotificationUtils$BrazeNotificationBroadcastType r1 = com.braze.push.BrazeNotificationUtils.BrazeNotificationBroadcastType.RECEIVED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.push.BrazeNotificationUtils$BrazeNotificationBroadcastType r1 = com.braze.push.BrazeNotificationUtils.BrazeNotificationBroadcastType.DELETED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.push.BrazeNotificationUtils.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final boolean isValidNotificationVisibility(int i) {
        return i == -1 || i == 0 || i == 1;
    }

    private BrazeNotificationUtils() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/braze/push/BrazeNotificationUtils$BrazeNotificationBroadcastType;", "", "brazePushEventType", "Lcom/braze/enums/BrazePushEventType;", "(Ljava/lang/String;ILcom/braze/enums/BrazePushEventType;)V", "getBrazePushEventType", "()Lcom/braze/enums/BrazePushEventType;", "OPENED", "RECEIVED", "DELETED", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BrazeNotificationUtils.kt */
    private enum BrazeNotificationBroadcastType {
        OPENED(BrazePushEventType.NOTIFICATION_OPENED),
        RECEIVED(BrazePushEventType.NOTIFICATION_RECEIVED),
        DELETED(BrazePushEventType.NOTIFICATION_DELETED);
        
        private final BrazePushEventType brazePushEventType;

        private BrazeNotificationBroadcastType(BrazePushEventType brazePushEventType2) {
            this.brazePushEventType = brazePushEventType2;
        }

        public final BrazePushEventType getBrazePushEventType() {
            return this.brazePushEventType;
        }
    }

    @JvmStatic
    public static final IBrazeNotificationFactory getActiveNotificationFactory() {
        IBrazeNotificationFactory customBrazeNotificationFactory = Braze.Companion.getCustomBrazeNotificationFactory();
        return customBrazeNotificationFactory == null ? BrazeNotificationFactory.Companion.getInstance() : customBrazeNotificationFactory;
    }

    @JvmStatic
    public static final Class<?> getNotificationReceiverClass() {
        return Constants.isAmazonDevice() ? BrazeAmazonDeviceMessagingReceiver.class : BrazePushReceiver.class;
    }

    @JvmStatic
    public static final void handleNotificationOpened(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        try {
            Braze.Companion.getInstance(context).logPushNotificationOpened(intent);
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            sendNotificationOpenedBroadcast(context, intent);
            if (new BrazeConfigurationProvider(context).getDoesHandlePushDeepLinksAutomatically()) {
                routeUserWithNotificationOpenedIntent(context, intent);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, BrazeLogger.Priority.I, (Throwable) null, (Function0) BrazeNotificationUtils$handleNotificationOpened$1.INSTANCE, 2, (Object) null);
            }
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$handleNotificationOpened$2.INSTANCE);
        }
    }

    @JvmStatic
    public static final void handleNotificationDeleted(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$handleNotificationDeleted$1.INSTANCE, 3, (Object) null);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                brazeNotificationUtils.sendPushActionIntent(context, BrazeNotificationBroadcastType.DELETED, extras, new BrazeNotificationPayload(extras, (Bundle) null, context, (BrazeConfigurationProvider) null, 10, (DefaultConstructorMarker) null));
                return;
            }
            sendPushActionIntent$default(brazeNotificationUtils, context, BrazeNotificationBroadcastType.DELETED, extras, (BrazeNotificationPayload) null, 8, (Object) null);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$handleNotificationDeleted$2.INSTANCE);
        }
    }

    @JvmStatic
    public static final void routeUserWithNotificationOpenedIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Bundle bundleExtra = intent.getBundleExtra("extra");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putString(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY, intent.getStringExtra(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY));
        bundleExtra.putString("source", Constants.BRAZE);
        String stringExtra = intent.getStringExtra("uri");
        CharSequence charSequence = stringExtra;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            boolean equals = StringsKt.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, intent.getStringExtra(Constants.BRAZE_PUSH_OPEN_URI_IN_WEBVIEW_KEY), true);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$routeUserWithNotificationOpenedIntent$1(stringExtra, equals), 3, (Object) null);
            bundleExtra.putString("uri", stringExtra);
            bundleExtra.putBoolean(Constants.BRAZE_PUSH_OPEN_URI_IN_WEBVIEW_KEY, equals);
            UriAction createUriActionFromUrlString = BrazeDeeplinkHandler.Companion.getInstance().createUriActionFromUrlString(stringExtra, bundleExtra, equals, Channel.PUSH);
            if (createUriActionFromUrlString != null) {
                BrazeDeeplinkHandler.Companion.getInstance().gotoUri(context, createUriActionFromUrlString);
                return;
            }
            return;
        }
        Intent mainActivityIntent = UriUtils.getMainActivityIntent(context, bundleExtra);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$routeUserWithNotificationOpenedIntent$3(mainActivityIntent), 3, (Object) null);
        context.startActivity(mainActivityIntent);
    }

    @JvmStatic
    public static final boolean isBrazePushMessage(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        return StringsKt.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, extras.getString(Constants.BRAZE_PUSH_BRAZE_KEY), true);
    }

    @JvmStatic
    public static final boolean isNotificationMessage(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey(Constants.BRAZE_PUSH_TITLE_KEY) && extras.containsKey(Constants.BRAZE_PUSH_CONTENT_KEY)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void sendPushMessageReceivedBroadcast(Context context, Bundle bundle, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$sendPushMessageReceivedBroadcast$1.INSTANCE, 3, (Object) null);
        brazeNotificationUtils.sendPushActionIntent(context, BrazeNotificationBroadcastType.RECEIVED, bundle, brazeNotificationPayload);
    }

    @JvmStatic
    public static final boolean requestGeofenceRefreshIfAppropriate(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (!brazeNotificationPayload.getShouldSyncGeofences() || context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$requestGeofenceRefreshIfAppropriate$2.INSTANCE, 3, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$requestGeofenceRefreshIfAppropriate$1.INSTANCE, 3, (Object) null);
        BrazeInternal.requestGeofenceRefresh(context, true);
        return true;
    }

    @JvmStatic
    public static final boolean refreshFeatureFlagsIfAppropriate(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (!brazeNotificationPayload.getShouldRefreshFeatureFlags() || context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, (Function0) BrazeNotificationUtils$refreshFeatureFlagsIfAppropriate$2.INSTANCE, 2, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$refreshFeatureFlagsIfAppropriate$1.INSTANCE, 3, (Object) null);
        BrazeInternal.refreshFeatureFlags(context);
        return true;
    }

    @JvmStatic
    public static final void setNotificationDurationAlarm(Context context, Class<?> cls, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, cls);
        intent.setAction(Constants.BRAZE_CANCEL_NOTIFICATION_ACTION);
        intent.putExtra(Constants.BRAZE_PUSH_NOTIFICATION_ID, i);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, IntentUtils.getImmutablePendingIntentFlags() | C.BUFFER_FLAG_FIRST_SAMPLE);
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        if (i2 >= 1000) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$setNotificationDurationAlarm$1(i2), 3, (Object) null);
            alarmManager.set(3, SystemClock.elapsedRealtime() + ((long) i2), broadcast);
        }
    }

    @JvmStatic
    public static final int getNotificationId(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer customNotificationId = brazeNotificationPayload.getCustomNotificationId();
        if (customNotificationId != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$getNotificationId$1(customNotificationId), 3, (Object) null);
            return customNotificationId.intValue();
        }
        String str = "";
        String titleText = brazeNotificationPayload.getTitleText();
        if (titleText != null) {
            str = str + titleText;
        }
        String contentText = brazeNotificationPayload.getContentText();
        if (contentText != null) {
            str = str + contentText;
        }
        int hashCode = str != null ? str.hashCode() : 0;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$getNotificationId$4(hashCode), 3, (Object) null);
        return hashCode;
    }

    @JvmStatic
    public static final int getNotificationPriority(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer notificationPriorityInt = brazeNotificationPayload.getNotificationPriorityInt();
        Integer notificationPriorityInt2 = brazeNotificationPayload.getNotificationPriorityInt();
        if (notificationPriorityInt2 != null) {
            int intValue = notificationPriorityInt2.intValue();
            if (-2 <= intValue && intValue < 3) {
                return intValue;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new BrazeNotificationUtils$getNotificationPriority$1$1(notificationPriorityInt), 2, (Object) null);
        }
        return 0;
    }

    @JvmStatic
    public static final boolean wakeScreenIfAppropriate(Context context, BrazeConfigurationProvider brazeConfigurationProvider, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        return wakeScreenIfAppropriate(new BrazeNotificationPayload(bundle, (Bundle) null, context, brazeConfigurationProvider, 2, (DefaultConstructorMarker) null));
    }

    @JvmStatic
    public static final boolean wakeScreenIfAppropriate(BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (context == null || (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) == null) {
            return false;
        }
        Bundle notificationExtras = brazeNotificationPayload.getNotificationExtras();
        if (!PermissionUtils.hasPermission(context, "android.permission.WAKE_LOCK") || !configurationProvider.isPushWakeScreenForNotificationEnabled()) {
            return false;
        }
        try {
            Object systemService = context.getSystemService("uimode");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
            if (((UiModeManager) systemService).getCurrentModeType() == 4) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$wakeScreenIfAppropriate$1.INSTANCE, 3, (Object) null);
                return false;
            }
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$wakeScreenIfAppropriate$2.INSTANCE);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService2 = context.getSystemService("notification");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            NotificationChannel validNotificationChannel = getValidNotificationChannel((NotificationManager) systemService2, notificationExtras);
            if (validNotificationChannel == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$wakeScreenIfAppropriate$3.INSTANCE, 3, (Object) null);
                return false;
            } else if (validNotificationChannel.getImportance() == 1) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$wakeScreenIfAppropriate$4(validNotificationChannel), 3, (Object) null);
                return false;
            }
        } else if (getNotificationPriority(brazeNotificationPayload) == -2) {
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$wakeScreenIfAppropriate$5.INSTANCE, 3, (Object) null);
        Object systemService3 = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService3).newWakeLock(268435482, TAG);
        newWakeLock.acquire();
        newWakeLock.release();
        return true;
    }

    @JvmStatic
    public static final void prefetchBitmapsIfNewlyReceivedStoryPush(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        if (context != null && brazeNotificationPayload.isPushStory() && brazeNotificationPayload.isNewlyReceivedPushStory()) {
            Collection arrayList = new ArrayList();
            for (BrazeNotificationPayload.PushStoryPage bitmapUrl : brazeNotificationPayload.getPushStoryPages()) {
                String bitmapUrl2 = bitmapUrl.getBitmapUrl();
                if (bitmapUrl2 != null) {
                    arrayList.add(bitmapUrl2);
                }
            }
            for (String str : (List) arrayList) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationUtils$prefetchBitmapsIfNewlyReceivedStoryPush$2$1(str), 2, (Object) null);
                Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, brazeNotificationPayload.getBrazeExtras(), str, BrazeViewBounds.NOTIFICATION_ONE_IMAGE_STORY);
            }
            brazeNotificationPayload.setNewlyReceivedPushStory(false);
        }
    }

    @JvmStatic
    public static final void setTitleIfPresent(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setTitleIfPresent$1.INSTANCE, 3, (Object) null);
        String titleText = brazeNotificationPayload.getTitleText();
        if (titleText != null && (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) != null) {
            builder.setContentTitle(HtmlUtils.getHtmlSpannedTextIfEnabled(titleText, configurationProvider));
        }
    }

    @JvmStatic
    public static final void setContentIfPresent(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setContentIfPresent$1.INSTANCE, 3, (Object) null);
        String contentText = brazeNotificationPayload.getContentText();
        if (contentText != null && (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) != null) {
            builder.setContentText(HtmlUtils.getHtmlSpannedTextIfEnabled(contentText, configurationProvider));
        }
    }

    @JvmStatic
    public static final void setTickerIfPresent(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setTickerIfPresent$1.INSTANCE, 3, (Object) null);
        String titleText = brazeNotificationPayload.getTitleText();
        if (titleText != null) {
            builder.setTicker(titleText);
        }
    }

    @JvmStatic
    public static final void setContentIntentIfPresent(Context context, NotificationCompat.Builder builder, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        try {
            builder.setContentIntent(INSTANCE.getPushActionPendingIntent(context, Constants.BRAZE_PUSH_CLICKED_ACTION, bundle));
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$setContentIntentIfPresent$1.INSTANCE);
        }
    }

    @JvmStatic
    public static final void setDeleteIntent(Context context, NotificationCompat.Builder builder, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        try {
            Intent intent = new Intent(Constants.BRAZE_PUSH_DELETED_ACTION).setClass(context, getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_P…otificationReceiverClass)");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            builder.setDeleteIntent(PendingIntent.getBroadcast(context, IntentUtils.getRequestCode(), intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags()));
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$setDeleteIntent$1.INSTANCE);
        }
    }

    @JvmStatic
    public static final int setSmallIcon(BrazeConfigurationProvider brazeConfigurationProvider, NotificationCompat.Builder builder) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        int smallNotificationIconResourceId = brazeConfigurationProvider.getSmallNotificationIconResourceId();
        if (smallNotificationIconResourceId == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setSmallIcon$1.INSTANCE, 3, (Object) null);
            smallNotificationIconResourceId = brazeConfigurationProvider.getApplicationIconResourceId();
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setSmallIcon$2.INSTANCE, 3, (Object) null);
        }
        builder.setSmallIcon(smallNotificationIconResourceId);
        return smallNotificationIconResourceId;
    }

    @JvmStatic
    public static final void setSetShowWhen(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (brazeNotificationPayload.isPushStory()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setSetShowWhen$1.INSTANCE, 3, (Object) null);
            builder.setShowWhen(false);
        }
    }

    @JvmStatic
    public static final boolean setLargeIconIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        BrazeConfigurationProvider configurationProvider;
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (brazeNotificationPayload.isPushStory()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
            return false;
        }
        Context context = brazeNotificationPayload.getContext();
        if (context == null || (configurationProvider = brazeNotificationPayload.getConfigurationProvider()) == null) {
            return false;
        }
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$2.INSTANCE, 3, (Object) null);
            String largeIcon = brazeNotificationPayload.getLargeIcon();
            if (largeIcon != null) {
                builder.setLargeIcon(Braze.Companion.getInstance(context).getImageLoader().getPushBitmapFromUrl(context, (Bundle) null, largeIcon, BrazeViewBounds.NOTIFICATION_LARGE_ICON));
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$4.INSTANCE, 3, (Object) null);
            int largeNotificationIconResourceId = configurationProvider.getLargeNotificationIconResourceId();
            if (largeNotificationIconResourceId != 0) {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeNotificationIconResourceId));
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$5.INSTANCE, 3, (Object) null);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$7.INSTANCE, 3, (Object) null);
            return false;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$setLargeIconIfPresentAndSupported$6.INSTANCE);
        }
    }

    @JvmStatic
    public static final void setSoundIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String notificationSound = brazeNotificationPayload.getNotificationSound();
        if (notificationSound != null) {
            if (Intrinsics.areEqual((Object) notificationSound, (Object) Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setSoundIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
                builder.setDefaults(1);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setSoundIfPresentAndSupported$2.INSTANCE, 3, (Object) null);
            builder.setSound(Uri.parse(notificationSound));
        }
    }

    @JvmStatic
    public static final void setSummaryTextIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String summaryText = brazeNotificationPayload.getSummaryText();
        if (summaryText != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setSummaryTextIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
            builder.setSubText(summaryText);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setSummaryTextIfPresentAndSupported$2.INSTANCE, 3, (Object) null);
    }

    @JvmStatic
    public static final void setPriorityIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setPriorityIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
        builder.setPriority(getNotificationPriority(brazeNotificationPayload));
    }

    @JvmStatic
    public static final void setAccentColorIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer accentColor = brazeNotificationPayload.getAccentColor();
        if (accentColor != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setAccentColorIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
            builder.setColor(accentColor.intValue());
            return;
        }
        BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
        if (configurationProvider != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setAccentColorIfPresentAndSupported$2$1.INSTANCE, 3, (Object) null);
            builder.setColor(configurationProvider.getDefaultNotificationAccentColor());
        }
    }

    @JvmStatic
    public static final void setCategoryIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String notificationCategory = brazeNotificationPayload.getNotificationCategory();
        if (notificationCategory != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setCategoryIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
            builder.setCategory(notificationCategory);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setCategoryIfPresentAndSupported$2.INSTANCE, 3, (Object) null);
    }

    @JvmStatic
    public static final void setVisibilityIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Integer notificationVisibility = brazeNotificationPayload.getNotificationVisibility();
        if (notificationVisibility != null) {
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            if (isValidNotificationVisibility(notificationVisibility.intValue())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setVisibilityIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
                builder.setVisibility(notificationVisibility.intValue());
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, BrazeLogger.Priority.W, (Throwable) null, (Function0) new BrazeNotificationUtils$setVisibilityIfPresentAndSupported$2(notificationVisibility), 2, (Object) null);
        }
    }

    @JvmStatic
    public static final void setPublicVersionIfPresentAndSupported(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        NotificationCompat.Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(builder2, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        Context context = brazeNotificationPayload.getContext();
        BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
        if (Build.VERSION.SDK_INT < 21) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setPublicVersionIfPresentAndSupported$1.INSTANCE, 3, (Object) null);
        } else if (context != null && brazeNotificationPayload.getPublicNotificationExtras() != null && configurationProvider != null) {
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            String orCreateNotificationChannelId = getOrCreateNotificationChannelId(brazeNotificationPayload);
            Bundle parseJsonObjectIntoBundle = JsonUtils.parseJsonObjectIntoBundle(brazeNotificationPayload.getPublicNotificationExtras());
            if (!parseJsonObjectIntoBundle.isEmpty()) {
                BrazeNotificationPayload brazeNotificationPayload2 = new BrazeNotificationPayload(parseJsonObjectIntoBundle, (Bundle) null, context, configurationProvider, 2, (DefaultConstructorMarker) null);
                NotificationCompat.Builder builder3 = new NotificationCompat.Builder(context, orCreateNotificationChannelId);
                BrazeNotificationPayload brazeNotificationPayload3 = brazeNotificationPayload2;
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$setPublicVersionIfPresentAndSupported$2(brazeNotificationPayload2), 3, (Object) null);
                setContentIfPresent(builder3, brazeNotificationPayload3);
                setTitleIfPresent(builder3, brazeNotificationPayload3);
                setSummaryTextIfPresentAndSupported(builder3, brazeNotificationPayload3);
                setSmallIcon(configurationProvider, builder3);
                setAccentColorIfPresentAndSupported(builder3, brazeNotificationPayload3);
                builder2.setPublicVersion(builder3.build());
            }
        }
    }

    @JvmStatic
    public static final void logBaiduNotificationClick(Context context, String str) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeNotificationUtils$logBaiduNotificationClick$1.INSTANCE, 2, (Object) null);
        } else if (context == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) BrazeNotificationUtils$logBaiduNotificationClick$2.INSTANCE, 2, (Object) null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optionalString = JsonUtils.getOptionalString(jSONObject, "source");
                String optionalString2 = JsonUtils.getOptionalString(jSONObject, Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
                if (optionalString != null && Intrinsics.areEqual((Object) optionalString, (Object) Constants.BRAZE) && optionalString2 != null) {
                    Braze.Companion.getInstance(context).logPushNotificationOpened(optionalString2);
                }
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new BrazeNotificationUtils$logBaiduNotificationClick$3(str));
            }
        }
    }

    @JvmStatic
    public static final void handleCancelNotificationAction(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        try {
            if (intent.hasExtra(Constants.BRAZE_PUSH_NOTIFICATION_ID)) {
                int intExtra = intent.getIntExtra(Constants.BRAZE_PUSH_NOTIFICATION_ID, -1);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$handleCancelNotificationAction$1(intExtra), 3, (Object) null);
                Object systemService = context.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) systemService).cancel(Constants.BRAZE_PUSH_NOTIFICATION_TAG, intExtra);
            }
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$handleCancelNotificationAction$2.INSTANCE);
        }
    }

    @JvmStatic
    public static final void cancelNotification(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$cancelNotification$1(i), 3, (Object) null);
            Intent intent = new Intent(Constants.BRAZE_CANCEL_NOTIFICATION_ACTION).setClass(context, getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_C…otificationReceiverClass)");
            intent.setPackage(context.getPackageName());
            intent.putExtra(Constants.BRAZE_PUSH_NOTIFICATION_ID, i);
            IntentUtils.addComponentAndSendBroadcast(context, intent);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$cancelNotification$2.INSTANCE);
        }
    }

    @JvmStatic
    @Deprecated(message = "Please use BrazeNotificationPayload().isUninstallTracking instead")
    public static final boolean isUninstallTrackingPush(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "notificationExtras");
        try {
            if (bundle.containsKey(Constants.BRAZE_PUSH_UNINSTALL_TRACKING_KEY)) {
                return true;
            }
            Bundle bundle2 = bundle.getBundle("extra");
            if (bundle2 != null) {
                return bundle2.containsKey(Constants.BRAZE_PUSH_UNINSTALL_TRACKING_KEY);
            }
            return false;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$isUninstallTrackingPush$1.INSTANCE);
            return false;
        }
    }

    @JvmStatic
    public static final String getOrCreateNotificationChannelId(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String notificationChannelId = brazeNotificationPayload.getNotificationChannelId();
        if (Build.VERSION.SDK_INT < 26) {
            return notificationChannelId == null ? Constants.BRAZE_PUSH_DEFAULT_NOTIFICATION_CHANNEL_ID : notificationChannelId;
        }
        Context context = brazeNotificationPayload.getContext();
        BrazeConfigurationProvider configurationProvider = brazeNotificationPayload.getConfigurationProvider();
        String str = null;
        Object systemService = context != null ? context.getSystemService("notification") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (notificationChannelId != null) {
            if (notificationManager.getNotificationChannel(notificationChannelId) != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$getOrCreateNotificationChannelId$1(notificationChannelId), 3, (Object) null);
                return notificationChannelId;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$getOrCreateNotificationChannelId$2(notificationChannelId), 3, (Object) null);
        }
        if (notificationManager.getNotificationChannel(Constants.BRAZE_PUSH_DEFAULT_NOTIFICATION_CHANNEL_ID) == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$getOrCreateNotificationChannelId$3.INSTANCE, 3, (Object) null);
            NotificationChannel notificationChannel = new NotificationChannel(Constants.BRAZE_PUSH_DEFAULT_NOTIFICATION_CHANNEL_ID, configurationProvider != null ? configurationProvider.getDefaultNotificationChannelName() : null, 3);
            if (configurationProvider != null) {
                str = configurationProvider.getDefaultNotificationChannelDescription();
            }
            notificationChannel.setDescription(str);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return Constants.BRAZE_PUSH_DEFAULT_NOTIFICATION_CHANNEL_ID;
    }

    @JvmStatic
    public static final void setNotificationBadgeNumberIfPresent(NotificationCompat.Builder builder, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(builder, "notificationBuilder");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        if (Build.VERSION.SDK_INT < 26) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$setNotificationBadgeNumberIfPresent$1.INSTANCE, 3, (Object) null);
            return;
        }
        Integer notificationBadgeNumber = brazeNotificationPayload.getNotificationBadgeNumber();
        if (notificationBadgeNumber != null) {
            builder.setNumber(notificationBadgeNumber.intValue());
        }
    }

    @JvmStatic
    public static final void handlePushStoryPageClicked(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        try {
            Braze.Companion.getInstance(context).logPushStoryPageClicked(intent.getStringExtra(Constants.BRAZE_CAMPAIGN_ID), intent.getStringExtra(Constants.BRAZE_STORY_PAGE_ID));
            BrazeConfigurationProvider brazeConfigurationProvider = new BrazeConfigurationProvider(context);
            boolean z = false;
            int intExtra = intent.getIntExtra(Constants.BRAZE_PUSH_NOTIFICATION_ID, 0);
            if (brazeConfigurationProvider.getDoesPushStoryDismissOnClick() && intExtra != 0) {
                cancelNotification(context, intExtra);
            }
            String stringExtra = intent.getStringExtra(Constants.BRAZE_ACTION_URI_KEY);
            CharSequence charSequence = stringExtra;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                intent.putExtra("uri", intent.getStringExtra(Constants.BRAZE_ACTION_URI_KEY));
                String stringExtra2 = intent.getStringExtra(Constants.BRAZE_ACTION_USE_WEBVIEW_KEY);
                CharSequence charSequence2 = stringExtra2;
                if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                    z = true;
                }
                if (!z) {
                    intent.putExtra(Constants.BRAZE_PUSH_OPEN_URI_IN_WEBVIEW_KEY, stringExtra2);
                }
            } else {
                intent.removeExtra("uri");
            }
            BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
            sendNotificationOpenedBroadcast(context, intent);
            if (brazeConfigurationProvider.getDoesHandlePushDeepLinksAutomatically()) {
                routeUserWithNotificationOpenedIntent(context, intent);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) brazeNotificationUtils, BrazeLogger.Priority.I, (Throwable) null, (Function0) new BrazeNotificationUtils$handlePushStoryPageClicked$1(stringExtra), 2, (Object) null);
            }
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) BrazeNotificationUtils$handlePushStoryPageClicked$2.INSTANCE);
        }
    }

    @JvmStatic
    public static final void handleContentCardsSerializedCardIfPresent(BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        String contentCardSyncData = brazeNotificationPayload.getContentCardSyncData();
        String contentCardSyncUserId = brazeNotificationPayload.getContentCardSyncUserId();
        Context context = brazeNotificationPayload.getContext();
        if (contentCardSyncData != null && context != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$handleContentCardsSerializedCardIfPresent$1(contentCardSyncUserId, contentCardSyncData), 3, (Object) null);
            BrazeInternal.addSerializedContentCardToStorage(context, contentCardSyncData, contentCardSyncUserId);
        }
    }

    @JvmStatic
    public static final void sendNotificationOpenedBroadcast(Context context, Intent intent) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeNotificationUtils brazeNotificationUtils = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeNotificationUtils, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$sendNotificationOpenedBroadcast$1.INSTANCE, 3, (Object) null);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            brazeNotificationUtils.sendPushActionIntent(context2, BrazeNotificationBroadcastType.OPENED, extras, new BrazeNotificationPayload(extras, (Bundle) null, context, (BrazeConfigurationProvider) null, 10, (DefaultConstructorMarker) null));
            return;
        }
        sendPushActionIntent$default(brazeNotificationUtils, context, BrazeNotificationBroadcastType.OPENED, extras, (BrazeNotificationPayload) null, 8, (Object) null);
    }

    @JvmStatic
    public static final NotificationChannel getValidNotificationChannel(NotificationManager notificationManager, Bundle bundle) {
        NotificationManager notificationManager2 = notificationManager;
        Bundle bundle2 = bundle;
        Intrinsics.checkNotNullParameter(notificationManager2, "notificationManager");
        if (bundle2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$getValidNotificationChannel$1.INSTANCE, 3, (Object) null);
            return null;
        }
        String string = bundle2.getString(Constants.BRAZE_PUSH_NOTIFICATION_CHANNEL_ID_KEY, (String) null);
        CharSequence charSequence = string;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            NotificationChannel notificationChannel = notificationManager2.getNotificationChannel(string);
            if (notificationChannel != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$getValidNotificationChannel$2(string), 3, (Object) null);
                return notificationChannel;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new BrazeNotificationUtils$getValidNotificationChannel$3(string), 3, (Object) null);
        }
        NotificationChannel notificationChannel2 = notificationManager2.getNotificationChannel(Constants.BRAZE_PUSH_DEFAULT_NOTIFICATION_CHANNEL_ID);
        if (notificationChannel2 != null) {
            return notificationChannel2;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, (Function0) BrazeNotificationUtils$getValidNotificationChannel$4.INSTANCE, 3, (Object) null);
        return null;
    }

    private final PendingIntent getPushActionPendingIntent(Context context, String str, Bundle bundle) {
        Intent intent = new Intent(str).setClass(context, NotificationTrampolineActivity.class);
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(action).setClass(…lineActivity::class.java)");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        PendingIntent activity = PendingIntent.getActivity(context, IntentUtils.getRequestCode(), intent, 1073741824 | IntentUtils.getImmutablePendingIntentFlags());
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(context, get… pushActionIntent, flags)");
        return activity;
    }

    static /* synthetic */ void sendPushActionIntent$default(BrazeNotificationUtils brazeNotificationUtils, Context context, BrazeNotificationBroadcastType brazeNotificationBroadcastType, Bundle bundle, BrazeNotificationPayload brazeNotificationPayload, int i, Object obj) {
        if ((i & 8) != 0) {
            brazeNotificationPayload = null;
        }
        brazeNotificationUtils.sendPushActionIntent(context, brazeNotificationBroadcastType, bundle, brazeNotificationPayload);
    }

    private final void sendPushActionIntent(Context context, BrazeNotificationBroadcastType brazeNotificationBroadcastType, Bundle bundle, BrazeNotificationPayload brazeNotificationPayload) {
        Intent intent;
        int i = WhenMappings.$EnumSwitchMapping$0[brazeNotificationBroadcastType.ordinal()];
        if (i == 1) {
            intent = new Intent(Constants.BRAZE_PUSH_INTENT_NOTIFICATION_OPENED).setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, "{\n                Intent…ackageName)\n            }");
        } else if (i == 2) {
            intent = new Intent(Constants.BRAZE_PUSH_INTENT_NOTIFICATION_RECEIVED).setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, "{\n                Intent…ackageName)\n            }");
        } else if (i == 3) {
            intent = new Intent(Constants.BRAZE_PUSH_INTENT_NOTIFICATION_DELETED).setPackage(context.getPackageName());
            Intrinsics.checkNotNullExpressionValue(intent, "{\n                Intent…ackageName)\n            }");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationUtils$sendPushActionIntent$1(brazeNotificationBroadcastType), 2, (Object) null);
        sendPushActionIntent(context, intent, bundle);
        if (brazeNotificationPayload != null) {
            BrazeInternal.INSTANCE.publishBrazePushAction(context, brazeNotificationBroadcastType.getBrazePushEventType(), brazeNotificationPayload);
        }
    }

    private final void sendPushActionIntent(Context context, Intent intent, Bundle bundle) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new BrazeNotificationUtils$sendPushActionIntent$2(intent), 2, (Object) null);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        IntentUtils.addComponentAndSendBroadcast(context, intent);
    }
}
