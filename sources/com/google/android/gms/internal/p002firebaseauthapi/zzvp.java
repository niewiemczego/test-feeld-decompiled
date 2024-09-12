package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvp extends zzaja<zzvp, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvp zzc;
    private static volatile zzakx<zzvp> zzd;
    private int zze;
    private int zzf;
    private zzvq zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvp$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvp, zza> implements zzakm {
        public final zza zza(zzvq zzvq) {
            zzh();
            ((zzvp) this.zza).zza(zzvq);
            return this;
        }

        private zza() {
            super(zzvp.zzc);
        }

        /* synthetic */ zza(zzvo zzvo) {
            this();
        }
    }

    public static zzvp zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzvp) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzvq zzd() {
        zzvq zzvq = this.zzg;
        return zzvq == null ? zzvq.zzd() : zzvq;
    }

    public static zzakx<zzvp> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvo.zza[i - 1]) {
            case 1:
                return new zzvp();
            case 2:
                return new zza((zzvo) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvp> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvp.class) {
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
        zzvp zzvp = new zzvp();
        zzc = zzvp;
        zzaja.zza(zzvp.class, zzvp);
    }

    private zzvp() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzvq zzvq) {
        zzvq.getClass();
        this.zzg = zzvq;
        this.zze |= 1;
    }
}
