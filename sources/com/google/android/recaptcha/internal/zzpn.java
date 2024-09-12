package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzpn extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzpn zzb;
    private String zzd = "";
    private zziy zze = zzv();
    private zzja zzf = zzw();

    static {
        zzpn zzpn = new zzpn();
        zzb = zzpn;
        zzit.zzD(zzpn.class, zzpn);
    }

    private zzpn() {
    }

    public static zzpn zzg(byte[] bArr) throws zzje {
        return (zzpn) zzit.zzu(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001Ȉ\u0002'\u0003%", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzpn();
        } else {
            if (i2 == 4) {
                return new zzpm((zzor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzi() {
        return this.zzd;
    }

    public final List zzj() {
        return this.zzf;
    }
}
