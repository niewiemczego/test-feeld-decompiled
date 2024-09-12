package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zzaf;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzz;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabu extends zzacw<AuthResult, zzl> {
    private String zzy;

    public final String zza() {
        return "unlinkFederatedCredential";
    }

    public zzabu(String str) {
        super(2);
        this.zzy = Preconditions.checkNotEmpty(str, "provider cannot be null or empty");
    }

    public final void zzb() {
        zzaf zza = zzaag.zza(this.zzc, this.zzk);
        ((zzl) this.zze).zza(this.zzj, zza);
        zzb(new zzz(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zzf(this.zzy, this.zzd.zze(), this.zzb);
    }
}
