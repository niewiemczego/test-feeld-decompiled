package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public abstract class zzig extends zzhn {
    private static final Logger zzb = Logger.getLogger(zzig.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzmg.zzc();
    zzij zza;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
    private static class zza extends zzig {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        public final int zza() {
            return this.zzd - this.zze;
        }

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i2 | 0 | (bArr.length - i2)) >= 0) {
                this.zzb = bArr;
                this.zzc = 0;
                this.zze = 0;
                this.zzd = i2;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
        }

        public final void zza(byte b) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(int i, boolean z) throws IOException {
            zzc(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzc(i2);
            zzc(bArr, 0, i2);
        }

        public final void zza(int i, zzhm zzhm) throws IOException {
            zzc(i, 2);
            zza(zzhm);
        }

        public final void zza(zzhm zzhm) throws IOException {
            zzc(zzhm.zzb());
            zzhm.zza((zzhn) this);
        }

        public final void zza(int i, int i2) throws IOException {
            zzc(i, 5);
            zza(i2);
        }

        public final void zza(int i) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                int i3 = i2 + 1;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                bArr[i4] = (byte) (i >> 16);
                this.zze = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzc(i, 1);
            zza(j);
        }

        public final void zza(long j) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                int i2 = i + 1;
                bArr[i] = (byte) ((int) j);
                int i3 = i2 + 1;
                bArr[i2] = (byte) ((int) (j >> 8));
                int i4 = i3 + 1;
                bArr[i3] = (byte) ((int) (j >> 16));
                int i5 = i4 + 1;
                bArr[i4] = (byte) ((int) (j >> 24));
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((int) (j >> 32));
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((int) (j >> 40));
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((int) (j >> 48));
                this.zze = i8 + 1;
                bArr[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zzb(int i, int i2) throws IOException {
            zzc(i, 0);
            zzb(i2);
        }

        public final void zzb(int i) throws IOException {
            if (i >= 0) {
                zzc(i);
            } else {
                zzb((long) i);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzkj zzkj, zzlb zzlb) throws IOException {
            zzc(i, 2);
            zzc(((zzhd) zzkj).zza(zzlb));
            zzlb.zza(zzkj, (zzmw) this.zza);
        }

        public final void zza(zzkj zzkj) throws IOException {
            zzc(zzkj.zzbw());
            zzkj.zza(this);
        }

        public final void zza(int i, zzkj zzkj) throws IOException {
            zzc(1, 3);
            zzd(2, i);
            zzc(3, 2);
            zza(zzkj);
            zzc(1, 4);
        }

        public final void zzb(int i, zzhm zzhm) throws IOException {
            zzc(1, 3);
            zzd(2, i);
            zza(3, zzhm);
            zzc(1, 4);
        }

        public final void zza(int i, String str) throws IOException {
            zzc(i, 2);
            zza(str);
        }

        public final void zza(String str) throws IOException {
            int i = this.zze;
            try {
                int zzj = zzj(str.length() * 3);
                int zzj2 = zzj(str.length());
                if (zzj2 == zzj) {
                    int i2 = i + zzj2;
                    this.zze = i2;
                    int zza = zzmh.zza(str, this.zzb, i2, zza());
                    this.zze = i;
                    zzc((zza - i) - zzj2);
                    this.zze = zza;
                    return;
                }
                zzc(zzmh.zza((CharSequence) str));
                this.zze = zzmh.zza(str, this.zzb, this.zze, zza());
            } catch (zzmk e) {
                this.zze = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final void zzc(int i, int i2) throws IOException {
            zzc((i << 3) | i2);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzc(i2);
        }

        public final void zzc(int i) throws IOException {
            while ((i & -128) != 0) {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzb;
                int i3 = this.zze;
                this.zze = i3 + 1;
                bArr2[i3] = (byte) i;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zzb(int i, long j) throws IOException {
            zzc(i, 0);
            zzb(j);
        }

        public final void zzb(long j) throws IOException {
            if (!zzig.zzc || zza() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zze;
                    this.zze = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    zzmg.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzmg.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzc(long j) {
        return 8;
    }

    public static int zze(int i) {
        return 4;
    }

    public static int zze(long j) {
        return 8;
    }

    public static int zzg(int i) {
        return 4;
    }

    public static int zzg(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzj(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    private static int zzl(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zza(int i) throws IOException;

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzhm zzhm) throws IOException;

    public abstract void zza(int i, zzkj zzkj) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzkj zzkj, zzlb zzlb) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(zzhm zzhm) throws IOException;

    public abstract void zza(zzkj zzkj) throws IOException;

    public abstract void zza(String str) throws IOException;

    public abstract void zzb(int i) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, long j) throws IOException;

    public abstract void zzb(int i, zzhm zzhm) throws IOException;

    public abstract void zzb(long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(int i) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzb(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static int zzb(int i, boolean z) {
        return zzj(i << 3) + 1;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzj(length) + length;
    }

    public static int zzc(int i, zzhm zzhm) {
        int zzj = zzj(i << 3);
        int zzb2 = zzhm.zzb();
        return zzj + zzj(zzb2) + zzb2;
    }

    public static int zzb(zzhm zzhm) {
        int zzb2 = zzhm.zzb();
        return zzj(zzb2) + zzb2;
    }

    public static int zza(int i, double d) {
        return zzj(i << 3) + 8;
    }

    public static int zze(int i, int i2) {
        return zzj(i << 3) + zzf(i2);
    }

    public static int zzd(int i) {
        return zzf(i);
    }

    public static int zzf(int i, int i2) {
        return zzj(i << 3) + 4;
    }

    public static int zzc(int i, long j) {
        return zzj(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzj(i << 3) + 4;
    }

    @Deprecated
    static int zzb(int i, zzkj zzkj, zzlb zzlb) {
        return (zzj(i << 3) << 1) + ((zzhd) zzkj).zza(zzlb);
    }

    @Deprecated
    public static int zzb(zzkj zzkj) {
        return zzkj.zzbw();
    }

    public static int zzg(int i, int i2) {
        return zzj(i << 3) + zzf(i2);
    }

    public static int zzf(int i) {
        if (i >= 0) {
            return zzj(i);
        }
        return 10;
    }

    public static int zzd(int i, long j) {
        return zzj(i << 3) + zzg(j);
    }

    public static int zzd(long j) {
        return zzg(j);
    }

    public static int zza(int i, zzjn zzjn) {
        return (zzj(8) << 1) + zzj(2, i) + zzb(3, zzjn);
    }

    public static int zzb(int i, zzjn zzjn) {
        int zzj = zzj(i << 3);
        int zzb2 = zzjn.zzb();
        return zzj + zzj(zzb2) + zzb2;
    }

    public static int zza(zzjn zzjn) {
        int zzb2 = zzjn.zzb();
        return zzj(zzb2) + zzb2;
    }

    public static int zzb(int i, zzkj zzkj) {
        return (zzj(8) << 1) + zzj(2, i) + zzj(24) + zzc(zzkj);
    }

    static int zzc(int i, zzkj zzkj, zzlb zzlb) {
        return zzj(i << 3) + zza(zzkj, zzlb);
    }

    public static int zzc(zzkj zzkj) {
        int zzbw = zzkj.zzbw();
        return zzj(zzbw) + zzbw;
    }

    static int zza(zzkj zzkj, zzlb zzlb) {
        int zza2 = ((zzhd) zzkj).zza(zzlb);
        return zzj(zza2) + zza2;
    }

    public static int zzd(int i, zzhm zzhm) {
        return (zzj(8) << 1) + zzj(2, i) + zzc(3, zzhm);
    }

    public static int zzh(int i, int i2) {
        return zzj(i << 3) + 4;
    }

    public static int zze(int i, long j) {
        return zzj(i << 3) + 8;
    }

    public static int zzi(int i, int i2) {
        return zzj(i << 3) + zzj(zzl(i2));
    }

    public static int zzh(int i) {
        return zzj(zzl(i));
    }

    public static int zzf(int i, long j) {
        return zzj(i << 3) + zzg(zzi(j));
    }

    public static int zzf(long j) {
        return zzg(zzi(j));
    }

    public static int zzb(int i, String str) {
        return zzj(i << 3) + zzb(str);
    }

    public static int zzb(String str) {
        int i;
        try {
            i = zzmh.zza((CharSequence) str);
        } catch (zzmk unused) {
            i = str.getBytes(zziz.zza).length;
        }
        return zzj(i) + i;
    }

    public static int zzi(int i) {
        return zzj(i << 3);
    }

    public static int zzj(int i, int i2) {
        return zzj(i << 3) + zzj(i2);
    }

    public static int zzg(int i, long j) {
        return zzj(i << 3) + zzg(j);
    }

    public static zzig zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    private zzig() {
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzmk zzmk) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzmk);
        byte[] bytes = str.getBytes(zziz.zza);
        try {
            zzc(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        }
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : 0);
    }

    public final void zzb(int i, double d) throws IOException {
        zza(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zza(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, float f) throws IOException {
        zza(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zza(Float.floatToRawIntBits(f));
    }

    public final void zzk(int i, int i2) throws IOException {
        zzd(i, zzl(i2));
    }

    public final void zzk(int i) throws IOException {
        zzc(zzl(i));
    }

    public final void zzh(int i, long j) throws IOException {
        zzb(i, zzi(j));
    }

    public final void zzh(long j) throws IOException {
        zzb(zzi(j));
    }
}
