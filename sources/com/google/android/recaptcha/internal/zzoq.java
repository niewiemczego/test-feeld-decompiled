package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzoq extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzoq zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzoq zzoq = new zzoq();
        zzb = zzoq;
        zzit.zzD(zzoq.class, zzoq);
    }

    private zzoq() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000$\u0001\u0000\u0001$$\u0000\u0000\u0000\u0001?\u0000\u0002?\u0000\u0003?\u0000\u0004?\u0000\u0005?\u0000\u0006?\u0000\u0007?\u0000\b?\u0000\t?\u0000\n?\u0000\u000b?\u0000\f?\u0000\r?\u0000\u000e?\u0000\u000f?\u0000\u0010?\u0000\u0011?\u0000\u0012?\u0000\u0013?\u0000\u0014?\u0000\u0015?\u0000\u0016?\u0000\u0017?\u0000\u0018?\u0000\u0019?\u0000\u001a?\u0000\u001b?\u0000\u001c?\u0000\u001d?\u0000\u001e?\u0000\u001f?\u0000 ?\u0000!?\u0000\"?\u0000#?\u0000$?\u0000", new Object[]{"zze", "zzd"});
        } else if (i2 == 3) {
            return new zzoq();
        } else {
            if (i2 == 4) {
                return new zzop((zzoo) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
