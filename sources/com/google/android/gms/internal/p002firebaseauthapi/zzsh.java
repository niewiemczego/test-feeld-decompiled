package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzsh extends zzaja<zzsh, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzsh zzc;
    private static volatile zzakx<zzsh> zzd;
    private int zze;
    private int zzf;
    private zzsl zzg;
    private zzahm zzh = zzahm.zza;

    public final int zza() {
        return this.zzf;
    }

    public static zza zzb() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsh$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzsh, zza> implements zzakm {
        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzsh) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(zzsl zzsl) {
            zzh();
            ((zzsh) this.zza).zza(zzsl);
            return this;
        }

        private zza() {
            super(zzsh.zzc);
        }

        /* synthetic */ zza(zzsi zzsi) {
            this();
        }
    }

    public static zzsh zzd() {
        return zzc;
    }

    public final zzsl zze() {
        zzsl zzsl = this.zzg;
        return zzsl == null ? zzsl.zzd() : zzsl;
    }

    public final zzahm zzf() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsi.zza[i - 1]) {
            case 1:
                return new zzsh();
            case 2:
                return new zza((zzsi) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzsh> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzsh.class) {
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
        zzsh zzsh = new zzsh();
        zzc = zzsh;
        zzaja.zza(zzsh.class, zzsh);
    }

    private zzsh() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzh = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzsl zzsl) {
        zzsl.getClass();
        this.zzg = zzsl;
        this.zze |= 1;
    }
}
