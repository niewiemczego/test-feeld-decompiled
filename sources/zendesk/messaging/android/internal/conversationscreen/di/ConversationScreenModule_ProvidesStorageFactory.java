package zendesk.messaging.android.internal.conversationscreen.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.storage.android.Storage;
import zendesk.storage.android.StorageType;

public final class ConversationScreenModule_ProvidesStorageFactory implements Factory<Storage> {
    private final Provider<Context> contextProvider;
    private final ConversationScreenModule module;
    private final Provider<StorageType> storageTypeProvider;

    public ConversationScreenModule_ProvidesStorageFactory(ConversationScreenModule conversationScreenModule, Provider<Context> provider, Provider<StorageType> provider2) {
        this.module = conversationScreenModule;
        this.contextProvider = provider;
        this.storageTypeProvider = provider2;
    }

    public Storage get() {
        return providesStorage(this.module, this.contextProvider.get(), this.storageTypeProvider.get());
    }

    public static ConversationScreenModule_ProvidesStorageFactory create(ConversationScreenModule conversationScreenModule, Provider<Context> provider, Provider<StorageType> provider2) {
        return new ConversationScreenModule_ProvidesStorageFactory(conversationScreenModule, provider, provider2);
    }

    public static Storage providesStorage(ConversationScreenModule conversationScreenModule, Context context, StorageType storageType) {
        return (Storage) Preconditions.checkNotNullFromProvides(conversationScreenModule.providesStorage(context, storageType));
    }
}
