package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzxu {
    private final BigInteger zza;

    public static zzxu zza(BigInteger bigInteger, zzct zzct) {
        if (zzct != null) {
            return new zzxu(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzct zzct) {
        if (zzct != null) {
            return this.zza;
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    private zzxu(BigInteger bigInteger) {
        this.zza = bigInteger;
    }
}
