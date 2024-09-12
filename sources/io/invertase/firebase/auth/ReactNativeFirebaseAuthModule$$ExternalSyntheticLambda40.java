package io.invertase.firebase.auth;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda40 implements OnFailureListener {
    public final /* synthetic */ ReactNativeFirebaseAuthModule f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda40(ReactNativeFirebaseAuthModule reactNativeFirebaseAuthModule, Promise promise) {
        this.f$0 = reactNativeFirebaseAuthModule;
        this.f$1 = promise;
    }

    public final void onFailure(Exception exc) {
        this.f$0.m822lambda$linkWithProvider$36$ioinvertasefirebaseauthReactNativeFirebaseAuthModule(this.f$1, exc);
    }
}
