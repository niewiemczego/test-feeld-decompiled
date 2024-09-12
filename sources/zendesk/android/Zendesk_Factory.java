package zendesk.android;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.events.internal.ZendeskEventDispatcher;
import zendesk.android.internal.frontendevents.pageviewevents.PageViewEvents;
import zendesk.android.messaging.Messaging;
import zendesk.conversationkit.android.ConversationKit;

public final class Zendesk_Factory implements Factory<Zendesk> {
    private final Provider<ConversationKit> conversationKitProvider;
    private final Provider<ZendeskEventDispatcher> eventDispatcherProvider;
    private final Provider<Messaging> messagingProvider;
    private final Provider<PageViewEvents> pageViewEventsProvider;
    private final Provider<CoroutineScope> scopeProvider;

    public Zendesk_Factory(Provider<Messaging> provider, Provider<CoroutineScope> provider2, Provider<ZendeskEventDispatcher> provider3, Provider<ConversationKit> provider4, Provider<PageViewEvents> provider5) {
        this.messagingProvider = provider;
        this.scopeProvider = provider2;
        this.eventDispatcherProvider = provider3;
        this.conversationKitProvider = provider4;
        this.pageViewEventsProvider = provider5;
    }

    public Zendesk get() {
        return newInstance(this.messagingProvider.get(), this.scopeProvider.get(), this.eventDispatcherProvider.get(), this.conversationKitProvider.get(), this.pageViewEventsProvider.get());
    }

    public static Zendesk_Factory create(Provider<Messaging> provider, Provider<CoroutineScope> provider2, Provider<ZendeskEventDispatcher> provider3, Provider<ConversationKit> provider4, Provider<PageViewEvents> provider5) {
        return new Zendesk_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static Zendesk newInstance(Messaging messaging, CoroutineScope coroutineScope, ZendeskEventDispatcher zendeskEventDispatcher, ConversationKit conversationKit, PageViewEvents pageViewEvents) {
        return new Zendesk(messaging, coroutineScope, zendeskEventDispatcher, conversationKit, pageViewEvents);
    }
}
