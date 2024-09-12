package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
abstract class zzamn {
    zzamn() {
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(int i, byte[] bArr, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract int zza(String str, byte[] bArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract String zza(byte[] bArr, int i, int i2) throws zzajj;

    /* access modifiers changed from: package-private */
    public final boolean zzb(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
