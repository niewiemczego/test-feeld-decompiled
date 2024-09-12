package zendesk.android.internal.di;

import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.messaging.Messaging;
import zendesk.conversationkit.android.ConversationKit;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/android/internal/di/ZendeskInitializedModule;", "", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "messaging", "Lzendesk/android/messaging/Messaging;", "(Lzendesk/conversationkit/android/ConversationKit;Lzendesk/android/messaging/Messaging;)V", "providesConversationKit", "providesMessaging", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: ZendeskInitializedModule.kt */
public final class ZendeskInitializedModule {
    private final ConversationKit conversationKit;
    private final Messaging messaging;

    public ZendeskInitializedModule(ConversationKit conversationKit2, Messaging messaging2) {
        Intrinsics.checkNotNullParameter(conversationKit2, "conversationKit");
        Intrinsics.checkNotNullParameter(messaging2, "messaging");
        this.conversationKit = conversationKit2;
        this.messaging = messaging2;
    }

    @Provides
    @ZendeskInitializedComponentScope
    public final Messaging providesMessaging() {
        return this.messaging;
    }

    @Provides
    @ZendeskInitializedComponentScope
    public final ConversationKit providesConversationKit() {
        return this.conversationKit;
    }
}
