package zendesk.messaging.android.push;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lzendesk/messaging/android/push/DefaultMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "newToken", "", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultMessagingService.kt */
public final class DefaultMessagingService extends FirebaseMessagingService {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String LOG_TAG = "DefaultMessagingService";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultMessagingService.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PushResponsibility.values().length];
            iArr[PushResponsibility.MESSAGING_SHOULD_DISPLAY.ordinal()] = 1;
            iArr[PushResponsibility.MESSAGING_SHOULD_NOT_DISPLAY.ordinal()] = 2;
            iArr[PushResponsibility.NOT_FROM_MESSAGING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        Map<String, String> data = remoteMessage.getData();
        Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
        int i = WhenMappings.$EnumSwitchMapping$0[PushNotifications.shouldBeDisplayed(data).ordinal()];
        if (i == 1) {
            Logger.d(LOG_TAG, "Notification received from Messaging and should be displayed", new Object[0]);
            Map<String, String> data2 = remoteMessage.getData();
            Intrinsics.checkNotNullExpressionValue(data2, "remoteMessage.data");
            PushNotifications.displayNotification(this, data2);
        } else if (i == 2) {
            Logger.d(LOG_TAG, "Notification received from Messaging but shouldn't be displayed", new Object[0]);
        } else if (i == 3) {
            Logger.d(LOG_TAG, "Notification received but doesn't belong to Messaging", new Object[0]);
        }
    }

    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, "newToken");
        Logger.d(LOG_TAG, "New Firebase Cloud Messaging token: " + str, new Object[0]);
        PushNotifications.updatePushNotificationToken(str);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/messaging/android/push/DefaultMessagingService$Companion;", "", "()V", "LOG_TAG", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultMessagingService.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
