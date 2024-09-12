package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzacd extends zzacw<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final zzyd zzy;

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final void zzb() {
    }

    public zzacd(zzafz zzafz) {
        super(8);
        Preconditions.checkNotNull(zzafz);
        this.zzy = new zzyd(zzafz);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, (zzacc) this.zzb);
    }
}
