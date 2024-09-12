package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zztk extends zzaja<zztk, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zztk zzc;
    private static volatile zzakx<zztk> zzd;
    private int zze;
    private zzvd zzf;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zztk, zza> implements zzakm {
        public final zza zza(zzvd zzvd) {
            zzh();
            ((zztk) this.zza).zza(zzvd);
            return this;
        }

        private zza() {
            super(zztk.zzc);
        }

        /* synthetic */ zza(zztm zztm) {
            this();
        }
    }

    public static zztk zzc() {
        return zzc;
    }

    public final zzvd zzd() {
        zzvd zzvd = this.zzf;
        return zzvd == null ? zzvd.zzc() : zzvd;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztm.zza[i - 1]) {
            case 1:
                return new zztk();
            case 2:
                return new zza((zztm) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztk> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zztk.class) {
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
        zztk zztk = new zztk();
        zzc = zztk;
        zzaja.zza(zztk.class, zztk);
    }

    private zztk() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzvd zzvd) {
        zzvd.getClass();
        this.zzf = zzvd;
        this.zze |= 1;
    }
}
