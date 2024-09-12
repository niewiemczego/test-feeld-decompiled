package io.invertase.firebase.messaging;

public class ReactNativeFirebaseMessagingStoreHelper {
    private static ReactNativeFirebaseMessagingStoreHelper _instance;
    private ReactNativeFirebaseMessagingStore messagingStore = new ReactNativeFirebaseMessagingStoreImpl();

    private ReactNativeFirebaseMessagingStoreHelper() {
    }

    public static ReactNativeFirebaseMessagingStoreHelper getInstance() {
        if (_instance == null) {
            _instance = new ReactNativeFirebaseMessagingStoreHelper();
        }
        return _instance;
    }

    public ReactNativeFirebaseMessagingStore getMessagingStore() {
        return this.messagingStore;
    }
}
