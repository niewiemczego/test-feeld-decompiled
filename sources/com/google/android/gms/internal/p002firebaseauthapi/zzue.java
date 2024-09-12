package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzue  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzue extends zzaja<zzue, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzue zzc;
    private static volatile zzakx<zzue> zzd;
    private int zze;
    private int zzf;
    private zzui zzg;
    private zzahm zzh = zzahm.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzue$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzue, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzue) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(zzui zzui) {
            zzh();
            ((zzue) this.zza).zza(zzui);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzue) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzue.zzc);
        }

        /* synthetic */ zza(zzud zzud) {
            this();
        }
    }

    public static zzue zzd() {
        return zzc;
    }

    public static zzue zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzue) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzui zze() {
        zzui zzui = this.zzg;
        return zzui == null ? zzui.zze() : zzui;
    }

    public final zzahm zzf() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzud.zza[i - 1]) {
            case 1:
                return new zzue();
            case 2:
                return new zza((zzud) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzue> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzue.class) {
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
        zzue zzue = new zzue();
        zzc = zzue;
        zzaja.zza(zzue.class, zzue);
    }

    private zzue() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzh = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzui zzui) {
        zzui.getClass();
        this.zzg = zzui;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }
}
