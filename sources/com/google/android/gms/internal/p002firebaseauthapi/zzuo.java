package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzuo extends zzaja<zzuo, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzuo zzc;
    private static volatile zzakx<zzuo> zzd;
    private int zze;
    private zzus zzf;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuo$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzuo, zza> implements zzakm {
        public final zza zza(zzus zzus) {
            zzh();
            ((zzuo) this.zza).zza(zzus);
            return this;
        }

        private zza() {
            super(zzuo.zzc);
        }

        /* synthetic */ zza(zzuq zzuq) {
            this();
        }
    }

    public static zzuo zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzuo) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzus zzc() {
        zzus zzus = this.zzf;
        return zzus == null ? zzus.zzf() : zzus;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuq.zza[i - 1]) {
            case 1:
                return new zzuo();
            case 2:
                return new zza((zzuq) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzuo> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzuo.class) {
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
        zzuo zzuo = new zzuo();
        zzc = zzuo;
        zzaja.zza(zzuo.class, zzuo);
    }

    private zzuo() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzus zzus) {
        zzus.getClass();
        this.zzf = zzus;
        this.zze |= 1;
    }
}
