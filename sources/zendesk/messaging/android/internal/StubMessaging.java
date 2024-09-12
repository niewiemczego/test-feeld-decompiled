package zendesk.messaging.android.internal;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.logger.Logger;
import zendesk.messaging.android.Messaging;
import zendesk.messaging.android.MessagingError;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lzendesk/messaging/android/internal/StubMessaging;", "Lzendesk/messaging/android/Messaging;", "()V", "LOG_TAG", "", "getUnreadMessageCount", "", "showMessaging", "", "context", "Landroid/content/Context;", "intentFlags", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StubMessaging.kt */
public final class StubMessaging implements Messaging {
    public static final StubMessaging INSTANCE = new StubMessaging();
    private static final String LOG_TAG = "Messaging";

    public int getUnreadMessageCount() {
        return 0;
    }

    private StubMessaging() {
    }

    public void showMessaging(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.e(LOG_TAG, MessagingError.NotInitialized.INSTANCE.getMessage(), MessagingError.NotInitialized.INSTANCE, new Object[0]);
    }

    public void showMessaging(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.e(LOG_TAG, MessagingError.NotInitialized.INSTANCE.getMessage(), MessagingError.NotInitialized.INSTANCE, new Object[0]);
    }
}
