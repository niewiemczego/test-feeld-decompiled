package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzxt {
    private final zzxr zza;

    public final int zza() {
        return this.zza.zza();
    }

    public static zzxt zza(byte[] bArr, zzct zzct) {
        if (zzct != null) {
            return new zzxt(zzxr.zza(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public static zzxt zza(int i) {
        return new zzxt(zzxr.zza(zzov.zza(i)));
    }

    private zzxt(zzxr zzxr) {
        this.zza = zzxr;
    }

    public final byte[] zza(zzct zzct) {
        if (zzct != null) {
            return this.zza.zzb();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
