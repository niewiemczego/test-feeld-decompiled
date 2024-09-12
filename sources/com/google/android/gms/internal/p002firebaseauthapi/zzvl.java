package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvl extends zzaja<zzvl, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvl zzc;
    private static volatile zzakx<zzvl> zzd;
    private int zze;
    private int zzf;
    private zzvm zzg;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvl, zza> implements zzakm {
        public final zza zza(zzvm zzvm) {
            zzh();
            ((zzvl) this.zza).zza(zzvm);
            return this;
        }

        private zza() {
            super(zzvl.zzc);
        }

        /* synthetic */ zza(zzvk zzvk) {
            this();
        }
    }

    public static zzvl zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzvl) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzvm zzd() {
        zzvm zzvm = this.zzg;
        return zzvm == null ? zzvm.zzc() : zzvm;
    }

    public static zzakx<zzvl> zze() {
        return (zzakx) zzc.zza(zzaja.zze.zzg, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvk.zza[i - 1]) {
            case 1:
                return new zzvl();
            case 2:
                return new zza((zzvk) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvl> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvl.class) {
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
        zzvl zzvl = new zzvl();
        zzc = zzvl;
        zzaja.zza(zzvl.class, zzvl);
    }

    private zzvl() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzvm zzvm) {
        zzvm.getClass();
        this.zzg = zzvm;
        this.zze |= 1;
    }
}
