package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyn implements zzadm<zzagg> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    zzyn(zzyl zzyl, zzacf zzacf) {
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagg zzagg = (zzagg) obj;
        this.zzb.zza(new zzafm(zzagg.zzc(), zzagg.zzb(), Long.valueOf(zzagg.zza()), "Bearer"), (String) null, (String) null, true, (zzd) null, this.zza, this);
    }
}
