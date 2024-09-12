package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzqa implements zzcq<zzpx, zzpx> {
    private static final zzqa zza = new zzqa();

    public final Class<zzpx> zza() {
        return zzpx.class;
    }

    public final Class<zzpx> zzb() {
        return zzpx.class;
    }

    public final /* synthetic */ Object zza(zzch zzch) throws GeneralSecurityException {
        if (zzch == null) {
            throw new GeneralSecurityException("primitive set must be non-null");
        } else if (zzch.zza() != null) {
            for (List<zzcm> it : zzch.zzd()) {
                for (zzcm zze : it) {
                    zzpx zzpx = (zzpx) zze.zze();
                }
            }
            return new zzpz(zzch);
        } else {
            throw new GeneralSecurityException("no primary in primitive set");
        }
    }

    private zzqa() {
    }

    static void zzc() throws GeneralSecurityException {
        zzcu.zza(zza);
    }
}
