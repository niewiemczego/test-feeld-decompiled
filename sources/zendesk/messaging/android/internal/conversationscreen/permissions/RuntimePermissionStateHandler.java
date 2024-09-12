package zendesk.messaging.android.internal.conversationscreen.permissions;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermissionStateHandler;", "", "()V", "NOTIFICATION_PERMISSION", "", "shouldShowRuntimePermissionRational", "", "runtimePermissionStates", "", "Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermissionState;", "shouldShowRuntimePermissionRational$zendesk_messaging_messaging_android", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RuntimePermissionStateHandler.kt */
public final class RuntimePermissionStateHandler {
    public static final RuntimePermissionStateHandler INSTANCE = new RuntimePermissionStateHandler();
    public static final String NOTIFICATION_PERMISSION = "android.permission.POST_NOTIFICATIONS";

    private RuntimePermissionStateHandler() {
    }

    public final boolean shouldShowRuntimePermissionRational$zendesk_messaging_messaging_android(List<RuntimePermissionState> list) {
        Intrinsics.checkNotNullParameter(list, "runtimePermissionStates");
        boolean z = false;
        for (RuntimePermissionState next : list) {
            String permission = next.getPermission();
            if (permission == null || !Intrinsics.areEqual((Object) permission, (Object) NOTIFICATION_PERMISSION)) {
                if (!next.isGranted() || next.getShouldShowRational()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                return false;
            }
        }
        return z;
    }
}
