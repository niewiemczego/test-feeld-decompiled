package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzon extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzon zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzon zzon = new zzon();
        zzb = zzon;
        zzit.zzD(zzon.class, zzon);
    }

    private zzon() {
    }

    public final String zzg() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzon();
        } else {
            if (i2 == 4) {
                return new zzom((zzoh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzi() {
        return this.zzf;
    }
}
