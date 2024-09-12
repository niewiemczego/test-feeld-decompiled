package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzd implements zzadm<zzafm> {
    final /* synthetic */ zzacf zza;
    final /* synthetic */ zzyl zzb;
    private final /* synthetic */ zzagx zzc;

    zzzd(zzyl zzyl, zzagx zzagx, zzacf zzacf) {
        this.zzc = zzagx;
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzc.zza(((zzafm) obj).zzc());
        this.zzb.zza.zza(this.zzc, (zzadm<zzaha>) new zzzc(this, this));
    }
}
