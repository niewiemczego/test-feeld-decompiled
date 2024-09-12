package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzpp;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzpm {
    private static final zznn<zzpp> zza = zzpl.zza;
    private static final zzoe<zzpi, zzpx> zzb = zzoe.zza(zzpo.zza, zzpi.class, zzpx.class);
    private static final zzoe<zzpi, zzcf> zzc = zzoe.zza(zzpn.zza, zzpi.class, zzcf.class);
    private static final zzbt<zzcf> zzd = zznd.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", zzcf.class, zzux.zzb.SYMMETRIC, zzry.zzf());

    public static void zza(boolean z) throws GeneralSecurityException {
        zzpr.zza();
        zznk.zza().zza(zza, zzpp.class);
        zzns.zza().zza(zzb);
        zzns.zza().zza(zzc);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES_CMAC", zzqv.zzc);
        hashMap.put("AES256_CMAC", zzqv.zzc);
        hashMap.put("AES256_CMAC_RAW", zzpp.zzd().zza(32).zzb(16).zza(zzpp.zzb.zzd).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzcu.zza(zzd, true);
    }

    /* access modifiers changed from: private */
    public static void zza(zzpp zzpp) throws GeneralSecurityException {
        if (zzpp.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
