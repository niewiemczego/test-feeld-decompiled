package io.invertase.firebase.messaging;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda6 implements OnCompleteListener {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda6(Promise promise) {
        this.f$0 = promise;
    }

    public final void onComplete(Task task) {
        ReactNativeFirebaseMessagingModule.lambda$setAutoInitEnabled$1(this.f$0, task);
    }
}