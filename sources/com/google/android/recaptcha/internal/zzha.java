package com.google.android.recaptcha.internal;

import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzha extends zzhc {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    /* synthetic */ zzha(InputStream inputStream, int i, zzgz zzgz) {
        super((zzhb) null);
        byte[] bArr = zzjc.zzd;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zze.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzk += read;
                    i2 += read;
                } else {
                    throw zzje.zzj();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzh = i4;
            this.zzg = i - i4;
            return;
        }
        this.zzh = 0;
    }

    private final void zzK(int i) throws IOException {
        if (zzL(i)) {
            return;
        }
        if (i > (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw zzje.zzi();
        }
        throw zzje.zzj();
    }

    private final boolean zzL(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = i2 + i;
        int i4 = this.zzg;
        if (i3 > i4) {
            int i5 = this.zzk;
            if (i > (Integer.MAX_VALUE - i5) - i2 || i5 + i2 + i > this.zzl) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                i5 = this.zzk + i2;
                this.zzk = i5;
                i4 = this.zzg - i2;
                this.zzg = i4;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i4, Math.min(4096 - i4, (Integer.MAX_VALUE - i5) - i4));
                if (read == 0 || read < -1 || read > 4096) {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzg += read;
                    zzJ();
                    if (this.zzg >= i) {
                        return true;
                    }
                    return zzL(i);
                }
            } catch (zzje e) {
                e.zzk();
                throw e;
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
    }

    private final byte[] zzM(int i, boolean z) throws IOException {
        byte[] zzN = zzN(i);
        if (zzN != null) {
            return zzN;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzI = zzI(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i) throws IOException {
        if (i == 0) {
            return zzjc.zzd;
        }
        if (i >= 0) {
            int i2 = this.zzk;
            int i3 = this.zzi;
            int i4 = i2 + i3 + i;
            if (C.RATE_UNSET_INT + i4 <= 0) {
                int i5 = this.zzl;
                if (i4 <= i5) {
                    int i6 = this.zzg - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096) {
                        try {
                            if (i7 > this.zze.available()) {
                                return null;
                            }
                        } catch (zzje e) {
                            e.zzk();
                            throw e;
                        }
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i6 < i) {
                        try {
                            int read = this.zze.read(bArr, i6, i - i6);
                            if (read != -1) {
                                this.zzk += read;
                                i6 += read;
                            } else {
                                throw zzje.zzj();
                            }
                        } catch (zzje e2) {
                            e2.zzk();
                            throw e2;
                        }
                    }
                    return bArr;
                }
                zzB((i5 - i2) - i3);
                throw zzje.zzj();
            }
            throw zzje.zzi();
        }
        throw zzje.zzf();
    }

    public final void zzA(int i) {
        this.zzl = i;
        zzJ();
    }

    public final void zzB(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
        } else if (i >= 0) {
            int i5 = this.zzk;
            int i6 = i5 + i3;
            int i7 = this.zzl;
            if (i6 + i <= i7) {
                this.zzk = i6;
                this.zzg = 0;
                this.zzi = 0;
                while (i4 < i) {
                    try {
                        long j = (long) (i - i4);
                        long skip = this.zze.skip(j);
                        int i8 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i8 < 0 || skip > j) {
                            throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        } else if (i8 == 0) {
                            break;
                        } else {
                            i4 += (int) skip;
                        }
                    } catch (zzje e) {
                        e.zzk();
                        throw e;
                    } catch (Throwable th) {
                        this.zzk += i4;
                        zzJ();
                        throw th;
                    }
                }
                this.zzk += i4;
                zzJ();
                if (i4 < i) {
                    int i9 = this.zzg;
                    int i10 = i9 - this.zzi;
                    this.zzi = i9;
                    zzK(1);
                    while (true) {
                        int i11 = i - i10;
                        int i12 = this.zzg;
                        if (i11 > i12) {
                            i10 += i12;
                            this.zzi = i12;
                            zzK(1);
                        } else {
                            this.zzi = i11;
                            return;
                        }
                    }
                }
            } else {
                zzB((i7 - i5) - i3);
                throw zzje.zzj();
            }
        } else {
            throw zzje.zzf();
        }
    }

    public final boolean zzC() throws IOException {
        return this.zzi == this.zzg && !zzL(1);
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final byte zza() throws IOException {
        if (this.zzi == this.zzg) {
            zzK(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return this.zzk + this.zzi;
    }

    public final int zze(int i) throws zzje {
        if (i >= 0) {
            int i2 = this.zzk + this.zzi;
            int i3 = this.zzl;
            int i4 = i + i2;
            if (i4 <= i3) {
                this.zzl = i4;
                zzJ();
                return i3;
            }
            throw zzje.zzj();
        }
        throw zzje.zzf();
    }

    public final int zzf() throws IOException {
        return zzj();
    }

    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzK(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzj = zzj2;
        if ((zzj2 >>> 3) != 0) {
            return zzj2;
        }
        throw zzje.zzc();
    }

    public final int zzn() throws IOException {
        return zzj();
    }

    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzK(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = (long) bArr[i + 2];
        long j2 = (long) bArr[i + 3];
        long j3 = (long) bArr[i + 4];
        long j4 = (long) bArr[i + 5];
        long j5 = (long) bArr[i + 6];
        long j6 = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((j & 255) << 16) | ((j2 & 255) << 24);
        return ((((long) bArr[i + 7]) & 255) << 56) | j6 | ((j3 & 255) << 32) | ((j4 & 255) << 40) | ((j5 & 255) << 48);
    }

    /* access modifiers changed from: package-private */
    public final long zzs() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zza = zza();
            j |= ((long) (zza & Byte.MAX_VALUE)) << i;
            if ((zza & 128) == 0) {
                return j;
            }
        }
        throw zzje.zze();
    }

    public final long zzt() throws IOException {
        return zzq();
    }

    public final long zzu() throws IOException {
        return zzG(zzr());
    }

    public final long zzv() throws IOException {
        return zzr();
    }

    public final zzgw zzw() throws IOException {
        int zzj2 = zzj();
        int i = this.zzg;
        int i2 = this.zzi;
        if (zzj2 <= i - i2 && zzj2 > 0) {
            zzgw zzm = zzgw.zzm(this.zzf, i2, zzj2);
            this.zzi += zzj2;
            return zzm;
        } else if (zzj2 == 0) {
            return zzgw.zzb;
        } else {
            byte[] zzN = zzN(zzj2);
            if (zzN != null) {
                return zzgw.zzm(zzN, 0, zzN.length);
            }
            int i3 = this.zzi;
            int i4 = this.zzg;
            int i5 = i4 - i3;
            this.zzk += i4;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzI = zzI(zzj2 - i5);
            byte[] bArr = new byte[zzj2];
            System.arraycopy(this.zzf, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzI) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i5, length);
                i5 += length;
            }
            return new zzgt(bArr);
        }
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (zzj2 <= i - i2) {
                String str = new String(this.zzf, i2, zzj2, zzjc.zzb);
                this.zzi += zzj2;
                return str;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 > this.zzg) {
            return new String(zzM(zzj2, false), zzjc.zzb);
        }
        zzK(zzj2);
        String str2 = new String(this.zzf, this.zzi, zzj2, zzjc.zzb);
        this.zzi += zzj2;
        return str2;
    }

    public final String zzy() throws IOException {
        byte[] bArr;
        int zzj2 = zzj();
        int i = this.zzi;
        int i2 = this.zzg;
        if (zzj2 <= i2 - i && zzj2 > 0) {
            bArr = this.zzf;
            this.zzi = i + zzj2;
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 <= i2) {
                zzK(zzj2);
                bArr = this.zzf;
                this.zzi = zzj2;
            } else {
                bArr = zzM(zzj2, false);
            }
            i = 0;
        }
        return zzma.zzd(bArr, i, zzj2);
    }

    public final void zzz(int i) throws zzje {
        if (this.zzj != i) {
            throw zzje.zzb();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] < 0) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L_0x0007
            goto L_0x006d
        L_0x0007:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzi = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x006a
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x006a
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r5.zzi = r1
            return r0
        L_0x006d:
            long r0 = r5.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzha.zzj():int");
    }

    public final boolean zzE(int i) throws IOException {
        int zzm;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzf;
                    int i4 = this.zzi;
                    this.zzi = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzje.zze();
            }
            while (i3 < 10) {
                if (zza() < 0) {
                    i3++;
                }
            }
            throw zzje.zze();
            return true;
        } else if (i2 == 1) {
            zzB(8);
            return true;
        } else if (i2 == 2) {
            zzB(zzj());
            return true;
        } else if (i2 == 3) {
            do {
                zzm = zzm();
                if (zzm == 0 || !zzE(zzm)) {
                    zzz(((i >>> 3) << 3) | 4);
                }
                zzm = zzm();
                break;
            } while (!zzE(zzm));
            zzz(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzB(4);
                return true;
            }
            throw zzje.zza();
        }
    }

    public final long zzr() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        byte b;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzi = i3;
                return (long) b2;
            } else if (i2 - i3 >= 9) {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ Byte.MIN_VALUE;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << Ascii.SO);
                    if (b4 >= 0) {
                        j2 = (long) (b4 ^ 16256);
                    } else {
                        i4 = i5 + 1;
                        byte b5 = b4 ^ (bArr[i5] << Ascii.NAK);
                        if (b5 < 0) {
                            b = b5 ^ -2080896;
                        } else {
                            i5 = i4 + 1;
                            long j5 = ((long) b5) ^ (((long) bArr[i4]) << 28);
                            if (j5 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i6 = i5 + 1;
                                long j6 = j5 ^ (((long) bArr[i5]) << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i5 = i6 + 1;
                                    j5 = j6 ^ (((long) bArr[i6]) << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i5 + 1;
                                        j6 = j5 ^ (((long) bArr[i5]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i5 = i6 + 1;
                                            j2 = (j6 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j2 < 0) {
                                                i6 = i5 + 1;
                                                if (((long) bArr[i5]) >= 0) {
                                                    j = j2;
                                                    i4 = i6;
                                                    this.zzi = i4;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j3 ^ j6;
                                i4 = i6;
                                this.zzi = i4;
                                return j;
                            }
                            j2 = j5 ^ j4;
                        }
                    }
                    i4 = i5;
                    j = j2;
                    this.zzi = i4;
                    return j;
                }
                j = (long) b;
                this.zzi = i4;
                return j;
            }
        }
        return zzs();
    }
}
