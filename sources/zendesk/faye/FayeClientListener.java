package zendesk.faye;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0011"}, d2 = {"Lzendesk/faye/FayeClientListener;", "", "onClientError", "", "fayeClientError", "Lzendesk/faye/FayeClientError;", "throwable", "", "onConnectedToServer", "onDisconnectedFromServer", "onMessagePublished", "channel", "", "message", "onMessageReceived", "onSubscribedToChannel", "onUnsubscribedFromChannel", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FayeClientListener.kt */
public interface FayeClientListener {
    void onClientError(FayeClientError fayeClientError, Throwable th);

    void onConnectedToServer();

    void onDisconnectedFromServer();

    void onMessagePublished(String str, String str2);

    void onMessageReceived(String str, String str2);

    void onSubscribedToChannel(String str);

    void onUnsubscribedFromChannel(String str);
}
