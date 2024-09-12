package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvh extends zzaja<zzvh, zzb> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvh zzc;
    private static volatile zzakx<zzvh> zzd;
    private int zze;
    private zzajg<zza> zzf = zzo();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja<zza, C0035zza> implements zzakm {
        /* access modifiers changed from: private */
        public static final zza zzc;
        private static volatile zzakx<zza> zzd;
        private int zze;
        private zzux zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        public final int zza() {
            return this.zzh;
        }

        public final zzux zzb() {
            zzux zzux = this.zzf;
            return zzux == null ? zzux.zzd() : zzux;
        }

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
        public static final class C0035zza extends zzaja.zzb<zza, C0035zza> implements zzakm {
            public final C0035zza zza(zzux zzux) {
                zzh();
                ((zza) this.zza).zza(zzux);
                return this;
            }

            public final C0035zza zza(int i) {
                zzh();
                ((zza) this.zza).zza(i);
                return this;
            }

            public final C0035zza zza(zzvt zzvt) {
                zzh();
                ((zza) this.zza).zza(zzvt);
                return this;
            }

            public final C0035zza zza(zzvb zzvb) {
                zzh();
                ((zza) this.zza).zza(zzvb);
                return this;
            }

            private C0035zza() {
                super(zza.zzc);
            }

            /* synthetic */ C0035zza(zzvg zzvg) {
                this();
            }
        }

        public final zzvb zzc() {
            zzvb zza = zzvb.zza(this.zzg);
            return zza == null ? zzvb.UNRECOGNIZED : zza;
        }

        public static C0035zza zzd() {
            return (C0035zza) zzc.zzl();
        }

        public final zzvt zzf() {
            zzvt zza = zzvt.zza(this.zzi);
            return zza == null ? zzvt.UNRECOGNIZED : zza;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzvg.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0035zza((zzvg) null);
                case 3:
                    return zza((zzakk) zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzakx<zza> zzakx = zzd;
                    if (zzakx == null) {
                        synchronized (zza.class) {
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
            zza zza = new zza();
            zzc = zza;
            zzaja.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        public final void zza(zzux zzux) {
            zzux.getClass();
            this.zzf = zzux;
            this.zze |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzh = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzvt zzvt) {
            this.zzi = zzvt.zza();
        }

        /* access modifiers changed from: private */
        public final void zza(zzvb zzvb) {
            this.zzg = zzvb.zza();
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zzb extends zzaja.zzb<zzvh, zzb> implements zzakm {
        public final int zza() {
            return ((zzvh) this.zza).zza();
        }

        public final zzb zza(zza zza) {
            zzh();
            ((zzvh) this.zza).zza(zza);
            return this;
        }

        public final zzb zza(int i) {
            zzh();
            ((zzvh) this.zza).zzc(i);
            return this;
        }

        public final zza zzb(int i) {
            return ((zzvh) this.zza).zza(i);
        }

        public final List<zza> zzb() {
            return Collections.unmodifiableList(((zzvh) this.zza).zze());
        }

        private zzb() {
            super(zzvh.zzc);
        }

        /* synthetic */ zzb(zzvg zzvg) {
            this();
        }
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public static zzb zzc() {
        return (zzb) zzc.zzl();
    }

    public final zza zza(int i) {
        return (zza) this.zzf.get(i);
    }

    public static zzvh zza(InputStream inputStream, zzaip zzaip) throws IOException {
        return (zzvh) zzaja.zza(zzc, inputStream, zzaip);
    }

    public static zzvh zza(byte[] bArr, zzaip zzaip) throws zzajj {
        return (zzvh) zzaja.zza(zzc, bArr, zzaip);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvg.zza[i - 1]) {
            case 1:
                return new zzvh();
            case 2:
                return new zzb((zzvg) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvh> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvh.class) {
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

    public final List<zza> zze() {
        return this.zzf;
    }

    static {
        zzvh zzvh = new zzvh();
        zzc = zzvh;
        zzaja.zza(zzvh.class, zzvh);
    }

    private zzvh() {
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        zza2.getClass();
        zzajg<zza> zzajg = this.zzf;
        if (!zzajg.zzc()) {
            this.zzf = zzaja.zza(zzajg);
        }
        this.zzf.add(zza2);
    }

    /* access modifiers changed from: private */
    public final void zzc(int i) {
        this.zze = i;
    }
}
