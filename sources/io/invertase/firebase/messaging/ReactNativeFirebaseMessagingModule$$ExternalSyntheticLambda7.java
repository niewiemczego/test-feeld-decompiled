package io.invertase.firebase.messaging;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda7 implements Callable {
    public final /* synthetic */ FirebaseMessaging f$0;

    public /* synthetic */ ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda7(FirebaseMessaging firebaseMessaging) {
        this.f$0 = firebaseMessaging;
    }

    public final Object call() {
        return Tasks.await(this.f$0.deleteToken());
    }
}
