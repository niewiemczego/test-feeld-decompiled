package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsd extends zzaja<zzsd, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsd zzc;
    private static volatile zzakx<zzsd> zzd;
    private int zze;
    private int zzf;
    private zzsh zzg;
    private zzue zzh;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsd$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsd, zza> implements zzakm {
        public final zza zza(zzsh zzsh) {
            zzh();
            ((zzsd) this.zza).zza(zzsh);
            return this;
        }

        public final zza zza(zzue zzue) {
            zzh();
            ((zzsd) this.zza).zza(zzue);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzsd) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzsd.zzc);
        }

        /* synthetic */ zza(zzse zzse) {
            this();
        }
    }

    public static zzsd zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzsd) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzsh zzd() {
        zzsh zzsh = this.zzg;
        return zzsh == null ? zzsh.zzd() : zzsh;
    }

    public final zzue zze() {
        zzue zzue = this.zzh;
        return zzue == null ? zzue.zzd() : zzue;
    }

    public static zzakx<zzsd> zzf() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzse.zza[i - 1]) {
            case 1:
                return new zzsd();
            case 2:
                return new zza((zzse) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsd> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsd.class) {
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
        zzsd zzsd = new zzsd();
        zzc = zzsd;
        zzaja.zza(zzsd.class, zzsd);
    }

    private zzsd() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzsh zzsh) {
        zzsh.getClass();
        this.zzg = zzsh;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(zzue zzue) {
        zzue.getClass();
        this.zzh = zzue;
        this.zze |= 2;
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }
}
