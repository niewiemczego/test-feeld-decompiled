package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaau  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaau extends zzacw<AuthResult, zzl> {
    private final PhoneAuthCredential zzy;

    public final String zza() {
        return "linkPhoneAuthCredential";
    }

    public zzaau(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzy = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
    }

    public final void zzb() {
        zzaf zza = zzaag.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zza);
        zzb(new zzz(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(new zzxy(this.zzd.zze(), this.zzy), (zzacc) this.zzb);
    }
}
