package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
class zzgt extends zzgs {
    protected final byte[] zza;

    zzgt(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgw) || zzd() != ((zzgw) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgt)) {
            return obj.equals(this);
        }
        zzgt zzgt = (zzgt) obj;
        int zzl = zzl();
        int zzl2 = zzgt.zzl();
        if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzgt.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd > zzgt.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzgt.zzd());
        } else if (!(zzgt instanceof zzgt)) {
            return zzgt.zzg(0, zzd).equals(zzg(0, zzd));
        } else {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzgt.zza;
            zzgt.zzc();
            int i = 0;
            int i2 = 0;
            while (i < zzd) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zza[i];
    }

    /* access modifiers changed from: protected */
    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    /* access modifiers changed from: protected */
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: protected */
    public final int zzf(int i, int i2, int i3) {
        return zzjc.zzb(i, this.zza, 0, i3);
    }

    public final zzgw zzg(int i, int i2) {
        int zzk = zzk(0, i2, zzd());
        if (zzk == 0) {
            return zzgw.zzb;
        }
        return new zzgq(this.zza, 0, zzk);
    }

    /* access modifiers changed from: protected */
    public final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zzgm zzgm) throws IOException {
        ((zzhe) zzgm).zzc(this.zza, 0, zzd());
    }

    public final boolean zzj() {
        return zzma.zzf(this.zza, 0, zzd());
    }
}
