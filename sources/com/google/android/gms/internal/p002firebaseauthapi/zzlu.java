package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzlu implements zzli {
    private final zzxr zza;
    private final zzxr zzb;

    static zzlu zza(byte[] bArr, byte[] bArr2, zzwq zzwq) throws GeneralSecurityException {
        zzwn.zza(zzwn.zza(zzwq, zzwp.UNCOMPRESSED, bArr2), zzwn.zza(zzwq, bArr));
        return new zzlu(bArr, bArr2);
    }

    public final zzxr zza() {
        return this.zza;
    }

    public final zzxr zzb() {
        return this.zzb;
    }

    private zzlu(byte[] bArr, byte[] bArr2) {
        this.zza = zzxr.zza(bArr);
        this.zzb = zzxr.zza(bArr2);
    }
}
