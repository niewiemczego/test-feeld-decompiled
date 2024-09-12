package zendesk.conversationkit.android.internal;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/ConnectivityObserver;", "Landroid/net/ConnectivityManager$NetworkCallback;", "connectivityManager", "Landroid/net/ConnectivityManager;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/net/ConnectivityManager;Lkotlinx/coroutines/CoroutineScope;)V", "actionDispatcher", "Lzendesk/conversationkit/android/internal/ActionDispatcher;", "getActionDispatcher", "()Lzendesk/conversationkit/android/internal/ActionDispatcher;", "setActionDispatcher", "(Lzendesk/conversationkit/android/internal/ActionDispatcher;)V", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "startObserving", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectivityObserver.kt */
public final class ConnectivityObserver extends ConnectivityManager.NetworkCallback {
    private ActionDispatcher actionDispatcher = new StubActionDispatcher();
    private final ConnectivityManager connectivityManager;
    private final CoroutineScope coroutineScope;

    public ConnectivityObserver(ConnectivityManager connectivityManager2, CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        this.connectivityManager = connectivityManager2;
        this.coroutineScope = coroutineScope2;
    }

    public final ActionDispatcher getActionDispatcher() {
        return this.actionDispatcher;
    }

    public final void setActionDispatcher(ActionDispatcher actionDispatcher2) {
        Intrinsics.checkNotNullParameter(actionDispatcher2, "<set-?>");
        this.actionDispatcher = actionDispatcher2;
    }

    public final void startObserving(ActionDispatcher actionDispatcher2) {
        Intrinsics.checkNotNullParameter(actionDispatcher2, "actionDispatcher");
        this.actionDispatcher = actionDispatcher2;
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
        ConnectivityManager connectivityManager2 = this.connectivityManager;
        if (connectivityManager2 != null) {
            connectivityManager2.registerNetworkCallback(build, this);
        }
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConnectivityObserver$onAvailable$1(this, (Continuation<? super ConnectivityObserver$onAvailable$1>) null), 3, (Object) null);
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConnectivityObserver$onLost$1(this, (Continuation<? super ConnectivityObserver$onLost$1>) null), 3, (Object) null);
    }
}
