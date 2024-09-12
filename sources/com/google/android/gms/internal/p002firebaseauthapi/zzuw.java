package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzuw extends zzaja<zzuw, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzuw zzc;
    private static volatile zzakx<zzuw> zzd;
    private int zze;
    private int zzf;
    private zzus zzg;
    private zzahm zzh = zzahm.zza;

    public final int zza() {
        return this.zzf;
    }

    public final zzus zzb() {
        zzus zzus = this.zzg;
        return zzus == null ? zzus.zzf() : zzus;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuw$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzuw, zza> implements zzakm {
        public final zza zza(zzus zzus) {
            zzh();
            ((zzuw) this.zza).zza(zzus);
            return this;
        }

        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzuw) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzuw) this.zza).zza(0);
            return this;
        }

        private zza() {
            super(zzuw.zzc);
        }

        /* synthetic */ zza(zzuv zzuv) {
            this();
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    public static zzuw zze() {
        return zzc;
    }

    public static zzuw zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzuw) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzahm zzf() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuv.zza[i - 1]) {
            case 1:
                return new zzuw();
            case 2:
                return new zza((zzuv) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzuw> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzuw.class) {
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
        zzuw zzuw = new zzuw();
        zzc = zzuw;
        zzaja.zza(zzuw.class, zzuw);
    }

    private zzuw() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzus zzus) {
        zzus.getClass();
        this.zzg = zzus;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzh = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }
}
