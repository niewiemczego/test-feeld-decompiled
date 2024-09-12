package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzkl implements zzbp {
    private final zzch<zzbp> zza;
    private final zzrp zzb;

    public zzkl(zzch<zzbp> zzch) {
        this.zza = zzch;
        if (zzch.zzf()) {
            this.zzb = zzno.zza().zzb().zza(zzng.zza(zzch), "hybrid_decrypt", "decrypt");
        } else {
            this.zzb = zzng.zza;
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, bArr.length);
            for (zzcm next : this.zza.zza(copyOfRange)) {
                try {
                    byte[] zza2 = ((zzbp) next.zzf()).zza(copyOfRange2, bArr2);
                    this.zzb.zza(next.zza(), (long) copyOfRange2.length);
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzcm next2 : this.zza.zze()) {
            try {
                byte[] zza3 = ((zzbp) next2.zzf()).zza(bArr, bArr2);
                this.zzb.zza(next2.zza(), (long) bArr.length);
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
