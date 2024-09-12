package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzti extends zzaja<zzti, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzti zzc;
    private static volatile zzakx<zzti> zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzti, zza> implements zzakm {
        private zza() {
            super(zzti.zzc);
        }

        /* synthetic */ zza(zzth zzth) {
            this();
        }
    }

    public static zzti zzb() {
        return zzc;
    }

    public static zzti zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzti) zzaja.zza(zzc, zzahm, zzaip);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzth.zza[i - 1]) {
            case 1:
                return new zzti();
            case 2:
                return new zza((zzth) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzakx<zzti> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzti.class) {
                        zzakx = zzd;
                        if (zzakx == null) {
                            zzakx = new zzaja.zza<>(zzc);
                            zzd = zzakx;
                        }
                    }
                }
                return zzakx;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzti zzti = new zzti();
        zzc = zzti;
        zzaja.zza(zzti.class, zzti);
    }

    private zzti() {
    }
}
