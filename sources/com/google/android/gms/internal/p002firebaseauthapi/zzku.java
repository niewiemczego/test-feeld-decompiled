package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzku  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzku {
    public static zzwq zza(zztx zztx) throws GeneralSecurityException {
        int i = zzkt.zzb[zztx.ordinal()];
        if (i == 1) {
            return zzwq.NIST_P256;
        }
        if (i == 2) {
            return zzwq.NIST_P384;
        }
        if (i == 3) {
            return zzwq.NIST_P521;
        }
        throw new GeneralSecurityException("unknown curve type: " + String.valueOf(zztx));
    }

    public static zzwp zza(zztj zztj) throws GeneralSecurityException {
        int i = zzkt.zzc[zztj.ordinal()];
        if (i == 1) {
            return zzwp.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzwp.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzwp.COMPRESSED;
        }
        throw new GeneralSecurityException("unknown point format: " + String.valueOf(zztj));
    }

    public static String zza(zzuc zzuc) throws NoSuchAlgorithmException {
        int i = zzkt.zza[zzuc.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha224";
        }
        if (i == 3) {
            return "HmacSha256";
        }
        if (i == 4) {
            return "HmacSha384";
        }
        if (i == 5) {
            return "HmacSha512";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + String.valueOf(zzuc));
    }

    public static void zza(zztp zztp) throws GeneralSecurityException {
        zzwn.zza(zza(zztp.zzf().zzd()));
        zza(zztp.zzf().zze());
        if (zztp.zza() != zztj.UNKNOWN_FORMAT) {
            zzcu.zza(zztp.zzb().zzd());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }
}
