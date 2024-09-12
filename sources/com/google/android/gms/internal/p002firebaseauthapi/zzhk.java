package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzhk {
    private static final int[] zza = zza(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    private static int zza(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private static void zza(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int zza2 = zza(i5 ^ iArr[i4], 16);
        iArr[i4] = zza2;
        int i6 = iArr[i3] + zza2;
        iArr[i3] = i6;
        int zza3 = zza(iArr[i2] ^ i6, 12);
        iArr[i2] = zza3;
        int i7 = iArr[i] + zza3;
        iArr[i] = i7;
        int zza4 = zza(iArr[i4] ^ i7, 8);
        iArr[i4] = zza4;
        int i8 = iArr[i3] + zza4;
        iArr[i3] = i8;
        iArr[i2] = zza(iArr[i2] ^ i8, 7);
    }

    static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zza;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    static void zza(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            zza(iArr2, 0, 4, 8, 12);
            zza(iArr2, 1, 5, 9, 13);
            zza(iArr2, 2, 6, 10, 14);
            zza(iArr2, 3, 7, 11, 15);
            zza(iArr2, 0, 5, 10, 15);
            zza(iArr2, 1, 6, 11, 12);
            zza(iArr2, 2, 7, 8, 13);
            zza(iArr2, 3, 4, 9, 14);
        }
    }

    static int[] zza(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
