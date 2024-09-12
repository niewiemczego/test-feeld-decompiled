package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import okio.Utf8;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzamk {
    private static boolean zza(byte b) {
        return b > -65;
    }

    static /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (zza(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || zza(b3) || zza(b4)) {
            throw zzajj.zzd();
        }
        byte b5 = ((b & 7) << Ascii.DC2) | ((b2 & Utf8.REPLACEMENT_BYTE) << Ascii.FF) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((b5 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((b5 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    static /* synthetic */ void zza(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    static /* synthetic */ void zza(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (zza(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || zza(b3)))) {
            throw zzajj.zzd();
        }
        cArr[i] = (char) (((b & Ascii.SI) << Ascii.FF) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }

    static /* synthetic */ void zza(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zza(b2)) {
            throw zzajj.zzd();
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }
}
