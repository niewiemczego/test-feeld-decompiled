package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzrz extends zzaja<zzrz, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzrz zzc;
    private static volatile zzakx<zzrz> zzd;
    private int zze;
    private int zzf;
    private zzsc zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrz$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzrz, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzrz) this.zza).zza(i);
            return this;
        }

        public final zza zza(zzsc zzsc) {
            zzh();
            ((zzrz) this.zza).zza(zzsc);
            return this;
        }

        private zza() {
            super(zzrz.zzc);
        }

        /* synthetic */ zza(zzsa zzsa) {
            this();
        }
    }

    public static zzrz zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzrz) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzsc zzd() {
        zzsc zzsc = this.zzg;
        return zzsc == null ? zzsc.zzd() : zzsc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsa.zza[i - 1]) {
            case 1:
                return new zzrz();
            case 2:
                return new zza((zzsa) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzrz> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzrz.class) {
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
        zzrz zzrz = new zzrz();
        zzc = zzrz;
        zzaja.zza(zzrz.class, zzrz);
    }

    private zzrz() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzsc zzsc) {
        zzsc.getClass();
        this.zzg = zzsc;
        this.zze |= 1;
    }
}
