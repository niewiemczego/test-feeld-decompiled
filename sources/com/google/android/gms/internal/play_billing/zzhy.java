package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzhy extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zzhy zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzii zzh;

    static {
        zzhy zzhy = new zzhy();
        zzb = zzhy;
        zzex.zzp(zzhy.class, zzhy);
    }

    private zzhy() {
    }

    static /* synthetic */ void zzA(zzhy zzhy, int i) {
        zzhy.zzg = i - 1;
        zzhy.zzd |= 1;
    }

    public static zzhx zzv() {
        return (zzhx) zzb.zzg();
    }

    public static zzhy zzx(byte[] bArr, zzej zzej) throws zzff {
        return (zzhy) zzex.zzj(zzb, bArr, zzej);
    }

    static /* synthetic */ void zzy(zzhy zzhy, zzii zzii) {
        zzii.getClass();
        zzhy.zzh = zzii;
        zzhy.zzd |= 2;
    }

    static /* synthetic */ void zzz(zzhy zzhy, zzis zzis) {
        zzis.getClass();
        zzhy.zzf = zzis;
        zzhy.zze = 4;
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzhz.zza, "zzh", zzis.class});
        } else if (i2 == 3) {
            return new zzhy();
        } else {
            if (i2 == 4) {
                return new zzhx((zzhw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
