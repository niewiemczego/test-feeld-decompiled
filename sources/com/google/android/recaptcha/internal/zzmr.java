package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzmr extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzmr zzb;
    private String zzd = "";
    private String zze = "";
    /* access modifiers changed from: private */
    public int zzf;
    private String zzg = "";
    /* access modifiers changed from: private */
    public String zzh = "";
    private int zzi;

    static {
        zzmr zzmr = new zzmr();
        zzb = zzmr;
        zzit.zzD(zzmr.class, zzmr);
    }

    private zzmr() {
    }

    static /* synthetic */ void zzH(zzmr zzmr, String str) {
        str.getClass();
        zzmr.zzd = str;
    }

    public static zzmq zzg() {
        return (zzmq) zzb.zzp();
    }

    public static zzmr zzj() {
        return zzb;
    }

    public final int zzf() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\u0004\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zzf", "zzh", "zzi", "zze", "zzg"});
        } else if (i2 == 3) {
            return new zzmr();
        } else {
            if (i2 == 4) {
                return new zzmq((zzmp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final String zzk() {
        return this.zzd;
    }
}
