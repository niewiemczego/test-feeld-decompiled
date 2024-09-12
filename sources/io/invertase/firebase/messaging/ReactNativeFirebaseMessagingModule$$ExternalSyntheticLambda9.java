package io.invertase.firebase.messaging;

import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda9 implements Callable {
    public final /* synthetic */ FirebaseMessaging f$0;

    public /* synthetic */ ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda9(FirebaseMessaging firebaseMessaging) {
        this.f$0 = firebaseMessaging;
    }

    public final Object call() {
        return ReactNativeFirebaseMessagingModule.lambda$getToken$2(this.f$0);
    }
}
