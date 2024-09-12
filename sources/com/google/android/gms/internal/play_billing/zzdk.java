package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzdk {
    static int zza(byte[] bArr, int i, zzdj zzdj) throws zzff {
        int zzh = zzh(bArr, i, zzdj);
        int i2 = zzdj.zza;
        if (i2 < 0) {
            throw zzff.zzd();
        } else if (i2 > bArr.length - zzh) {
            throw zzff.zzg();
        } else if (i2 == 0) {
            zzdj.zzc = zzdw.zzb;
            return zzh;
        } else {
            zzdj.zzc = zzdw.zzl(bArr, zzh, i2);
            return zzh + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    static int zzc(zzgm zzgm, byte[] bArr, int i, int i2, int i3, zzdj zzdj) throws IOException {
        Object zze = zzgm.zze();
        int zzl = zzl(zze, zzgm, bArr, i, i2, i3, zzdj);
        zzgm.zzf(zze);
        zzdj.zzc = zze;
        return zzl;
    }

    static int zzd(zzgm zzgm, byte[] bArr, int i, int i2, zzdj zzdj) throws IOException {
        Object zze = zzgm.zze();
        int zzm = zzm(zze, zzgm, bArr, i, i2, zzdj);
        zzgm.zzf(zze);
        zzdj.zzc = zze;
        return zzm;
    }

    static int zze(zzgm zzgm, int i, byte[] bArr, int i2, int i3, zzfc zzfc, zzdj zzdj) throws IOException {
        int zzd = zzd(zzgm, bArr, i2, i3, zzdj);
        zzfc.add(zzdj.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzdj);
            if (i != zzdj.zza) {
                break;
            }
            zzd = zzd(zzgm, bArr, zzh, i3, zzdj);
            zzfc.add(zzdj.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzfc zzfc, zzdj zzdj) throws IOException {
        zzey zzey = (zzey) zzfc;
        int zzh = zzh(bArr, i, zzdj);
        int i2 = zzdj.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzdj);
            zzey.zzf(zzdj.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw zzff.zzg();
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzhe zzhe, zzdj zzdj) throws zzff {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzk = zzk(bArr, i2, zzdj);
                zzhe.zzj(i, Long.valueOf(zzdj.zzb));
                return zzk;
            } else if (i4 == 1) {
                zzhe.zzj(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzh = zzh(bArr, i2, zzdj);
                int i5 = zzdj.zza;
                if (i5 < 0) {
                    throw zzff.zzd();
                } else if (i5 <= bArr.length - zzh) {
                    if (i5 == 0) {
                        zzhe.zzj(i, zzdw.zzb);
                    } else {
                        zzhe.zzj(i, zzdw.zzl(bArr, zzh, i5));
                    }
                    return zzh + i5;
                } else {
                    throw zzff.zzg();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzhe zzf = zzhe.zzf();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzh2 = zzh(bArr, i2, zzdj);
                    int i8 = zzdj.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zzh2;
                        break;
                    }
                    int zzg = zzg(i7, bArr, zzh2, i3, zzf, zzdj);
                    i7 = i8;
                    i2 = zzg;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzff.zze();
                }
                zzhe.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzhe.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzff.zzb();
            }
        } else {
            throw zzff.zzb();
        }
    }

    static int zzh(byte[] bArr, int i, zzdj zzdj) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzdj);
        }
        zzdj.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzdj zzdj) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzdj.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzdj.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdj.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdj.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzdj.zza = i11;
                return i12;
            }
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzfc zzfc, zzdj zzdj) {
        zzey zzey = (zzey) zzfc;
        int zzh = zzh(bArr, i2, zzdj);
        zzey.zzf(zzdj.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzdj);
            if (i != zzdj.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzdj);
            zzey.zzf(zzdj.zza);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i, zzdj zzdj) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzdj.zzb = j;
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
        zzdj.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzgm zzgm, byte[] bArr, int i, int i2, int i3, zzdj zzdj) throws IOException {
        int zzc = ((zzgf) zzgm).zzc(obj, bArr, i, i2, i3, zzdj);
        zzdj.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzm(java.lang.Object r6, com.google.android.gms.internal.play_billing.zzgm r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.play_billing.zzdj r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzi(r9, r8, r0, r11)
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
            r0.zzh(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.play_billing.zzff r6 = com.google.android.gms.internal.play_billing.zzff.zzg()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzdk.zzm(java.lang.Object, com.google.android.gms.internal.play_billing.zzgm, byte[], int, int, com.google.android.gms.internal.play_billing.zzdj):int");
    }

    static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
