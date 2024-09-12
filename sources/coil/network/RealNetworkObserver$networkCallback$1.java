package coil.network;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"coil/network/RealNetworkObserver$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkObserver.kt */
public final class RealNetworkObserver$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ RealNetworkObserver this$0;

    RealNetworkObserver$networkCallback$1(RealNetworkObserver realNetworkObserver) {
        this.this$0 = realNetworkObserver;
    }

    public void onAvailable(Network network) {
        this.this$0.onConnectivityChange(network, true);
    }

    public void onLost(Network network) {
        this.this$0.onConnectivityChange(network, false);
    }
}
