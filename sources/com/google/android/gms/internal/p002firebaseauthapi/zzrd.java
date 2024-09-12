package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzrd implements zzpx {
    private static final zzic.zza zza = zzic.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final zzqb zzb;

    public zzrd(zzqb zzqb) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = zzqb;
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
