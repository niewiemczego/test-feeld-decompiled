package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzct  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzct {
    private static final zzct zza = new zzct();

    static zzct zza() {
        return zza;
    }

    public static zzct zza(@Nullable zzct zzct) throws GeneralSecurityException {
        if (zzct != null) {
            return zzct;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }

    private zzct() {
    }
}
