package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zztp extends zzaja<zztp, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zztp zzc;
    private static volatile zzakx<zztp> zzd;
    private int zze;
    private zztw zzf;
    private zztk zzg;
    private int zzh;

    public final zztj zza() {
        zztj zza2 = zztj.zza(this.zzh);
        return zza2 == null ? zztj.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zztp, zza> implements zzakm {
        public final zza zza(zztk zztk) {
            zzh();
            ((zztp) this.zza).zza(zztk);
            return this;
        }

        public final zza zza(zztj zztj) {
            zzh();
            ((zztp) this.zza).zza(zztj);
            return this;
        }

        public final zza zza(zztw zztw) {
            zzh();
            ((zztp) this.zza).zza(zztw);
            return this;
        }

        private zza() {
            super(zztp.zzc);
        }

        /* synthetic */ zza(zztq zztq) {
            this();
        }
    }

    public final zztk zzb() {
        zztk zztk = this.zzg;
        return zztk == null ? zztk.zzc() : zztk;
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    public static zztp zze() {
        return zzc;
    }

    public final zztw zzf() {
        zztw zztw = this.zzf;
        return zztw == null ? zztw.zzc() : zztw;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztq.zza[i - 1]) {
            case 1:
                return new zztp();
            case 2:
                return new zza((zztq) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztp> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zztp.class) {
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
        zztp zztp = new zztp();
        zzc = zztp;
        zzaja.zza(zztp.class, zztp);
    }

    private zztp() {
    }

    /* access modifiers changed from: private */
    public final void zza(zztk zztk) {
        zztk.getClass();
        this.zzg = zztk;
        this.zze |= 2;
    }

    /* access modifiers changed from: private */
    public final void zza(zztj zztj) {
        this.zzh = zztj.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(zztw zztw) {
        zztw.getClass();
        this.zzf = zztw;
        this.zze |= 1;
    }
}
