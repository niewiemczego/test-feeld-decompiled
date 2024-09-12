package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsp extends zzaja<zzsp, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsp zzc;
    private static volatile zzakx<zzsp> zzd;
    private int zze;
    private zzss zzf;
    private int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsp$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsp, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzsp) this.zza).zza(i);
            return this;
        }

        public final zza zza(zzss zzss) {
            zzh();
            ((zzsp) this.zza).zza(zzss);
            return this;
        }

        private zza() {
            super(zzsp.zzc);
        }

        /* synthetic */ zza(zzsq zzsq) {
            this();
        }
    }

    public static zzsp zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzsp) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzss zzd() {
        zzss zzss = this.zzf;
        return zzss == null ? zzss.zzd() : zzss;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsq.zza[i - 1]) {
            case 1:
                return new zzsp();
            case 2:
                return new zza((zzsq) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsp> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsp.class) {
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
        zzsp zzsp = new zzsp();
        zzc = zzsp;
        zzaja.zza(zzsp.class, zzsp);
    }

    private zzsp() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzg = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzss zzss) {
        zzss.getClass();
        this.zzf = zzss;
        this.zze |= 1;
    }
}
