package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabs extends zzacw<Void, zzl> {
    private final String zzaa;
    private final String zzy;
    private final String zzz;

    public final String zza() {
        return "unenrollMfa";
    }

    public zzabs(String str, String str2, String str3) {
        super(2);
        this.zzy = Preconditions.checkNotEmpty(str);
        this.zzz = Preconditions.checkNotEmpty(str2);
        this.zzaa = str3;
    }

    public final void zzb() {
        ((zzl) this.zze).zza(this.zzj, zzaag.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, this.zzz, this.zzaa, (zzacc) this.zzb);
    }
}
