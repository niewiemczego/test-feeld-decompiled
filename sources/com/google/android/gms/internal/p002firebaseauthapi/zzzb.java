package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzb implements zzadm<zzafm> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzacf zze;
    private final /* synthetic */ zzyl zzf;

    zzzb(zzyl zzyl, String str, String str2, String str3, String str4, zzacf zzacf) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzacf;
        this.zzf = zzyl;
    }

    public final void zza(String str) {
        this.zze.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzyl.zza(this.zzf, this.zze, new zzagd(this.zza, this.zzb, (String) null, this.zzc, this.zzd, ((zzafm) obj).zzc()), (zzadj) this);
    }
}
