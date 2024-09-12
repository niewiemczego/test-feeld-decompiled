package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzwg implements zzbh {
    private static final zzic.zza zza = zzic.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final zzhn zzb;
    private final byte[] zzc;

    public static zzbh zza(zzek zzek) throws GeneralSecurityException {
        if (zzek.zzc().zzb() != 12) {
            throw new GeneralSecurityException("Expected IV Size 12, got " + zzek.zzc().zzb());
        } else if (zzek.zzc().zzd() == 16) {
            return new zzwg(zzek.zze().zza(zzbr.zza()), zzek.zzd());
        } else {
            throw new GeneralSecurityException("Expected tag Size 16, got " + zzek.zzc().zzd());
        }
    }

    private zzwg(byte[] bArr, zzxr zzxr) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = new zzhn(bArr, true);
            this.zzc = zzxr.zzb();
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzc;
        if (bArr3.length == 0) {
            return this.zzb.zza(Arrays.copyOf(bArr, 12), bArr, bArr2);
        } else if (zzpg.zza(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzc.length, bArr.length);
            return this.zzb.zza(Arrays.copyOf(copyOfRange, 12), copyOfRange, bArr2);
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zza2 = zzov.zza(12);
        byte[] bArr3 = this.zzc;
        if (bArr3.length == 0) {
            return this.zzb.zzb(zza2, bArr, bArr2);
        }
        return zzwi.zza(bArr3, this.zzb.zzb(zza2, bArr, bArr2));
    }
}
