package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zziv extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zziv zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzio zzg;

    static {
        zziv zziv = new zziv();
        zzb = zziv;
        zzex.zzp(zziv.class, zziv);
    }

    private zziv() {
    }

    static /* synthetic */ void zzA(zziv zziv, zzic zzic) {
        zziv.zzf = zzic;
        zziv.zze = 3;
    }

    public static zziu zzv() {
        return (zziu) zzb.zzg();
    }

    static /* synthetic */ void zzx(zziv zziv, zziz zziz) {
        zziv.zzf = zziz;
        zziv.zze = 4;
    }

    static /* synthetic */ void zzy(zziv zziv, zzio zzio) {
        zziv.zzg = zzio;
        zziv.zzd |= 1;
    }

    static /* synthetic */ void zzz(zziv zziv, zzhy zzhy) {
        zziv.zzf = zzhy;
        zziv.zze = 2;
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzhy.class, zzic.class, zziz.class, zzil.class});
        } else if (i2 == 3) {
            return new zziv();
        } else {
            if (i2 == 4) {
                return new zziu((zzit) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
