package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzhd;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzgz {
    private static final zzoe<zzha, zzbh> zza = zzoe.zza(zzhc.zza, zzha.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzbh.class, zzux.zzb.SYMMETRIC, zzvw.zze());
    private static final zznp<zzhd> zzc = zzhb.zza;
    private static final zznn<zzhd> zzd = zzhe.zza;

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    static zzha zza(zzhd zzhd, @Nullable Integer num) throws GeneralSecurityException {
        return zzha.zza(zzhd.zzb(), zzxt.zza(32), num);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzhu.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", zzhd.zza(zzhd.zza.zza));
        hashMap.put("XCHACHA20_POLY1305_RAW", zzhd.zza(zzhd.zza.zzc));
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznk.zza().zza(zzd, zzhd.class);
        zznm.zza().zza(zzc, zzhd.class);
        zzcu.zza(zzb, true);
    }
}
