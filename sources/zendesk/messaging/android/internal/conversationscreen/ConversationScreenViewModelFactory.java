package zendesk.messaging.android.internal.conversationscreen;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.android.messaging.model.MessagingSettings;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.messaging.android.internal.NewMessagesDividerHandler;
import zendesk.messaging.android.internal.conversationscreen.cache.MessagingStorage;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J5\u0010\u0015\u001a\u0002H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "messagingSettings", "Lzendesk/android/messaging/model/MessagingSettings;", "colorTheme", "Lzendesk/android/messaging/model/ColorTheme;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "messageLogEntryMapper", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper;", "messagingStorage", "Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorage;", "newMessagesDividerHandler", "Lzendesk/messaging/android/internal/NewMessagesDividerHandler;", "sdkCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lzendesk/android/messaging/model/MessagingSettings;Lzendesk/android/messaging/model/ColorTheme;Lzendesk/conversationkit/android/ConversationKit;Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper;Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingStorage;Lzendesk/messaging/android/internal/NewMessagesDividerHandler;Lkotlinx/coroutines/CoroutineScope;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenViewModelFactory.kt */
public final class ConversationScreenViewModelFactory extends AbstractSavedStateViewModelFactory {
    private final ColorTheme colorTheme;
    private final ConversationKit conversationKit;
    private final MessageLogEntryMapper messageLogEntryMapper;
    private final MessagingSettings messagingSettings;
    private final MessagingStorage messagingStorage;
    private final NewMessagesDividerHandler newMessagesDividerHandler;
    private final CoroutineScope sdkCoroutineScope;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationScreenViewModelFactory(MessagingSettings messagingSettings2, ColorTheme colorTheme2, ConversationKit conversationKit2, MessageLogEntryMapper messageLogEntryMapper2, MessagingStorage messagingStorage2, NewMessagesDividerHandler newMessagesDividerHandler2, CoroutineScope coroutineScope, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(messagingSettings2, colorTheme2, conversationKit2, messageLogEntryMapper2, messagingStorage2, newMessagesDividerHandler2, coroutineScope, savedStateRegistryOwner, (i & 256) != 0 ? null : bundle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConversationScreenViewModelFactory(MessagingSettings messagingSettings2, ColorTheme colorTheme2, ConversationKit conversationKit2, MessageLogEntryMapper messageLogEntryMapper2, MessagingStorage messagingStorage2, NewMessagesDividerHandler newMessagesDividerHandler2, CoroutineScope coroutineScope, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        super(savedStateRegistryOwner, bundle);
        Intrinsics.checkNotNullParameter(messagingSettings2, "messagingSettings");
        Intrinsics.checkNotNullParameter(colorTheme2, "colorTheme");
        Intrinsics.checkNotNullParameter(conversationKit2, "conversationKit");
        Intrinsics.checkNotNullParameter(messageLogEntryMapper2, "messageLogEntryMapper");
        Intrinsics.checkNotNullParameter(messagingStorage2, "messagingStorage");
        Intrinsics.checkNotNullParameter(newMessagesDividerHandler2, "newMessagesDividerHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "sdkCoroutineScope");
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        this.messagingSettings = messagingSettings2;
        this.colorTheme = colorTheme2;
        this.conversationKit = conversationKit2;
        this.messageLogEntryMapper = messageLogEntryMapper2;
        this.messagingStorage = messagingStorage2;
        this.newMessagesDividerHandler = newMessagesDividerHandler2;
        this.sdkCoroutineScope = coroutineScope;
    }

    /* access modifiers changed from: protected */
    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        return (ViewModel) new ConversationScreenViewModel(this.messagingSettings, this.colorTheme, this.conversationKit, this.messageLogEntryMapper, this.messagingStorage, this.newMessagesDividerHandler, savedStateHandle, this.sdkCoroutineScope);
    }
}
