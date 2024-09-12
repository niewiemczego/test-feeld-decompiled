package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzis extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zzis zzb;
    private int zzd;
    private int zze;

    static {
        zzis zzis = new zzis();
        zzb = zzis;
        zzex.zzp(zzis.class, zzis);
    }

    private zzis() {
    }

    public static zziq zzv() {
        return (zziq) zzb.zzg();
    }

    static /* synthetic */ void zzx(zzis zzis, int i) {
        zzis.zze = i - 1;
        zzis.zzd |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzir.zza});
        } else if (i2 == 3) {
            return new zzis();
        } else {
            if (i2 == 4) {
                return new zziq((zzip) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
