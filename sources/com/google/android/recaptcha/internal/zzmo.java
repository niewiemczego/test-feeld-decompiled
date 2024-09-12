package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzmo extends zzit implements zzkf {
    private static final zziz zzb = new zzmm();
    /* access modifiers changed from: private */
    public static final zzmo zzd;
    /* access modifiers changed from: private */
    public int zze;
    private String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zziy zzk = zzv();

    static {
        zzmo zzmo = new zzmo();
        zzd = zzmo;
        zzit.zzD(zzmo.class, zzmo);
    }

    private zzmo() {
    }

    static /* synthetic */ void zzH(zzmo zzmo, String str) {
        str.getClass();
        zzmo.zzf = str;
    }

    static /* synthetic */ void zzJ(zzmo zzmo, String str) {
        str.getClass();
        zzmo.zzh = str;
    }

    public static zzmn zzf() {
        return (zzmn) zzd.zzp();
    }

    static /* synthetic */ void zzj(zzmo zzmo, String str) {
        str.getClass();
        zzmo.zzi = str;
    }

    static /* synthetic */ void zzk(zzmo zzmo, String str) {
        str.getClass();
        zzmo.zzj = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzd, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007,", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzmo();
        } else {
            if (i2 == 4) {
                return new zzmn((zzmm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzd;
        }
    }
}
