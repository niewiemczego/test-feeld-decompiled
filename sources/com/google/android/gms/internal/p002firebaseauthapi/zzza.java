package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzza  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzza implements zzadm<zzagg> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzadj zzb;
    private final /* synthetic */ zzyl zzc;

    zzza(zzyl zzyl, zzacf zzacf, zzadj zzadj) {
        this.zza = zzacf;
        this.zzb = zzadj;
        this.zzc = zzyl;
    }

    public final void zza(String str) {
        this.zzb.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagg zzagg = (zzagg) obj;
        this.zzc.zza(new zzafm(zzagg.zzc(), zzagg.zzb(), Long.valueOf(zzagg.zza()), "Bearer"), (String) null, "password", false, (zzd) null, this.zza, this);
    }
}
