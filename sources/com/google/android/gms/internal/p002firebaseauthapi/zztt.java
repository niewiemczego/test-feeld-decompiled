package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zztt extends zzaja<zztt, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zztt zzc;
    private static volatile zzakx<zztt> zzd;
    private int zze;
    private int zzf;
    private zztp zzg;
    private zzahm zzh = zzahm.zza;
    private zzahm zzi = zzahm.zza;

    public final int zza() {
        return this.zzf;
    }

    public final zztp zzb() {
        zztp zztp = this.zzg;
        return zztp == null ? zztp.zze() : zztp;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztt$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zztt, zza> implements zzakm {
        public final zza zza(zztp zztp) {
            zzh();
            ((zztt) this.zza).zza(zztp);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zztt) this.zza).zza(0);
            return this;
        }

        public final zza zza(zzahm zzahm) {
            zzh();
            ((zztt) this.zza).zza(zzahm);
            return this;
        }

        public final zza zzb(zzahm zzahm) {
            zzh();
            ((zztt) this.zza).zzb(zzahm);
            return this;
        }

        private zza() {
            super(zztt.zzc);
        }

        /* synthetic */ zza(zztu zztu) {
            this();
        }
    }

    public static zza zzc() {
        return (zza) zzc.zzl();
    }

    public static zztt zze() {
        return zzc;
    }

    public static zztt zza(zzahm zzahm, zzaip zzaip) throws zzajj {
        return (zztt) zzaja.zza(zzc, zzahm, zzaip);
    }

    public final zzahm zzf() {
        return this.zzh;
    }

    public final zzahm zzg() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztu.zza[i - 1]) {
            case 1:
                return new zztt();
            case 2:
                return new zza((zztu) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzakx<zztt> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zztt.class) {
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
        zztt zztt = new zztt();
        zzc = zztt;
        zzaja.zza(zztt.class, zztt);
    }

    private zztt() {
    }

    /* access modifiers changed from: private */
    public final void zza(zztp zztp) {
        zztp.getClass();
        this.zzg = zztp;
        this.zze |= 1;
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        this.zzf = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzh = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzahm zzahm) {
        zzahm.getClass();
        this.zzi = zzahm;
    }
}
