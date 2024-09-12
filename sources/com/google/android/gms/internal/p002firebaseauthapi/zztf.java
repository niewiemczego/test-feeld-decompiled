package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zztf extends zzaja<zztf, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zztf zzc;
    private static volatile zzakx<zztf> zzd;
    private int zze;
    private zzahm zzf = zzahm.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zztf, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zztf) this.zza).zza(zzahm);
            return this;
        }

        private zza() {
            super(zztf.zzc);
        }

        /* synthetic */ zza(zztg zztg) {
            this();
        }
    }

    public static zztf zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zztf) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzahm zzd() {
        return this.zzf;
    }

    public static zzakx<zztf> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztg.zza[i - 1]) {
            case 1:
                return new zztf();
            case 2:
                return new zza((zztg) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztf> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zztf.class) {
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
        zztf zztf = new zztf();
        zzc = zztf;
        zzaja.zza(zztf.class, zztf);
    }

    private zztf() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzf = zzahm;
    }
}
