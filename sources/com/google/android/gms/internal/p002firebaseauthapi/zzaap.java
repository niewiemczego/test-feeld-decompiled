package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaap  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaap extends zzacw<Void, zzl> {
    private final String zzaa;
    private final String zzab;
    private final MultiFactorAssertion zzy;
    private final String zzz;

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public zzaap(MultiFactorAssertion multiFactorAssertion, String str, String str2, String str3) {
        super(2);
        this.zzy = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzz = Preconditions.checkNotEmpty(str);
        this.zzaa = str2;
        this.zzab = str3;
    }

    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, this.zzz, this.zzaa, this.zzab, (zzacc) this.zzb);
    }
}
