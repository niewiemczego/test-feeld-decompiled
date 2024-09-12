package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException {
    private final String zza;

    public final String getReason() {
        return this.zza;
    }

    public FirebaseAuthWeakPasswordException(String str, String str2, String str3) {
        super(str, str2);
        this.zza = str3;
    }
}
