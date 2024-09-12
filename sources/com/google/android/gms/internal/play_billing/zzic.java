package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzic extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zzic zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        zzic zzic = new zzic();
        zzb = zzic;
        zzex.zzp(zzic.class, zzic);
    }

    private zzic() {
    }

    public static zzib zzv() {
        return (zzib) zzb.zzg();
    }

    static /* synthetic */ void zzx(zzic zzic, zzis zzis) {
        zzis.getClass();
        zzic.zzf = zzis;
        zzic.zze = 2;
    }

    static /* synthetic */ void zzy(zzic zzic, int i) {
        zzic.zzg = i - 1;
        zzic.zzd |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0002\u0001\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzhz.zza, zzis.class});
        } else if (i2 == 3) {
            return new zzic();
        } else {
            if (i2 == 4) {
                return new zzib((zzia) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
