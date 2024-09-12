package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzus  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzus extends zzaja<zzus, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzus zzc;
    private static volatile zzakx<zzus> zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final zzuj zza() {
        zzuj zza2 = zzuj.zza(this.zzg);
        return zza2 == null ? zzuj.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzus$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzus, zza> implements zzakm {
        public final zza zza(zzuj zzuj) {
            zzh();
            ((zzus) this.zza).zza(zzuj);
            return this;
        }

        public final zza zza(zzuk zzuk) {
            zzh();
            ((zzus) this.zza).zza(zzuk);
            return this;
        }

        public final zza zza(zzum zzum) {
            zzh();
            ((zzus) this.zza).zza(zzum);
            return this;
        }

        private zza() {
            super(zzus.zzc);
        }

        /* synthetic */ zza(zzur zzur) {
            this();
        }
    }

    public final zzuk zzb() {
        zzuk zza2 = zzuk.zza(this.zzf);
        return zza2 == null ? zzuk.UNRECOGNIZED : zza2;
    }

    public final zzum zzc() {
        zzum zza2 = zzum.zza(this.zze);
        return zza2 == null ? zzum.UNRECOGNIZED : zza2;
    }

    public static zza zzd() {
        return (zza) zzc.zzl();
    }

    public static zzus zzf() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzur.zza[i - 1]) {
            case 1:
                return new zzus();
            case 2:
                return new zza((zzur) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzus> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzus.class) {
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
        zzus zzus = new zzus();
        zzc = zzus;
        zzaja.zza(zzus.class, zzus);
    }

    private zzus() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzuj zzuj) {
        this.zzg = zzuj.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(zzuk zzuk) {
        this.zzf = zzuk.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(zzum zzum) {
        this.zze = zzum.zza();
    }
}
