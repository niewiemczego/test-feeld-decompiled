package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzrb {
    public static byte[] zza(byte[] bArr) {
        if (bArr.length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[bArr.length] = Byte.MIN_VALUE;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    public static byte[] zzb(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                byte b = (byte) ((bArr[i] << 1) & 254);
                bArr2[i] = b;
                if (i < 15) {
                    bArr2[i] = (byte) (((byte) ((bArr[i + 1] >> 7) & 1)) | b);
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & TsExtractor.TS_STREAM_TYPE_E_AC3)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
