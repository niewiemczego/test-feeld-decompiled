package zendesk.android.internal.frontendevents;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.storage.android.Storage;

public final class FrontendEventsStorage_Factory implements Factory<FrontendEventsStorage> {
    private final Provider<CoroutineDispatcher> persistenceDispatcherProvider;
    private final Provider<Storage> storageProvider;

    public FrontendEventsStorage_Factory(Provider<Storage> provider, Provider<CoroutineDispatcher> provider2) {
        this.storageProvider = provider;
        this.persistenceDispatcherProvider = provider2;
    }

    public FrontendEventsStorage get() {
        return newInstance(this.storageProvider.get(), this.persistenceDispatcherProvider.get());
    }

    public static FrontendEventsStorage_Factory create(Provider<Storage> provider, Provider<CoroutineDispatcher> provider2) {
        return new FrontendEventsStorage_Factory(provider, provider2);
    }

    public static FrontendEventsStorage newInstance(Storage storage, CoroutineDispatcher coroutineDispatcher) {
        return new FrontendEventsStorage(storage, coroutineDispatcher);
    }
}
