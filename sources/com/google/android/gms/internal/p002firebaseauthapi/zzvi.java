package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvi extends zzaja<zzvi, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvi zzc;
    private static volatile zzakx<zzvi> zzd;
    private int zze;
    private zzajg<zzb> zzf = zzo();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvi$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzb extends zzaja<zzb, zza> implements zzakm {
        /* access modifiers changed from: private */
        public static final zzb zzc;
        private static volatile zzakx<zzb> zzd;
        private String zze = "";
        private int zzf;
        private int zzg;
        private int zzh;

        public final int zza() {
            return this.zzg;
        }

        public static zza zzb() {
            return (zza) zzc.zzl();
        }

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvi$zzb$zza */
        /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
        public static final class zza extends zzaja.zzb<zzb, zza> implements zzakm {
            public final zza zza(int i) {
                zzh();
                ((zzb) this.zza).zza(i);
                return this;
            }

            public final zza zza(zzvt zzvt) {
                zzh();
                ((zzb) this.zza).zza(zzvt);
                return this;
            }

            public final zza zza(zzvb zzvb) {
                zzh();
                ((zzb) this.zza).zza(zzvb);
                return this;
            }

            public final zza zza(String str) {
                zzh();
                ((zzb) this.zza).zza(str);
                return this;
            }

            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzvj zzvj) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzvj.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzvj) null);
                case 3:
                    return zza((zzakk) zzc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzakx<zzb> zzakx = zzd;
                    if (zzakx == null) {
                        synchronized (zzb.class) {
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
            zzb zzb = new zzb();
            zzc = zzb;
            zzaja.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzg = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzvt zzvt) {
            this.zzh = zzvt.zza();
        }

        /* access modifiers changed from: private */
        public final void zza(zzvb zzvb) {
            this.zzf = zzvb.zza();
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze = str;
        }
    }

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    public final zzb zza(int i) {
        return (zzb) this.zzf.get(0);
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvi$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvi, zza> implements zzakm {
        public final zza zza(zzb zzb) {
            zzh();
            ((zzvi) this.zza).zza(zzb);
            return this;
        }

        public final zza zza(int i) {
            zzh();
            ((zzvi) this.zza).zzc(i);
            return this;
        }

        private zza() {
            super(zzvi.zzc);
        }

        /* synthetic */ zza(zzvj zzvj) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvj.zza[i - 1]) {
            case 1:
                return new zzvi();
            case 2:
                return new zza((zzvj) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzb.class});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvi> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvi.class) {
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
        zzvi zzvi = new zzvi();
        zzc = zzvi;
        zzaja.zza(zzvi.class, zzvi);
    }

    private zzvi() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        zzb2.getClass();
        zzajg<zzb> zzajg = this.zzf;
        if (!zzajg.zzc()) {
            this.zzf = zzaja.zza(zzajg);
        }
        this.zzf.add(zzb2);
    }

    /* access modifiers changed from: private */
    public final void zzc(int i) {
        this.zze = i;
    }
}
