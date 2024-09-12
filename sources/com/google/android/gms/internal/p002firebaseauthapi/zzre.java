package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzre  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzre implements zzpx {
    private static final zzic.zza zza = zzic.zza.ALGORITHM_NOT_FIPS;
    private final zzpi zzb;

    public zzre(zzpi zzpi) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = zzpi;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }
}
