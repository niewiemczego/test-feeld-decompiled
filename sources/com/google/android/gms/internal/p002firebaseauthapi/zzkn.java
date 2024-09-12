package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzkn implements zzbs {
    private final zzch<zzbs> zza;
    private final zzrp zzb;

    public zzkn(zzch<zzbs> zzch) {
        this.zza = zzch;
        if (zzch.zzf()) {
            this.zzb = zzno.zza().zzb().zza(zzng.zza(zzch), "hybrid_encrypt", "encrypt");
        } else {
            this.zzb = zzng.zza;
        }
    }
}
