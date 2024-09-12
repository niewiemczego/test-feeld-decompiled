package zendesk.messaging.android.internal.conversationscreen.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.messaging.android.internal.conversationscreen.MessageContainerFactory;
import zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper;
import zendesk.messaging.android.internal.conversationscreen.MessageLogLabelProvider;
import zendesk.messaging.android.internal.conversationscreen.MessageLogTimestampFormatter;

public final class MessageLogModule_ProvidesMessageLogEntryMapperFactory implements Factory<MessageLogEntryMapper> {
    private final Provider<MessageContainerFactory> messageContainerFactoryProvider;
    private final Provider<MessageLogLabelProvider> messageLogLabelProvider;
    private final Provider<MessageLogTimestampFormatter> messageLogTimestampFormatterProvider;
    private final MessageLogModule module;

    public MessageLogModule_ProvidesMessageLogEntryMapperFactory(MessageLogModule messageLogModule, Provider<MessageContainerFactory> provider, Provider<MessageLogLabelProvider> provider2, Provider<MessageLogTimestampFormatter> provider3) {
        this.module = messageLogModule;
        this.messageContainerFactoryProvider = provider;
        this.messageLogLabelProvider = provider2;
        this.messageLogTimestampFormatterProvider = provider3;
    }

    public MessageLogEntryMapper get() {
        return providesMessageLogEntryMapper(this.module, this.messageContainerFactoryProvider.get(), this.messageLogLabelProvider.get(), this.messageLogTimestampFormatterProvider.get());
    }

    public static MessageLogModule_ProvidesMessageLogEntryMapperFactory create(MessageLogModule messageLogModule, Provider<MessageContainerFactory> provider, Provider<MessageLogLabelProvider> provider2, Provider<MessageLogTimestampFormatter> provider3) {
        return new MessageLogModule_ProvidesMessageLogEntryMapperFactory(messageLogModule, provider, provider2, provider3);
    }

    public static MessageLogEntryMapper providesMessageLogEntryMapper(MessageLogModule messageLogModule, MessageContainerFactory messageContainerFactory, MessageLogLabelProvider messageLogLabelProvider2, MessageLogTimestampFormatter messageLogTimestampFormatter) {
        return (MessageLogEntryMapper) Preconditions.checkNotNullFromProvides(messageLogModule.providesMessageLogEntryMapper(messageContainerFactory, messageLogLabelProvider2, messageLogTimestampFormatter));
    }
}
