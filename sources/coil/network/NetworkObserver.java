package coil.network;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0005\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lcoil/network/NetworkObserver;", "", "isOnline", "", "()Z", "shutdown", "", "Listener", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NetworkObserver.kt */
public interface NetworkObserver {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcoil/network/NetworkObserver$Listener;", "", "onConnectivityChange", "", "isOnline", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NetworkObserver.kt */
    public interface Listener {
        void onConnectivityChange(boolean z);
    }

    boolean isOnline();

    void shutdown();
}
