package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzp implements zzadm<zzaep> {
    private final /* synthetic */ zzzm zza;

    zzzp(zzzm zzzm) {
        this.zza = zzzm;
    }

    public final void zza(String str) {
        this.zza.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaep zzaep = (zzaep) obj;
        this.zza.zzb.zza(new zzafm(zzaep.zzb(), zzaep.zza(), Long.valueOf(zzafo.zza(zzaep.zza())), "Bearer"), (String) null, (String) null, false, (zzd) null, this.zza.zza, this);
    }
}
