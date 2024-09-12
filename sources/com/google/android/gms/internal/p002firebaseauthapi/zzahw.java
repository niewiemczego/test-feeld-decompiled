package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
class zzahw extends zzahx {
    protected final byte[] zzb;

    public byte zza(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: protected */
    public int zzh() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        return zzajc.zza(i, this.zzb, zzh(), i3);
    }

    public int zzb() {
        return this.zzb.length;
    }

    public final zzahm zza(int i, int i2) {
        int zza = zza(0, i2, zzb());
        if (zza == 0) {
            return zzahm.zza;
        }
        return new zzahq(this.zzb, zzh(), zza);
    }

    public final zzaib zzc() {
        return zzaib.zza(this.zzb, zzh(), zzb(), true);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzb, zzh(), zzb(), charset);
    }

    zzahw(byte[] bArr) {
        bArr.getClass();
        this.zzb = bArr;
    }

    /* access modifiers changed from: protected */
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzahn zzahn) throws IOException {
        zzahn.zza(this.zzb, zzh(), zzb());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzahm) || zzb() != ((zzahm) obj).zzb()) {
            return false;
        }
        if (zzb() == 0) {
            return true;
        }
        if (!(obj instanceof zzahw)) {
            return obj.equals(this);
        }
        zzahw zzahw = (zzahw) obj;
        int zza = zza();
        int zza2 = zzahw.zza();
        if (zza == 0 || zza2 == 0 || zza == zza2) {
            return zza(zzahw, 0, zzb());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzahm zzahm, int i, int i2) {
        if (i2 > zzahm.zzb()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzb());
        } else if (i2 > zzahm.zzb()) {
            throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + i2 + ", " + zzahm.zzb());
        } else if (!(zzahm instanceof zzahw)) {
            return zzahm.zza(0, i2).equals(zza(0, i2));
        } else {
            zzahw zzahw = (zzahw) zzahm;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzahw.zzb;
            int zzh = zzh() + i2;
            int zzh2 = zzh();
            int zzh3 = zzahw.zzh();
            while (zzh2 < zzh) {
                if (bArr[zzh2] != bArr2[zzh3]) {
                    return false;
                }
                zzh2++;
                zzh3++;
            }
            return true;
        }
    }

    public final boolean zzf() {
        int zzh = zzh();
        return zzaml.zzc(this.zzb, zzh, zzb() + zzh);
    }
}
