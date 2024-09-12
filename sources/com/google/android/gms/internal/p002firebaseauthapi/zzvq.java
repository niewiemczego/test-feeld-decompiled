package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvq extends zzaja<zzvq, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvq zzc;
    private static volatile zzakx<zzvq> zzd;
    private int zze;
    private String zzf = "";
    private zzvd zzg;

    public final zzvd zza() {
        zzvd zzvd = this.zzg;
        return zzvd == null ? zzvd.zzc() : zzvd;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvq$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvq, zza> implements zzakm {
        public final zza zza(zzvd zzvd) {
            zzh();
            ((zzvq) this.zza).zza(zzvd);
            return this;
        }

        public final zza zza(String str) {
            zzh();
            ((zzvq) this.zza).zza(str);
            return this;
        }

        private zza() {
            super(zzvq.zzc);
        }

        /* synthetic */ zza(zzvr zzvr) {
            this();
        }
    }

    public static zzvq zzd() {
        return zzc;
    }

    public static zzvq zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzvq) zzaja.zza(zzc, zzahm, zzaip);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvr.zza[i - 1]) {
            case 1:
                return new zzvq();
            case 2:
                return new zza((zzvr) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvq> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvq.class) {
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

    public final String zze() {
        return this.zzf;
    }

    static {
        zzvq zzvq = new zzvq();
        zzc = zzvq;
        zzaja.zza(zzvq.class, zzvq);
    }

    private zzvq() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzvd zzvd) {
        zzvd.getClass();
        this.zzg = zzvd;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(String str) {
        str.getClass();
        this.zzf = str;
    }
}
