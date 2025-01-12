package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzx implements Runnable {
    private final /* synthetic */ FirebaseAuth zza;

    zzx(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void run() {
        for (FirebaseAuth.AuthStateListener onAuthStateChanged : this.zza.zzd) {
            onAuthStateChanged.onAuthStateChanged(this.zza);
        }
    }
}
