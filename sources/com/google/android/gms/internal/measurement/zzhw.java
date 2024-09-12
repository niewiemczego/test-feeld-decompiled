package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
class zzhw extends zzhx {
    protected final byte[] zzb;

    public byte zza(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        return zziz.zza(i, this.zzb, zze(), i3);
    }

    public int zzb() {
        return this.zzb.length;
    }

    public final zzhm zza(int i, int i2) {
        int zza = zza(0, i2, zzb());
        if (zza == 0) {
            return zzhm.zza;
        }
        return new zzhq(this.zzb, zze(), zza);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zzb(), charset);
    }

    zzhw(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzhn zzhn) throws IOException {
        zzhn.zza(this.zzb, zze(), zzb());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhm) || zzb() != ((zzhm) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzhw)) {
            return obj.equals(this);
        }
        zzhw zzhw = (zzhw) obj;
        int zza = zza();
        int zza2 = zzhw.zza();
        if (zza == 0 || zza2 == 0 || zza == zza2) {
            return zza(zzhw, 0, zzb());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzhm zzhm, int i, int i2) {
        if (i2 > zzhm.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        } else if (i2 > zzhm.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + i2 + ", " + zzhm.zzb());
        } else if (!(zzhm instanceof zzhw)) {
            return zzhm.zza(0, i2).equals(zza(0, i2));
        } else {
            zzhw zzhw = (zzhw) zzhm;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzhw.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzhw.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    public final boolean zzd() {
        int zze = zze();
        return zzmh.zzc(this.zzb, zze, zzb() + zze);
    }
}
