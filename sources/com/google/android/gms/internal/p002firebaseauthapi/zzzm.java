package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzm implements zzadm<zzafm> {
    final /* synthetic */ zzacf zza;
    final /* synthetic */ zzyl zzb;
    private final /* synthetic */ zzaeq zzc;

    zzzm(zzyl zzyl, zzaeq zzaeq, zzacf zzacf) {
        this.zzc = zzaeq;
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzc.zza(((zzafm) obj).zzc());
        this.zzb.zza.zza(this.zzc, (zzadm<zzaep>) new zzzp(this));
    }
}
