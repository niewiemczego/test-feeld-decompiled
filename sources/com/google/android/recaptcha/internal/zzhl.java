package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzhl extends zzip implements zzkf {
    /* access modifiers changed from: private */
    public static final zzhl zzd;
    private int zze;
    private boolean zzf;
    private zzht zzg;
    private boolean zzh;
    private zzjb zzi = zzko.zze();
    private byte zzj = 2;

    static {
        zzhl zzhl = new zzhl();
        zzd = zzhl;
        zzit.zzD(zzhl.class, zzhl);
    }

    private zzhl() {
    }

    public static zzhl zzg() {
        return zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        byte b = 1;
        if (i2 == 2) {
            return new zzkp(zzd, "\u0001\u0004\u0000\u0001\u0001ϧ\u0004\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002ϧЛ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzhx.class});
        } else if (i2 == 3) {
            return new zzhl();
        } else {
            if (i2 == 4) {
                return new zzhk((zzhj) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzj = b;
            return null;
        }
    }
}
