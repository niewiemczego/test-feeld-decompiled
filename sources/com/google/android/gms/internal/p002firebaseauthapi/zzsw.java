package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsw extends zzaja<zzsw, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsw zzc;
    private static volatile zzakx<zzsw> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsw, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzsw) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzsw.zzc);
        }

        /* synthetic */ zza(zzsv zzsv) {
            this();
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    public static zzsw zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzsw) zzaja.zza(zzc, zzahm, zzaip);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsv.zza[i - 1]) {
            case 1:
                return new zzsw();
            case 2:
                return new zza((zzsv) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsw> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsw.class) {
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
        zzsw zzsw = new zzsw();
        zzc = zzsw;
        zzaja.zza(zzsw.class, zzsw);
    }

    private zzsw() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zze = i;
    }
}