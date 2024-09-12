package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzahq extends zzahw {
    private final int zzc;
    private final int zzd;

    public final byte zza(int i) {
        int zzb = zzb();
        if (((zzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + zzb);
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    /* access modifiers changed from: protected */
    public final int zzh() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzd;
    }

    zzahq(byte[] bArr, int i, int i2) {
        super(bArr);
        zza(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    /* access modifiers changed from: protected */
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, zzh(), bArr, 0, i3);
    }
}
