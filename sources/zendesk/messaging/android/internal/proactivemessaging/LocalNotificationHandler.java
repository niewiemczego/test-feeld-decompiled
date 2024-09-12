package zendesk.messaging.android.internal.proactivemessaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.MessagingBuildConfig;
import zendesk.messaging.android.push.internal.NotificationBuilder;
import zendesk.messaging.android.push.internal.NotificationProcessor;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0017\u0010\u0016\u001a\u00020\u00122\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lzendesk/messaging/android/internal/proactivemessaging/LocalNotificationHandler;", "", "notificationProcessor", "Lzendesk/messaging/android/push/internal/NotificationProcessor;", "context", "Landroid/content/Context;", "(Lzendesk/messaging/android/push/internal/NotificationProcessor;Landroid/content/Context;)V", "smallNotificationIconId", "", "getSmallNotificationIconId", "()I", "setSmallNotificationIconId", "(I)V", "buildChannel", "Landroid/app/NotificationChannel;", "channelName", "", "displayLocalNotification", "", "id", "title", "body", "setLocalNotificationSmallIconId", "smallIconId", "(Ljava/lang/Integer;)V", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocalNotificationHandler.kt */
public final class LocalNotificationHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String channelName = "Proactive Messages";
    private static final String proactiveMessageNotificationChannelId = "PROACTIVE_MESSAGING_NOTIFICATION_CHANNEL_ID";
    private final Context context;
    private final NotificationProcessor notificationProcessor;
    private int smallNotificationIconId = R.drawable.zma_default_notification_icon;

    public LocalNotificationHandler(NotificationProcessor notificationProcessor2, Context context2) {
        Intrinsics.checkNotNullParameter(notificationProcessor2, "notificationProcessor");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.notificationProcessor = notificationProcessor2;
        this.context = context2;
        if (MessagingBuildConfig.INSTANCE.atLeastAndroid26()) {
            Object systemService = context2.getSystemService("notification");
            NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(buildChannel(channelName));
            }
        }
    }

    public final int getSmallNotificationIconId() {
        return this.smallNotificationIconId;
    }

    public final void setSmallNotificationIconId(int i) {
        this.smallNotificationIconId = i;
    }

    private final NotificationChannel buildChannel(String str) {
        NotificationChannel notificationChannel = new NotificationChannel(proactiveMessageNotificationChannelId, str, 4);
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        return notificationChannel;
    }

    public final void displayLocalNotification(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "body");
        this.notificationProcessor.displayLocalNotification(this.context, i, str, str2, new NotificationBuilder(new NotificationCompat.Builder(this.context, proactiveMessageNotificationChannelId), this.context), this.smallNotificationIconId);
    }

    public final void setLocalNotificationSmallIconId(Integer num) {
        this.smallNotificationIconId = num != null ? num.intValue() : R.drawable.zma_default_notification_icon;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lzendesk/messaging/android/internal/proactivemessaging/LocalNotificationHandler$Companion;", "", "()V", "channelName", "", "proactiveMessageNotificationChannelId", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LocalNotificationHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
