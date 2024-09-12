package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsl extends zzaja<zzsl, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsl zzc;
    private static volatile zzakx<zzsl> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsl$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsl, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzsl) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzsl.zzc);
        }

        /* synthetic */ zza(zzsm zzsm) {
            this();
        }
    }

    public static zzsl zzd() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsm.zza[i - 1]) {
            case 1:
                return new zzsl();
            case 2:
                return new zza((zzsm) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsl> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsl.class) {
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
        zzsl zzsl = new zzsl();
        zzc = zzsl;
        zzaja.zza(zzsl.class, zzsl);
    }

    private zzsl() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zze = i;
    }
}
