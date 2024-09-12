package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzpl extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzpl zzb;
    private zzjb zzd = zzx();
    private int zze;

    static {
        zzpl zzpl = new zzpl();
        zzb = zzpl;
        zzit.zzD(zzpl.class, zzpl);
    }

    private zzpl() {
    }

    public static zzpi zzf() {
        return (zzpi) zzb.zzp();
    }

    static /* synthetic */ void zzi(zzpl zzpl, zzpk zzpk) {
        zzpk.getClass();
        zzpl.zzk();
        zzpl.zzd.add(zzpk);
    }

    static /* synthetic */ void zzj(zzpl zzpl, Iterable iterable) {
        zzpl.zzk();
        zzgf.zzc(iterable, zzpl.zzd);
    }

    private final void zzk() {
        zzjb zzjb = this.zzd;
        if (!zzjb.zzc()) {
            this.zzd = zzit.zzy(zzjb);
        }
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u000b", new Object[]{"zzd", zzpk.class, "zze"});
        } else if (i2 == 3) {
            return new zzpl();
        } else {
            if (i2 == 4) {
                return new zzpi((zzor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
