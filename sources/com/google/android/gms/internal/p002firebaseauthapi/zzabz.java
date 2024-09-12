package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabz extends zzacw<Void, zzl> {
    private final PhoneAuthCredential zzy;

    public final String zza() {
        return "updatePhoneNumber";
    }

    public zzabz(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzy = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(new zzxy(this.zzd.zze(), this.zzy), (zzacc) this.zzb);
    }
}
