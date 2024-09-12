package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzame  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzame {
    private static final zzame zza = new zzame(0, new int[0], new Object[0], false);
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
                i = zzaii.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzaii.zza(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzaii.zza(i6, (zzahm) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzaii.zzg(i6) << 1) + ((zzame) this.zzd[i4]).zza();
            } else if (i7 == 5) {
                i = zzaii.zzb(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzajj.zza());
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
            i2 += zzaii.zzb(this.zzc[i3] >>> 3, (zzahm) this.zzd[i3]);
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

    public static zzame zzc() {
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final zzame zza(zzame zzame) {
        if (zzame.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzame.zzb;
        zza(i);
        System.arraycopy(zzame.zzc, 0, this.zzc, this.zzb, zzame.zzb);
        System.arraycopy(zzame.zzd, 0, this.zzd, this.zzb, zzame.zzb);
        this.zzb = i;
        return this;
    }

    static zzame zza(zzame zzame, zzame zzame2) {
        int i = zzame.zzb + zzame2.zzb;
        int[] copyOf = Arrays.copyOf(zzame.zzc, i);
        System.arraycopy(zzame2.zzc, 0, copyOf, zzame.zzb, zzame2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzame.zzd, i);
        System.arraycopy(zzame2.zzd, 0, copyOf2, zzame.zzb, zzame2.zzb);
        return new zzame(i, copyOf, copyOf2, true);
    }

    static zzame zzd() {
        return new zzame();
    }

    private zzame() {
        this(0, new int[8], new Object[8], true);
    }

    private zzame(int i, int[] iArr, Object[] objArr, boolean z) {
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
            zzakp.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
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
    public final void zza(zzanb zzanb) throws IOException {
        if (zzanb.zza() == zzana.zzb) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzanb.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzanb.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzanb zzanb) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzanb.zzb(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzanb.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzanb.zza(i2, (zzahm) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzanb.zzb(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzajj.zza());
        } else if (zzanb.zza() == zzana.zza) {
            zzanb.zzb(i2);
            ((zzame) obj).zzb(zzanb);
            zzanb.zza(i2);
        } else {
            zzanb.zza(i2);
            ((zzame) obj).zzb(zzanb);
            zzanb.zzb(i2);
        }
    }

    public final void zzb(zzanb zzanb) throws IOException {
        if (this.zzb != 0) {
            if (zzanb.zza() == zzana.zza) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzanb);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzanb);
            }
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzame)) {
            return false;
        }
        zzame zzame = (zzame) obj;
        int i = this.zzb;
        if (i == zzame.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzame.zzc;
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
                Object[] objArr2 = zzame.zzd;
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
