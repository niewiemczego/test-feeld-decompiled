package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzui  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzui extends zzaja<zzui, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzui zzc;
    private static volatile zzakx<zzui> zzd;
    private int zze;
    private int zzf;

    public final int zza() {
        return this.zzf;
    }

    public final zzuc zzb() {
        zzuc zza2 = zzuc.zza(this.zze);
        return zza2 == null ? zzuc.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzui$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzui, zza> implements zzakm {
        public final zza zza(zzuc zzuc) {
            zzh();
            ((zzui) this.zza).zza(zzuc);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzui) this.zza).zza(i);
            return this;
        }

        private zza() {
            super(zzui.zzc);
        }

        /* synthetic */ zza(zzuh zzuh) {
            this();
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    public static zzui zze() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuh.zza[i - 1]) {
            case 1:
                return new zzui();
            case 2:
                return new zza((zzuh) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzui> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzui.class) {
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
        zzui zzui = new zzui();
        zzc = zzui;
        zzaja.zza(zzui.class, zzui);
    }

    private zzui() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzuc zzuc) {
        this.zze = zzuc.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }
}
