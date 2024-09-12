package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zznz extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zznz zzb;
    private int zzd;
    private zznx zze;
    private zznx zzf;

    static {
        zznz zznz = new zznz();
        zzb = zznz;
        zzit.zzD(zznz.class, zznz);
    }

    private zznz() {
    }

    public static zznz zzj(byte[] bArr) throws zzje {
        return (zznz) zzit.zzu(zzb, bArr);
    }

    public final zznx zzf() {
        zznx zznx = this.zze;
        return zznx == null ? zznx.zzg() : zznx;
    }

    public final zznx zzg() {
        zznx zznx = this.zzf;
        return zznx == null ? zznx.zzg() : zznx;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zznz();
        } else {
            if (i2 == 4) {
                return new zzny((zznv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
