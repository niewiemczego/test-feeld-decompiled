package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzso  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzso extends zzaja<zzso, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzso zzc;
    private static volatile zzakx<zzso> zzd;
    private int zze;
    private int zzf;
    private zzss zzg;
    private zzahm zzh = zzahm.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzso$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzso, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzso) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(zzss zzss) {
            zzh();
            ((zzso) this.zza).zza(zzss);
            return this;
        }

        private zza() {
            super(zzso.zzc);
        }

        /* synthetic */ zza(zzsn zzsn) {
            this();
        }
    }

    public static zzso zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzso) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzss zzd() {
        zzss zzss = this.zzg;
        return zzss == null ? zzss.zzd() : zzss;
    }

    public final zzahm zze() {
        return this.zzh;
    }

    public static zzakx<zzso> zzf() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsn.zza[i - 1]) {
            case 1:
                return new zzso();
            case 2:
                return new zza((zzsn) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzso> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzso.class) {
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
        zzso zzso = new zzso();
        zzc = zzso;
        zzaja.zza(zzso.class, zzso);
    }

    private zzso() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzh = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzss zzss) {
        zzss.getClass();
        this.zzg = zzss;
        this.zze |= 1;
    }
}
