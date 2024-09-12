package zendesk.messaging.android.internal.conversationscreen.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorageSerializer;

public final class ConversationScreenModule_ProvidesMessagingStorageSerializerFactory implements Factory<MessagingStorageSerializer> {
    private final ConversationScreenModule module;

    public ConversationScreenModule_ProvidesMessagingStorageSerializerFactory(ConversationScreenModule conversationScreenModule) {
        this.module = conversationScreenModule;
    }

    public MessagingStorageSerializer get() {
        return providesMessagingStorageSerializer(this.module);
    }

    public static ConversationScreenModule_ProvidesMessagingStorageSerializerFactory create(ConversationScreenModule conversationScreenModule) {
        return new ConversationScreenModule_ProvidesMessagingStorageSerializerFactory(conversationScreenModule);
    }

    public static MessagingStorageSerializer providesMessagingStorageSerializer(ConversationScreenModule conversationScreenModule) {
        return (MessagingStorageSerializer) Preconditions.checkNotNullFromProvides(conversationScreenModule.providesMessagingStorageSerializer());
    }
}
