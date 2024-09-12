package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zziw implements zzbq {
    private final zzch<zzbq> zza;
    private final zzrp zzb;
    private final zzrp zzc;

    public zziw(zzch<zzbq> zzch) {
        this.zza = zzch;
        if (zzch.zzf()) {
            zzrq zzb2 = zzno.zza().zzb();
            zzrs zza2 = zzng.zza(zzch);
            this.zzb = zzb2.zza(zza2, "daead", "encrypt");
            this.zzc = zzb2.zza(zza2, "daead", "decrypt");
            return;
        }
        this.zzb = zzng.zza;
        this.zzc = zzng.zza;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (zzcm next : this.zza.zza(copyOf)) {
                try {
                    byte[] zza2 = ((zzbq) next.zzf()).zza(copyOfRange, bArr2);
                    this.zzc.zza(next.zza(), (long) copyOfRange.length);
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcm next2 : this.zza.zze()) {
            try {
                byte[] zza3 = ((zzbq) next2.zzf()).zza(bArr, bArr2);
                this.zzc.zza(next2.zza(), (long) bArr.length);
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
