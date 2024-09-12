package zendesk.messaging.android.internal.conversationscreen.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorageSerializer;
import zendesk.storage.android.StorageType;

public final class ConversationScreenModule_ProvidesStorageTypeFactory implements Factory<StorageType> {
    private final Provider<MessagingStorageSerializer> messagingStorageSerializerProvider;
    private final ConversationScreenModule module;

    public ConversationScreenModule_ProvidesStorageTypeFactory(ConversationScreenModule conversationScreenModule, Provider<MessagingStorageSerializer> provider) {
        this.module = conversationScreenModule;
        this.messagingStorageSerializerProvider = provider;
    }

    public StorageType get() {
        return providesStorageType(this.module, this.messagingStorageSerializerProvider.get());
    }

    public static ConversationScreenModule_ProvidesStorageTypeFactory create(ConversationScreenModule conversationScreenModule, Provider<MessagingStorageSerializer> provider) {
        return new ConversationScreenModule_ProvidesStorageTypeFactory(conversationScreenModule, provider);
    }

    public static StorageType providesStorageType(ConversationScreenModule conversationScreenModule, MessagingStorageSerializer messagingStorageSerializer) {
        return (StorageType) Preconditions.checkNotNullFromProvides(conversationScreenModule.providesStorageType(messagingStorageSerializer));
    }
}
