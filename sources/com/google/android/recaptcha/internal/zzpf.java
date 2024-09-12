package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzpf extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzpf zzb;
    private zzjb zzd = zzx();

    static {
        zzpf zzpf = new zzpf();
        zzb = zzpf;
        zzit.zzD(zzpf.class, zzpf);
    }

    private zzpf() {
    }

    public static zzpf zzg(byte[] bArr) throws zzje {
        return (zzpf) zzit.zzu(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzpr.class});
        } else if (i2 == 3) {
            return new zzpf();
        } else {
            if (i2 == 4) {
                return new zzpe((zzor) null);
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
