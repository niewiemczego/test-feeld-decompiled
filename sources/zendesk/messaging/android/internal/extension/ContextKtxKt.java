package zendesk.messaging.android.internal.extension;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.android.messaging.model.MessagingSettings;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getColorTheme", "Lzendesk/android/messaging/model/ColorTheme;", "Landroid/content/Context;", "messagingSettings", "Lzendesk/android/messaging/model/MessagingSettings;", "zendesk.messaging_messaging-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContextKtx.kt */
public final class ContextKtxKt {
    public static final ColorTheme getColorTheme(Context context, MessagingSettings messagingSettings) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(messagingSettings, "messagingSettings");
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return messagingSettings.getDarkTheme();
        }
        return messagingSettings.getLightTheme();
    }
}
