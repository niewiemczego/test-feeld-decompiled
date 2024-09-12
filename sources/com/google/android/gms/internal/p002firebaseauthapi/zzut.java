package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzut  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzut extends zzaja<zzut, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzut zzc;
    private static volatile zzakx<zzut> zzd;
    private int zze;
    private int zzf;
    private zzuw zzg;
    private zzahm zzh = zzahm.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzut$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzut, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzut) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(zzuw zzuw) {
            zzh();
            ((zzut) this.zza).zza(zzuw);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzut) this.zza).zza(0);
            return this;
        }

        private zza() {
            super(zzut.zzc);
        }

        /* synthetic */ zza(zzuu zzuu) {
            this();
        }
    }

    public static zzut zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzut) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzuw zzd() {
        zzuw zzuw = this.zzg;
        return zzuw == null ? zzuw.zze() : zzuw;
    }

    public final zzahm zze() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuu.zza[i - 1]) {
            case 1:
                return new zzut();
            case 2:
                return new zza((zzuu) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzut> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzut.class) {
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
        zzut zzut = new zzut();
        zzc = zzut;
        zzaja.zza(zzut.class, zzut);
    }

    private zzut() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzh = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzuw zzuw) {
        zzuw.getClass();
        this.zzg = zzuw;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }
}
