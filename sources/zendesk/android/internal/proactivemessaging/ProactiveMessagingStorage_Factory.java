package zendesk.android.internal.proactivemessaging;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.storage.android.Storage;

public final class ProactiveMessagingStorage_Factory implements Factory<ProactiveMessagingStorage> {
    private final Provider<CoroutineDispatcher> persistenceDispatcherProvider;
    private final Provider<Storage> storageProvider;

    public ProactiveMessagingStorage_Factory(Provider<Storage> provider, Provider<CoroutineDispatcher> provider2) {
        this.storageProvider = provider;
        this.persistenceDispatcherProvider = provider2;
    }

    public ProactiveMessagingStorage get() {
        return newInstance(this.storageProvider.get(), this.persistenceDispatcherProvider.get());
    }

    public static ProactiveMessagingStorage_Factory create(Provider<Storage> provider, Provider<CoroutineDispatcher> provider2) {
        return new ProactiveMessagingStorage_Factory(provider, provider2);
    }

    public static ProactiveMessagingStorage newInstance(Storage storage, CoroutineDispatcher coroutineDispatcher) {
        return new ProactiveMessagingStorage(storage, coroutineDispatcher);
    }
}
