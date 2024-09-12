package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzuf extends zzaja<zzuf, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzuf zzc;
    private static volatile zzakx<zzuf> zzd;
    private int zze;
    private zzui zzf;
    private int zzg;
    private int zzh;

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzh;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuf$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzuf, zza> implements zzakm {
        public final zza zza(int i) {
            zzh();
            ((zzuf) this.zza).zza(i);
            return this;
        }

        public final zza zza(zzui zzui) {
            zzh();
            ((zzuf) this.zza).zza(zzui);
            return this;
        }

        private zza() {
            super(zzuf.zzc);
        }

        /* synthetic */ zza(zzug zzug) {
            this();
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    public static zzuf zze() {
        return zzc;
    }

    public static zzuf zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzuf) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzui zzf() {
        zzui zzui = this.zzf;
        return zzui == null ? zzui.zze() : zzui;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzug.zza[i - 1]) {
            case 1:
                return new zzuf();
            case 2:
                return new zza((zzug) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzuf> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzuf.class) {
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
        zzuf zzuf = new zzuf();
        zzc = zzuf;
        zzaja.zza(zzuf.class, zzuf);
    }

    private zzuf() {
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzg = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzui zzui) {
        zzui.getClass();
        this.zzf = zzui;
        this.zze |= 1;
    }
}
