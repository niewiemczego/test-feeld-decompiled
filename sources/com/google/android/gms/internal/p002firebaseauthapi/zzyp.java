package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyp implements zzadm<zzafm> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzacf zzc;
    private final /* synthetic */ zzyl zzd;

    zzyp(zzyl zzyl, EmailAuthCredential emailAuthCredential, String str, zzacf zzacf) {
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzacf;
        this.zzd = zzyl;
    }

    public final void zza(String str) {
        this.zzc.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzd.zza(new zzaeo(this.zza, ((zzafm) obj).zzc(), this.zzb), this.zzc);
    }
}
