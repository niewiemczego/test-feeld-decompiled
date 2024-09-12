package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzqt implements zzcf {
    private final zzch<zzcf> zza;
    private final zzrp zzb;
    private final zzrp zzc;

    private zzqt(zzch<zzcf> zzch) {
        this.zza = zzch;
        if (zzch.zzf()) {
            zzrq zzb2 = zzno.zza().zzb();
            zzrs zza2 = zzng.zza(zzch);
            this.zzb = zzb2.zza(zza2, "mac", "compute");
            this.zzc = zzb2.zza(zza2, "mac", "verify");
            return;
        }
        this.zzb = zzng.zza;
        this.zzc = zzng.zza;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzcm next : this.zza.zza(Arrays.copyOf(bArr, 5))) {
                try {
                    ((zzcf) next.zze()).zza(bArr, bArr2);
                    this.zzc.zza(next.zza(), (long) bArr2.length);
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            for (zzcm next2 : this.zza.zze()) {
                try {
                    ((zzcf) next2.zze()).zza(bArr, bArr2);
                    this.zzc.zza(next2.zza(), (long) bArr2.length);
                    return;
                } catch (GeneralSecurityException unused2) {
                }
            }
            this.zzc.zza();
            throw new GeneralSecurityException("invalid MAC");
        }
        this.zzc.zza();
        throw new GeneralSecurityException("tag too short");
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        try {
            byte[] zza2 = this.zza.zza().zze().zza(bArr);
            this.zzb.zza(this.zza.zza().zza(), (long) bArr.length);
            return zza2;
        } catch (GeneralSecurityException e) {
            this.zzb.zza();
            throw e;
        }
    }
}
