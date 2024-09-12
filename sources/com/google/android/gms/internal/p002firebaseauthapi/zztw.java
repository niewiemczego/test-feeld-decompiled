package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zztw extends zzaja<zztw, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zztw zzc;
    private static volatile zzakx<zztw> zzd;
    private int zze;
    private int zzf;
    private zzahm zzg = zzahm.zza;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztw$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zztw, zza> implements zzakm {
        public final zza zza(zztx zztx) {
            zzh();
            ((zztw) this.zza).zza(zztx);
            return this;
        }

        public final zza zza(zzuc zzuc) {
            zzh();
            ((zztw) this.zza).zza(zzuc);
            return this;
        }

        public final zza zza(zzahm zzahm) {
            zzh();
            ((zztw) this.zza).zza(zzahm);
            return this;
        }

        private zza() {
            super(zztw.zzc);
        }

        /* synthetic */ zza(zztv zztv) {
            this();
        }
    }

    public static zztw zzc() {
        return zzc;
    }

    public final zztx zzd() {
        zztx zza2 = zztx.zza(this.zze);
        return zza2 == null ? zztx.UNRECOGNIZED : zza2;
    }

    public final zzuc zze() {
        zzuc zza2 = zzuc.zza(this.zzf);
        return zza2 == null ? zzuc.UNRECOGNIZED : zza2;
    }

    public final zzahm zzf() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztv.zza[i - 1]) {
            case 1:
                return new zztw();
            case 2:
                return new zza((zztv) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztw> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zztw.class) {
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
        zztw zztw = new zztw();
        zzc = zztw;
        zzaja.zza(zztw.class, zztw);
    }

    private zztw() {
    }

    /* access modifiers changed from: private */
    public final void zza(zztx zztx) {
        this.zze = zztx.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(zzuc zzuc) {
        this.zzf = zzuc.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzg = zzahm;
    }
}
