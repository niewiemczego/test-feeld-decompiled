package zendesk.messaging.android.internal;

import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lzendesk/messaging/android/internal/AttachmentIntents;", "", "canOpenAttachmentIntent", "", "canOpenCameraIntent", "getAttachmentIntent", "Landroid/content/Intent;", "getCameraIntent", "shouldAskForCameraPermission", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttachmentIntents.kt */
public interface AttachmentIntents {
    boolean canOpenAttachmentIntent();

    boolean canOpenCameraIntent();

    Intent getAttachmentIntent();

    Intent getCameraIntent();

    boolean shouldAskForCameraPermission();
}
