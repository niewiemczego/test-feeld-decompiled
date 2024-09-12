package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzoj extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzoj zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzoj zzoj = new zzoj();
        zzb = zzoj;
        zzit.zzD(zzoj.class, zzoj);
    }

    private zzoj() {
    }

    static /* synthetic */ void zzH(zzoj zzoj, String str) {
        str.getClass();
        zzoj.zzd |= 32;
        zzoj.zzj = str;
    }

    static /* synthetic */ void zzI(zzoj zzoj, String str) {
        str.getClass();
        zzoj.zzd |= 64;
        zzoj.zzk = str;
    }

    static /* synthetic */ void zzJ(zzoj zzoj, String str) {
        str.getClass();
        zzoj.zzd |= 2;
        zzoj.zzf = str;
    }

    static /* synthetic */ void zzK(zzoj zzoj, String str) {
        str.getClass();
        zzoj.zzd |= 4;
        zzoj.zzg = str;
    }

    public static zzoi zzf() {
        return (zzoi) zzb.zzp();
    }

    static /* synthetic */ void zzi(zzoj zzoj, String str) {
        str.getClass();
        zzoj.zzd |= 1;
        zzoj.zze = str;
    }

    static /* synthetic */ void zzj(zzoj zzoj, String str) {
        str.getClass();
        zzoj.zzd |= 8;
        zzoj.zzh = str;
    }

    static /* synthetic */ void zzk(zzoj zzoj, String str) {
        str.getClass();
        zzoj.zzd |= 16;
        zzoj.zzi = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005\u0007ለ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzoj();
        } else {
            if (i2 == 4) {
                return new zzoi((zzoh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
