package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zznx extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zznx zzb;
    private zzjb zzd = zzit.zzx();

    static {
        zznx zznx = new zznx();
        zzb = zznx;
        zzit.zzD(zznx.class, zznx);
    }

    private zznx() {
    }

    public static zznx zzg() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zznx();
        } else {
            if (i2 == 4) {
                return new zznw((zznv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzi() {
        return this.zzd;
    }
}
