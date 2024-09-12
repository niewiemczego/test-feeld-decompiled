package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzadr extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    private final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zza;
    private final /* synthetic */ String zzb;

    zzadr(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, String str) {
        this.zza = onVerificationStateChangedCallbacks;
        this.zzb = str;
    }

    public final void onCodeAutoRetrievalTimeOut(String str) {
        zzads.zza.remove(this.zzb);
        this.zza.onCodeAutoRetrievalTimeOut(str);
    }

    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.zza.onCodeSent(str, forceResendingToken);
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        zzads.zza.remove(this.zzb);
        this.zza.onVerificationCompleted(phoneAuthCredential);
    }

    public final void onVerificationFailed(FirebaseException firebaseException) {
        zzads.zza.remove(this.zzb);
        this.zza.onVerificationFailed(firebaseException);
    }
}
