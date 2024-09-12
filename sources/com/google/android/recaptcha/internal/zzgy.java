package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzgy extends zzhc {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;

    /* synthetic */ zzgy(byte[] bArr, int i, int i2, boolean z, zzgx zzgx) {
        super((zzhb) null);
        this.zze = bArr;
        this.zzf = 0;
        this.zzh = 0;
    }

    private final void zzI() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = this.zzj;
        if (i > i2) {
            int i3 = i - i2;
            this.zzg = i3;
            this.zzf = i - i3;
            return;
        }
        this.zzg = 0;
    }

    public final void zzA(int i) {
        this.zzj = i;
        zzI();
    }

    public final void zzB(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzje.zzf();
        }
        throw zzje.zzj();
    }

    public final boolean zzC() throws IOException {
        return this.zzh == this.zzf;
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final byte zza() throws IOException {
        int i = this.zzh;
        if (i != this.zzf) {
            byte[] bArr = this.zze;
            this.zzh = i + 1;
            return bArr[i];
        }
        throw zzje.zzj();
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return this.zzh;
    }

    public final int zze(int i) throws zzje {
        if (i >= 0) {
            int i2 = i + this.zzh;
            if (i2 >= 0) {
                int i3 = this.zzj;
                if (i2 <= i3) {
                    this.zzj = i2;
                    zzI();
                    return i3;
                }
                throw zzje.zzj();
            }
            throw zzje.zzg();
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
        int i = this.zzh;
        if (this.zzf - i >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i + 4;
            int i2 = (bArr[i + 1] & 255) << 8;
            return ((bArr[i + 3] & 255) << Ascii.CAN) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << Ascii.DLE);
        }
        throw zzje.zzj();
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzi = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzi = zzj2;
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
        int i = this.zzh;
        if (this.zzf - i >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i + 8;
            long j = (long) bArr[i + 2];
            long j2 = (long) bArr[i + 3];
            long j3 = (long) bArr[i + 4];
            long j4 = (long) bArr[i + 5];
            long j5 = (long) bArr[i + 6];
            long j6 = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((j & 255) << 16) | ((j2 & 255) << 24);
            return ((((long) bArr[i + 7]) & 255) << 56) | j6 | ((j3 & 255) << 32) | ((j4 & 255) << 40) | ((j5 & 255) << 48);
        }
        throw zzje.zzj();
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
        if (zzj2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzj2 <= i - i2) {
                zzgw zzm = zzgw.zzm(this.zze, i2, zzj2);
                this.zzh += zzj2;
                return zzm;
            }
        }
        if (zzj2 == 0) {
            return zzgw.zzb;
        }
        if (zzj2 > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (zzj2 <= i3 - i4) {
                int i5 = zzj2 + i4;
                this.zzh = i5;
                return new zzgt(Arrays.copyOfRange(this.zze, i4, i5));
            }
        }
        if (zzj2 <= 0) {
            throw zzje.zzf();
        }
        throw zzje.zzj();
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzj2 <= i - i2) {
                String str = new String(this.zze, i2, zzj2, zzjc.zzb);
                this.zzh += zzj2;
                return str;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 < 0) {
            throw zzje.zzf();
        }
        throw zzje.zzj();
    }

    public final String zzy() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzj2 <= i - i2) {
                String zzd = zzma.zzd(this.zze, i2, zzj2);
                this.zzh += zzj2;
                return zzd;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 <= 0) {
            throw zzje.zzf();
        }
        throw zzje.zzj();
    }

    public final void zzz(int i) throws zzje {
        if (this.zzi != i) {
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
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 != r0) goto L_0x0007
            goto L_0x006d
        L_0x0007:
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzh = r3
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
            r5.zzh = r1
            return r0
        L_0x006d:
            long r0 = r5.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgy.zzj():int");
    }

    public final boolean zzE(int i) throws IOException {
        int zzm;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zze;
                    int i4 = this.zzh;
                    this.zzh = i4 + 1;
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
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.zzh = i3;
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
                                                    this.zzh = i4;
                                                    return j;
                                                }
                                            }
                                        }
                                    }
                                }
                                j = j3 ^ j6;
                                i4 = i6;
                                this.zzh = i4;
                                return j;
                            }
                            j2 = j5 ^ j4;
                        }
                    }
                    i4 = i5;
                    j = j2;
                    this.zzh = i4;
                    return j;
                }
                j = (long) b;
                this.zzh = i4;
                return j;
            }
        }
        return zzs();
    }
}
