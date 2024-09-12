package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzhn {
    private static final zzic.zza zza = zzic.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final ThreadLocal<Cipher> zzb = new zzhm();
    private final SecretKey zzc;
    private final boolean zzd;

    private static AlgorithmParameterSpec zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        Integer zzb2 = zzpg.zzb();
        if (zzb2 == null || zzb2.intValue() > 19) {
            return new GCMParameterSpec(128, bArr, 0, length);
        }
        return new IvParameterSpec(bArr, 0, length);
    }

    public zzhn(byte[] bArr, boolean z) throws GeneralSecurityException {
        if (zza.zza()) {
            zzxq.zza(bArr.length);
            this.zzc = new SecretKeySpec(bArr, CipherStorageKeystoreAesCbc.ALGORITHM_AES);
            this.zzd = z;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length == 12) {
            boolean z = this.zzd;
            if (bArr2.length >= (z ? 28 : 16)) {
                int i = 0;
                if (!z || ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
                    AlgorithmParameterSpec zza2 = zza(bArr);
                    ThreadLocal<Cipher> threadLocal = zzb;
                    threadLocal.get().init(2, this.zzc, zza2);
                    if (!(bArr3 == null || bArr3.length == 0)) {
                        threadLocal.get().updateAAD(bArr3);
                    }
                    boolean z2 = this.zzd;
                    if (z2) {
                        i = 12;
                    }
                    return threadLocal.get().doFinal(bArr2, i, z2 ? bArr2.length - 12 : bArr2.length);
                }
                throw new GeneralSecurityException("iv does not match prepended iv");
            }
            throw new GeneralSecurityException("ciphertext too short");
        }
        throw new GeneralSecurityException("iv is wrong size");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        int i;
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        } else if (bArr2.length <= 2147483619) {
            boolean z = this.zzd;
            if (z) {
                i = bArr2.length + 12;
            } else {
                i = bArr2.length;
            }
            byte[] bArr4 = new byte[(i + 16)];
            if (z) {
                System.arraycopy(bArr, 0, bArr4, 0, 12);
            }
            AlgorithmParameterSpec zza2 = zza(bArr);
            ThreadLocal<Cipher> threadLocal = zzb;
            threadLocal.get().init(1, this.zzc, zza2);
            if (!(bArr3 == null || bArr3.length == 0)) {
                threadLocal.get().updateAAD(bArr3);
            }
            int doFinal = threadLocal.get().doFinal(bArr2, 0, bArr2.length, bArr4, this.zzd ? 12 : 0);
            if (doFinal == bArr2.length + 16) {
                return bArr4;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - bArr2.length)}));
        } else {
            throw new GeneralSecurityException("plaintext too long");
        }
    }
}
