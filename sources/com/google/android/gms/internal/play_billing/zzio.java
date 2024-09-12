package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzio extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zzio zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzio zzio = new zzio();
        zzb = zzio;
        zzex.zzp(zzio.class, zzio);
    }

    private zzio() {
    }

    public static zzin zzv() {
        return (zzin) zzb.zzg();
    }

    static /* synthetic */ void zzx(zzio zzio, String str) {
        str.getClass();
        zzio.zzd |= 1;
        zzio.zze = str;
    }

    static /* synthetic */ void zzy(zzio zzio, String str) {
        str.getClass();
        zzio.zzd |= 2;
        zzio.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzio();
        } else {
            if (i2 == 4) {
                return new zzin((zzim) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
