package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvd extends zzaja<zzvd, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvd zzc;
    private static volatile zzakx<zzvd> zzd;
    private String zze = "";
    private zzahm zzf = zzahm.zza;
    private int zzg;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvd, zza> implements zzakm {
        public final zza zza(zzvt zzvt) {
            zzh();
            ((zzvd) this.zza).zza(zzvt);
            return this;
        }

        public final zza zza(String str) {
            zzh();
            ((zzvd) this.zza).zza(str);
            return this;
        }

        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzvd) this.zza).zza(zzahm);
            return this;
        }

        private zza() {
            super(zzvd.zzc);
        }

        /* synthetic */ zza(zzvc zzvc) {
            this();
        }
    }

    public static zzvd zzc() {
        return zzc;
    }

    public static zzvd zza(byte[] bArr, zzaip zzaip) throws zzajj {
        return (zzvd) zzaja.zza(zzc, bArr, zzaip);
    }

    public final zzvt zzd() {
        zzvt zza2 = zzvt.zza(this.zzg);
        return zza2 == null ? zzvt.UNRECOGNIZED : zza2;
    }

    public final zzahm zze() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvc.zza[i - 1]) {
            case 1:
                return new zzvd();
            case 2:
                return new zza((zzvc) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvd> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvd.class) {
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

    public final String zzf() {
        return this.zze;
    }

    static {
        zzvd zzvd = new zzvd();
        zzc = zzvd;
        zzaja.zza(zzvd.class, zzvd);
    }

    private zzvd() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzvt zzvt) {
        this.zzg = zzvt.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(String str) {
        str.getClass();
        this.zze = str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzf = zzahm;
    }
}
