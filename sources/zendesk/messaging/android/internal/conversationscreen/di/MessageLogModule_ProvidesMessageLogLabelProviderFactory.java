package zendesk.messaging.android.internal.conversationscreen.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.messaging.android.internal.conversationscreen.MessageLogLabelProvider;

public final class MessageLogModule_ProvidesMessageLogLabelProviderFactory implements Factory<MessageLogLabelProvider> {
    private final Provider<Context> contextProvider;
    private final MessageLogModule module;

    public MessageLogModule_ProvidesMessageLogLabelProviderFactory(MessageLogModule messageLogModule, Provider<Context> provider) {
        this.module = messageLogModule;
        this.contextProvider = provider;
    }

    public MessageLogLabelProvider get() {
        return providesMessageLogLabelProvider(this.module, this.contextProvider.get());
    }

    public static MessageLogModule_ProvidesMessageLogLabelProviderFactory create(MessageLogModule messageLogModule, Provider<Context> provider) {
        return new MessageLogModule_ProvidesMessageLogLabelProviderFactory(messageLogModule, provider);
    }

    public static MessageLogLabelProvider providesMessageLogLabelProvider(MessageLogModule messageLogModule, Context context) {
        return (MessageLogLabelProvider) Preconditions.checkNotNullFromProvides(messageLogModule.providesMessageLogLabelProvider(context));
    }
}
