package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzk implements zzadm<zzagu> {
    private final /* synthetic */ zzacf zza;
    private final /* synthetic */ zzyl zzb;

    zzzk(zzyl zzyl, zzacf zzacf) {
        this.zza = zzacf;
        this.zzb = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagu zzagu = (zzagu) obj;
        if (!zzagu.zzl()) {
            zzyl.zza(this.zzb, zzagu, this.zza, (zzadj) this);
        } else {
            this.zza.zza(new zzyi(zzagu.zzf(), zzagu.zzk(), zzagu.zzb()));
        }
    }
}
