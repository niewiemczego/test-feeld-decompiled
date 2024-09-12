package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzgk {
    static int zza(byte[] bArr, int i, zzgj zzgj) throws zzje {
        int zzi = zzi(bArr, i, zzgj);
        int i2 = zzgj.zza;
        if (i2 < 0) {
            throw zzje.zzf();
        } else if (i2 > bArr.length - zzi) {
            throw zzje.zzj();
        } else if (i2 == 0) {
            zzgj.zzc = zzgw.zzb;
            return zzi;
        } else {
            zzgj.zzc = zzgw.zzm(bArr, zzi, i2);
            return zzi + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zzc(zzkr zzkr, byte[] bArr, int i, int i2, int i3, zzgj zzgj) throws IOException {
        Object zze = zzkr.zze();
        int zzm = zzm(zze, zzkr, bArr, i, i2, i3, zzgj);
        zzkr.zzf(zze);
        zzgj.zzc = zze;
        return zzm;
    }

    static int zzd(zzkr zzkr, byte[] bArr, int i, int i2, zzgj zzgj) throws IOException {
        Object zze = zzkr.zze();
        int zzn = zzn(zze, zzkr, bArr, i, i2, zzgj);
        zzkr.zzf(zze);
        zzgj.zzc = zze;
        return zzn;
    }

    static int zze(zzkr zzkr, int i, byte[] bArr, int i2, int i3, zzjb zzjb, zzgj zzgj) throws IOException {
        int zzd = zzd(zzkr, bArr, i2, i3, zzgj);
        zzjb.add(zzgj.zzc);
        while (zzd < i3) {
            int zzi = zzi(bArr, zzd, zzgj);
            if (i != zzgj.zza) {
                break;
            }
            zzd = zzd(zzkr, bArr, zzi, i3, zzgj);
            zzjb.add(zzgj.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzjb zzjb, zzgj zzgj) throws IOException {
        zziu zziu = (zziu) zzjb;
        int zzi = zzi(bArr, i, zzgj);
        int i2 = zzgj.zza + zzi;
        while (zzi < i2) {
            zzi = zzi(bArr, zzi, zzgj);
            zziu.zzg(zzgj.zza);
        }
        if (zzi == i2) {
            return zzi;
        }
        throw zzje.zzj();
    }

    static int zzg(byte[] bArr, int i, zzgj zzgj) throws zzje {
        int zzi = zzi(bArr, i, zzgj);
        int i2 = zzgj.zza;
        if (i2 < 0) {
            throw zzje.zzf();
        } else if (i2 == 0) {
            zzgj.zzc = "";
            return zzi;
        } else {
            zzgj.zzc = new String(bArr, zzi, i2, zzjc.zzb);
            return zzi + i2;
        }
    }

    static int zzh(int i, byte[] bArr, int i2, int i3, zzlm zzlm, zzgj zzgj) throws zzje {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzl = zzl(bArr, i2, zzgj);
                zzlm.zzj(i, Long.valueOf(zzgj.zzb));
                return zzl;
            } else if (i4 == 1) {
                zzlm.zzj(i, Long.valueOf(zzp(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzi = zzi(bArr, i2, zzgj);
                int i5 = zzgj.zza;
                if (i5 < 0) {
                    throw zzje.zzf();
                } else if (i5 <= bArr.length - zzi) {
                    if (i5 == 0) {
                        zzlm.zzj(i, zzgw.zzb);
                    } else {
                        zzlm.zzj(i, zzgw.zzm(bArr, zzi, i5));
                    }
                    return zzi + i5;
                } else {
                    throw zzje.zzj();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzlm zzf = zzlm.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzi2 = zzi(bArr, i2, zzgj);
                    int i8 = zzgj.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzi2;
                        break;
                    }
                    int zzh = zzh(i7, bArr, zzi2, i3, zzf, zzgj);
                    i7 = i8;
                    i2 = zzh;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzje.zzg();
                }
                zzlm.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzlm.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzje.zzc();
            }
        } else {
            throw zzje.zzc();
        }
    }

    static int zzi(byte[] bArr, int i, zzgj zzgj) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzj(b, bArr, i2, zzgj);
        }
        zzgj.zza = b;
        return i2;
    }

    static int zzj(int i, byte[] bArr, int i2, zzgj zzgj) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgj.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgj.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgj.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgj.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzgj.zza = i11;
                return i12;
            }
        }
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzjb zzjb, zzgj zzgj) {
        zziu zziu = (zziu) zzjb;
        int zzi = zzi(bArr, i2, zzgj);
        zziu.zzg(zzgj.zza);
        while (zzi < i3) {
            int zzi2 = zzi(bArr, zzi, zzgj);
            if (i != zzgj.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzgj);
            zziu.zzg(zzgj.zza);
        }
        return zzi;
    }

    static int zzl(byte[] bArr, int i, zzgj zzgj) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgj.zzb = j;
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
            byte b3 = b2;
            i3 = i5;
            b = b3;
        }
        zzgj.zzb = j2;
        return i3;
    }

    static int zzm(Object obj, zzkr zzkr, byte[] bArr, int i, int i2, int i3, zzgj zzgj) throws IOException {
        int zzc = ((zzkh) zzkr).zzc(obj, bArr, i, i2, i3, zzgj);
        zzgj.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzn(java.lang.Object r6, com.google.android.recaptcha.internal.zzkr r7, byte[] r8, int r9, int r10, com.google.android.recaptcha.internal.zzgj r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzj(r9, r8, r0, r11)
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
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.recaptcha.internal.zzje r6 = com.google.android.recaptcha.internal.zzje.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgk.zzn(java.lang.Object, com.google.android.recaptcha.internal.zzkr, byte[], int, int, com.google.android.recaptcha.internal.zzgj):int");
    }

    static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static int zzo(int i, byte[] bArr, int i2, int i3, zzgj zzgj) throws zzje {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzl(bArr, i2, zzgj);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zzi(bArr, i2, zzgj) + zzgj.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zzi(bArr, i2, zzgj);
                    i6 = zzgj.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zzo(i6, bArr, i2, i3, zzgj);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzje.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzje.zzc();
            }
        } else {
            throw zzje.zzc();
        }
    }
}
