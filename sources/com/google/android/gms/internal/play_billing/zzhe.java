package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzhe {
    private static final zzhe zza = new zzhe(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhe zzc() {
        return zza;
    }

    static zzhe zze(zzhe zzhe, zzhe zzhe2) {
        int i = zzhe.zzb + zzhe2.zzb;
        int[] copyOf = Arrays.copyOf(zzhe.zzc, i);
        System.arraycopy(zzhe2.zzc, 0, copyOf, zzhe.zzb, zzhe2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzhe.zzd, i);
        System.arraycopy(zzhe2.zzd, 0, copyOf2, zzhe.zzb, zzhe2.zzb);
        return new zzhe(i, copyOf, copyOf2, true);
    }

    static zzhe zzf() {
        return new zzhe(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhe)) {
            return false;
        }
        zzhe zzhe = (zzhe) obj;
        int i = this.zzb;
        if (i == zzhe.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhe.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhe.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzee.zzx(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int i10 = i8 << 3;
                    int i11 = zzee.zzb;
                    int zzd2 = ((zzdw) this.zzd[i6]).zzd();
                    i = zzee.zzx(i10) + zzee.zzx(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int i12 = i8 << 3;
                    int i13 = zzee.zzb;
                    i2 = ((zzhe) this.zzd[i6]).zza();
                    int zzx = zzee.zzx(i12);
                    i3 = zzx + zzx;
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzee.zzx(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzff.zza());
                }
                i5 += i;
            } else {
                int i14 = i8 << 3;
                i2 = zzee.zzy(((Long) this.zzd[i6]).longValue());
                i3 = zzee.zzx(i14);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = zzee.zzb;
            int zzd2 = ((zzdw) this.zzd[i3]).zzd();
            int zzx = zzee.zzx(zzd2) + zzd2;
            int zzx2 = zzee.zzx(16);
            int zzx3 = zzee.zzx(this.zzc[i3] >>> 3);
            int zzx4 = zzee.zzx(8);
            i2 += zzx4 + zzx4 + zzx2 + zzx3 + zzee.zzx(24) + zzx;
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final zzhe zzd(zzhe zzhe) {
        if (zzhe.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhe.zzb;
        zzl(i);
        System.arraycopy(zzhe.zzc, 0, this.zzc, this.zzb, zzhe.zzb);
        System.arraycopy(zzhe.zzd, 0, this.zzd, this.zzb, zzhe.zzb);
        this.zzb = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzge.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzhv zzhv) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhv.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhv.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhv.zzd(i4, (zzdw) obj);
                } else if (i3 == 3) {
                    zzhv.zzE(i4);
                    ((zzhe) obj).zzk(zzhv);
                    zzhv.zzh(i4);
                } else if (i3 == 5) {
                    zzhv.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzff.zza());
                }
            }
        }
    }
}
