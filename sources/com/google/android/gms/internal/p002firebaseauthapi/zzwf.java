package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzwf implements zzbq {
    private static final zzic.zza zza = zzic.zza.ALGORITHM_NOT_FIPS;
    private static final Collection<Integer> zzb = Arrays.asList(new Integer[]{64});
    private static final byte[] zzc = new byte[16];
    private static final byte[] zzd = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private final zzxj zze;
    private final byte[] zzf;
    private final byte[] zzg;

    public static zzbq zza(zzij zzij) throws GeneralSecurityException {
        return new zzwf(zzij.zze().zza(zzbr.zza()), zzij.zzd());
    }

    private zzwf(byte[] bArr, zzxr zzxr) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        } else if (zzb.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.zzf = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.zze = new zzxj(copyOfRange);
            this.zzg = zzxr.zzb();
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        byte[] bArr4 = this.zzg;
        if (length < bArr4.length + 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        } else if (zzpg.zza(bArr4, bArr)) {
            Cipher zza2 = zzwr.zza.zza("AES/CTR/NoPadding");
            byte[] bArr5 = this.zzg;
            byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr5.length, bArr5.length + 16);
            byte[] bArr6 = (byte[]) copyOfRange.clone();
            bArr6[8] = (byte) (bArr6[8] & Byte.MAX_VALUE);
            bArr6[12] = (byte) (bArr6[12] & Byte.MAX_VALUE);
            zza2.init(2, new SecretKeySpec(this.zzf, CipherStorageKeystoreAesCbc.ALGORITHM_AES), new IvParameterSpec(bArr6));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzg.length + 16, bArr.length);
            byte[] doFinal = zza2.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && zzxn.zza()) {
                doFinal = new byte[0];
            }
            byte[][] bArr7 = {bArr2, doFinal};
            byte[] zza3 = this.zze.zza(zzc, 16);
            for (int i = 0; i <= 0; i++) {
                byte[] bArr8 = bArr7[i];
                if (bArr8 == null) {
                    bArr8 = new byte[0];
                }
                zza3 = zzwi.zza(zzrb.zzb(zza3), this.zze.zza(bArr8, 16));
            }
            byte[] bArr9 = bArr7[1];
            if (bArr9.length < 16) {
                bArr3 = zzwi.zza(zzrb.zza(bArr9), zzrb.zzb(zza3));
            } else if (bArr9.length >= zza3.length) {
                int length2 = bArr9.length - zza3.length;
                bArr3 = Arrays.copyOf(bArr9, bArr9.length);
                for (int i2 = 0; i2 < zza3.length; i2++) {
                    int i3 = length2 + i2;
                    bArr3[i3] = (byte) (bArr3[i3] ^ zza3[i2]);
                }
            } else {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            if (MessageDigest.isEqual(copyOfRange, this.zze.zza(bArr3, 16))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }
}
