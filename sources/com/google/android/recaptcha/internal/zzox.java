package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzox extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzox zzb;
    private int zzd;

    static {
        zzox zzox = new zzox();
        zzb = zzox;
        zzit.zzD(zzox.class, zzox);
    }

    private zzox() {
    }

    public static zzox zzg(byte[] bArr) throws zzje {
        return (zzox) zzit.zzu(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzA(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zzd"});
        } else if (i2 == 3) {
            return new zzox();
        } else {
            if (i2 == 4) {
                return new zzow((zzor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzpb zzi() {
        zzpb zzb2 = zzpb.zzb(this.zzd);
        return zzb2 == null ? zzpb.UNRECOGNIZED : zzb2;
    }
}
