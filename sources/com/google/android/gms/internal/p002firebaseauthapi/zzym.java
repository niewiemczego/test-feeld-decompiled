package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzym  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzym implements zzadm<zzagy> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    zzym(zzyl zzyl, zzacf zzacf) {
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagy zzagy = (zzagy) obj;
        if (zzagy.zzf()) {
            this.zza.zza(new zzyi(zzagy.zzc(), zzagy.zze(), (zzd) null));
            return;
        }
        this.zzb.zza(new zzafm(zzagy.zzd(), zzagy.zzb(), Long.valueOf(zzagy.zza()), "Bearer"), (String) null, (String) null, false, (zzd) null, this.zza, this);
    }
}
