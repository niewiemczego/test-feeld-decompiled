package zendesk.messaging.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.messaging.UrlSource;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lzendesk/messaging/android/internal/StubUriHandler;", "Lzendesk/messaging/android/internal/UriHandler;", "()V", "onUriClicked", "", "uri", "", "urlSource", "Lzendesk/android/messaging/UrlSource;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UriHandler.kt */
public final class StubUriHandler implements UriHandler {
    public static final StubUriHandler INSTANCE = new StubUriHandler();

    public void onUriClicked(String str, UrlSource urlSource) {
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(urlSource, "urlSource");
    }

    private StubUriHandler() {
    }
}
