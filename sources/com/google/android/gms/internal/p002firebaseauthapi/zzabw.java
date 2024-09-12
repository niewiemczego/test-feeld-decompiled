package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabw extends zzacw<Void, zzl> {
    private final String zzy;

    public final String zza() {
        return "updatePassword";
    }

    public zzabw(String str) {
        super(2);
        this.zzy = Preconditions.checkNotEmpty(str, "password cannot be null or empty");
    }

    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zzc(this.zzd.zze(), this.zzy, this.zzb);
    }
}
