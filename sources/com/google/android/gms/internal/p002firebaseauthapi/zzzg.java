package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzg implements zzadm<zzafm> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzacf zzb;
    final /* synthetic */ zzyl zzc;

    zzzg(zzyl zzyl, String str, zzacf zzacf) {
        this.zza = str;
        this.zzb = zzacf;
        this.zzc = zzyl;
    }

    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzafm zzafm = (zzafm) obj;
        this.zzc.zza.zza(new zzaez(zzafm.zzc()), (zzadm<zzafc>) new zzzj(this, this, zzafm));
    }
}
