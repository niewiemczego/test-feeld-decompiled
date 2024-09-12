package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzqr implements zzcq<zzcf, zzcf> {
    private static final zzqr zza = new zzqr();
    private static final zzoe<zznc, zzcf> zzb = zzoe.zza(zzqu.zza, zznc.class, zzcf.class);

    public final Class<zzcf> zza() {
        return zzcf.class;
    }

    public final Class<zzcf> zzb() {
        return zzcf.class;
    }

    public final /* synthetic */ Object zza(zzch zzch) throws GeneralSecurityException {
        for (List it : zzch.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzcm zzcm = (zzcm) it2.next();
                    if (zzcm.zzb() instanceof zzqp) {
                        zzqp zzqp = (zzqp) zzcm.zzb();
                        zzxr zza2 = zzxr.zza(zzcm.zzh());
                        if (!zza2.equals(zzqp.zzd())) {
                            String valueOf = String.valueOf(zzqp.zzc());
                            String valueOf2 = String.valueOf(zzqp.zzd());
                            throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + valueOf2 + ") instead of (" + String.valueOf(zza2) + ")");
                        }
                    }
                }
            }
        }
        return new zzqt(zzch);
    }

    zzqr() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzcu.zza(zza);
        zzns.zza().zza(zzb);
    }
}
