package zendesk.android.internal.frontendevents.analyticsevents;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.internal.frontendevents.FrontendEventsRepository;
import zendesk.conversationkit.android.ConversationKit;

public final class ProactiveMessagingAnalyticsManager_Factory implements Factory<ProactiveMessagingAnalyticsManager> {
    private final Provider<ConversationKit> conversationKitProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<FrontendEventsRepository> frontendEventsRepositoryProvider;

    public ProactiveMessagingAnalyticsManager_Factory(Provider<FrontendEventsRepository> provider, Provider<CoroutineScope> provider2, Provider<ConversationKit> provider3) {
        this.frontendEventsRepositoryProvider = provider;
        this.coroutineScopeProvider = provider2;
        this.conversationKitProvider = provider3;
    }

    public ProactiveMessagingAnalyticsManager get() {
        return newInstance(this.frontendEventsRepositoryProvider.get(), this.coroutineScopeProvider.get(), this.conversationKitProvider.get());
    }

    public static ProactiveMessagingAnalyticsManager_Factory create(Provider<FrontendEventsRepository> provider, Provider<CoroutineScope> provider2, Provider<ConversationKit> provider3) {
        return new ProactiveMessagingAnalyticsManager_Factory(provider, provider2, provider3);
    }

    public static ProactiveMessagingAnalyticsManager newInstance(FrontendEventsRepository frontendEventsRepository, CoroutineScope coroutineScope, ConversationKit conversationKit) {
        return new ProactiveMessagingAnalyticsManager(frontendEventsRepository, coroutineScope, conversationKit);
    }
}
