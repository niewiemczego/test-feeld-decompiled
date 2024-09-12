package zendesk.messaging.android.push.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.Zendesk;
import zendesk.android.messaging.Messaging;
import zendesk.messaging.android.internal.DefaultMessaging;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000eJ\u001e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lzendesk/messaging/android/push/internal/NotificationBuilder;", "", "compatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "context", "Landroid/content/Context;", "(Landroidx/core/app/NotificationCompat$Builder;Landroid/content/Context;)V", "build", "Landroid/app/Notification;", "setAutoCancel", "autoCancel", "", "setCategory", "category", "", "setMessage", "message", "setMessagingStyle", "text", "received", "", "person", "Landroidx/core/app/Person;", "setOpenNotificationIntent", "notificationId", "", "setSmallIcon", "smallIconId", "setStyle", "style", "Landroidx/core/app/NotificationCompat$Style;", "setTitle", "title", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationBuilder.kt */
public final class NotificationBuilder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INTENT_REQUEST_CODE = 0;
    public static final String NOTIFICATION_ID = "NOTIFICATION_ID";
    private final NotificationCompat.Builder compatBuilder;
    private final Context context;

    public NotificationBuilder(NotificationCompat.Builder builder, Context context2) {
        Intrinsics.checkNotNullParameter(builder, "compatBuilder");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.compatBuilder = builder;
        this.context = context2;
    }

    public final NotificationBuilder setSmallIcon(int i) {
        NotificationBuilder notificationBuilder = this;
        this.compatBuilder.setSmallIcon(i);
        return this;
    }

    public final NotificationBuilder setStyle(NotificationCompat.Style style) {
        NotificationBuilder notificationBuilder = this;
        this.compatBuilder.setStyle(style);
        return this;
    }

    public final NotificationBuilder setMessagingStyle(String str, long j, Person person) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(person, "person");
        NotificationBuilder notificationBuilder = this;
        setStyle(new NotificationCompat.MessagingStyle(person).addMessage(new NotificationCompat.MessagingStyle.Message((CharSequence) str, j, person)));
        return this;
    }

    public final NotificationBuilder setCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "category");
        NotificationBuilder notificationBuilder = this;
        this.compatBuilder.setCategory(str);
        return this;
    }

    public final NotificationBuilder setAutoCancel(boolean z) {
        NotificationBuilder notificationBuilder = this;
        this.compatBuilder.setAutoCancel(z);
        return this;
    }

    public final NotificationBuilder setOpenNotificationIntent(int i) {
        Intent intent;
        NotificationBuilder notificationBuilder = this;
        Messaging messaging = Zendesk.Companion.getInstance().getMessaging();
        DefaultMessaging defaultMessaging = messaging instanceof DefaultMessaging ? (DefaultMessaging) messaging : null;
        if (defaultMessaging == null || (intent = defaultMessaging.messagingIntent$zendesk_messaging_messaging_android(this.context, C.ENCODING_PCM_32BIT)) == null) {
            intent = this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName());
        }
        if (intent != null) {
            intent.putExtra(NOTIFICATION_ID, i);
        }
        int i2 = Build.VERSION.SDK_INT > 30 ? 1140850688 : 1073741824;
        if (intent != null) {
            this.compatBuilder.setContentIntent(PendingIntent.getActivity(this.context, 0, intent, i2));
        }
        return this;
    }

    public final NotificationBuilder setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        NotificationBuilder notificationBuilder = this;
        this.compatBuilder.setContentTitle(str);
        return this;
    }

    public final NotificationBuilder setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        NotificationBuilder notificationBuilder = this;
        this.compatBuilder.setContentText(str);
        return this;
    }

    public final Notification build() {
        Notification build = this.compatBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "compatBuilder.build()");
        return build;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/push/internal/NotificationBuilder$Companion;", "", "()V", "INTENT_REQUEST_CODE", "", "NOTIFICATION_ID", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NotificationBuilder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
