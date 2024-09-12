package zendesk.android.internal.frontendevents.pageviewevents;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.android.internal.frontendevents.FrontendEventsRepository;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingManager;

public final class DefaultPageViewEvents_Factory implements Factory<DefaultPageViewEvents> {
    private final Provider<FrontendEventsRepository> frontendEventsRepositoryProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<ProactiveMessagingManager> proactiveMessagingManagerProvider;

    public DefaultPageViewEvents_Factory(Provider<FrontendEventsRepository> provider, Provider<CoroutineDispatcher> provider2, Provider<ProactiveMessagingManager> provider3) {
        this.frontendEventsRepositoryProvider = provider;
        this.ioDispatcherProvider = provider2;
        this.proactiveMessagingManagerProvider = provider3;
    }

    public DefaultPageViewEvents get() {
        return newInstance(this.frontendEventsRepositoryProvider.get(), this.ioDispatcherProvider.get(), this.proactiveMessagingManagerProvider.get());
    }

    public static DefaultPageViewEvents_Factory create(Provider<FrontendEventsRepository> provider, Provider<CoroutineDispatcher> provider2, Provider<ProactiveMessagingManager> provider3) {
        return new DefaultPageViewEvents_Factory(provider, provider2, provider3);
    }

    public static DefaultPageViewEvents newInstance(FrontendEventsRepository frontendEventsRepository, CoroutineDispatcher coroutineDispatcher, ProactiveMessagingManager proactiveMessagingManager) {
        return new DefaultPageViewEvents(frontendEventsRepository, coroutineDispatcher, proactiveMessagingManager);
    }
}
