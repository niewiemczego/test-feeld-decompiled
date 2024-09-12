package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzer;
import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzeo {
    private static final zzoe<zzek, zzbh> zza = zzoe.zza(zzen.zza, zzek.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza(zzcx.zzb, zzbh.class, zzux.zzb.SYMMETRIC, zzst.zze());
    private static final zznp<zzer> zzc = zzeq.zza;
    private static final zznn<zzer> zzd = zzep.zza;

    static String zza() {
        return zzcx.zzb;
    }

    public static /* synthetic */ zzek zza(zzer zzer, Integer num) {
        if (zzer.zzc() != 24) {
            return zzek.zzb().zza(zzer).zza(num).zza(zzxt.zza(zzer.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzhf.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzgr.zza);
        hashMap.put("AES128_GCM_RAW", zzer.zze().zza(12).zzb(16).zzc(16).zza(zzer.zzb.zzc).zza());
        hashMap.put("AES256_GCM", zzgr.zzb);
        hashMap.put("AES256_GCM_RAW", zzer.zze().zza(12).zzb(32).zzc(16).zza(zzer.zzb.zzc).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznm.zza().zza(zzc, zzer.class);
        zznk.zza().zza(zzd, zzer.class);
        zzmn.zza().zza(zzb, zzic.zza.ALGORITHM_REQUIRES_BORINGCRYPTO, true);
    }
}
