package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzto extends zzaja<zzto, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzto zzc;
    private static volatile zzakx<zzto> zzd;
    private int zze;
    private zztp zzf;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzto, zza> implements zzakm {
        public final zza zza(zztp zztp) {
            zzh();
            ((zzto) this.zza).zza(zztp);
            return this;
        }

        private zza() {
            super(zzto.zzc);
        }

        /* synthetic */ zza(zztn zztn) {
            this();
        }
    }

    public static zzto zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zzto) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zztp zzc() {
        zztp zztp = this.zzf;
        return zztp == null ? zztp.zze() : zztp;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztn.zza[i - 1]) {
            case 1:
                return new zzto();
            case 2:
                return new zza((zztn) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzto> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzto.class) {
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
        zzto zzto = new zzto();
        zzc = zzto;
        zzaja.zza(zzto.class, zzto);
    }

    private zzto() {
    }

    /* access modifiers changed from: private */
    public final void zza(zztp zztp) {
        zztp.getClass();
        this.zzf = zztp;
        this.zze |= 1;
    }
}
