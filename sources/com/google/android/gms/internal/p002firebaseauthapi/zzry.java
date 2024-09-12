package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzry  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzry extends zzaja<zzry, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzry zzc;
    private static volatile zzakx<zzry> zzd;
    private int zze;
    private int zzf;
    private zzahm zzg = zzahm.zza;
    private zzsc zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzry$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzry, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzry) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(zzsc zzsc) {
            zzh();
            ((zzry) this.zza).zza(zzsc);
            return this;
        }

        private zza() {
            super(zzry.zzc);
        }

        /* synthetic */ zza(zzrx zzrx) {
            this();
        }
    }

    public static zzry zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzry) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzsc zzd() {
        zzsc zzsc = this.zzh;
        return zzsc == null ? zzsc.zzd() : zzsc;
    }

    public final zzahm zze() {
        return this.zzg;
    }

    public static zzakx<zzry> zzf() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzrx.zza[i - 1]) {
            case 1:
                return new zzry();
            case 2:
                return new zza((zzrx) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzry> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzry.class) {
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
        zzry zzry = new zzry();
        zzc = zzry;
        zzaja.zza(zzry.class, zzry);
    }

    private zzry() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzg = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzsc zzsc) {
        zzsc.getClass();
        this.zzh = zzsc;
        this.zze |= 1;
    }
}
