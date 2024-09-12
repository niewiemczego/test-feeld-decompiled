package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvw extends zzaja<zzvw, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvw zzc;
    private static volatile zzakx<zzvw> zzd;
    private int zze;
    private zzahm zzf = zzahm.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvw$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvw, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzvw) this.zza).zza(zzahm);
            return this;
        }

        private zza() {
            super(zzvw.zzc);
        }

        /* synthetic */ zza(zzvx zzvx) {
            this();
        }
    }

    public static zzvw zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzvw) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzahm zzd() {
        return this.zzf;
    }

    public static zzakx<zzvw> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvx.zza[i - 1]) {
            case 1:
                return new zzvw();
            case 2:
                return new zza((zzvx) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvw> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvw.class) {
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
        zzvw zzvw = new zzvw();
        zzc = zzvw;
        zzaja.zza(zzvw.class, zzvw);
    }

    private zzvw() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzf = zzahm;
    }
}
