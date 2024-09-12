package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzts  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzts extends zzaja<zzts, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzts zzc;
    private static volatile zzakx<zzts> zzd;
    private int zze;
    private int zzf;
    private zztt zzg;
    private zzahm zzh = zzahm.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzts$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzts, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzts) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(zztt zztt) {
            zzh();
            ((zzts) this.zza).zza(zztt);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzts) this.zza).zza(0);
            return this;
        }

        private zza() {
            super(zzts.zzc);
        }

        /* synthetic */ zza(zztr zztr) {
            this();
        }
    }

    public static zzts zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzts) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zztt zzd() {
        zztt zztt = this.zzg;
        return zztt == null ? zztt.zze() : zztt;
    }

    public final zzahm zze() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztr.zza[i - 1]) {
            case 1:
                return new zzts();
            case 2:
                return new zza((zztr) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzts> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzts.class) {
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
        zzts zzts = new zzts();
        zzc = zzts;
        zzaja.zza(zzts.class, zzts);
    }

    private zzts() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzh = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(zztt zztt) {
        zztt.getClass();
        this.zzg = zztt;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }
}
