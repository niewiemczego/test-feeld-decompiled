package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzahi {
    static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    static int zza(byte[] bArr, int i, zzahl zzahl) throws zzajj {
        int zzc = zzc(bArr, i, zzahl);
        int i2 = zzahl.zza;
        if (i2 < 0) {
            throw zzajj.zzf();
        } else if (i2 > bArr.length - zzc) {
            throw zzajj.zzi();
        } else if (i2 == 0) {
            zzahl.zzc = zzahm.zza;
            return zzc;
        } else {
            zzahl.zzc = zzahm.zza(bArr, zzc, i2);
            return zzc + i2;
        }
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zza(zzalc zzalc, byte[] bArr, int i, int i2, int i3, zzahl zzahl) throws IOException {
        Object zza = zzalc.zza();
        int zza2 = zza(zza, zzalc, bArr, i, i2, i3, zzahl);
        zzalc.zzc(zza);
        zzahl.zzc = zza;
        return zza2;
    }

    static int zza(zzalc zzalc, byte[] bArr, int i, int i2, zzahl zzahl) throws IOException {
        Object zza = zzalc.zza();
        int zza2 = zza(zza, zzalc, bArr, i, i2, zzahl);
        zzalc.zzc(zza);
        zzahl.zzc = zza;
        return zza2;
    }

    static int zza(zzalc<?> zzalc, int i, byte[] bArr, int i2, int i3, zzajg<?> zzajg, zzahl zzahl) throws IOException {
        int zza = zza((zzalc) zzalc, bArr, i2, i3, zzahl);
        zzajg.add(zzahl.zzc);
        while (zza < i3) {
            int zzc = zzc(bArr, zza, zzahl);
            if (i != zzahl.zza) {
                break;
            }
            zza = zza((zzalc) zzalc, bArr, zzc, i3, zzahl);
            zzajg.add(zzahl.zzc);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzajg<?> zzajg, zzahl zzahl) throws IOException {
        zzajd zzajd = (zzajd) zzajg;
        int zzc = zzc(bArr, i, zzahl);
        int i2 = zzahl.zza + zzc;
        while (zzc < i2) {
            zzc = zzc(bArr, zzc, zzahl);
            zzajd.zzc(zzahl.zza);
        }
        if (zzc == i2) {
            return zzc;
        }
        throw zzajj.zzi();
    }

    static int zzb(byte[] bArr, int i, zzahl zzahl) throws zzajj {
        int zzc = zzc(bArr, i, zzahl);
        int i2 = zzahl.zza;
        if (i2 < 0) {
            throw zzajj.zzf();
        } else if (i2 == 0) {
            zzahl.zzc = "";
            return zzc;
        } else {
            zzahl.zzc = zzaml.zzb(bArr, zzc, i2);
            return zzc + i2;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzame zzame, zzahl zzahl) throws zzajj {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzd = zzd(bArr, i2, zzahl);
                zzame.zza(i, (Object) Long.valueOf(zzahl.zzb));
                return zzd;
            } else if (i4 == 1) {
                zzame.zza(i, (Object) Long.valueOf(zzd(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzc = zzc(bArr, i2, zzahl);
                int i5 = zzahl.zza;
                if (i5 < 0) {
                    throw zzajj.zzf();
                } else if (i5 <= bArr.length - zzc) {
                    if (i5 == 0) {
                        zzame.zza(i, (Object) zzahm.zza);
                    } else {
                        zzame.zza(i, (Object) zzahm.zza(bArr, zzc, i5));
                    }
                    return zzc + i5;
                } else {
                    throw zzajj.zzi();
                }
            } else if (i4 == 3) {
                zzame zzd2 = zzame.zzd();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzc2 = zzc(bArr, i2, zzahl);
                    int i8 = zzahl.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzc2;
                        break;
                    }
                    int zza = zza(i7, bArr, zzc2, i3, zzd2, zzahl);
                    i7 = i8;
                    i2 = zza;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzajj.zzg();
                }
                zzame.zza(i, (Object) zzd2);
                return i2;
            } else if (i4 == 5) {
                zzame.zza(i, (Object) Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzajj.zzc();
            }
        } else {
            throw zzajj.zzc();
        }
    }

    static int zzc(byte[] bArr, int i, zzahl zzahl) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzahl);
        }
        zzahl.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzahl zzahl) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzahl.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzahl.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzahl.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzahl.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzahl.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzajg<?> zzajg, zzahl zzahl) {
        zzajd zzajd = (zzajd) zzajg;
        int zzc = zzc(bArr, i2, zzahl);
        zzajd.zzc(zzahl.zza);
        while (zzc < i3) {
            int zzc2 = zzc(bArr, zzc, zzahl);
            if (i != zzahl.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzahl);
            zzajd.zzc(zzahl.zza);
        }
        return zzc;
    }

    static int zzd(byte[] bArr, int i, zzahl zzahl) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzahl.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzahl.zzb = j2;
        return i3;
    }

    static int zza(Object obj, zzalc zzalc, byte[] bArr, int i, int i2, int i3, zzahl zzahl) throws IOException {
        int zza = ((zzako) zzalc).zza(obj, bArr, i, i2, i3, zzahl);
        zzahl.zzc = obj;
        return zza;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(java.lang.Object r6, com.google.android.gms.internal.p002firebaseauthapi.zzalc r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.p002firebaseauthapi.zzahl r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zza((int) r9, (byte[]) r8, (int) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zza(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.firebase-auth-api.zzajj r6 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzalc, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzahl):int");
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzahl zzahl) throws zzajj {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzd(bArr, i2, zzahl);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zzc(bArr, i2, zzahl) + zzahl.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zzc(bArr, i2, zzahl);
                    i6 = zzahl.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzahl);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzajj.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzajj.zzc();
            }
        } else {
            throw zzajj.zzc();
        }
    }

    static long zzd(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
