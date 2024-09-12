package zendesk.messaging.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import zendesk.android.messaging.MessagingScreen;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0005H\u0000¢\u0006\u0002\b\fJ\u0011\u0010\r\u001a\u00020\u000b*\u00020\u0005H\u0000¢\u0006\u0002\b\u000eR\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/messaging/android/internal/ScreenStateStore;", "", "()V", "currentlyVisibleScreen", "Lkotlinx/coroutines/flow/StateFlow;", "Lzendesk/android/messaging/MessagingScreen;", "getCurrentlyVisibleScreen$zendesk_messaging_messaging_android", "()Lkotlinx/coroutines/flow/StateFlow;", "mutableCurrentlyVisibleScreen", "Lkotlinx/coroutines/flow/MutableStateFlow;", "clearAsVisibleMessagingScreen", "", "clearAsVisibleMessagingScreen$zendesk_messaging_messaging_android", "setAsVisibleMessagingScreen", "setAsVisibleMessagingScreen$zendesk_messaging_messaging_android", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenStateStore.kt */
public final class ScreenStateStore {
    public static final ScreenStateStore INSTANCE = new ScreenStateStore();
    private static final MutableStateFlow<MessagingScreen> mutableCurrentlyVisibleScreen = StateFlowKt.MutableStateFlow(null);

    private ScreenStateStore() {
    }

    public final StateFlow<MessagingScreen> getCurrentlyVisibleScreen$zendesk_messaging_messaging_android() {
        return mutableCurrentlyVisibleScreen;
    }

    public final void setAsVisibleMessagingScreen$zendesk_messaging_messaging_android(MessagingScreen messagingScreen) {
        Intrinsics.checkNotNullParameter(messagingScreen, "<this>");
        mutableCurrentlyVisibleScreen.setValue(messagingScreen);
    }

    public final void clearAsVisibleMessagingScreen$zendesk_messaging_messaging_android(MessagingScreen messagingScreen) {
        Intrinsics.checkNotNullParameter(messagingScreen, "<this>");
        MutableStateFlow<MessagingScreen> mutableStateFlow = mutableCurrentlyVisibleScreen;
        if (Intrinsics.areEqual((Object) mutableStateFlow.getValue(), (Object) messagingScreen)) {
            mutableStateFlow.setValue(null);
        }
    }
}
