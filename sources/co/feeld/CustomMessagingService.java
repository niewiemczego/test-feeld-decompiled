package co.feeld;

import com.braze.push.BrazeFirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingService;

public class CustomMessagingService extends ReactNativeFirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        BrazeFirebaseMessagingService.handleBrazeRemoteMessage(this, remoteMessage);
    }
}
