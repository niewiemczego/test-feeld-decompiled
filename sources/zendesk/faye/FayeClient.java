package zendesk.faye;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lzendesk/faye/FayeClient;", "", "keepConnectionAlive", "", "getKeepConnectionAlive", "()Z", "setKeepConnectionAlive", "(Z)V", "addListener", "", "listener", "Lzendesk/faye/FayeClientListener;", "isConnected", "removeListener", "send", "bayeuxMessage", "Lzendesk/faye/BayeuxMessage;", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FayeClient.kt */
public interface FayeClient {
    void addListener(FayeClientListener fayeClientListener);

    boolean getKeepConnectionAlive();

    boolean isConnected();

    void removeListener(FayeClientListener fayeClientListener);

    void send(BayeuxMessage bayeuxMessage);

    void setKeepConnectionAlive(boolean z);
}
