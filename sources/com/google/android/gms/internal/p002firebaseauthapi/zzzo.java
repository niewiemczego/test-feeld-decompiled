package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzo implements zzadm<zzaer> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    zzzo(zzyl zzyl, zzacf zzacf) {
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaer zzaer = (zzaer) obj;
        this.zzb.zza(new zzafm(zzaer.zzb(), zzaer.zza(), Long.valueOf(zzafo.zza(zzaer.zza())), "Bearer"), (String) null, (String) null, false, (zzd) null, this.zza, this);
    }
}
