package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzeb extends zzee {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    zzeb(byte[] bArr, int i, int i2) {
        super((zzed) null);
        int length = bArr.length;
        if (((length - i2) | i2) >= 0) {
            this.zzc = bArr;
            this.zze = 0;
            this.zzd = i2;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i2)}));
    }

    public final int zza() {
        return this.zzd - this.zze;
    }

    public final void zzd(int i, boolean z) throws IOException {
        zzq(i << 3);
        zzb(z ? (byte) 1 : 0);
    }

    public final void zze(int i, zzdw zzdw) throws IOException {
        zzq((i << 3) | 2);
        zzq(zzdw.zzd());
        zzdw.zzh(this);
    }

    public final void zzf(int i, int i2) throws IOException {
        zzq((i << 3) | 5);
        zzg(i2);
    }

    public final void zzg(int i) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i2 = this.zze;
            int i3 = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zze = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
        }
    }

    public final void zzh(int i, long j) throws IOException {
        zzq((i << 3) | 1);
        zzi(j);
    }

    public final void zzi(long j) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i = this.zze;
            int i2 = i + 1;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zze = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
        }
    }

    public final void zzj(int i, int i2) throws IOException {
        zzq(i << 3);
        zzk(i2);
    }

    public final void zzk(int i) throws IOException {
        if (i >= 0) {
            zzq(i);
        } else {
            zzs((long) i);
        }
    }

    public final void zzl(byte[] bArr, int i, int i2) throws IOException {
        zzc(bArr, 0, i2);
    }

    public final void zzm(int i, String str) throws IOException {
        zzq((i << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i = this.zze;
        try {
            int zzx = zzx(str.length() * 3);
            int zzx2 = zzx(str.length());
            if (zzx2 == zzx) {
                int i2 = i + zzx2;
                this.zze = i2;
                int zzb = zzhs.zzb(str, this.zzc, i2, this.zzd - i2);
                this.zze = i;
                zzq((zzb - i) - zzx2);
                this.zze = zzb;
                return;
            }
            zzq(zzhs.zzc(str));
            byte[] bArr = this.zzc;
            int i3 = this.zze;
            this.zze = zzhs.zzb(str, bArr, i3, this.zzd - i3);
        } catch (zzhr e) {
            this.zze = i;
            zzB(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzec(e2);
        }
    }

    public final void zzo(int i, int i2) throws IOException {
        zzq((i << 3) | i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        zzq(i << 3);
        zzq(i2);
    }

    public final void zzr(int i, long j) throws IOException {
        zzq(i << 3);
        zzs(j);
    }

    public final void zzb(byte b) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i = this.zze;
            this.zze = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i2);
            this.zze += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)}), e);
        }
    }

    public final void zzq(int i) throws IOException {
        while ((i & -128) != 0) {
            byte[] bArr = this.zzc;
            int i2 = this.zze;
            this.zze = i2 + 1;
            bArr[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
        }
        try {
            byte[] bArr2 = this.zzc;
            int i3 = this.zze;
            this.zze = i3 + 1;
            bArr2[i3] = (byte) i;
        } catch (IndexOutOfBoundsException e) {
            throw new zzec(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
        }
    }

    public final void zzs(long j) throws IOException {
        if (!zzee.zzd || this.zzd - this.zze < 10) {
            while ((j & -128) != 0) {
                byte[] bArr = this.zzc;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzc;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr2[i2] = (byte) ((int) j);
            } catch (IndexOutOfBoundsException e) {
                throw new zzec(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e);
            }
        } else {
            while (true) {
                int i3 = (int) j;
                if ((j & -128) == 0) {
                    byte[] bArr3 = this.zzc;
                    int i4 = this.zze;
                    this.zze = i4 + 1;
                    zzhn.zzn(bArr3, (long) i4, (byte) i3);
                    return;
                }
                byte[] bArr4 = this.zzc;
                int i5 = this.zze;
                this.zze = i5 + 1;
                zzhn.zzn(bArr4, (long) i5, (byte) ((i3 & 127) | 128));
                j >>>= 7;
            }
        }
    }
}
