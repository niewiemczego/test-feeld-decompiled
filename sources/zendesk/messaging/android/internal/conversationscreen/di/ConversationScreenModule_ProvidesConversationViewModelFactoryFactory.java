package zendesk.messaging.android.internal.conversationscreen.di;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.android.messaging.model.MessagingSettings;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.messaging.android.internal.NewMessagesDividerHandler;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModelFactory;
import zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage;

public final class ConversationScreenModule_ProvidesConversationViewModelFactoryFactory implements Factory<ConversationScreenViewModelFactory> {
    private final Provider<ColorTheme> colorThemeProvider;
    private final Provider<ConversationKit> conversationKitProvider;
    private final Provider<Bundle> defaultArgsProvider;
    private final Provider<MessageLogEntryMapper> messageLogEntryMapperProvider;
    private final Provider<MessagingSettings> messagingSettingsProvider;
    private final Provider<MessagingStorage> messagingStorageProvider;
    private final ConversationScreenModule module;
    private final Provider<NewMessagesDividerHandler> newMessagesDividerHandlerProvider;
    private final Provider<SavedStateRegistryOwner> savedStateRegistryOwnerProvider;
    private final Provider<CoroutineScope> sdkCoroutineScopeProvider;

    public ConversationScreenModule_ProvidesConversationViewModelFactoryFactory(ConversationScreenModule conversationScreenModule, Provider<MessagingSettings> provider, Provider<ColorTheme> provider2, Provider<ConversationKit> provider3, Provider<MessageLogEntryMapper> provider4, Provider<MessagingStorage> provider5, Provider<NewMessagesDividerHandler> provider6, Provider<SavedStateRegistryOwner> provider7, Provider<Bundle> provider8, Provider<CoroutineScope> provider9) {
        this.module = conversationScreenModule;
        this.messagingSettingsProvider = provider;
        this.colorThemeProvider = provider2;
        this.conversationKitProvider = provider3;
        this.messageLogEntryMapperProvider = provider4;
        this.messagingStorageProvider = provider5;
        this.newMessagesDividerHandlerProvider = provider6;
        this.savedStateRegistryOwnerProvider = provider7;
        this.defaultArgsProvider = provider8;
        this.sdkCoroutineScopeProvider = provider9;
    }

    public ConversationScreenViewModelFactory get() {
        return providesConversationViewModelFactory(this.module, this.messagingSettingsProvider.get(), this.colorThemeProvider.get(), this.conversationKitProvider.get(), this.messageLogEntryMapperProvider.get(), this.messagingStorageProvider.get(), this.newMessagesDividerHandlerProvider.get(), this.savedStateRegistryOwnerProvider.get(), this.defaultArgsProvider.get(), this.sdkCoroutineScopeProvider.get());
    }

    public static ConversationScreenModule_ProvidesConversationViewModelFactoryFactory create(ConversationScreenModule conversationScreenModule, Provider<MessagingSettings> provider, Provider<ColorTheme> provider2, Provider<ConversationKit> provider3, Provider<MessageLogEntryMapper> provider4, Provider<MessagingStorage> provider5, Provider<NewMessagesDividerHandler> provider6, Provider<SavedStateRegistryOwner> provider7, Provider<Bundle> provider8, Provider<CoroutineScope> provider9) {
        return new ConversationScreenModule_ProvidesConversationViewModelFactoryFactory(conversationScreenModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ConversationScreenViewModelFactory providesConversationViewModelFactory(ConversationScreenModule conversationScreenModule, MessagingSettings messagingSettings, ColorTheme colorTheme, ConversationKit conversationKit, MessageLogEntryMapper messageLogEntryMapper, MessagingStorage messagingStorage, NewMessagesDividerHandler newMessagesDividerHandler, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, CoroutineScope coroutineScope) {
        return (ConversationScreenViewModelFactory) Preconditions.checkNotNullFromProvides(conversationScreenModule.providesConversationViewModelFactory(messagingSettings, colorTheme, conversationKit, messageLogEntryMapper, messagingStorage, newMessagesDividerHandler, savedStateRegistryOwner, bundle, coroutineScope));
    }
}
