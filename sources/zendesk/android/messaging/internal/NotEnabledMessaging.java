package zendesk.android.messaging.internal;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.Zendesk;
import zendesk.android.internal.ZendeskError;
import zendesk.android.messaging.Messaging;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lzendesk/android/messaging/internal/NotEnabledMessaging;", "Lzendesk/android/messaging/Messaging;", "()V", "getUnreadMessageCount", "", "showMessaging", "", "context", "Landroid/content/Context;", "intentFlags", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotEnabledMessaging.kt */
public final class NotEnabledMessaging implements Messaging {
    public static final NotEnabledMessaging INSTANCE = new NotEnabledMessaging();

    private NotEnabledMessaging() {
    }

    public void showMessaging(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.e(Zendesk.LOG_TAG, ZendeskError.SdkNotEnabled.INSTANCE.getMessage(), ZendeskError.SdkNotEnabled.INSTANCE, new Object[0]);
    }

    public void showMessaging(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger.e(Zendesk.LOG_TAG, ZendeskError.SdkNotEnabled.INSTANCE.getMessage(), ZendeskError.SdkNotEnabled.INSTANCE, new Object[0]);
    }

    public int getUnreadMessageCount() {
        Logger.e(Zendesk.LOG_TAG, ZendeskError.SdkNotEnabled.INSTANCE.getMessage(), ZendeskError.SdkNotEnabled.INSTANCE, new Object[0]);
        return 0;
    }
}
