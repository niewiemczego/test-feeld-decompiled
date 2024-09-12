package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzhw extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzhw zzb;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private byte zzg = 2;

    static {
        zzhw zzhw = new zzhw();
        zzb = zzhw;
        zzit.zzD(zzhw.class, zzhw);
    }

    private zzhw() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b = 1;
        if (i2 == 2) {
            return new zzkp(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzhw();
        } else {
            if (i2 == 4) {
                return new zzhv((zzhj) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzg = b;
            return null;
        }
    }
}
