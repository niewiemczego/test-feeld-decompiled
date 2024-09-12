package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzxj implements zzrv {
    private static final zzic.zza zza = zzic.zza.ALGORITHM_NOT_FIPS;
    private final SecretKey zzb;
    private byte[] zzc;
    private byte[] zzd;

    private static Cipher zza() throws GeneralSecurityException {
        if (zza.zza()) {
            return zzwr.zza.zza("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public zzxj(byte[] bArr) throws GeneralSecurityException {
        zzxq.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CipherStorageKeystoreAesCbc.ALGORITHM_AES);
        this.zzb = secretKeySpec;
        Cipher zza2 = zza();
        zza2.init(1, secretKeySpec);
        byte[] zzb2 = zzrb.zzb(zza2.doFinal(new byte[16]));
        this.zzc = zzb2;
        this.zzd = zzrb.zzb(zzb2);
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher zza2 = zza();
            zza2.init(1, this.zzb);
            int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
            if ((max << 4) == bArr.length) {
                bArr2 = zzwi.zza(bArr, (max - 1) << 4, this.zzc, 0, 16);
            } else {
                bArr2 = zzwi.zza(zzrb.zza(Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length)), this.zzd);
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = zza2.doFinal(zzwi.zza(bArr3, 0, bArr, i2 << 4, 16));
            }
            return Arrays.copyOf(zza2.doFinal(zzwi.zza(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
