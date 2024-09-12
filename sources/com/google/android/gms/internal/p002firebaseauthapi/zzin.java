package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziq;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzin  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzin {
    private static final zzoe<zzij, zzbq> zza = zzoe.zza(zzim.zza, zzij.class, zzbq.class);
    private static final zzbt<zzbq> zzb = zznd.zza(zzis.zza, zzbq.class, zzux.zzb.SYMMETRIC, zztb.zze());
    private static final zznp<zziq> zzc = zzip.zza;
    private static final zznn<zziq> zzd = zzio.zza;

    static zzij zza(zziq zziq, @Nullable Integer num) throws GeneralSecurityException {
        zza(zziq);
        return zzij.zzb().zza(zziq).zza(num).zza(zzxt.zza(zziq.zzb())).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzjb.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES256_SIV", zziz.zza);
        hashMap.put("AES256_SIV_RAW", zziq.zzc().zza(64).zza(zziq.zzb.zzc).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznm.zza().zza(zzc, zziq.class);
        zznk.zza().zza(zzd, zziq.class);
        zzcu.zza(zzb, true);
    }

    /* access modifiers changed from: private */
    public static void zza(zziq zziq) throws GeneralSecurityException {
        if (zziq.zzb() != 64) {
            throw new InvalidAlgorithmParameterException("invalid key size: " + zziq.zzb() + ". Valid keys must have 64 bytes.");
        }
    }
}
