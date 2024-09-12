package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzng  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzng {
    public static final zzrp zza = new zzni();

    public static <P> zzrs zza(zzch<P> zzch) {
        zzbw zzbw;
        zzrr zzrr = new zzrr();
        zzrr.zza(zzch.zzb());
        for (List<zzcm<P>> it : zzch.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzcm zzcm = (zzcm) it2.next();
                    int i = zznj.zza[zzcm.zzc().ordinal()];
                    if (i == 1) {
                        zzbw = zzbw.zza;
                    } else if (i == 2) {
                        zzbw = zzbw.zzb;
                    } else if (i == 3) {
                        zzbw = zzbw.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzcm.zza();
                    String zzg = zzcm.zzg();
                    if (zzg.startsWith("type.googleapis.com/google.crypto.")) {
                        zzg = zzg.substring(34);
                    }
                    zzrr.zza(zzbw, zza2, zzg, zzcm.zzd().name());
                }
            }
        }
        if (zzch.zza() != null) {
            zzrr.zza(zzch.zza().zza());
        }
        try {
            return zzrr.zza();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
