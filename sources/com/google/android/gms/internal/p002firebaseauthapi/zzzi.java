package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzi implements zzadm<zzafm> {
    final /* synthetic */ zzacf zza;
    final /* synthetic */ zzyl zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;

    zzzi(zzyl zzyl, String str, String str2, zzacf zzacf) {
        this.zzc = str;
        this.zzd = str2;
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zza.zza(new zzagz(((zzafm) obj).zzc(), this.zzc, this.zzd), (zzadm<zzahc>) new zzzl(this));
    }
}
