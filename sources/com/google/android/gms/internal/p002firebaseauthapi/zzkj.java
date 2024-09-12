package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdm;
import com.google.android.gms.internal.p002firebaseauthapi.zzer;
import com.google.android.gms.internal.p002firebaseauthapi.zzjl;
import com.google.android.gms.internal.p002firebaseauthapi.zzjx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzkj {
    private static final String zza = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    private static final String zzb = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    @Deprecated
    private static final zzvv zzc = zzvv.zzb();
    @Deprecated
    private static final zzvv zzd = zzvv.zzb();
    @Deprecated
    private static final zzvv zze = zzvv.zzb();

    static {
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzkm.zzc();
        zzko.zzc();
        zzcx.zza();
        zzis.zza();
        if (!zzic.zzb()) {
            zzcu.zza(new zzje(), new zzjj(), true);
            zzjq.zza();
            zznt zza2 = zznt.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zzb).zza(zzjl.zzd.zza).zza((zzci) zzer.zze().zza(12).zzb(16).zzc(16).zza(zzer.zzb.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zzb).zza(zzjl.zzd.zzc).zza((zzci) zzer.zze().zza(12).zzb(16).zzc(16).zza(zzer.zzb.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zza).zza(zzjl.zzd.zza).zza((zzci) zzer.zze().zza(12).zzb(16).zzc(16).zza(zzer.zzb.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zza).zza(zzjl.zzd.zzc).zza((zzci) zzer.zze().zza(12).zzb(16).zzc(16).zza(zzer.zzb.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zza).zza(zzjl.zzd.zzc).zza((zzci) zzer.zze().zza(12).zzb(16).zzc(16).zza(zzer.zzb.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zzb).zza(zzjl.zzd.zza).zza((zzci) zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zzb).zza(zzjl.zzd.zzc).zza((zzci) zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zza).zza(zzjl.zzd.zza).zza((zzci) zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjl.zzc().zza(zzjl.zzc.zza).zza(zzjl.zzb.zzc).zza(zzjl.zze.zza).zza(zzjl.zzd.zzc).zza((zzci) zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza()).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzcu.zza(new zzlk(), new zzlo(), true);
            zzkb.zza();
            zznt zza3 = zznt.zza();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zzd).zza(zzjx.zze.zza).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zzd).zza(zzjx.zze.zza).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zzd).zza(zzjx.zze.zza).zza(zzjx.zza.zzb).zza());
            hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zzd).zza(zzjx.zze.zza).zza(zzjx.zza.zzb).zza());
            hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zzd).zza(zzjx.zze.zza).zza(zzjx.zza.zzc).zza());
            hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zzd).zza(zzjx.zze.zza).zza(zzjx.zza.zzc).zza());
            hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zza).zza(zzjx.zze.zza).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zza).zza(zzjx.zze.zza).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zza).zza(zzjx.zze.zza).zza(zzjx.zza.zzb).zza());
            hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zza).zza(zzjx.zze.zza).zza(zzjx.zza.zzb).zza());
            hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zzb).zza(zzjx.zze.zzb).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zzb).zza(zzjx.zze.zzb).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zzb).zza(zzjx.zze.zzb).zza(zzjx.zza.zzb).zza());
            hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zzb).zza(zzjx.zze.zzb).zza(zzjx.zza.zzb).zza());
            hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zzc).zza(zzjx.zze.zzc).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zzc).zza(zzjx.zze.zzc).zza(zzjx.zza.zza).zza());
            hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzjx.zzc().zza(zzjx.zzf.zza).zza(zzjx.zzd.zzc).zza(zzjx.zze.zzc).zza(zzjx.zza.zzb).zza());
            hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzjx.zzc().zza(zzjx.zzf.zzc).zza(zzjx.zzd.zzc).zza(zzjx.zze.zzc).zza(zzjx.zza.zzb).zza());
            zza3.zza(Collections.unmodifiableMap(hashMap2));
        }
    }
}
