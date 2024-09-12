package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzol extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzol zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private int zzg;
    private zzjb zzh = zzx();

    static {
        zzol zzol = new zzol();
        zzb = zzol;
        zzit.zzD(zzol.class, zzol);
    }

    private zzol() {
    }

    public static zzol zzg(InputStream inputStream) throws IOException {
        return (zzol) zzit.zzt(zzb, inputStream);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0001\u0000\u0001ለ\u0000\u0002ဂ\u0001\u0004ဌ\u0002\u0005\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzon.class});
        } else if (i2 == 3) {
            return new zzol();
        } else {
            if (i2 == 4) {
                return new zzok((zzoh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzi() {
        return this.zze;
    }

    public final List zzj() {
        return this.zzh;
    }
}
