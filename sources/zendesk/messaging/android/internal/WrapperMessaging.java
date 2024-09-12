package zendesk.messaging.android.internal;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.Zendesk;
import zendesk.messaging.android.Messaging;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lzendesk/messaging/android/internal/WrapperMessaging;", "Lzendesk/messaging/android/Messaging;", "zendesk", "Lzendesk/android/Zendesk;", "(Lzendesk/android/Zendesk;)V", "getZendesk$zendesk_messaging_messaging_android", "()Lzendesk/android/Zendesk;", "getUnreadMessageCount", "", "showMessaging", "", "context", "Landroid/content/Context;", "intentFlags", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WrapperMessaging.kt */
public final class WrapperMessaging implements Messaging {

    /* renamed from: zendesk  reason: collision with root package name */
    private final Zendesk f32zendesk;

    public WrapperMessaging(Zendesk zendesk2) {
        Intrinsics.checkNotNullParameter(zendesk2, "zendesk");
        this.f32zendesk = zendesk2;
    }

    public final Zendesk getZendesk$zendesk_messaging_messaging_android() {
        return this.f32zendesk;
    }

    public void showMessaging(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f32zendesk.getMessaging().showMessaging(context);
    }

    public void showMessaging(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f32zendesk.getMessaging().showMessaging(context, i);
    }

    public int getUnreadMessageCount() {
        return this.f32zendesk.getMessaging().getUnreadMessageCount();
    }
}
