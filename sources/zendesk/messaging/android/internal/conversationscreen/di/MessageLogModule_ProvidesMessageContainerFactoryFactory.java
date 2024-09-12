package zendesk.messaging.android.internal.conversationscreen.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.messaging.android.internal.conversationscreen.MessageContainerFactory;
import zendesk.messaging.android.internal.conversationscreen.MessageLogLabelProvider;
import zendesk.messaging.android.internal.conversationscreen.MessageLogTimestampFormatter;

public final class MessageLogModule_ProvidesMessageContainerFactoryFactory implements Factory<MessageContainerFactory> {
    private final Provider<MessageLogLabelProvider> messageLogLabelProvider;
    private final Provider<MessageLogTimestampFormatter> messageLogTimestampFormatterProvider;
    private final MessageLogModule module;

    public MessageLogModule_ProvidesMessageContainerFactoryFactory(MessageLogModule messageLogModule, Provider<MessageLogLabelProvider> provider, Provider<MessageLogTimestampFormatter> provider2) {
        this.module = messageLogModule;
        this.messageLogLabelProvider = provider;
        this.messageLogTimestampFormatterProvider = provider2;
    }

    public MessageContainerFactory get() {
        return providesMessageContainerFactory(this.module, this.messageLogLabelProvider.get(), this.messageLogTimestampFormatterProvider.get());
    }

    public static MessageLogModule_ProvidesMessageContainerFactoryFactory create(MessageLogModule messageLogModule, Provider<MessageLogLabelProvider> provider, Provider<MessageLogTimestampFormatter> provider2) {
        return new MessageLogModule_ProvidesMessageContainerFactoryFactory(messageLogModule, provider, provider2);
    }

    public static MessageContainerFactory providesMessageContainerFactory(MessageLogModule messageLogModule, MessageLogLabelProvider messageLogLabelProvider2, MessageLogTimestampFormatter messageLogTimestampFormatter) {
        return (MessageContainerFactory) Preconditions.checkNotNullFromProvides(messageLogModule.providesMessageContainerFactory(messageLogLabelProvider2, messageLogTimestampFormatter));
    }
}
