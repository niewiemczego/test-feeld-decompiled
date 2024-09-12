package zendesk.messaging.android.push;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import zendesk.logger.Logger;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.CoroutinesDispatcherProvider;
import zendesk.messaging.android.internal.MessagingBuildConfig;
import zendesk.messaging.android.internal.ScreenStateStore;
import zendesk.messaging.android.internal.conversationscreen.ConversationActivity;
import zendesk.messaging.android.push.internal.NotificationProcessor;
import zendesk.messaging.android.push.internal.NotificationProcessorFactory;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0003J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 H\u0007J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\r\u0010\"\u001a\u00020\u001cH\u0000¢\u0006\u0002\b#J\u0019\u0010$\u001a\u00020\u001c2\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u00020(2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 H\u0007J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lzendesk/messaging/android/push/PushNotifications;", "", "()V", "LOG_TAG", "", "MESSAGING_NOTIFICATION_CHANNEL_ID", "NOTIFICATION_KEY", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mutablePushNotificationToken", "Lkotlinx/coroutines/flow/MutableStateFlow;", "notificationProcessor", "Lzendesk/messaging/android/push/internal/NotificationProcessor;", "pushNotificationToken", "Lkotlinx/coroutines/flow/Flow;", "getPushNotificationToken$zendesk_messaging_messaging_android", "()Lkotlinx/coroutines/flow/Flow;", "smallNotificationIconId", "", "getSmallNotificationIconId$zendesk_messaging_messaging_android$annotations", "getSmallNotificationIconId$zendesk_messaging_messaging_android", "()I", "setSmallNotificationIconId$zendesk_messaging_messaging_android", "(I)V", "buildChannel", "Landroid/app/NotificationChannel;", "channelName", "displayNotification", "", "context", "Landroid/content/Context;", "messageData", "", "initialize", "reset", "reset$zendesk_messaging_messaging_android", "setNotificationSmallIconId", "smallIconId", "(Ljava/lang/Integer;)V", "shouldBeDisplayed", "Lzendesk/messaging/android/push/PushResponsibility;", "updatePushNotificationToken", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PushNotifications.kt */
public final class PushNotifications {
    public static final PushNotifications INSTANCE = new PushNotifications();
    private static final String LOG_TAG = "PushNotifications";
    private static final String MESSAGING_NOTIFICATION_CHANNEL_ID = "MESSAGING_NOTIFICATION_CHANNEL_ID";
    private static final String NOTIFICATION_KEY = "smoochNotification";
    private static final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(new CoroutinesDispatcherProvider().getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private static final MutableStateFlow<String> mutablePushNotificationToken = StateFlowKt.MutableStateFlow("");
    /* access modifiers changed from: private */
    public static NotificationProcessor notificationProcessor;
    private static int smallNotificationIconId = R.drawable.zma_default_notification_icon;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PushNotifications.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PushResponsibility.values().length];
            iArr[PushResponsibility.NOT_FROM_MESSAGING.ordinal()] = 1;
            iArr[PushResponsibility.MESSAGING_SHOULD_NOT_DISPLAY.ordinal()] = 2;
            iArr[PushResponsibility.MESSAGING_SHOULD_DISPLAY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getSmallNotificationIconId$zendesk_messaging_messaging_android$annotations() {
    }

    private PushNotifications() {
    }

    public final Flow<String> getPushNotificationToken$zendesk_messaging_messaging_android() {
        return new PushNotifications$special$$inlined$filter$1(mutablePushNotificationToken);
    }

    public final int getSmallNotificationIconId$zendesk_messaging_messaging_android() {
        return smallNotificationIconId;
    }

    public final void setSmallNotificationIconId$zendesk_messaging_messaging_android(int i) {
        smallNotificationIconId = i;
    }

    private final void initialize(Context context) {
        if (MessagingBuildConfig.INSTANCE.atLeastAndroid26()) {
            Object systemService = context.getSystemService("notification");
            NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
            if (notificationManager != null) {
                String string = context.getString(R.string.zma_notification_channel_name);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…otification_channel_name)");
                notificationManager.createNotificationChannel(buildChannel(string));
            }
        }
        notificationProcessor = NotificationProcessorFactory.INSTANCE.create();
    }

    public final void reset$zendesk_messaging_messaging_android() {
        smallNotificationIconId = R.drawable.zma_default_notification_icon;
        notificationProcessor = null;
    }

    private final NotificationChannel buildChannel(String str) {
        NotificationChannel notificationChannel = new NotificationChannel(MESSAGING_NOTIFICATION_CHANNEL_ID, str, 4);
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        return notificationChannel;
    }

    @JvmStatic
    public static final void updatePushNotificationToken(String str) {
        Intrinsics.checkNotNullParameter(str, "pushNotificationToken");
        mutablePushNotificationToken.setValue(str);
    }

    @JvmStatic
    public static final PushResponsibility shouldBeDisplayed(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "messageData");
        if (!Boolean.parseBoolean(map.get(NOTIFICATION_KEY))) {
            return PushResponsibility.NOT_FROM_MESSAGING;
        }
        if (ScreenStateStore.INSTANCE.getCurrentlyVisibleScreen$zendesk_messaging_messaging_android().getValue() instanceof ConversationActivity) {
            return PushResponsibility.MESSAGING_SHOULD_NOT_DISPLAY;
        }
        return PushResponsibility.MESSAGING_SHOULD_DISPLAY;
    }

    @JvmStatic
    public static final void displayNotification(Context context, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "messageData");
        PushNotifications pushNotifications = INSTANCE;
        int i = WhenMappings.$EnumSwitchMapping$0[shouldBeDisplayed(map).ordinal()];
        if (i == 1) {
            Logger.w(LOG_TAG, "Cannot display notification because it doesn't belong to Messaging", new Object[0]);
        } else if (i == 2 || i == 3) {
            pushNotifications.initialize(context);
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PushNotifications$displayNotification$1(context, map, (Continuation<? super PushNotifications$displayNotification$1>) null), 3, (Object) null);
        }
    }

    @JvmStatic
    public static final void setNotificationSmallIconId(Integer num) {
        smallNotificationIconId = num != null ? num.intValue() : R.drawable.zma_default_notification_icon;
    }
}
