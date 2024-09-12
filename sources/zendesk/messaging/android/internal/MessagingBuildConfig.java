package zendesk.messaging.android.internal;

import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lzendesk/messaging/android/internal/MessagingBuildConfig;", "", "()V", "atLeastAndroid26", "", "atLeastAndroid29", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingBuildConfig.kt */
public final class MessagingBuildConfig {
    public static final MessagingBuildConfig INSTANCE = new MessagingBuildConfig();

    private MessagingBuildConfig() {
    }

    public final boolean atLeastAndroid26() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final boolean atLeastAndroid29() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
