package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzhx extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzhx zzb;
    private int zzd;
    private zzjb zze = zzko.zze();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private double zzi;
    private zzgw zzj = zzgw.zzb;
    private String zzk = "";
    private byte zzl = 2;

    static {
        zzhx zzhx = new zzhx();
        zzb = zzhx;
        zzit.zzD(zzhx.class, zzhx);
    }

    private zzhx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        byte b = 1;
        if (i2 == 2) {
            return new zzkp(zzb, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zzd", "zze", zzhw.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzhx();
        } else {
            if (i2 == 4) {
                return new zzhu((zzhj) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzl = b;
            return null;
        }
    }
}
