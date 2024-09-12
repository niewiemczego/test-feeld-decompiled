package zendesk.android.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import zendesk.conversationkit.android.ConversationKit;

public final class ZendeskInitializedModule_ProvidesConversationKitFactory implements Factory<ConversationKit> {
    private final ZendeskInitializedModule module;

    public ZendeskInitializedModule_ProvidesConversationKitFactory(ZendeskInitializedModule zendeskInitializedModule) {
        this.module = zendeskInitializedModule;
    }

    public ConversationKit get() {
        return providesConversationKit(this.module);
    }

    public static ZendeskInitializedModule_ProvidesConversationKitFactory create(ZendeskInitializedModule zendeskInitializedModule) {
        return new ZendeskInitializedModule_ProvidesConversationKitFactory(zendeskInitializedModule);
    }

    public static ConversationKit providesConversationKit(ZendeskInitializedModule zendeskInitializedModule) {
        return (ConversationKit) Preconditions.checkNotNullFromProvides(zendeskInitializedModule.providesConversationKit());
    }
}
