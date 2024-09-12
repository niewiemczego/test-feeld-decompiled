package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzil extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zzil zzb;
    private int zzd;
    private String zze = "";

    static {
        zzil zzil = new zzil();
        zzb = zzil;
        zzex.zzp(zzil.class, zzil);
    }

    private zzil() {
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        } else if (i2 == 3) {
            return new zzil();
        } else {
            if (i2 == 4) {
                return new zzik((zzij) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
