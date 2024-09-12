package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzcl implements Comparable<zzcl> {
    private final byte[] zza;

    public final /* synthetic */ int compareTo(Object obj) {
        zzcl zzcl = (zzcl) obj;
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = zzcl.zza;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        int i = 0;
        while (true) {
            byte[] bArr3 = this.zza;
            if (i >= bArr3.length) {
                return 0;
            }
            byte b = bArr3[i];
            byte b2 = zzcl.zza[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzxh.zza(this.zza);
    }

    private zzcl(byte[] bArr) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcl)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzcl) obj).zza);
    }
}
