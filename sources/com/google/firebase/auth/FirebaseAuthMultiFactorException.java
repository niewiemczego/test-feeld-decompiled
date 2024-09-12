package com.google.firebase.auth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class FirebaseAuthMultiFactorException extends FirebaseAuthException {
    private MultiFactorResolver zza;

    public MultiFactorResolver getResolver() {
        return this.zza;
    }

    public FirebaseAuthMultiFactorException(String str, String str2, MultiFactorResolver multiFactorResolver) {
        super(str, str2);
        this.zza = multiFactorResolver;
    }
}
