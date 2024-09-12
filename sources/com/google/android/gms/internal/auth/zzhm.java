package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzhm {
    private static final zzhk zza = new zzhl();

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i = zzdr.zza;
        }
    }

    static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b2 = bArr[i];
                if (b <= -12 && b2 <= -65) {
                    return b ^ (b2 << 8);
                }
            } else if (i3 == 2) {
                byte b3 = bArr[i];
                byte b4 = bArr[i + 1];
                if (b <= -12 && b3 <= -65 && b4 <= -65) {
                    return ((b3 << 8) ^ b) ^ (b4 << Ascii.DLE);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b <= -12) {
            return b;
        }
        return -1;
    }

    static String zzb(byte[] bArr, int i, int i2) throws zzfa {
        int i3;
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (r11 < i4) {
                byte b = bArr[r11];
                if (!zzhj.zzd(b)) {
                    break;
                }
                i = r11 + 1;
                cArr[i3] = (char) b;
                i5 = i3 + 1;
            }
            while (r11 < i4) {
                int i6 = r11 + 1;
                byte b2 = bArr[r11];
                if (zzhj.zzd(b2)) {
                    int i7 = i3 + 1;
                    cArr[i3] = (char) b2;
                    r11 = i6;
                    while (true) {
                        i3 = i7;
                        if (r11 >= i4) {
                            break;
                        }
                        byte b3 = bArr[r11];
                        if (!zzhj.zzd(b3)) {
                            break;
                        }
                        r11++;
                        i7 = i3 + 1;
                        cArr[i3] = (char) b3;
                    }
                } else if (b2 < -32) {
                    if (i6 < i4) {
                        zzhj.zzc(b2, bArr[i6], cArr, i3);
                        r11 = i6 + 1;
                        i3++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b2 < -16) {
                    if (i6 < i4 - 1) {
                        int i8 = i6 + 1;
                        zzhj.zzb(b2, bArr[i6], bArr[i8], cArr, i3);
                        r11 = i8 + 1;
                        i3++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i6 < i4 - 2) {
                    int i9 = i6 + 1;
                    int i10 = i9 + 1;
                    zzhj.zza(b2, bArr[i6], bArr[i9], bArr[i10], cArr, i3);
                    i3 += 2;
                    r11 = i10 + 1;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i3);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    static boolean zzd(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }
}
