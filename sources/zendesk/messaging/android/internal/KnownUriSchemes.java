package zendesk.messaging.android.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lzendesk/messaging/android/internal/KnownUriSchemes;", "", "()V", "EMAIL", "", "PHONE_NUMBER", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UriHandler.kt */
public final class KnownUriSchemes {
    public static final String EMAIL = "mailto:";
    public static final KnownUriSchemes INSTANCE = new KnownUriSchemes();
    public static final String PHONE_NUMBER = "tel:";

    private KnownUriSchemes() {
    }
}
