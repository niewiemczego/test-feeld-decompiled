package zendesk.messaging.android.internal.di;

import android.content.Context;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistryOwner;
import dagger.internal.Preconditions;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.ZendeskCredentials;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.android.messaging.model.MessagingSettings;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.messaging.android.internal.CoroutinesDispatcherProvider;
import zendesk.messaging.android.internal.NewMessagesDividerHandler;
import zendesk.messaging.android.internal.conversationscreen.ConversationActivity;
import zendesk.messaging.android.internal.conversationscreen.ConversationActivity_MembersInjector;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModelFactory;
import zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity;
import zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity_MembersInjector;
import zendesk.messaging.android.internal.conversationscreen.MessageContainerFactory;
import zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper;
import zendesk.messaging.android.internal.conversationscreen.MessageLogLabelProvider;
import zendesk.messaging.android.internal.conversationscreen.MessageLogTimestampFormatter;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationActivityComponent;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationScreenModule;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationScreenModule_ProvidesColorThemeFactory;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationScreenModule_ProvidesConversationViewModelFactoryFactory;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationScreenModule_ProvidesMessagingStorageFactory;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationScreenModule_ProvidesMessagingStorageSerializerFactory;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationScreenModule_ProvidesStorageFactory;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationScreenModule_ProvidesStorageTypeFactory;
import zendesk.messaging.android.internal.conversationscreen.di.ImageViewerComponent;
import zendesk.messaging.android.internal.conversationscreen.di.MessageLogModule;
import zendesk.messaging.android.internal.conversationscreen.di.MessageLogModule_ProvidesMessageContainerFactoryFactory;
import zendesk.messaging.android.internal.conversationscreen.di.MessageLogModule_ProvidesMessageLogEntryMapperFactory;
import zendesk.messaging.android.internal.conversationscreen.di.MessageLogModule_ProvidesMessageLogLabelProviderFactory;
import zendesk.messaging.android.internal.conversationscreen.di.MessageLogModule_ProvidesMessageLogTimestampFormatterFactory;
import zendesk.messaging.android.internal.di.MessagingComponent;
import zendesk.storage.android.Storage;
import zendesk.storage.android.StorageType;

public final class DaggerMessagingComponent {
    private DaggerMessagingComponent() {
    }

    public static MessagingComponent.Factory factory() {
        return new Factory();
    }

    private static final class Factory implements MessagingComponent.Factory {
        private Factory() {
        }

        public MessagingComponent create(ZendeskCredentials zendeskCredentials, MessagingSettings messagingSettings, ConversationKit conversationKit, Function2<? super ZendeskEvent, ? super Continuation<? super Unit>, ?> function2, CoroutineScope coroutineScope) {
            Preconditions.checkNotNull(zendeskCredentials);
            Preconditions.checkNotNull(messagingSettings);
            Preconditions.checkNotNull(conversationKit);
            Preconditions.checkNotNull(function2);
            Preconditions.checkNotNull(coroutineScope);
            return new MessagingComponentImpl(zendeskCredentials, messagingSettings, conversationKit, function2, coroutineScope);
        }
    }

    private static final class ConversationActivityComponentFactory implements ConversationActivityComponent.Factory {
        private final MessagingComponentImpl messagingComponentImpl;

        private ConversationActivityComponentFactory(MessagingComponentImpl messagingComponentImpl2) {
            this.messagingComponentImpl = messagingComponentImpl2;
        }

        public ConversationActivityComponent create(Context context, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(savedStateRegistryOwner);
            return new ConversationActivityComponentImpl(this.messagingComponentImpl, new ConversationScreenModule(), new MessageLogModule(), context, savedStateRegistryOwner, bundle);
        }
    }

    private static final class ImageViewerComponentFactory implements ImageViewerComponent.Factory {
        private final MessagingComponentImpl messagingComponentImpl;

        private ImageViewerComponentFactory(MessagingComponentImpl messagingComponentImpl2) {
            this.messagingComponentImpl = messagingComponentImpl2;
        }

        public ImageViewerComponent create(Context context, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(savedStateRegistryOwner);
            return new ImageViewerComponentImpl(this.messagingComponentImpl, new ConversationScreenModule(), new MessageLogModule(), context, savedStateRegistryOwner, bundle);
        }
    }

    private static final class ConversationActivityComponentImpl implements ConversationActivityComponent {
        private final Context context;
        private final ConversationActivityComponentImpl conversationActivityComponentImpl;
        private final ConversationScreenModule conversationScreenModule;
        private final Bundle defaultArgs;
        private final MessageLogModule messageLogModule;
        private final MessagingComponentImpl messagingComponentImpl;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        private ConversationActivityComponentImpl(MessagingComponentImpl messagingComponentImpl2, ConversationScreenModule conversationScreenModule2, MessageLogModule messageLogModule2, Context context2, SavedStateRegistryOwner savedStateRegistryOwner2, Bundle bundle) {
            this.conversationActivityComponentImpl = this;
            this.messagingComponentImpl = messagingComponentImpl2;
            this.conversationScreenModule = conversationScreenModule2;
            this.context = context2;
            this.messageLogModule = messageLogModule2;
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
            this.defaultArgs = bundle;
        }

        private ColorTheme colorTheme() {
            return ConversationScreenModule_ProvidesColorThemeFactory.providesColorTheme(this.conversationScreenModule, this.context, this.messagingComponentImpl.messagingSettings);
        }

        private MessageLogLabelProvider messageLogLabelProvider() {
            return MessageLogModule_ProvidesMessageLogLabelProviderFactory.providesMessageLogLabelProvider(this.messageLogModule, this.context);
        }

        private MessageLogTimestampFormatter messageLogTimestampFormatter() {
            return MessageLogModule_ProvidesMessageLogTimestampFormatterFactory.providesMessageLogTimestampFormatter(this.messageLogModule, this.context);
        }

        private MessageContainerFactory messageContainerFactory() {
            return MessageLogModule_ProvidesMessageContainerFactoryFactory.providesMessageContainerFactory(this.messageLogModule, messageLogLabelProvider(), messageLogTimestampFormatter());
        }

        private MessageLogEntryMapper messageLogEntryMapper() {
            return MessageLogModule_ProvidesMessageLogEntryMapperFactory.providesMessageLogEntryMapper(this.messageLogModule, messageContainerFactory(), messageLogLabelProvider(), messageLogTimestampFormatter());
        }

        private StorageType storageType() {
            ConversationScreenModule conversationScreenModule2 = this.conversationScreenModule;
            return ConversationScreenModule_ProvidesStorageTypeFactory.providesStorageType(conversationScreenModule2, ConversationScreenModule_ProvidesMessagingStorageSerializerFactory.providesMessagingStorageSerializer(conversationScreenModule2));
        }

        private Storage storage() {
            return ConversationScreenModule_ProvidesStorageFactory.providesStorage(this.conversationScreenModule, this.context, storageType());
        }

        private MessagingStorage messagingStorage() {
            return ConversationScreenModule_ProvidesMessagingStorageFactory.providesMessagingStorage(this.conversationScreenModule, new CoroutinesDispatcherProvider(), storage());
        }

        private ConversationScreenViewModelFactory conversationScreenViewModelFactory() {
            return ConversationScreenModule_ProvidesConversationViewModelFactoryFactory.providesConversationViewModelFactory(this.conversationScreenModule, this.messagingComponentImpl.messagingSettings, colorTheme(), this.messagingComponentImpl.conversationKit, messageLogEntryMapper(), messagingStorage(), new NewMessagesDividerHandler(), this.savedStateRegistryOwner, this.defaultArgs, this.messagingComponentImpl.coroutineScope);
        }

        public void inject(ConversationActivity conversationActivity) {
            injectConversationActivity(conversationActivity);
        }

        private ConversationActivity injectConversationActivity(ConversationActivity conversationActivity) {
            ConversationActivity_MembersInjector.injectConversationScreenViewModelFactory(conversationActivity, conversationScreenViewModelFactory());
            ConversationActivity_MembersInjector.injectSdkCoroutineScope(conversationActivity, this.messagingComponentImpl.coroutineScope);
            return conversationActivity;
        }
    }

    private static final class ImageViewerComponentImpl implements ImageViewerComponent {
        private final Context context;
        private final ConversationScreenModule conversationScreenModule;
        private final Bundle defaultArgs;
        private final ImageViewerComponentImpl imageViewerComponentImpl;
        private final MessageLogModule messageLogModule;
        private final MessagingComponentImpl messagingComponentImpl;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        private ImageViewerComponentImpl(MessagingComponentImpl messagingComponentImpl2, ConversationScreenModule conversationScreenModule2, MessageLogModule messageLogModule2, Context context2, SavedStateRegistryOwner savedStateRegistryOwner2, Bundle bundle) {
            this.imageViewerComponentImpl = this;
            this.messagingComponentImpl = messagingComponentImpl2;
            this.conversationScreenModule = conversationScreenModule2;
            this.context = context2;
            this.messageLogModule = messageLogModule2;
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
            this.defaultArgs = bundle;
        }

        private ColorTheme colorTheme() {
            return ConversationScreenModule_ProvidesColorThemeFactory.providesColorTheme(this.conversationScreenModule, this.context, this.messagingComponentImpl.messagingSettings);
        }

        private MessageLogLabelProvider messageLogLabelProvider() {
            return MessageLogModule_ProvidesMessageLogLabelProviderFactory.providesMessageLogLabelProvider(this.messageLogModule, this.context);
        }

        private MessageLogTimestampFormatter messageLogTimestampFormatter() {
            return MessageLogModule_ProvidesMessageLogTimestampFormatterFactory.providesMessageLogTimestampFormatter(this.messageLogModule, this.context);
        }

        private MessageContainerFactory messageContainerFactory() {
            return MessageLogModule_ProvidesMessageContainerFactoryFactory.providesMessageContainerFactory(this.messageLogModule, messageLogLabelProvider(), messageLogTimestampFormatter());
        }

        private MessageLogEntryMapper messageLogEntryMapper() {
            return MessageLogModule_ProvidesMessageLogEntryMapperFactory.providesMessageLogEntryMapper(this.messageLogModule, messageContainerFactory(), messageLogLabelProvider(), messageLogTimestampFormatter());
        }

        private StorageType storageType() {
            ConversationScreenModule conversationScreenModule2 = this.conversationScreenModule;
            return ConversationScreenModule_ProvidesStorageTypeFactory.providesStorageType(conversationScreenModule2, ConversationScreenModule_ProvidesMessagingStorageSerializerFactory.providesMessagingStorageSerializer(conversationScreenModule2));
        }

        private Storage storage() {
            return ConversationScreenModule_ProvidesStorageFactory.providesStorage(this.conversationScreenModule, this.context, storageType());
        }

        private MessagingStorage messagingStorage() {
            return ConversationScreenModule_ProvidesMessagingStorageFactory.providesMessagingStorage(this.conversationScreenModule, new CoroutinesDispatcherProvider(), storage());
        }

        private ConversationScreenViewModelFactory conversationScreenViewModelFactory() {
            return ConversationScreenModule_ProvidesConversationViewModelFactoryFactory.providesConversationViewModelFactory(this.conversationScreenModule, this.messagingComponentImpl.messagingSettings, colorTheme(), this.messagingComponentImpl.conversationKit, messageLogEntryMapper(), messagingStorage(), new NewMessagesDividerHandler(), this.savedStateRegistryOwner, this.defaultArgs, this.messagingComponentImpl.coroutineScope);
        }

        public void inject(ImageViewerActivity imageViewerActivity) {
            injectImageViewerActivity(imageViewerActivity);
        }

        private ImageViewerActivity injectImageViewerActivity(ImageViewerActivity imageViewerActivity) {
            ImageViewerActivity_MembersInjector.injectConversationScreenViewModelFactory(imageViewerActivity, conversationScreenViewModelFactory());
            return imageViewerActivity;
        }
    }

    private static final class MessagingComponentImpl implements MessagingComponent {
        /* access modifiers changed from: private */
        public final ConversationKit conversationKit;
        /* access modifiers changed from: private */
        public final CoroutineScope coroutineScope;
        private final MessagingComponentImpl messagingComponentImpl;
        /* access modifiers changed from: private */
        public final MessagingSettings messagingSettings;

        private MessagingComponentImpl(ZendeskCredentials zendeskCredentials, MessagingSettings messagingSettings2, ConversationKit conversationKit2, Function2<? super ZendeskEvent, ? super Continuation<? super Unit>, ?> function2, CoroutineScope coroutineScope2) {
            this.messagingComponentImpl = this;
            this.messagingSettings = messagingSettings2;
            this.conversationKit = conversationKit2;
            this.coroutineScope = coroutineScope2;
        }

        public ConversationActivityComponent.Factory conversationActivityComponent() {
            return new ConversationActivityComponentFactory(this.messagingComponentImpl);
        }

        public ImageViewerComponent.Factory imageViewerActivityComponent() {
            return new ImageViewerComponentFactory(this.messagingComponentImpl);
        }
    }
}
