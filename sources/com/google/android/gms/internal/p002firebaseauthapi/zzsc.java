package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsc extends zzaja<zzsc, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsc zzc;
    private static volatile zzakx<zzsc> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsc$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsc, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzsc) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzsc.zzc);
        }

        /* synthetic */ zza(zzsb zzsb) {
            this();
        }
    }

    public static zzsc zzd() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsb.zza[i - 1]) {
            case 1:
                return new zzsc();
            case 2:
                return new zza((zzsb) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsc> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsc.class) {
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
        zzsc zzsc = new zzsc();
        zzc = zzsc;
        zzaja.zza(zzsc.class, zzsc);
    }

    private zzsc() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zze = i;
    }
}
