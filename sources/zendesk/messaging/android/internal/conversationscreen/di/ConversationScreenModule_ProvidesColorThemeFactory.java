package zendesk.messaging.android.internal.conversationscreen.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.android.messaging.model.MessagingSettings;

public final class ConversationScreenModule_ProvidesColorThemeFactory implements Factory<ColorTheme> {
    private final Provider<Context> contextProvider;
    private final Provider<MessagingSettings> messagingSettingsProvider;
    private final ConversationScreenModule module;

    public ConversationScreenModule_ProvidesColorThemeFactory(ConversationScreenModule conversationScreenModule, Provider<Context> provider, Provider<MessagingSettings> provider2) {
        this.module = conversationScreenModule;
        this.contextProvider = provider;
        this.messagingSettingsProvider = provider2;
    }

    public ColorTheme get() {
        return providesColorTheme(this.module, this.contextProvider.get(), this.messagingSettingsProvider.get());
    }

    public static ConversationScreenModule_ProvidesColorThemeFactory create(ConversationScreenModule conversationScreenModule, Provider<Context> provider, Provider<MessagingSettings> provider2) {
        return new ConversationScreenModule_ProvidesColorThemeFactory(conversationScreenModule, provider, provider2);
    }

    public static ColorTheme providesColorTheme(ConversationScreenModule conversationScreenModule, Context context, MessagingSettings messagingSettings) {
        return (ColorTheme) Preconditions.checkNotNullFromProvides(conversationScreenModule.providesColorTheme(context, messagingSettings));
    }
}
