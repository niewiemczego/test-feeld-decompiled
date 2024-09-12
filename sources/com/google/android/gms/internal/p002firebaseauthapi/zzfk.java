package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfo;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzfk {
    private static final zzoe<zzfl, zzbh> zza = zzoe.zza(zzfn.zza, zzfl.class, zzbh.class);
    private static final zznn<zzfo> zzb = zzfm.zza;
    private static final zzbt<zzbh> zzc = zznd.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzbh.class, zzux.zzb.SYMMETRIC, zztf.zze());

    static String zza() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    static zzfl zza(zzfo zzfo, @Nullable Integer num) throws GeneralSecurityException {
        return zzfl.zza(zzfo.zzb(), zzxt.zza(32), num);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzfq.zza();
        zzns.zza().zza(zza);
        zznk.zza().zza(zzb, zzfo.class);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", zzfo.zza(zzfo.zza.zza));
        hashMap.put("CHACHA20_POLY1305_RAW", zzfo.zza(zzfo.zza.zzc));
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzcu.zza(zzc, true);
    }
}
