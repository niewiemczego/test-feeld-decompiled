package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfa;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzew  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzew {
    private static final zzoe<zzet, zzbh> zza = zzoe.zza(zzez.zza, zzet.class, zzbh.class);
    private static final zznn<zzfa> zzb = zzey.zza;
    private static final zznp<zzfa> zzc = zzfb.zza;
    private static final zzbt<zzbh> zzd = zznd.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzbh.class, zzux.zzb.SYMMETRIC, zzsx.zze());

    public static void zza(boolean z) throws GeneralSecurityException {
        zzff.zza();
        if (zza()) {
            zzns.zza().zza(zza);
            zznt zza2 = zznt.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_GCM_SIV", zzfa.zzc().zza(16).zza(zzfa.zzb.zza).zza());
            hashMap.put("AES128_GCM_SIV_RAW", zzfa.zzc().zza(16).zza(zzfa.zzb.zzc).zza());
            hashMap.put("AES256_GCM_SIV", zzfa.zzc().zza(32).zza(zzfa.zzb.zza).zza());
            hashMap.put("AES256_GCM_SIV_RAW", zzfa.zzc().zza(32).zza(zzfa.zzb.zzc).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zznm.zza().zza(zzc, zzfa.class);
            zznk.zza().zza(zzb, zzfa.class);
            zzcu.zza(zzd, true);
        }
    }

    private static boolean zza() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}
