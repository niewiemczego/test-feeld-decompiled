package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzii extends zzex implements zzgd {
    /* access modifiers changed from: private */
    public static final zzii zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private int zzg;
    private String zzh = "";

    static {
        zzii zzii = new zzii();
        zzb = zzii;
        zzex.zzp(zzii.class, zzii);
    }

    private zzii() {
    }

    static /* synthetic */ void zzA(zzii zzii, int i) {
        zzii.zzg = i - 1;
        zzii.zzd |= 4;
    }

    public static zzie zzv() {
        return (zzie) zzb.zzg();
    }

    static /* synthetic */ void zzx(zzii zzii, int i) {
        zzii.zzd |= 1;
        zzii.zze = i;
    }

    static /* synthetic */ void zzy(zzii zzii, String str) {
        str.getClass();
        zzii.zzd |= 2;
        zzii.zzf = str;
    }

    static /* synthetic */ void zzz(zzii zzii, String str) {
        zzii.zzd |= 8;
        zzii.zzh = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzu(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzm(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzig.zza, "zzh"});
        } else if (i2 == 3) {
            return new zzii();
        } else {
            if (i2 == 4) {
                return new zzie((zzid) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
