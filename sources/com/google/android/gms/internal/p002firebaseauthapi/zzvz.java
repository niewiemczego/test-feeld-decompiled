package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvz extends zzaja<zzvz, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvz zzc;
    private static volatile zzakx<zzvz> zzd;
    private int zze;

    public final int zza() {
        return this.zze;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvz$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvz, zza> implements zzakm {
        private zza() {
            super(zzvz.zzc);
        }

        /* synthetic */ zza(zzvy zzvy) {
            this();
        }
    }

    public static zzvz zzc() {
        return zzc;
    }

    public static zzvz zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzvz) zzaja.zza(zzc, zzahm, zzaip);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvy.zza[i - 1]) {
            case 1:
                return new zzvz();
            case 2:
                return new zza((zzvy) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvz> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvz.class) {
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
        zzvz zzvz = new zzvz();
        zzc = zzvz;
        zzaja.zza(zzvz.class, zzvz);
    }

    private zzvz() {
    }
}
