package io.invertase.firebase.messaging;

import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda5 implements Callable {
    public final /* synthetic */ Boolean f$0;

    public /* synthetic */ ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda5(Boolean bool) {
        this.f$0 = bool;
    }

    public final Object call() {
        return FirebaseMessaging.getInstance().setAutoInitEnabled(this.f$0.booleanValue());
    }
}
