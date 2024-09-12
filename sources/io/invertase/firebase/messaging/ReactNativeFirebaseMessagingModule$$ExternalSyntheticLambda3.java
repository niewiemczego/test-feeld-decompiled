package io.invertase.firebase.messaging;

import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ ReadableMap f$0;

    public /* synthetic */ ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda3(ReadableMap readableMap) {
        this.f$0 = readableMap;
    }

    public final Object call() {
        return FirebaseMessaging.getInstance().send(ReactNativeFirebaseMessagingSerializer.remoteMessageFromReadableMap(this.f$0));
    }
}
