package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzot extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzot zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";

    static {
        zzot zzot = new zzot();
        zzb = zzot;
        zzit.zzD(zzot.class, zzot);
    }

    private zzot() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzot();
        } else {
            if (i2 == 4) {
                return new zzos((zzor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
