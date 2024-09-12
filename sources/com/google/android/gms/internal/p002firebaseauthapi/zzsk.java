package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsk extends zzaja<zzsk, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsk zzc;
    private static volatile zzakx<zzsk> zzd;
    private int zze;
    private zzsl zzf;
    private int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsk$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsk, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzsk) this.zza).zza(i);
            return this;
        }

        public final zza zza(zzsl zzsl) {
            zzh();
            ((zzsk) this.zza).zza(zzsl);
            return this;
        }

        private zza() {
            super(zzsk.zzc);
        }

        /* synthetic */ zza(zzsj zzsj) {
            this();
        }
    }

    public static zzsk zzd() {
        return zzc;
    }

    public final zzsl zze() {
        zzsl zzsl = this.zzf;
        return zzsl == null ? zzsl.zzd() : zzsl;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsj.zza[i - 1]) {
            case 1:
                return new zzsk();
            case 2:
                return new zza((zzsj) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsk> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsk.class) {
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
        zzsk zzsk = new zzsk();
        zzc = zzsk;
        zzaja.zza(zzsk.class, zzsk);
    }

    private zzsk() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzg = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzsl zzsl) {
        zzsl.getClass();
        this.zzf = zzsl;
        this.zze |= 1;
    }
}
