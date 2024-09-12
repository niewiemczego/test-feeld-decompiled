package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzde  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzde implements zzbh {
    private final zzch<zzbh> zza;
    private final zzrp zzb;
    private final zzrp zzc;

    private zzde(zzch<zzbh> zzch) {
        this.zza = zzch;
        if (zzch.zzf()) {
            zzrq zzb2 = zzno.zza().zzb();
            zzrs zza2 = zzng.zza(zzch);
            this.zzb = zzb2.zza(zza2, "aead", "encrypt");
            this.zzc = zzb2.zza(zza2, "aead", "decrypt");
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
                    byte[] zza2 = ((zzbh) next.zzf()).zza(copyOfRange, bArr2);
                    this.zzc.zza(next.zza(), (long) copyOfRange.length);
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcm next2 : this.zza.zze()) {
            try {
                byte[] zza3 = ((zzbh) next2.zzf()).zza(bArr, bArr2);
                this.zzc.zza(next2.zza(), (long) bArr.length);
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzc.zza();
        throw new GeneralSecurityException("decryption failed");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zza2 = zzwi.zza(this.zza.zza().zzh(), this.zza.zza().zzf().zzb(bArr, bArr2));
            this.zzb.zza(this.zza.zza().zza(), (long) bArr.length);
            return zza2;
        } catch (GeneralSecurityException e) {
            this.zzb.zza();
            throw e;
        }
    }
}
