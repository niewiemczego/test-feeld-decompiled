package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzna extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzna zzb;
    private int zzd;
    private String zze = "";
    private int zzf;
    private String zzg = "";
    private int zzh;
    private String zzi = "";
    private int zzj;

    static {
        zzna zzna = new zzna();
        zzb = zzna;
        zzit.zzD(zzna.class, zzna);
    }

    private zzna() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005\u0004\u0006Ȉ\u0007\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzna();
        } else {
            if (i2 == 4) {
                return new zzmz((zzmy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
