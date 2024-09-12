package com.google.android.recaptcha.internal;

import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzni extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzni zzb;
    private zzjb zzd = zzx();
    private zzjb zze = zzx();

    static {
        zzni zzni = new zzni();
        zzb = zzni;
        zzit.zzD(zzni.class, zzni);
    }

    private zzni() {
    }

    static /* synthetic */ void zzI(zzni zzni, zznf zznf) {
        zznf.getClass();
        zzjb zzjb = zzni.zzd;
        if (!zzjb.zzc()) {
            zzni.zzd = zzit.zzy(zzjb);
        }
        zzni.zzd.add(zznf);
    }

    static /* synthetic */ void zzJ(zzni zzni, zznu zznu) {
        zznu.getClass();
        zzjb zzjb = zzni.zze;
        if (!zzjb.zzc()) {
            zzni.zze = zzit.zzy(zzjb);
        }
        zzni.zze.add(zznu);
    }

    public static zznh zzi() {
        return (zznh) zzb.zzp();
    }

    public static zzni zzk(byte[] bArr) throws zzje {
        return (zzni) zzit.zzu(zzb, bArr);
    }

    public final List zzH() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzd.size();
    }

    public final int zzg() {
        return this.zze.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzd", zznf.class, "zze", zznu.class});
        } else if (i2 == 3) {
            return new zzni();
        } else {
            if (i2 == 4) {
                return new zznh((zzng) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
