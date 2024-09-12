package io.invertase.firebase.auth;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda41 implements OnSuccessListener {
    public final /* synthetic */ ReactNativeFirebaseAuthModule f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda41(ReactNativeFirebaseAuthModule reactNativeFirebaseAuthModule, Promise promise) {
        this.f$0 = reactNativeFirebaseAuthModule;
        this.f$1 = promise;
    }

    public final void onSuccess(Object obj) {
        this.f$0.m823lambda$linkWithProvider$37$ioinvertasefirebaseauthReactNativeFirebaseAuthModule(this.f$1, (AuthResult) obj);
    }
}
