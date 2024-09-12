package com.google.firebase.auth;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzi implements Runnable {
    private /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    private /* synthetic */ FirebaseException zzb;

    public /* synthetic */ zzi(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, FirebaseException firebaseException) {
        this.zza = onVerificationStateChangedCallbacks;
        this.zzb = firebaseException;
    }

    public final void run() {
        this.zza.onVerificationFailed(this.zzb);
    }
}
