package zendesk.messaging.android.internal.conversationscreen.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.messaging.android.internal.CoroutinesDispatcherProvider;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage;
import zendesk.storage.android.Storage;

public final class ConversationScreenModule_ProvidesMessagingStorageFactory implements Factory<MessagingStorage> {
    private final Provider<CoroutinesDispatcherProvider> dispatchersProvider;
    private final ConversationScreenModule module;
    private final Provider<Storage> storageProvider;

    public ConversationScreenModule_ProvidesMessagingStorageFactory(ConversationScreenModule conversationScreenModule, Provider<CoroutinesDispatcherProvider> provider, Provider<Storage> provider2) {
        this.module = conversationScreenModule;
        this.dispatchersProvider = provider;
        this.storageProvider = provider2;
    }

    public MessagingStorage get() {
        return providesMessagingStorage(this.module, this.dispatchersProvider.get(), this.storageProvider.get());
    }

    public static ConversationScreenModule_ProvidesMessagingStorageFactory create(ConversationScreenModule conversationScreenModule, Provider<CoroutinesDispatcherProvider> provider, Provider<Storage> provider2) {
        return new ConversationScreenModule_ProvidesMessagingStorageFactory(conversationScreenModule, provider, provider2);
    }

    public static MessagingStorage providesMessagingStorage(ConversationScreenModule conversationScreenModule, CoroutinesDispatcherProvider coroutinesDispatcherProvider, Storage storage) {
        return (MessagingStorage) Preconditions.checkNotNullFromProvides(conversationScreenModule.providesMessagingStorage(coroutinesDispatcherProvider, storage));
    }
}
