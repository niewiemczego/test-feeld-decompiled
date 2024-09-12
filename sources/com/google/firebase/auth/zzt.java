package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzt implements Runnable {
    private final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzt(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zza = authStateListener;
        this.zzb = firebaseAuth;
    }

    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
