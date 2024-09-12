package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzea;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzdz {
    private static final zzoe<zzdv, zzbh> zza = zzoe.zza(zzdy.zza, zzdv.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", zzbh.class, zzux.zzb.SYMMETRIC, zzso.zzf());
    private static final zznn<zzea> zzc = zzeb.zza;

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public static /* synthetic */ zzdv zza(zzea zzea, Integer num) {
        if (zzea.zzc() != 24) {
            return zzdv.zzb().zza(zzea).zza(num).zza(zzxt.zza(zzea.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzef.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzgr.zzc);
        hashMap.put("AES128_EAX_RAW", zzea.zze().zza(16).zzb(16).zzc(16).zza(zzea.zzb.zzc).zza());
        hashMap.put("AES256_EAX", zzgr.zzd);
        hashMap.put("AES256_EAX_RAW", zzea.zze().zza(16).zzb(32).zzc(16).zza(zzea.zzb.zzc).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznk.zza().zza(zzc, zzea.class);
        zzcu.zza(zzb, true);
    }
}
