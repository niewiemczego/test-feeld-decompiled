package zendesk.messaging.android.push.internal;

import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lzendesk/messaging/android/push/internal/NotificationProcessorFactory;", "", "()V", "notificationProcessor", "Lzendesk/messaging/android/push/internal/NotificationProcessor;", "create", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationProcessorFactory.kt */
public final class NotificationProcessorFactory {
    public static final NotificationProcessorFactory INSTANCE = new NotificationProcessorFactory();
    private static NotificationProcessor notificationProcessor;

    private NotificationProcessorFactory() {
    }

    public final NotificationProcessor create() {
        NotificationProcessor notificationProcessor2 = notificationProcessor;
        if (notificationProcessor2 != null) {
            return notificationProcessor2;
        }
        NotificationProcessor notificationProcessor3 = new NotificationProcessor((Moshi) null, 1, (DefaultConstructorMarker) null);
        notificationProcessor = notificationProcessor3;
        return notificationProcessor3;
    }
}
