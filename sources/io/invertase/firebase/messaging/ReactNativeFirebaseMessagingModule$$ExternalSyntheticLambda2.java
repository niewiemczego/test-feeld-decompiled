package io.invertase.firebase.messaging;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda2 implements OnCompleteListener {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda2(Promise promise) {
        this.f$0 = promise;
    }

    public final void onComplete(Task task) {
        ReactNativeFirebaseMessagingModule.lambda$subscribeToTopic$10(this.f$0, task);
    }
}
