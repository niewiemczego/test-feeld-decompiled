package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzwb implements zzbh {
    private static final zzic.zza zza = zzic.zza.ALGORITHM_NOT_FIPS;
    private static final ThreadLocal<Cipher> zzb = new zzwe();
    private static final ThreadLocal<Cipher> zzc = new zzwd();
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private final SecretKeySpec zzg;
    private final int zzh;

    public static zzbh zza(zzdv zzdv) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (zzdv.zzc().zzd() == 16) {
            return new zzwb(zzdv.zze().zza(zzbr.zza()), zzdv.zzc().zzb(), zzdv.zzd().zzb());
        } else {
            throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + zzdv.zzc().zzd());
        }
    }

    private zzwb(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i == 12 || i == 16) {
            this.zzh = i;
            zzxq.zza(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CipherStorageKeystoreAesCbc.ALGORITHM_AES);
            this.zzg = secretKeySpec;
            Cipher cipher = zzb.get();
            cipher.init(1, secretKeySpec);
            byte[] zza2 = zza(cipher.doFinal(new byte[16]));
            this.zzd = zza2;
            this.zze = zza(zza2);
            this.zzf = bArr2;
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzf;
        if (bArr3.length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzpg.zza(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, this.zzf.length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        int length = bArr3.length;
        int i = this.zzh;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr4 = new byte[(bArr3.length + i + 16)];
            byte[] zza2 = zzov.zza(i);
            System.arraycopy(zza2, 0, bArr4, 0, this.zzh);
            Cipher cipher = zzb.get();
            cipher.init(1, this.zzg);
            byte[] zza3 = zza(cipher, 0, zza2, 0, zza2.length);
            byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza4 = zza(cipher, 1, bArr5, 0, bArr5.length);
            Cipher cipher2 = zzc.get();
            cipher2.init(1, this.zzg, new IvParameterSpec(zza3));
            cipher2.doFinal(bArr, 0, bArr3.length, bArr4, this.zzh);
            byte[] zza5 = zza(cipher, 2, bArr4, this.zzh, bArr3.length);
            int length2 = bArr3.length + this.zzh;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr4[length2 + i2] = (byte) ((zza4[i2] ^ zza3[i2]) ^ zza5[i2]);
            }
            byte[] bArr6 = this.zzf;
            if (bArr6.length == 0) {
                return bArr4;
            }
            return zzwi.zza(bArr6, bArr4);
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    private static byte[] zza(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7));
            i = i2;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & TsExtractor.TS_STREAM_TYPE_E_AC3) ^ (bArr[15] << 1));
        return bArr2;
    }

    private final byte[] zza(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzd));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzd);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zze, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.zzh) - 16;
        if (length >= 0) {
            Cipher cipher = zzb.get();
            cipher.init(1, this.zzg);
            byte[] zza2 = zza(cipher, 0, bArr, 0, this.zzh);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] zza3 = zza(cipher, 1, bArr3, 0, bArr3.length);
            byte[] zza4 = zza(cipher, 2, bArr, this.zzh, length);
            int length2 = bArr.length - 16;
            byte b = 0;
            for (int i = 0; i < 16; i++) {
                b = (byte) (b | (((bArr[length2 + i] ^ zza3[i]) ^ zza2[i]) ^ zza4[i]));
            }
            if (b == 0) {
                Cipher cipher2 = zzc.get();
                cipher2.init(1, this.zzg, new IvParameterSpec(zza2));
                return cipher2.doFinal(bArr, this.zzh, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }
}
