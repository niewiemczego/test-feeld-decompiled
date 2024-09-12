package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyo implements zzadm<zzaen> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    zzyo(zzyl zzyl, zzacf zzacf) {
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaen zzaen = (zzaen) obj;
        if (zzaen.zzf()) {
            this.zza.zza(new zzyi(zzaen.zzc(), zzaen.zze(), (zzd) null));
            return;
        }
        this.zzb.zza(new zzafm(zzaen.zzd(), zzaen.zzb(), Long.valueOf(zzaen.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzaen.zzg()), (zzd) null, this.zza, this);
    }
}
