package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzmu extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzmu zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzmu zzmu = new zzmu();
        zzb = zzmu;
        zzit.zzD(zzmu.class, zzmu);
    }

    private zzmu() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzmu();
        } else {
            if (i2 == 4) {
                return new zzmt((zzms) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
