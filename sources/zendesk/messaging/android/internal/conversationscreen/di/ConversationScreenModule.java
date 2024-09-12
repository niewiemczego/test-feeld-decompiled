package zendesk.messaging.android.internal.conversationscreen.di;

import android.content.Context;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistryOwner;
import com.oblador.keychain.KeychainModule;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.android.messaging.model.MessagingSettings;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.messaging.android.internal.CoroutinesDispatcherProvider;
import zendesk.messaging.android.internal.DefaultMessaging;
import zendesk.messaging.android.internal.NewMessagesDividerHandler;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModelFactory;
import zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorageSerializer;
import zendesk.messaging.android.internal.extension.ContextKtxKt;
import zendesk.storage.android.Storage;
import zendesk.storage.android.StorageFactory;
import zendesk.storage.android.StorageType;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007JR\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020 H\u0007¨\u0006&"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/di/ConversationScreenModule;", "", "()V", "providesColorTheme", "Lzendesk/android/messaging/model/ColorTheme;", "context", "Landroid/content/Context;", "messagingSettings", "Lzendesk/android/messaging/model/MessagingSettings;", "providesConversationViewModelFactory", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;", "colorTheme", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "messageLogEntryMapper", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper;", "messagingStorage", "Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorage;", "newMessagesDividerHandler", "Lzendesk/messaging/android/internal/NewMessagesDividerHandler;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "sdkCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "providesMessagingStorage", "dispatchers", "Lzendesk/messaging/android/internal/CoroutinesDispatcherProvider;", "storage", "Lzendesk/storage/android/Storage;", "providesMessagingStorageSerializer", "Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorageSerializer;", "providesStorage", "storageType", "Lzendesk/storage/android/StorageType;", "providesStorageType", "messagingStorageSerializer", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: ConversationScreenModule.kt */
public final class ConversationScreenModule {
    @Provides
    public final MessagingStorage providesMessagingStorage(CoroutinesDispatcherProvider coroutinesDispatcherProvider, Storage storage) {
        Intrinsics.checkNotNullParameter(coroutinesDispatcherProvider, "dispatchers");
        Intrinsics.checkNotNullParameter(storage, KeychainModule.Maps.STORAGE);
        return new MessagingStorage(coroutinesDispatcherProvider.getIo(), storage);
    }

    @Provides
    public final MessagingStorageSerializer providesMessagingStorageSerializer() {
        return new MessagingStorageSerializer((Moshi) null, 1, (DefaultConstructorMarker) null);
    }

    @Provides
    public final StorageType providesStorageType(MessagingStorageSerializer messagingStorageSerializer) {
        Intrinsics.checkNotNullParameter(messagingStorageSerializer, "messagingStorageSerializer");
        return new StorageType.Complex(messagingStorageSerializer);
    }

    @Provides
    public final Storage providesStorage(Context context, StorageType storageType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageType, "storageType");
        return StorageFactory.INSTANCE.create(DefaultMessaging.MESSAGING_NAMESPACE, context, storageType);
    }

    @Provides
    public final ColorTheme providesColorTheme(Context context, MessagingSettings messagingSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messagingSettings, "messagingSettings");
        return ContextKtxKt.getColorTheme(context, messagingSettings);
    }

    @Provides
    public final ConversationScreenViewModelFactory providesConversationViewModelFactory(MessagingSettings messagingSettings, ColorTheme colorTheme, ConversationKit conversationKit, MessageLogEntryMapper messageLogEntryMapper, MessagingStorage messagingStorage, NewMessagesDividerHandler newMessagesDividerHandler, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(messagingSettings, "messagingSettings");
        Intrinsics.checkNotNullParameter(colorTheme, "colorTheme");
        Intrinsics.checkNotNullParameter(conversationKit, "conversationKit");
        Intrinsics.checkNotNullParameter(messageLogEntryMapper, "messageLogEntryMapper");
        MessagingStorage messagingStorage2 = messagingStorage;
        Intrinsics.checkNotNullParameter(messagingStorage2, "messagingStorage");
        NewMessagesDividerHandler newMessagesDividerHandler2 = newMessagesDividerHandler;
        Intrinsics.checkNotNullParameter(newMessagesDividerHandler2, "newMessagesDividerHandler");
        SavedStateRegistryOwner savedStateRegistryOwner2 = savedStateRegistryOwner;
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner2, "savedStateRegistryOwner");
        CoroutineScope coroutineScope2 = coroutineScope;
        Intrinsics.checkNotNullParameter(coroutineScope2, "sdkCoroutineScope");
        return new ConversationScreenViewModelFactory(messagingSettings, colorTheme, conversationKit, messageLogEntryMapper, messagingStorage2, newMessagesDividerHandler2, coroutineScope2, savedStateRegistryOwner2, bundle);
    }
}
