package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzlv {
    private final zzbh zza;
    private final zzbq zzb;

    public zzlv(zzbh zzbh) {
        this.zza = zzbh;
        this.zzb = null;
    }

    public zzlv(zzbq zzbq) {
        this.zza = null;
        this.zzb = zzbq;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzbh zzbh = this.zza;
        if (zzbh != null) {
            return zzbh.zza(bArr, bArr2);
        }
        return this.zzb.zza(bArr, bArr2);
    }
}
