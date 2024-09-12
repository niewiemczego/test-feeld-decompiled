package zendesk.messaging.android.internal.conversationscreen.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.messaging.android.internal.conversationscreen.MessageLogTimestampFormatter;

public final class MessageLogModule_ProvidesMessageLogTimestampFormatterFactory implements Factory<MessageLogTimestampFormatter> {
    private final Provider<Context> contextProvider;
    private final MessageLogModule module;

    public MessageLogModule_ProvidesMessageLogTimestampFormatterFactory(MessageLogModule messageLogModule, Provider<Context> provider) {
        this.module = messageLogModule;
        this.contextProvider = provider;
    }

    public MessageLogTimestampFormatter get() {
        return providesMessageLogTimestampFormatter(this.module, this.contextProvider.get());
    }

    public static MessageLogModule_ProvidesMessageLogTimestampFormatterFactory create(MessageLogModule messageLogModule, Provider<Context> provider) {
        return new MessageLogModule_ProvidesMessageLogTimestampFormatterFactory(messageLogModule, provider);
    }

    public static MessageLogTimestampFormatter providesMessageLogTimestampFormatter(MessageLogModule messageLogModule, Context context) {
        return (MessageLogTimestampFormatter) Preconditions.checkNotNullFromProvides(messageLogModule.providesMessageLogTimestampFormatter(context));
    }
}
