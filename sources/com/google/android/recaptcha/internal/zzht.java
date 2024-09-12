package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzht extends zzip implements zzkf {
    /* access modifiers changed from: private */
    public static final zzht zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private byte zzl = 2;

    static {
        zzht zzht = new zzht();
        zzd = zzht;
        zzit.zzD(zzht.class, zzht);
    }

    private zzht() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        byte b = 1;
        if (i2 == 2) {
            return new zzkp(zzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"zze", "zzf", zzho.zza, "zzg", zzhn.zza, "zzh", zzhr.zza, "zzi", zzhs.zza, "zzj", zzhq.zza, "zzk", zzhp.zza});
        } else if (i2 == 3) {
            return new zzht();
        } else {
            if (i2 == 4) {
                return new zzhm((zzhj) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzl = b;
            return null;
        }
    }
}
