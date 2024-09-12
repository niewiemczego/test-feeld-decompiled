package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaly  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaly extends zzaja<zzaly, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzaly zzc;
    private static volatile zzakx<zzaly> zzd;
    private long zze;
    private int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaly$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzaly, zza> implements zzakm {
        public final zza zza(int i) {
            if (!this.zza.zzv()) {
                zzi();
            }
            ((zzaly) this.zza).zza(i);
            return this;
        }

        public final zza zza(long j) {
            if (!this.zza.zzv()) {
                zzi();
            }
            ((zzaly) this.zza).zza(j);
            return this;
        }

        private zza() {
            super(zzaly.zzc);
        }

        /* synthetic */ zza(zzama zzama) {
            this();
        }
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zze;
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzama.zza[i - 1]) {
            case 1:
                return new zzaly();
            case 2:
                return new zza((zzama) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzaly> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzaly.class) {
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
        zzaly zzaly = new zzaly();
        zzc = zzaly;
        zzaja.zza(zzaly.class, zzaly);
    }

    private zzaly() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }

    /* access modifiers changed from: private */
    public final void zza(long j) {
        this.zze = j;
    }
}
