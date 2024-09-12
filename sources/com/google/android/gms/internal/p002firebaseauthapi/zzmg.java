package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzmg {
    static final zzmg zza = new zzmg(BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
    BigInteger zzb;
    BigInteger zzc;
    BigInteger zzd;

    zzmg(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zzb = bigInteger;
        this.zzc = bigInteger2;
        this.zzd = bigInteger3;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zzd.equals(BigInteger.ZERO);
    }
}
