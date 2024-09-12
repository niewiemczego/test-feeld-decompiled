package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzoz extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzoz zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzoz zzoz = new zzoz();
        zzb = zzoz;
        zzit.zzD(zzoz.class, zzoz);
    }

    private zzoz() {
    }

    public static zzoz zzg(InputStream inputStream) throws IOException {
        return (zzoz) zzit.zzt(zzb, inputStream);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzoz();
        } else {
            if (i2 == 4) {
                return new zzoy((zzor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzpb zzi() {
        zzpb zzb2 = zzpb.zzb(this.zzf);
        return zzb2 == null ? zzpb.UNRECOGNIZED : zzb2;
    }
}
