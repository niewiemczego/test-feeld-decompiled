package zendesk.messaging.android.internal.conversationscreen;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.ZendeskCredentials;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationActivityIntentBuilder;", "", "context", "Landroid/content/Context;", "credentials", "Lzendesk/android/ZendeskCredentials;", "(Landroid/content/Context;Lzendesk/android/ZendeskCredentials;)V", "intent", "Landroid/content/Intent;", "build", "withFlags", "flags", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationActivity.kt */
public final class ConversationActivityIntentBuilder {
    private final Intent intent;

    public ConversationActivityIntentBuilder(Context context, ZendeskCredentials zendeskCredentials) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(zendeskCredentials, "credentials");
        Intent intent2 = new Intent(context, ConversationActivity.class);
        this.intent = intent2;
        ConversationActivityKt.setCredentials(intent2, ZendeskCredentials.Companion.toQuery(zendeskCredentials));
    }

    public final ConversationActivityIntentBuilder withFlags(int i) {
        ConversationActivityIntentBuilder conversationActivityIntentBuilder = this;
        this.intent.setFlags(i);
        return this;
    }

    public final Intent build() {
        return this.intent;
    }
}
