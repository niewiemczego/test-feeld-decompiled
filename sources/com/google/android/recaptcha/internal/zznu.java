package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zznu extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zznu zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private zzib zzi;
    private zzlj zzj;
    private int zzk;
    private zzna zzl;
    private zzjb zzm = zzx();

    static {
        zznu zznu = new zznu();
        zzb = zznu;
        zzit.zzD(zznu.class, zznu);
    }

    private zznu() {
    }

    public static zznu zzg() {
        return zzb;
    }

    public static zznu zzi(byte[] bArr) throws zzje {
        return (zznu) zzit.zzu(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\t\u0000\u0001\u0001\u000b\t\u0000\u0001\u0000\u0001\u0004\u0003ဉ\u0000\u0004ဉ\u0001\u0005\f\u0007\u001b\b\f\tȈ\nȈ\u000bဉ\u0002", new Object[]{"zzd", "zze", "zzi", "zzj", "zzk", "zzm", zznl.class, "zzf", "zzg", "zzh", "zzl"});
        } else if (i2 == 3) {
            return new zznu();
        } else {
            if (i2 == 4) {
                return new zznt((zzns) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
