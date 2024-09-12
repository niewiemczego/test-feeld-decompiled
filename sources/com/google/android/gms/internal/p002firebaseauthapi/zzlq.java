package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzlq {
    public static final byte[] zza = zza(1, 0);
    public static final byte[] zzb = zza(2, 32);
    public static final byte[] zzc = zza(2, 16);
    public static final byte[] zzd = zza(2, 17);
    public static final byte[] zze = zza(2, 18);
    public static final byte[] zzf = zza(2, 1);
    public static final byte[] zzg = zza(2, 2);
    public static final byte[] zzh = zza(2, 3);
    public static final byte[] zzi = zza(2, 1);
    public static final byte[] zzj = zza(2, 2);
    public static final byte[] zzk = zza(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm = zza(1, 2);
    private static final byte[] zzn = "KEM".getBytes(zzpg.zza);
    private static final byte[] zzo = "HPKE".getBytes(zzpg.zza);
    private static final byte[] zzp = "HPKE-v1".getBytes(zzpg.zza);

    public static int zza(zzum zzum) throws GeneralSecurityException {
        int i = zzlp.zza[zzum.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 48;
        }
        if (i == 3) {
            return 66;
        }
        if (i == 4) {
            return 32;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    public static int zzb(zzum zzum) throws GeneralSecurityException {
        int i = zzlp.zza[zzum.ordinal()];
        if (i == 1) {
            return 65;
        }
        if (i == 2) {
            return 97;
        }
        if (i == 3) {
            return 133;
        }
        if (i == 4) {
            return 32;
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }

    static zzwq zzc(zzum zzum) throws GeneralSecurityException {
        int i = zzlp.zza[zzum.ordinal()];
        if (i == 1) {
            return zzwq.NIST_P256;
        }
        if (i == 2) {
            return zzwq.NIST_P384;
        }
        if (i == 3) {
            return zzwq.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    static void zza(zzus zzus) throws GeneralSecurityException {
        if (zzus.zzc() == zzum.KEM_UNKNOWN || zzus.zzc() == zzum.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KEM param: " + zzus.zzc().name());
        } else if (zzus.zzb() == zzuk.KDF_UNKNOWN || zzus.zzb() == zzuk.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KDF param: " + zzus.zzb().name());
        } else if (zzus.zza() == zzuj.AEAD_UNKNOWN || zzus.zza() == zzuj.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid AEAD param: " + zzus.zza().name());
        }
    }

    static byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzwi.zza(zzo, bArr, bArr2, bArr3);
    }

    private static byte[] zza(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) (i2 >> (((i - i3) - 1) * 8));
        }
        return bArr;
    }

    static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        return zzwi.zza(zzn, bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzwi.zza(zzp, bArr2, str.getBytes(zzpg.zza), bArr);
    }

    static byte[] zza(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzwi.zza(zza(2, i), zzp, bArr2, str.getBytes(zzpg.zza), bArr);
    }
}
