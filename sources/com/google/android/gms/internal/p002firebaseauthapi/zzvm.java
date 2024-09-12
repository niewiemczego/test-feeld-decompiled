package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvm extends zzaja<zzvm, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvm zzc;
    private static volatile zzakx<zzvm> zzd;
    private String zze = "";

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvm, zza> implements zzakm {
        public final zza zza(String str) {
            zzh();
            ((zzvm) this.zza).zza(str);
            return this;
        }

        private zza() {
            super(zzvm.zzc);
        }

        /* synthetic */ zza(zzvn zzvn) {
            this();
        }
    }

    public static zzvm zzc() {
        return zzc;
    }

    public static zzvm zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzvm) zzaja.zza(zzc, zzahm, zzaip);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvn.zza[i - 1]) {
            case 1:
                return new zzvm();
            case 2:
                return new zza((zzvn) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvm> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvm.class) {
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

    public final String zzd() {
        return this.zze;
    }

    static {
        zzvm zzvm = new zzvm();
        zzc = zzvm;
        zzaja.zza(zzvm.class, zzvm);
    }

    private zzvm() {
    }

    /* access modifiers changed from: private */
    public final void zza(String str) {
        str.getClass();
        this.zze = str;
    }
}
