package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzix;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzfp {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zza extends zzix<zza, C0042zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zza zzc;
        private static volatile zzkw<zza> zzd;
        private zzjf<zzb> zze = zzcc();

        public final int zza() {
            return this.zze.size();
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzfp$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class C0042zza extends zzix.zzb<zza, C0042zza> implements zzkl {
            private C0042zza() {
                super(zza.zzc);
            }

            /* synthetic */ C0042zza(zzfo zzfo) {
                this();
            }
        }

        public static zza zzc() {
            return zzc;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0042zza((zzfo) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzb.class});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zza> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (zza.class) {
                            zzkw = zzd;
                            if (zzkw == null) {
                                zzkw = new zzix.zza<>(zzc);
                                zzd = zzkw;
                            }
                        }
                    }
                    return zzkw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzb> zzd() {
            return this.zze;
        }

        static {
            zza zza = new zza();
            zzc = zza;
            zzix.zza(zza.class, zza);
        }

        private zza() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzb extends zzix<zzb, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzb zzc;
        private static volatile zzkw<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzjf<zzd> zzg = zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzb, zza> implements zzkl {
            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzfo zzfo) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzfo) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzd.class});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zzb> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (zzb.class) {
                            zzkw = zzd;
                            if (zzkw == null) {
                                zzkw = new zzix.zza<>(zzc);
                                zzd = zzkw;
                            }
                        }
                    }
                    return zzkw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zzb() {
            return this.zzf;
        }

        public final List<zzd> zzc() {
            return this.zzg;
        }

        static {
            zzb zzb = new zzb();
            zzc = zzb;
            zzix.zza(zzb.class, zzb);
        }

        private zzb() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzc extends zzix<zzc, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzc zzc;
        private static volatile zzkw<zzc> zzd;
        private int zze;
        private zzjf<zzd> zzf = zzcc();
        private zza zzg;

        public final zza zza() {
            zza zza2 = this.zzg;
            return zza2 == null ? zza.zzc() : zza2;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzc, zza> implements zzkl {
            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzfo zzfo) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzfo) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzd.class, "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zzc> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (zzc.class) {
                            zzkw = zzd;
                            if (zzkw == null) {
                                zzkw = new zzix.zza<>(zzc);
                                zzd = zzkw;
                            }
                        }
                    }
                    return zzkw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzd> zzc() {
            return this.zzf;
        }

        static {
            zzc zzc2 = new zzc();
            zzc = zzc2;
            zzix.zza(zzc.class, zzc2);
        }

        private zzc() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzd extends zzix<zzd, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzd zzc;
        private static volatile zzkw<zzd> zzd;
        private int zze;
        private int zzf;
        private zzjf<zzd> zzg = zzcc();
        private String zzh = "";
        private String zzi = "";
        private boolean zzj;
        private double zzk;

        public final double zza() {
            return this.zzk;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzd, zza> implements zzkl {
            private zza() {
                super(zzd.zzc);
            }

            /* synthetic */ zza(zzfo zzfo) {
                this();
            }
        }

        public final zzb zzb() {
            zzb zza2 = zzb.zza(this.zzf);
            return zza2 == null ? zzb.UNKNOWN : zza2;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            Class<zzd> cls = zzd.class;
            switch (zzfo.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzfo) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", zzb.zzb(), "zzg", cls, "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zzd> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (cls) {
                            zzkw = zzd;
                            if (zzkw == null) {
                                zzkw = new zzix.zza<>(zzc);
                                zzd = zzkw;
                            }
                        }
                    }
                    return zzkw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public enum zzb implements zzjc {
            UNKNOWN(0),
            STRING(1),
            NUMBER(2),
            BOOLEAN(3),
            STATEMENT(4);
            
            private static final zzjb<zzb> zzf = null;
            private final int zzh;

            public final int zza() {
                return this.zzh;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i == 1) {
                    return STRING;
                }
                if (i == 2) {
                    return NUMBER;
                }
                if (i == 3) {
                    return BOOLEAN;
                }
                if (i != 4) {
                    return null;
                }
                return STATEMENT;
            }

            public static zzje zzb() {
                return zzfs.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzh);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            static {
                zzf = new zzfq();
            }

            private zzb(int i) {
                this.zzh = i;
            }
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzi;
        }

        public final List<zzd> zzf() {
            return this.zzg;
        }

        static {
            zzd zzd2 = new zzd();
            zzc = zzd2;
            zzix.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        public final boolean zzg() {
            return this.zzj;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 4) != 0;
        }
    }
}
