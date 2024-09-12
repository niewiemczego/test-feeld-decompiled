package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzml extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzml zzb;
    private int zzd;
    private zzib zze;
    private int zzf;

    static {
        zzml zzml = new zzml();
        zzb = zzml;
        zzit.zzD(zzml.class, zzml);
    }

    private zzml() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzml();
        } else {
            if (i2 == 4) {
                return new zzmk((zzmj) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
