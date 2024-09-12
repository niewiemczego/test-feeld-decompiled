package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzta  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzta extends zzaja<zzta, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzta zzc;
    private static volatile zzakx<zzta> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzta$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzta, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzta) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzta.zzc);
        }

        /* synthetic */ zza(zzsz zzsz) {
            this();
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    public static zzta zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzta) zzaja.zza(zzc, zzahm, zzaip);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsz.zza[i - 1]) {
            case 1:
                return new zzta();
            case 2:
                return new zza((zzsz) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzta> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzta.class) {
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
        zzta zzta = new zzta();
        zzc = zzta;
        zzaja.zza(zzta.class, zzta);
    }

    private zzta() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zze = i;
    }
}
