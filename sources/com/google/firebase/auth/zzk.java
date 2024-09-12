package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzk implements Runnable {
    private final /* synthetic */ FirebaseAuth.IdTokenListener zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzk(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zza = idTokenListener;
        this.zzb = firebaseAuth;
    }

    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
