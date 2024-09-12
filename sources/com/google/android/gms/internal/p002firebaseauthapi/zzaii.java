package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzaii extends zzahn {
    private static final Logger zzb = Logger.getLogger(zzaii.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzamh.zzc();
    zzaik zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    private static class zza extends zzaii {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        public final int zza() {
            return this.zzd - this.zze;
        }

        public final void zzc() {
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
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)}), e);
            }
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzj(i, 0);
            zza(z ? (byte) 1 : 0);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzl(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzc(int i, zzahm zzahm) throws IOException {
            zzj(i, 2);
            zzb(zzahm);
        }

        public final void zzb(zzahm zzahm) throws IOException {
            zzl(zzahm.zzb());
            zzahm.zza((zzahn) this);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzj(i, 5);
            zzi(i2);
        }

        public final void zzi(int i) throws IOException {
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
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zzf(int i, long j) throws IOException {
            zzj(i, 1);
            zzf(j);
        }

        public final void zzf(long j) throws IOException {
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
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zzh(int i, int i2) throws IOException {
            zzj(i, 0);
            zzj(i2);
        }

        public final void zzj(int i) throws IOException {
            if (i >= 0) {
                zzl(i);
            } else {
                zzh((long) i);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zzc(int i, zzakk zzakk, zzalc zzalc) throws IOException {
            zzj(i, 2);
            zzl(((zzahd) zzakk).zza(zzalc));
            zzalc.zza(zzakk, (zzanb) this.zza);
        }

        public final void zzc(zzakk zzakk) throws IOException {
            zzl(zzakk.zzk());
            zzakk.zza(this);
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzakk zzakk, zzalc zzalc) throws IOException {
            zzl(((zzahd) zzakk).zza(zzalc));
            zzalc.zza(zzakk, (zzanb) this.zza);
        }

        public final void zzb(int i, zzakk zzakk) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzc(zzakk);
            zzj(1, 4);
        }

        public final void zzd(int i, zzahm zzahm) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzahm);
            zzj(1, 4);
        }

        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        public final void zzb(String str) throws IOException {
            int i = this.zze;
            try {
                int zzh = zzh(str.length() * 3);
                int zzh2 = zzh(str.length());
                if (zzh2 == zzh) {
                    int i2 = i + zzh2;
                    this.zze = i2;
                    int zza = zzaml.zza(str, this.zzb, i2, zza());
                    this.zze = i;
                    zzl((zza - i) - zzh2);
                    this.zze = zza;
                    return;
                }
                zzl(zzaml.zza(str));
                this.zze = zzaml.zza(str, this.zzb, this.zze, zza());
            } catch (zzamp e) {
                this.zze = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzd(e2);
            }
        }

        public final void zzj(int i, int i2) throws IOException {
            zzl((i << 3) | i2);
        }

        public final void zzk(int i, int i2) throws IOException {
            zzj(i, 0);
            zzl(i2);
        }

        public final void zzl(int i) throws IOException {
            while ((i & -128) != 0) {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr[i2] = (byte) (i | 128);
                i >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzb;
                int i3 = this.zze;
                this.zze = i3 + 1;
                bArr2[i3] = (byte) i;
            } catch (IndexOutOfBoundsException e) {
                throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        }

        public final void zzh(int i, long j) throws IOException {
            zzj(i, 0);
            zzh(j);
        }

        public final void zzh(long j) throws IOException {
            if (!zzaii.zzc || zza() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zze;
                    this.zze = i + 1;
                    bArr[i] = (byte) (((int) j) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzd(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    zzamh.zza(bArr3, (long) i3, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.zzb;
                int i4 = this.zze;
                this.zze = i4 + 1;
                zzamh.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    private static abstract class zzb extends zzaii {
        final byte[] zzb;
        final int zzc;
        int zzd;
        int zze;

        public final int zza() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        zzb(int i) {
            super();
            if (i >= 0) {
                byte[] bArr = new byte[Math.max(i, 20)];
                this.zzb = bArr;
                this.zzc = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void zzb(byte b) {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            this.zzd = i + 1;
            bArr[i] = b;
            this.zze++;
        }

        /* access modifiers changed from: package-private */
        public final void zzm(int i) {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            int i3 = i2 + 1;
            bArr[i2] = (byte) i;
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i >> 8);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (i >> 16);
            this.zzd = i5 + 1;
            bArr[i5] = (byte) (i >>> 24);
            this.zze += 4;
        }

        /* access modifiers changed from: package-private */
        public final void zzi(long j) {
            byte[] bArr = this.zzb;
            int i = this.zzd;
            int i2 = i + 1;
            bArr[i] = (byte) ((int) (j & 255));
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((int) ((j >> 8) & 255));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) ((j >> 16) & 255));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (255 & (j >> 24)));
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((int) (j >> 32));
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((int) (j >> 40));
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((int) (j >> 48));
            this.zzd = i8 + 1;
            bArr[i8] = (byte) ((int) (j >> 56));
            this.zze += 8;
        }

        /* access modifiers changed from: package-private */
        public final void zzl(int i, int i2) {
            zzn((i << 3) | i2);
        }

        /* access modifiers changed from: package-private */
        public final void zzn(int i) {
            if (zzaii.zzc) {
                long j = (long) this.zzd;
                while ((i & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    zzamh.zza(bArr, (long) i2, (byte) (i | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                zzamh.zza(bArr2, (long) i3, (byte) i);
                this.zze += (int) (((long) this.zzd) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                bArr3[i4] = (byte) (i | 128);
                this.zze++;
                i >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i5 = this.zzd;
            this.zzd = i5 + 1;
            bArr4[i5] = (byte) i;
            this.zze++;
        }

        /* access modifiers changed from: package-private */
        public final void zzj(long j) {
            if (zzaii.zzc) {
                long j2 = (long) this.zzd;
                while ((j & -128) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zzd;
                    this.zzd = i + 1;
                    zzamh.zza(bArr, (long) i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zzd;
                this.zzd = i2 + 1;
                zzamh.zza(bArr2, (long) i2, (byte) ((int) j));
                this.zze += (int) (((long) this.zzd) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr3[i3] = (byte) (((int) j) | 128);
                this.zze++;
                j >>>= 7;
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr4[i4] = (byte) ((int) j);
            this.zze++;
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zza(long j) {
        return 8;
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j) {
        return 8;
    }

    static int zzd(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zze(int i) {
        return 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zzb(int i, zzakk zzakk) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzahm zzahm) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(zzakk zzakk, zzalc zzalc) throws IOException;

    public abstract void zzb(String str) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc() throws IOException;

    public abstract void zzc(int i, zzahm zzahm) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzc(int i, zzakk zzakk, zzalc zzalc) throws IOException;

    public abstract void zzc(zzakk zzakk) throws IOException;

    public abstract void zzd(int i, zzahm zzahm) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(long j) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    public abstract void zzl(int i) throws IOException;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zzd */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class zzd extends IOException {
        zzd() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzd(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzd(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static int zza(int i, boolean z) {
        return zzh(i << 3) + 1;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii$zzc */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    private static final class zzc extends zzb {
        private final OutputStream zzf;

        zzc(OutputStream outputStream, int i) {
            super(i);
            if (outputStream != null) {
                this.zzf = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private final void zze() throws IOException {
            this.zzf.write(this.zzb, 0, this.zzd);
            this.zzd = 0;
        }

        public final void zzc() throws IOException {
            if (this.zzd > 0) {
                zze();
            }
        }

        private final void zzo(int i) throws IOException {
            if (this.zzc - this.zzd < i) {
                zze();
            }
        }

        public final void zza(byte b) throws IOException {
            if (this.zzd == this.zzc) {
                zze();
            }
            zzb(b);
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            if (this.zzc - this.zzd >= i2) {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } else {
                int i3 = this.zzc - this.zzd;
                System.arraycopy(bArr, i, this.zzb, this.zzd, i3);
                int i4 = i + i3;
                i2 -= i3;
                this.zzd = this.zzc;
                this.zze += i3;
                zze();
                if (i2 <= this.zzc) {
                    System.arraycopy(bArr, i4, this.zzb, 0, i2);
                    this.zzd = i2;
                } else {
                    this.zzf.write(bArr, i4, i2);
                }
            }
            this.zze += i2;
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzo(11);
            zzl(i, 0);
            zzb(z ? (byte) 1 : 0);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzl(i2);
            zzc(bArr, 0, i2);
        }

        public final void zzc(int i, zzahm zzahm) throws IOException {
            zzj(i, 2);
            zzb(zzahm);
        }

        public final void zzb(zzahm zzahm) throws IOException {
            zzl(zzahm.zzb());
            zzahm.zza((zzahn) this);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzo(14);
            zzl(i, 5);
            zzm(i2);
        }

        public final void zzi(int i) throws IOException {
            zzo(4);
            zzm(i);
        }

        public final void zzf(int i, long j) throws IOException {
            zzo(18);
            zzl(i, 1);
            zzi(j);
        }

        public final void zzf(long j) throws IOException {
            zzo(8);
            zzi(j);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzo(20);
            zzl(i, 0);
            if (i2 >= 0) {
                zzn(i2);
            } else {
                zzj((long) i2);
            }
        }

        public final void zzj(int i) throws IOException {
            if (i >= 0) {
                zzl(i);
            } else {
                zzh((long) i);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zzc(int i, zzakk zzakk, zzalc zzalc) throws IOException {
            zzj(i, 2);
            zzb(zzakk, zzalc);
        }

        public final void zzc(zzakk zzakk) throws IOException {
            zzl(zzakk.zzk());
            zzakk.zza(this);
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzakk zzakk, zzalc zzalc) throws IOException {
            zzl(((zzahd) zzakk).zza(zzalc));
            zzalc.zza(zzakk, (zzanb) this.zza);
        }

        public final void zzb(int i, zzakk zzakk) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzc(zzakk);
            zzj(1, 4);
        }

        public final void zzd(int i, zzahm zzahm) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zzahm);
            zzj(1, 4);
        }

        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        public final void zzb(String str) throws IOException {
            int i;
            int i2;
            try {
                int length = str.length() * 3;
                int zzh = zzh(length);
                int i3 = zzh + length;
                if (i3 > this.zzc) {
                    byte[] bArr = new byte[length];
                    int zza = zzaml.zza(str, bArr, 0, length);
                    zzl(zza);
                    zza(bArr, 0, zza);
                    return;
                }
                if (i3 > this.zzc - this.zzd) {
                    zze();
                }
                int zzh2 = zzh(str.length());
                i = this.zzd;
                if (zzh2 == zzh) {
                    this.zzd = i + zzh2;
                    int zza2 = zzaml.zza(str, this.zzb, this.zzd, this.zzc - this.zzd);
                    this.zzd = i;
                    i2 = (zza2 - i) - zzh2;
                    zzn(i2);
                    this.zzd = zza2;
                } else {
                    i2 = zzaml.zza(str);
                    zzn(i2);
                    this.zzd = zzaml.zza(str, this.zzb, this.zzd, i2);
                }
                this.zze += i2;
            } catch (zzamp e) {
                this.zze -= this.zzd - i;
                this.zzd = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzd(e2);
            } catch (zzamp e3) {
                zza(str, e3);
            }
        }

        public final void zzj(int i, int i2) throws IOException {
            zzl((i << 3) | i2);
        }

        public final void zzk(int i, int i2) throws IOException {
            zzo(20);
            zzl(i, 0);
            zzn(i2);
        }

        public final void zzl(int i) throws IOException {
            zzo(5);
            zzn(i);
        }

        public final void zzh(int i, long j) throws IOException {
            zzo(20);
            zzl(i, 0);
            zzj(j);
        }

        public final void zzh(long j) throws IOException {
            zzo(10);
            zzj(j);
        }
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzh(length) + length;
    }

    public static int zza(int i, zzahm zzahm) {
        int zzh = zzh(i << 3);
        int zzb2 = zzahm.zzb();
        return zzh + zzh(zzb2) + zzb2;
    }

    public static int zza(zzahm zzahm) {
        int zzb2 = zzahm.zzb();
        return zzh(zzb2) + zzb2;
    }

    public static int zza(int i, double d) {
        return zzh(i << 3) + 8;
    }

    public static int zza(int i, int i2) {
        return zzh(i << 3) + zze((long) i2);
    }

    public static int zza(int i) {
        return zze((long) i);
    }

    public static int zzb(int i, int i2) {
        return zzh(i << 3) + 4;
    }

    public static int zza(int i, long j) {
        return zzh(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzh(i << 3) + 4;
    }

    @Deprecated
    static int zza(int i, zzakk zzakk, zzalc zzalc) {
        return (zzh(i << 3) << 1) + ((zzahd) zzakk).zza(zzalc);
    }

    @Deprecated
    public static int zza(zzakk zzakk) {
        return zzakk.zzk();
    }

    public static int zzc(int i, int i2) {
        return zzh(i << 3) + zze((long) i2);
    }

    public static int zzc(int i) {
        return zze((long) i);
    }

    public static int zzb(int i, long j) {
        return zzh(i << 3) + zze(j);
    }

    public static int zzb(long j) {
        return zze(j);
    }

    public static int zza(int i, zzajo zzajo) {
        return (zzh(8) << 1) + zzf(2, i) + zzb(3, zzajo);
    }

    public static int zzb(int i, zzajo zzajo) {
        int zzh = zzh(i << 3);
        int zzb2 = zzajo.zzb();
        return zzh + zzh(zzb2) + zzb2;
    }

    public static int zza(zzajo zzajo) {
        int zzb2 = zzajo.zzb();
        return zzh(zzb2) + zzb2;
    }

    public static int zza(int i, zzakk zzakk) {
        return (zzh(8) << 1) + zzf(2, i) + zzh(24) + zzb(zzakk);
    }

    static int zzb(int i, zzakk zzakk, zzalc zzalc) {
        return zzh(i << 3) + zza(zzakk, zzalc);
    }

    public static int zzb(zzakk zzakk) {
        int zzk = zzakk.zzk();
        return zzh(zzk) + zzk;
    }

    static int zza(zzakk zzakk, zzalc zzalc) {
        int zza2 = ((zzahd) zzakk).zza(zzalc);
        return zzh(zza2) + zza2;
    }

    public static int zzb(int i, zzahm zzahm) {
        return (zzh(8) << 1) + zzf(2, i) + zza(3, zzahm);
    }

    public static int zzd(int i, int i2) {
        return zzh(i << 3) + 4;
    }

    public static int zzc(int i, long j) {
        return zzh(i << 3) + 8;
    }

    public static int zze(int i, int i2) {
        return zzh(i << 3) + zzh(zzm(i2));
    }

    public static int zzf(int i) {
        return zzh(zzm(i));
    }

    public static int zzd(int i, long j) {
        return zzh(i << 3) + zze(zzi(j));
    }

    public static int zzd(long j) {
        return zze(zzi(j));
    }

    public static int zza(int i, String str) {
        return zzh(i << 3) + zza(str);
    }

    public static int zza(String str) {
        int i;
        try {
            i = zzaml.zza(str);
        } catch (zzamp unused) {
            i = str.getBytes(zzajc.zza).length;
        }
        return zzh(i) + i;
    }

    public static int zzg(int i) {
        return zzh(i << 3);
    }

    public static int zzf(int i, int i2) {
        return zzh(i << 3) + zzh(i2);
    }

    public static int zzh(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zze(int i, long j) {
        return zzh(i << 3) + zze(j);
    }

    public static int zze(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzaii zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static zzaii zza(OutputStream outputStream, int i) {
        return new zzc(outputStream, i);
    }

    private zzaii() {
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzamp zzamp) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzamp);
        byte[] bytes = str.getBytes(zzajc.zza);
        try {
            zzl(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzd(e);
        }
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : 0);
    }

    public final void zzb(int i, double d) throws IOException {
        zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zzi(Float.floatToRawIntBits(f));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzk(i, zzm(i2));
    }

    public final void zzk(int i) throws IOException {
        zzl(zzm(i));
    }

    public final void zzg(int i, long j) throws IOException {
        zzh(i, zzi(j));
    }

    public final void zzg(long j) throws IOException {
        zzh(zzi(j));
    }
}
