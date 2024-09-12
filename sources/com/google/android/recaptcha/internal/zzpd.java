package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzpd extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzpd zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzpd zzpd = new zzpd();
        zzb = zzpd;
        zzit.zzD(zzpd.class, zzpd);
    }

    private zzpd() {
    }

    static /* synthetic */ void zzH(zzpd zzpd, zznf zznf) {
        zznf.getClass();
        zzpd.zze = zznf;
        zzpd.zzd = 1;
    }

    static /* synthetic */ void zzI(zzpd zzpd, zznu zznu) {
        zznu.getClass();
        zzpd.zze = zznu;
        zzpd.zzd = 2;
    }

    public static zzpc zzi() {
        return (zzpc) zzb.zzp();
    }

    public static zzpd zzk(byte[] bArr) throws zzje {
        return (zzpd) zzit.zzu(zzb, bArr);
    }

    public final int zzJ() {
        int i = this.zzd;
        if (i == 0) {
            return 3;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public final zznf zzf() {
        if (this.zzd == 1) {
            return (zznf) this.zze;
        }
        return zznf.zzH();
    }

    public final zznu zzg() {
        if (this.zzd == 2) {
            return (zznu) this.zze;
        }
        return zznu.zzg();
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zze", "zzd", zznf.class, zznu.class});
        } else if (i2 == 3) {
            return new zzpd();
        } else {
            if (i2 == 4) {
                return new zzpc((zzor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
