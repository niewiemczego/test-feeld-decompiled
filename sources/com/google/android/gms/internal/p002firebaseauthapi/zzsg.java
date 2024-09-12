package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsg extends zzaja<zzsg, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsg zzc;
    private static volatile zzakx<zzsg> zzd;
    private int zze;
    private zzsk zzf;
    private zzuf zzg;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsg$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsg, zza> implements zzakm {
        public final zza zza(zzsk zzsk) {
            zzh();
            ((zzsg) this.zza).zza(zzsk);
            return this;
        }

        public final zza zza(zzuf zzuf) {
            zzh();
            ((zzsg) this.zza).zza(zzuf);
            return this;
        }

        private zza() {
            super(zzsg.zzc);
        }

        /* synthetic */ zza(zzsf zzsf) {
            this();
        }
    }

    public static zzsg zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzsg) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzsk zzc() {
        zzsk zzsk = this.zzf;
        return zzsk == null ? zzsk.zzd() : zzsk;
    }

    public final zzuf zzd() {
        zzuf zzuf = this.zzg;
        return zzuf == null ? zzuf.zze() : zzuf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsf.zza[i - 1]) {
            case 1:
                return new zzsg();
            case 2:
                return new zza((zzsf) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsg> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsg.class) {
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
        zzsg zzsg = new zzsg();
        zzc = zzsg;
        zzaja.zza(zzsg.class, zzsg);
    }

    private zzsg() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzsk zzsk) {
        zzsk.getClass();
        this.zzf = zzsk;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(zzuf zzuf) {
        zzuf.getClass();
        this.zzg = zzuf;
        this.zze |= 2;
    }
}
