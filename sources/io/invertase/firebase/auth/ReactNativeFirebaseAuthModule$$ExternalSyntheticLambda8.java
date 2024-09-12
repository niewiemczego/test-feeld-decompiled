package io.invertase.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda8 implements FirebaseAuth.AuthStateListener {
    public final /* synthetic */ ReactNativeFirebaseAuthModule f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ ReactNativeFirebaseAuthModule$$ExternalSyntheticLambda8(ReactNativeFirebaseAuthModule reactNativeFirebaseAuthModule, String str) {
        this.f$0 = reactNativeFirebaseAuthModule;
        this.f$1 = str;
    }

    public final void onAuthStateChanged(FirebaseAuth firebaseAuth) {
        this.f$0.m807lambda$addAuthStateListener$0$ioinvertasefirebaseauthReactNativeFirebaseAuthModule(this.f$1, firebaseAuth);
    }
}
