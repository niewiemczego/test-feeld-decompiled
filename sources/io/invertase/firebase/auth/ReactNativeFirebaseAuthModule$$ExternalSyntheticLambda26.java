package io.invertase.firebase.auth;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda26 implements OnCompleteListener {
    public final /* synthetic */ ReactNativeFirebaseAuthModule f$0;
    public final /* synthetic */ FirebaseAuth f$1;
    public final /* synthetic */ Promise f$2;

    public /* synthetic */ ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda26(ReactNativeFirebaseAuthModule reactNativeFirebaseAuthModule, FirebaseAuth firebaseAuth, Promise promise) {
        this.f$0 = reactNativeFirebaseAuthModule;
        this.f$1 = firebaseAuth;
        this.f$2 = promise;
    }

    public final void onComplete(Task task) {
        this.f$0.m849lambda$updateEmail$18$ioinvertasefirebaseauthReactNativeFirebaseAuthModule(this.f$1, this.f$2, task);
    }
}
