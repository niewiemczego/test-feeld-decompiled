package zendesk.android.messaging;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lzendesk/android/messaging/Messaging;", "", "getUnreadMessageCount", "", "showMessaging", "", "context", "Landroid/content/Context;", "intentFlags", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Messaging.kt */
public interface Messaging {
    public static final Companion Companion = Companion.$$INSTANCE;

    @JvmStatic
    static void setDelegate(MessagingDelegate messagingDelegate) {
        Companion.setDelegate(messagingDelegate);
    }

    int getUnreadMessageCount();

    void showMessaging(Context context);

    void showMessaging(Context context, int i);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048B@BX\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/android/messaging/Messaging$Companion;", "", "()V", "<set-?>", "Lzendesk/android/messaging/MessagingDelegate;", "messagingDelegate", "getDelegate", "setDelegate", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Messaging.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static MessagingDelegate messagingDelegate;

        private Companion() {
        }

        @JvmStatic
        public final void setDelegate(MessagingDelegate messagingDelegate2) {
            messagingDelegate = messagingDelegate2;
        }

        public final /* synthetic */ MessagingDelegate getDelegate() {
            MessagingDelegate messagingDelegate2 = messagingDelegate;
            return messagingDelegate2 == null ? new MessagingDelegate() : messagingDelegate2;
        }
    }
}
