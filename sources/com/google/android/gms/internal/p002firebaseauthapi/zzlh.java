package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzlh {
    public static zzla zza(zzus zzus) throws GeneralSecurityException {
        if (zzus.zza() == zzuj.AES_128_GCM) {
            return new zzkv(16);
        }
        if (zzus.zza() == zzuj.AES_256_GCM) {
            return new zzkv(32);
        }
        if (zzus.zza() == zzuj.CHACHA20_POLY1305) {
            return new zzky();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzld zzb(zzus zzus) {
        if (zzus.zzb() == zzuk.HKDF_SHA256) {
            return new zzkx("HmacSha256");
        }
        if (zzus.zzb() == zzuk.HKDF_SHA384) {
            return new zzkx("HmacSha384");
        }
        if (zzus.zzb() == zzuk.HKDF_SHA512) {
            return new zzkx("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static zzlg zzc(zzus zzus) throws GeneralSecurityException {
        if (zzus.zzc() == zzum.DHKEM_X25519_HKDF_SHA256) {
            return new zzlt(new zzkx("HmacSha256"));
        }
        if (zzus.zzc() == zzum.DHKEM_P256_HKDF_SHA256) {
            return zzls.zza(zzwq.NIST_P256);
        }
        if (zzus.zzc() == zzum.DHKEM_P384_HKDF_SHA384) {
            return zzls.zza(zzwq.NIST_P384);
        }
        if (zzus.zzc() == zzum.DHKEM_P521_HKDF_SHA512) {
            return zzls.zza(zzwq.NIST_P521);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }
}
