package zendesk.conversationkit.android.internal.faye;

import com.oblador.keychain.KeychainModule;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.internal.ActionDispatcher;
import zendesk.conversationkit.android.internal.StubActionDispatcher;
import zendesk.conversationkit.android.model.AuthenticationType;
import zendesk.conversationkit.android.model.RealtimeSettings;
import zendesk.faye.FayeClientBuilder;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/SunCoFayeClientFactory;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "actionDispatcher", "Lzendesk/conversationkit/android/internal/ActionDispatcher;", "getActionDispatcher", "()Lzendesk/conversationkit/android/internal/ActionDispatcher;", "setActionDispatcher", "(Lzendesk/conversationkit/android/internal/ActionDispatcher;)V", "create", "Lzendesk/conversationkit/android/internal/faye/SunCoFayeClient;", "realtimeSettings", "Lzendesk/conversationkit/android/model/RealtimeSettings;", "authenticationType", "Lzendesk/conversationkit/android/model/AuthenticationType;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunCoFayeClientFactory.kt */
public final class SunCoFayeClientFactory {
    private ActionDispatcher actionDispatcher = new StubActionDispatcher();
    private final CoroutineScope coroutineScope;

    public SunCoFayeClientFactory(CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.coroutineScope = coroutineScope2;
    }

    public final ActionDispatcher getActionDispatcher() {
        return this.actionDispatcher;
    }

    public final void setActionDispatcher(ActionDispatcher actionDispatcher2) {
        Intrinsics.checkNotNullParameter(actionDispatcher2, "<set-?>");
        this.actionDispatcher = actionDispatcher2;
    }

    public final SunCoFayeClient create(RealtimeSettings realtimeSettings, AuthenticationType authenticationType) {
        Intrinsics.checkNotNullParameter(realtimeSettings, "realtimeSettings");
        Intrinsics.checkNotNullParameter(authenticationType, KeychainModule.Maps.AUTH_TYPE);
        return new DefaultSunCoFayeClient(new FayeClientBuilder(realtimeSettings.getBaseUrl()).build(), realtimeSettings, authenticationType, this.actionDispatcher, this.coroutineScope, (Moshi) null, 32, (DefaultConstructorMarker) null);
    }
}
