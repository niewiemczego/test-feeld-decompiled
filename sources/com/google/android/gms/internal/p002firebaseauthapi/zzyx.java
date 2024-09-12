package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyx implements zzadm<zzagw> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    zzyx(zzyl zzyl, zzacf zzacf) {
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagw zzagw = (zzagw) obj;
        this.zzb.zza(new zzafm(zzagw.zzc(), zzagw.zzb(), Long.valueOf(zzagw.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzagw.zzd()), (zzd) null, this.zza, this);
    }
}
