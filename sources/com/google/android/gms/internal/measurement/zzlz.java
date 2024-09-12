package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public final class zzlz {
    private static final zzlz zza = new zzlz(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public final int zza() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzig.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzig.zzc(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzig.zzc(i6, (zzhm) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzig.zzi(i6) << 1) + ((zzlz) this.zzd[i4]).zza();
            } else if (i7 == 5) {
                i = zzig.zzf(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzji.zza());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzig.zzd(this.zzc[i3] >>> 3, (zzhm) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public static zzlz zzc() {
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final zzlz zza(zzlz zzlz) {
        if (zzlz.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzlz.zzb;
        zza(i);
        System.arraycopy(zzlz.zzc, 0, this.zzc, this.zzb, zzlz.zzb);
        System.arraycopy(zzlz.zzd, 0, this.zzd, this.zzb, zzlz.zzb);
        this.zzb = i;
        return this;
    }

    static zzlz zza(zzlz zzlz, zzlz zzlz2) {
        int i = zzlz.zzb + zzlz2.zzb;
        int[] copyOf = Arrays.copyOf(zzlz.zzc, i);
        System.arraycopy(zzlz2.zzc, 0, copyOf, zzlz.zzb, zzlz2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzlz.zzd, i);
        System.arraycopy(zzlz2.zzd, 0, copyOf2, zzlz.zzb, zzlz2.zzb);
        return new zzlz(i, copyOf, copyOf2, true);
    }

    static zzlz zzd() {
        return new zzlz();
    }

    private zzlz() {
        this(0, new int[8], new Object[8], true);
    }

    private zzlz(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    private final void zza(int i) {
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

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzko.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzmw zzmw) throws IOException {
        if (zzmw.zza() == zzmz.zzb) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzmw.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzmw.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzmw zzmw) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzmw.zzb(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzmw.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzmw.zza(i2, (zzhm) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzmw.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzji.zza());
        } else if (zzmw.zza() == zzmz.zza) {
            zzmw.zzb(i2);
            ((zzlz) obj).zzb(zzmw);
            zzmw.zza(i2);
        } else {
            zzmw.zza(i2);
            ((zzlz) obj).zzb(zzmw);
            zzmw.zzb(i2);
        }
    }

    public final void zzb(zzmw zzmw) throws IOException {
        if (this.zzb != 0) {
            if (zzmw.zza() == zzmz.zza) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzmw);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzmw);
            }
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzlz)) {
            return false;
        }
        zzlz zzlz = (zzlz) obj;
        int i = this.zzb;
        if (i == zzlz.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzlz.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzlz.zzd;
                int i3 = this.zzb;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }
}
