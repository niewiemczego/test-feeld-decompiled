package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class FirebaseAuthSettings {
    public abstract void forceRecaptchaFlowForTesting(boolean z);

    public abstract void setAppVerificationDisabledForTesting(boolean z);

    public abstract void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2);
}
