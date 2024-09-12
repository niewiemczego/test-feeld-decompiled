package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzf implements zzadm<zzafm> {
    final /* synthetic */ zzacf zza;
    final /* synthetic */ zzyl zzb;
    private final /* synthetic */ zzags zzc;

    zzzf(zzyl zzyl, zzags zzags, zzacf zzacf) {
        this.zzc = zzags;
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzc.zzb(true);
        this.zzc.zza(((zzafm) obj).zzc());
        this.zzb.zza.zza(this.zzc, (zzadm<zzagu>) new zzze(this, this));
    }
}
