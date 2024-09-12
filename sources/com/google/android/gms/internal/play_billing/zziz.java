package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zziz extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zziz zzb;
    private int zzd;
    private int zze;

    static {
        zziz zziz = new zziz();
        zzb = zziz;
        zzex.zzp(zziz.class, zziz);
    }

    private zziz() {
    }

    public static zziz zzw() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zziy.zza});
        } else if (i2 == 3) {
            return new zziz();
        } else {
            if (i2 == 4) {
                return new zzix((zziw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
