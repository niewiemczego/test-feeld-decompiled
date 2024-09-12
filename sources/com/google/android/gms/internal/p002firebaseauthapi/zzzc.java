package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zzd;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzc implements zzadm<zzaha> {
    private final /* synthetic */ zzadm zza;
    private final /* synthetic */ zzzd zzb;

    zzzc(zzzd zzzd, zzadm zzadm) {
        this.zza = zzadm;
        this.zzb = zzzd;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaha zzaha = (zzaha) obj;
        if (!TextUtils.isEmpty(zzaha.zze())) {
            this.zzb.zza.zza(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzb(zzaha.zzc(), zzaha.zze()));
            return;
        }
        this.zzb.zzb.zza(new zzafm(zzaha.zzd(), zzaha.zzb(), Long.valueOf(zzaha.zza()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzaha.zzf()), (zzd) null, this.zzb.zza, this.zza);
    }
}
