package com.appsflyer.internal;

import com.google.common.base.Ascii;

public final class AFg1ySDK {
    static final int[] AFInAppEventParameterName = new int[256];
    static final int[] AFInAppEventType = new int[256];
    static final int[] AFKeystoreWrapper = new int[256];
    private static byte[] AFLogger = new byte[256];
    private static int[] afErrorLog = new int[10];
    static final int[] valueOf = new int[256];
    static final byte[] values = new byte[256];

    static {
        byte[] bArr;
        byte b;
        byte b2 = 1;
        byte b3 = 1;
        do {
            b2 = (byte) (((b2 & 128) != 0 ? Ascii.ESC : 0) ^ ((b2 << 1) ^ b2));
            byte b4 = (byte) (b3 ^ (b3 << 1));
            byte b5 = (byte) (b4 ^ (b4 << 2));
            byte b6 = (byte) (b5 ^ (b5 << 4));
            b3 = (byte) (b6 ^ ((b6 & 128) != 0 ? (byte) 9 : 0));
            bArr = AFLogger;
            b = b2 & 255;
            byte b7 = b3 & 255;
            bArr[b] = (byte) (((((b3 ^ 99) ^ ((b7 << 1) | (b7 >> 7))) ^ ((b7 << 2) | (b7 >> 6))) ^ ((b7 << 3) | (b7 >> 5))) ^ ((b7 >> 4) | (b7 << 4)));
        } while (b != 1);
        bArr[0] = 99;
        for (int i = 0; i < 256; i++) {
            byte b8 = AFLogger[i] & 255;
            values[b8] = (byte) i;
            int i2 = i << 1;
            if (i2 >= 256) {
                i2 ^= 283;
            }
            int i3 = i2 << 1;
            if (i3 >= 256) {
                i3 ^= 283;
            }
            int i4 = i3 << 1;
            if (i4 >= 256) {
                i4 ^= 283;
            }
            int i5 = i4 ^ i;
            int i6 = ((i2 ^ (i3 ^ i4)) << 24) | (i5 << 16) | ((i5 ^ i3) << 8) | (i5 ^ i2);
            AFKeystoreWrapper[b8] = i6;
            AFInAppEventType[b8] = (i6 >>> 8) | (i6 << 24);
            valueOf[b8] = (i6 >>> 16) | (i6 << 16);
            AFInAppEventParameterName[b8] = (i6 << 8) | (i6 >>> 24);
        }
        afErrorLog[0] = 16777216;
        int i7 = 1;
        for (int i8 = 1; i8 < 10; i8++) {
            i7 <<= 1;
            if (i7 >= 256) {
                i7 ^= 283;
            }
            afErrorLog[i8] = i7 << 24;
        }
    }

    public static byte[][] valueOf(int i) {
        byte[][] bArr = new byte[4][];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i >>> (i2 << 3);
            bArr[i2] = new byte[]{(byte) (i3 & 3), (byte) ((i3 >> 2) & 3), (byte) ((i3 >> 4) & 3), (byte) ((i3 >> 6) & 3)};
        }
        return bArr;
    }

    static int[] valueOf(byte[] bArr, int i) throws IllegalArgumentException {
        if (bArr.length == 16) {
            int i2 = 4;
            int i3 = (i + 1) * 4;
            int[] iArr = new int[i3];
            int i4 = 0;
            int i5 = 0;
            while (i4 < 4) {
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                byte b = (bArr[i5] << Ascii.CAN) | ((bArr[i6] & 255) << Ascii.DLE);
                int i8 = i7 + 1;
                iArr[i4] = b | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                i4++;
                i5 = i8 + 1;
            }
            int i9 = 4;
            int i10 = 0;
            int i11 = 0;
            while (i9 < i3) {
                int i12 = iArr[i9 - 1];
                if (i10 == 0) {
                    byte[] bArr2 = AFLogger;
                    i12 = ((bArr2[i12 >>> 24] & 255) | (((bArr2[(i12 >>> 16) & 255] << Ascii.CAN) | ((bArr2[(i12 >>> 8) & 255] & 255) << Ascii.DLE)) | ((bArr2[i12 & 255] & 255) << 8))) ^ afErrorLog[i11];
                    i10 = 4;
                    i11++;
                }
                iArr[i9] = i12 ^ iArr[i9 - 4];
                i9++;
                i10--;
            }
            if (bArr.length == 16) {
                int[] iArr2 = new int[i3];
                int i13 = i * 4;
                int i14 = i13 + 1;
                iArr2[0] = iArr[i13];
                int i15 = i14 + 1;
                iArr2[1] = iArr[i14];
                int i16 = i15 + 1;
                iArr2[2] = iArr[i15];
                iArr2[3] = iArr[i16];
                int i17 = i16 - 7;
                for (int i18 = 1; i18 < i; i18++) {
                    int i19 = i17 + 1;
                    int i20 = iArr[i17];
                    int i21 = i2 + 1;
                    int[] iArr3 = AFKeystoreWrapper;
                    byte[] bArr3 = AFLogger;
                    int i22 = iArr3[bArr3[i20 >>> 24] & 255];
                    int[] iArr4 = AFInAppEventType;
                    int i23 = i22 ^ iArr4[bArr3[(i20 >>> 16) & 255] & 255];
                    int[] iArr5 = valueOf;
                    int i24 = i23 ^ iArr5[bArr3[(i20 >>> 8) & 255] & 255];
                    int[] iArr6 = AFInAppEventParameterName;
                    iArr2[i2] = iArr6[bArr3[i20 & 255] & 255] ^ i24;
                    int i25 = i19 + 1;
                    int i26 = iArr[i19];
                    int i27 = i21 + 1;
                    iArr2[i21] = iArr6[bArr3[i26 & 255] & 255] ^ ((iArr3[bArr3[i26 >>> 24] & 255] ^ iArr4[bArr3[(i26 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i26 >>> 8) & 255] & 255]);
                    int i28 = i25 + 1;
                    int i29 = iArr[i25];
                    int i30 = i27 + 1;
                    iArr2[i27] = iArr6[bArr3[i29 & 255] & 255] ^ ((iArr3[bArr3[i29 >>> 24] & 255] ^ iArr4[bArr3[(i29 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i29 >>> 8) & 255] & 255]);
                    int i31 = iArr[i28];
                    i2 = i30 + 1;
                    iArr2[i30] = iArr6[bArr3[i31 & 255] & 255] ^ ((iArr3[bArr3[i31 >>> 24] & 255] ^ iArr4[bArr3[(i31 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i31 >>> 8) & 255] & 255]);
                    i17 = i28 - 7;
                }
                int i32 = i2 + 1;
                int i33 = i17 + 1;
                iArr2[i2] = iArr[i17];
                int i34 = i32 + 1;
                int i35 = i33 + 1;
                iArr2[i32] = iArr[i33];
                iArr2[i34] = iArr[i35];
                iArr2[i34 + 1] = iArr[i35 + 1];
                return iArr2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }
}
