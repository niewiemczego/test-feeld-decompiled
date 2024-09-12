package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdm;
import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzdj {
    private static final zzoe<zzdf, zzbh> zza = zzoe.zza(zzdi.zza, zzdf.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza(zzcx.zza, zzbh.class, zzux.zzb.SYMMETRIC, zzsd.zzf());
    private static final zznp<zzdm> zzc = zzdl.zza;
    private static final zznn<zzdm> zzd = zzdk.zza;

    static String zza() {
        return zzcx.zza;
    }

    static zzdf zza(zzdm zzdm, @Nullable Integer num) throws GeneralSecurityException {
        if (zzdm.zzb() == 16 || zzdm.zzb() == 32) {
            return zzdf.zzb().zza(zzdm).zza(num).zza(zzxt.zza(zzdm.zzb())).zzb(zzxt.zza(zzdm.zzc())).zza();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzdq.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzgr.zze);
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza());
        hashMap.put("AES256_CTR_HMAC_SHA256", zzgr.zzf);
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdm.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzdm.zzb.zzc).zza(zzdm.zzc.zzc).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznm.zza().zza(zzc, zzdm.class);
        zznk.zza().zza(zzd, zzdm.class);
        zzmn.zza().zza(zzb, zzic.zza.ALGORITHM_REQUIRES_BORINGCRYPTO, true);
    }
}
