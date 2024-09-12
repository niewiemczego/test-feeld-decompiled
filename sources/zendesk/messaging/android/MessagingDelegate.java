package zendesk.messaging.android;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lzendesk/messaging/android/MessagingDelegate;", "Lzendesk/android/messaging/MessagingDelegate;", "()V", "shouldHandleUrl", "", "url", "", "urlSource", "Lzendesk/messaging/android/UrlSource;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Please use Zendesk SDK")
/* compiled from: MessagingDelegate.kt */
public class MessagingDelegate extends zendesk.android.messaging.MessagingDelegate {
    public boolean shouldHandleUrl(String str, UrlSource urlSource) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(urlSource, "urlSource");
        return true;
    }
}
