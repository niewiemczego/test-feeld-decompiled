package io.invertase.firebase.messaging;

import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.RemoteMessage;

public interface ReactNativeFirebaseMessagingStore {
    void clearFirebaseMessage(String str);

    @Deprecated
    RemoteMessage getFirebaseMessage(String str);

    WritableMap getFirebaseMessageMap(String str);

    void storeFirebaseMessage(RemoteMessage remoteMessage);
}
