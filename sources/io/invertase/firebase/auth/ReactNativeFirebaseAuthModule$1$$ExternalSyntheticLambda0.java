package io.invertase.firebase.auth;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthCredential;
import io.invertase.firebase.auth.ReactNativeFirebaseAuthModule;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseAuthModule$1$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ ReactNativeFirebaseAuthModule.AnonymousClass1 f$0;
    public final /* synthetic */ PhoneAuthCredential f$1;
    public final /* synthetic */ Promise f$2;

    public /* synthetic */ ReactNativeFirebaseAuthModule$1$$ExternalSyntheticLambda0(ReactNativeFirebaseAuthModule.AnonymousClass1 r1, PhoneAuthCredential phoneAuthCredential, Promise promise) {
        this.f$0 = r1;
        this.f$1 = phoneAuthCredential;
        this.f$2 = promise;
    }

    public final void onComplete(Task task) {
        this.f$0.m855lambda$onVerificationCompleted$0$ioinvertasefirebaseauthReactNativeFirebaseAuthModule$1(this.f$1, this.f$2, task);
    }
}
