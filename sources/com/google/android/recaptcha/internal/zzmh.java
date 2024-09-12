package com.google.android.recaptcha.internal;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzmh {
    protected static final Charset zza = StandardCharsets.UTF_16;

    protected static int zza(int i, int i2) {
        if (i % 2 != 0) {
            return (i | i2) - (i & i2);
        }
        return ((~i) & i2) | ((~i2) & i);
    }

    public static String zzb(String str, byte[] bArr, zzmi zzmi) {
        byte[] bArr2 = bArr;
        int i = 0;
        byte[] decode = Base64.decode(str, 0);
        char c = 12;
        byte[] bArr3 = new byte[12];
        int length = decode.length - 12;
        byte[] bArr4 = new byte[length];
        System.arraycopy(decode, 0, bArr3, 0, 12);
        System.arraycopy(decode, 12, bArr4, 0, length);
        int[] iArr = {511133343, 1277647508, 107287496, 338123662};
        if (bArr2.length == 32) {
            int i2 = 16;
            int[] iArr2 = new int[16];
            for (int i3 = 0; i3 < 4; i3++) {
                iArr2[i3] = zza(iArr[i3], 2131181306);
            }
            for (int i4 = 4; i4 < 12; i4++) {
                iArr2[i4] = zze(bArr2, (i4 - 4) * 4);
            }
            iArr2[12] = 1;
            for (int i5 = 13; i5 < 16; i5++) {
                iArr2[i5] = zze(bArr3, (i5 - 13) * 4);
            }
            int[] iArr3 = new int[16];
            System.arraycopy(iArr2, 0, iArr3, 0, 16);
            byte[] bArr5 = new byte[length];
            int i6 = length;
            int i7 = 1;
            int i8 = 0;
            while (i6 > 0) {
                System.arraycopy(iArr3, i, iArr2, i, i2);
                iArr2[c] = i7;
                int i9 = i;
                while (i9 < 10) {
                    int i10 = i9;
                    int[] iArr4 = iArr;
                    int i11 = i6;
                    byte[] bArr6 = bArr;
                    byte[] bArr7 = bArr5;
                    byte[] bArr8 = bArr3;
                    int[] iArr5 = iArr3;
                    int i12 = i7;
                    int[] iArr6 = iArr2;
                    int i13 = i2;
                    int[] iArr7 = iArr5;
                    zzc(0, 4, 8, 12, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    zzc(1, 5, 9, 13, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    zzc(2, 6, 10, 14, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    zzc(3, 7, 11, 15, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    zzc(0, 5, 10, 15, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    zzc(1, 6, 11, 12, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    zzc(2, 7, 8, 13, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    zzc(3, 4, 9, 14, iArr4, bArr6, bArr8, i12, iArr2, iArr7);
                    i9 = i10 + 1;
                    i2 = i13;
                    i6 = i11;
                    bArr5 = bArr7;
                    iArr3 = iArr5;
                    byte[] bArr9 = bArr;
                }
                int i14 = i6;
                byte[] bArr10 = bArr5;
                int[] iArr8 = iArr3;
                int[] iArr9 = iArr2;
                int i15 = i2;
                byte[] bArr11 = new byte[64];
                for (int i16 = 0; i16 < i15; i16++) {
                    int i17 = iArr9[i16];
                    int i18 = i16 * 4;
                    bArr11[i18] = (byte) (i17 & 255);
                    bArr11[i18 + 1] = (byte) ((i17 >> 8) & 255);
                    bArr11[i18 + 2] = (byte) ((i17 >> 16) & 255);
                    bArr11[i18 + 3] = (byte) ((i17 >> 24) & 255);
                }
                for (int i19 = 0; i19 < Math.min(64, i14); i19++) {
                    int i20 = i8 + i19;
                    bArr10[i20] = (byte) zza(bArr11[i19], bArr4[i20]);
                }
                i7++;
                i6 = i14 - 64;
                i8 += 64;
                i2 = i15;
                bArr5 = bArr10;
                iArr3 = iArr8;
                iArr2 = iArr9;
                i = 0;
                c = 12;
                byte[] bArr12 = bArr;
            }
            return new String(bArr5, zza);
        }
        throw new IllegalArgumentException();
    }

    protected static final void zzc(int i, int i2, int i3, int i4, int[] iArr, byte[] bArr, byte[] bArr2, int i5, int[] iArr2, int[] iArr3) {
        zzd(i, i2, i4, 16, iArr, bArr, bArr2, i5, iArr2, iArr3);
        zzd(i3, i4, i2, 12, iArr, bArr, bArr2, i5, iArr2, iArr3);
        zzd(i, i2, i4, 8, iArr, bArr, bArr2, i5, iArr2, iArr3);
        zzd(i3, i4, i2, 7, iArr, bArr, bArr2, i5, iArr2, iArr3);
    }

    protected static final void zzd(int i, int i2, int i3, int i4, int[] iArr, byte[] bArr, byte[] bArr2, int i5, int[] iArr2, int[] iArr3) {
        int i6 = iArr2[i] + iArr2[i2];
        iArr2[i] = i6;
        int zza2 = zza(iArr2[i3], i6);
        iArr2[i3] = (zza2 << i4) | (zza2 >>> (32 - i4));
    }

    private static final int zze(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }
}
