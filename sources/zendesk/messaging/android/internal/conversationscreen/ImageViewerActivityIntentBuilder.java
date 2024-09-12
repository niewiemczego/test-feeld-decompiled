package zendesk.messaging.android.internal.conversationscreen;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ImageViewerActivityIntentBuilder;", "", "context", "Landroid/content/Context;", "credentials", "", "(Landroid/content/Context;Ljava/lang/String;)V", "intent", "Landroid/content/Intent;", "build", "withFlags", "flags", "", "withUri", "uri", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewerActivity.kt */
public final class ImageViewerActivityIntentBuilder {
    private final Intent intent;

    public ImageViewerActivityIntentBuilder(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "credentials");
        Intent intent2 = new Intent(context, ImageViewerActivity.class);
        this.intent = intent2;
        ImageViewerActivityKt.setCredentials(intent2, str);
    }

    public final ImageViewerActivityIntentBuilder withFlags(int i) {
        ImageViewerActivityIntentBuilder imageViewerActivityIntentBuilder = this;
        this.intent.setFlags(i);
        return this;
    }

    public final ImageViewerActivityIntentBuilder withUri(String str) {
        Intrinsics.checkNotNullParameter(str, "uri");
        ImageViewerActivityIntentBuilder imageViewerActivityIntentBuilder = this;
        ImageViewerActivityKt.setUri(this.intent, str);
        return this;
    }

    public final Intent build() {
        return this.intent;
    }
}
