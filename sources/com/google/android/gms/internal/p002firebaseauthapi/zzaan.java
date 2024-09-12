package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzav;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaan  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaan extends zzacw<Void, zzav> {
    public final String zza() {
        return "delete";
    }

    public zzaan() {
        super(5);
    }

    public final void zzb() {
        ((zzav) this.zze).zza();
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzd.zze(), (zzacc) this.zzb);
    }
}
