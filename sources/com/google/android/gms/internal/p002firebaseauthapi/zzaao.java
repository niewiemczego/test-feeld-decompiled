package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaao  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaao extends zzacw<AuthResult, zzl> {
    private final String zzaa;
    private final MultiFactorAssertion zzy;
    private final String zzz;

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public zzaao(MultiFactorAssertion multiFactorAssertion, String str, String str2) {
        super(2);
        this.zzy = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzz = Preconditions.checkNotEmpty(str);
        this.zzaa = str2;
    }

    public final void zzb() {
        zzaf zza = zzaag.zza(this.zzc, this.zzk);
        if (this.zzd == null || this.zzd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zzl) this.zze).zza(this.zzj, zza);
            zzb(new zzz(zza));
            return;
        }
        zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzz, this.zzy, this.zzaa, (zzacc) this.zzb);
    }
}
