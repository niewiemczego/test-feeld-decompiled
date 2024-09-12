package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabh extends zzacw<Void, Void> {
    private final zzafy zzy;

    public final String zza() {
        return "revokeAccessToken";
    }

    public zzabh(String str, String str2, String str3, String str4) {
        super(15);
        this.zzy = zzafy.zzg().zzd(str).zza(str2).zzc(str4).zzb(str3).zza(zzaex.ACCESS_TOKEN).zza();
    }

    public final void zzb() {
        zzb(null);
    }

    public final void zza(TaskCompletionSource<Void> taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, (zzacc) this.zzb);
    }
}
