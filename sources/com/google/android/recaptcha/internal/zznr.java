package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zznr extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zznr zzb;
    private int zzd;
    private String zze = "";
    private zzmu zzf;
    private zzmo zzg;
    private zzmx zzh;
    private String zzi = "";
    private String zzj = "";

    static {
        zznr zznr = new zznr();
        zzb = zznr;
        zzit.zzD(zznr.class, zznr);
    }

    private zznr() {
    }

    static /* synthetic */ void zzH(zznr zznr, zzmo zzmo) {
        zzmo.getClass();
        zznr.zzg = zzmo;
        zznr.zzd |= 2;
    }

    public static zznq zzf() {
        return (zznq) zzb.zzp();
    }

    static /* synthetic */ void zzi(zznr zznr, String str) {
        str.getClass();
        zznr.zze = str;
    }

    static /* synthetic */ void zzj(zznr zznr, String str) {
        str.getClass();
        zznr.zzi = str;
    }

    static /* synthetic */ void zzk(zznr zznr, String str) {
        str.getClass();
        zznr.zzj = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zznr();
        } else {
            if (i2 == 4) {
                return new zznq((zznp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
