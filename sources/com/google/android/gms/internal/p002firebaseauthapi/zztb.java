package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zztb extends zzaja<zztb, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zztb zzc;
    private static volatile zzakx<zztb> zzd;
    private int zze;
    private zzahm zzf = zzahm.zza;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztb$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zztb, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zztb) this.zza).zza(zzahm);
            return this;
        }

        private zza() {
            super(zztb.zzc);
        }

        /* synthetic */ zza(zztc zztc) {
            this();
        }
    }

    public static zztb zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zztb) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzahm zzd() {
        return this.zzf;
    }

    public static zzakx<zztb> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztc.zza[i - 1]) {
            case 1:
                return new zztb();
            case 2:
                return new zza((zztc) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztb> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zztb.class) {
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
        zztb zztb = new zztb();
        zzc = zztb;
        zzaja.zza(zztb.class, zztb);
    }

    private zztb() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzf = zzahm;
    }
}
