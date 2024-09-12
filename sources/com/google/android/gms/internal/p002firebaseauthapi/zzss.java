package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzss  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzss extends zzaja<zzss, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzss zzc;
    private static volatile zzakx<zzss> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzss$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzss, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzss) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzss.zzc);
        }

        /* synthetic */ zza(zzsr zzsr) {
            this();
        }
    }

    public static zzss zzd() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsr.zza[i - 1]) {
            case 1:
                return new zzss();
            case 2:
                return new zza((zzsr) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzss> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzss.class) {
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
        zzss zzss = new zzss();
        zzc = zzss;
        zzaja.zza(zzss.class, zzss);
    }

    private zzss() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zze = i;
    }
}
