package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzlw implements zzli {
    private final zzxr zza;
    private final zzxr zzb;

    static zzlw zza(byte[] bArr) throws GeneralSecurityException {
        return new zzlw(bArr, zzxp.zza(bArr));
    }

    public final zzxr zza() {
        return this.zza;
    }

    public final zzxr zzb() {
        return this.zzb;
    }

    private zzlw(byte[] bArr, byte[] bArr2) {
        this.zza = zzxr.zza(bArr);
        this.zzb = zzxr.zza(bArr2);
    }
}
