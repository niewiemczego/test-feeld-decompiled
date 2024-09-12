package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyy implements zzadm<zzaha> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    zzyy(zzyl zzyl, zzacf zzacf) {
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaha zzaha = (zzaha) obj;
        this.zzb.zza(new zzafm(zzaha.zzd(), zzaha.zzb(), Long.valueOf(zzaha.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzaha.zzf()), (zzd) null, this.zza, this);
    }
}
