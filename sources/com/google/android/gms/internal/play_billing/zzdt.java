package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
class zzdt extends zzds {
    protected final byte[] zza;

    zzdt(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdw) || zzd() != ((zzdw) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzdt)) {
            return obj.equals(this);
        }
        zzdt zzdt = (zzdt) obj;
        int zzk = zzk();
        int zzk2 = zzdt.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzdt.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd > zzdt.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzdt.zzd());
        } else if (!(zzdt instanceof zzdt)) {
            return zzdt.zzf(0, zzd).equals(zzf(0, zzd));
        } else {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzdt.zza;
            zzdt.zzc();
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
    public final int zze(int i, int i2, int i3) {
        return zzfd.zzb(i, this.zza, 0, i3);
    }

    public final zzdw zzf(int i, int i2) {
        int zzj = zzj(0, i2, zzd());
        if (zzj == 0) {
            return zzdw.zzb;
        }
        return new zzdq(this.zza, 0, zzj);
    }

    /* access modifiers changed from: protected */
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzdm zzdm) throws IOException {
        ((zzeb) zzdm).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zzhs.zze(this.zza, 0, zzd());
    }
}
