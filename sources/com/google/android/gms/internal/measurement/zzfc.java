package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzew;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzix;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzfc {

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zza extends zzix<zza, C0037zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zza zzc;
        private static volatile zzkw<zza> zzd;
        private int zze;
        private zzjf<zzb> zzf = zzcc();
        private zzjf<zzc> zzg = zzcc();
        private zzjf<zzf> zzh = zzcc();
        private boolean zzi;
        private zzjf<zzb> zzj = zzcc();

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zzb extends zzix<zzb, C0038zza> implements zzkl {
            /* access modifiers changed from: private */
            public static final zzb zzc;
            private static volatile zzkw<zzb> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zzb$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
            public static final class C0038zza extends zzix.zzb<zzb, C0038zza> implements zzkl {
                private C0038zza() {
                    super(zzb.zzc);
                }

                /* synthetic */ C0038zza(zzfb zzfb) {
                    this();
                }
            }

            public final zzd zzb() {
                zzd zza = zzd.zza(this.zzg);
                return zza == null ? zzd.CONSENT_STATUS_UNSPECIFIED : zza;
            }

            public final zze zzc() {
                zze zza = zze.zza(this.zzf);
                return zza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzfb.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0038zza((zzfb) null);
                    case 3:
                        return zza((zzkj) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
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

            static {
                zzb zzb = new zzb();
                zzc = zzb;
                zzix.zza(zzb.class, zzb);
            }

            private zzb() {
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zzc extends zzix<zzc, C0039zza> implements zzkl {
            /* access modifiers changed from: private */
            public static final zzc zzc;
            private static volatile zzkw<zzc> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zzc$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
            public static final class C0039zza extends zzix.zzb<zzc, C0039zza> implements zzkl {
                private C0039zza() {
                    super(zzc.zzc);
                }

                /* synthetic */ C0039zza(zzfb zzfb) {
                    this();
                }
            }

            public final zze zzb() {
                zze zza = zze.zza(this.zzg);
                return zza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza;
            }

            public final zze zzc() {
                zze zza = zze.zza(this.zzf);
                return zza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zza;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzfb.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new C0039zza((zzfb) null);
                    case 3:
                        return zza((zzkj) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
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

            static {
                zzc zzc2 = new zzc();
                zzc = zzc2;
                zzix.zza(zzc.class, zzc2);
            }

            private zzc() {
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zzf extends zzix<zzf, C0040zza> implements zzkl {
            /* access modifiers changed from: private */
            public static final zzf zzc;
            private static volatile zzkw<zzf> zzd;
            private int zze;
            private String zzf = "";
            private String zzg = "";

            /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zzf$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
            public static final class C0040zza extends zzix.zzb<zzf, C0040zza> implements zzkl {
                private C0040zza() {
                    super(zzf.zzc);
                }

                /* synthetic */ C0040zza(zzfb zzfb) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzfb.zza[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0040zza((zzfb) null);
                    case 3:
                        return zza((zzkj) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                    case 4:
                        return zzc;
                    case 5:
                        zzkw<zzf> zzkw = zzd;
                        if (zzkw == null) {
                            synchronized (zzf.class) {
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

            static {
                zzf zzf2 = new zzf();
                zzc = zzf2;
                zzix.zza(zzf.class, zzf2);
            }

            private zzf() {
            }
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzfc$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class C0037zza extends zzix.zzb<zza, C0037zza> implements zzkl {
            private C0037zza() {
                super(zza.zzc);
            }

            /* synthetic */ C0037zza(zzfb zzfb) {
                this();
            }
        }

        public static zza zzb() {
            return zzc;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0037zza((zzfb) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", zzb.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", zzb.class});
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

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public enum zzd implements zzjc {
            CONSENT_STATUS_UNSPECIFIED(0),
            GRANTED(1),
            DENIED(2);
            
            private static final zzjb<zzd> zzd = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzd zza(int i) {
                if (i == 0) {
                    return CONSENT_STATUS_UNSPECIFIED;
                }
                if (i == 1) {
                    return GRANTED;
                }
                if (i != 2) {
                    return null;
                }
                return DENIED;
            }

            public static zzje zzb() {
                return zzfe.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            static {
                zzd = new zzfd();
            }

            private zzd(int i) {
                this.zzf = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public enum zze implements zzjc {
            CONSENT_TYPE_UNSPECIFIED(0),
            AD_STORAGE(1),
            ANALYTICS_STORAGE(2),
            AD_USER_DATA(3),
            AD_PERSONALIZATION(4);
            
            private static final zzjb<zze> zzf = null;
            private final int zzh;

            public final int zza() {
                return this.zzh;
            }

            public static zze zza(int i) {
                if (i == 0) {
                    return CONSENT_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return AD_STORAGE;
                }
                if (i == 2) {
                    return ANALYTICS_STORAGE;
                }
                if (i == 3) {
                    return AD_USER_DATA;
                }
                if (i != 4) {
                    return null;
                }
                return AD_PERSONALIZATION;
            }

            public static zzje zzb() {
                return zzff.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzh);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            static {
                zzf = new zzfg();
            }

            private zze(int i) {
                this.zzh = i;
            }
        }

        public final List<zzf> zzc() {
            return this.zzh;
        }

        public final List<zzb> zzd() {
            return this.zzf;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        static {
            zza zza = new zza();
            zzc = zza;
            zzix.zza(zza.class, zza);
        }

        private zza() {
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzb extends zzix<zzb, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzb zzc;
        private static volatile zzkw<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzjf<zzf> zzg = zzcc();
        private boolean zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzb, zza> implements zzkl {
            private zza() {
                super(zzb.zzc);
            }

            /* synthetic */ zza(zzfb zzfb) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzfb) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzf.class, "zzh"});
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

        static {
            zzb zzb = new zzb();
            zzc = zzb;
            zzix.zza(zzb.class, zzb);
        }

        private zzb() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzd extends zzix<zzd, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzd zzc;
        private static volatile zzkw<zzd> zzd;
        private int zze;
        private long zzf;
        private String zzg = "";
        private int zzh;
        private zzjf<zzg> zzi = zzcc();
        private zzjf<zzc> zzj = zzcc();
        private zzjf<zzew.zza> zzk = zzcc();
        private String zzl = "";
        private boolean zzm;
        private zzjf<zzfp.zzc> zzn = zzcc();
        private zzjf<zzb> zzo = zzcc();
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzs = "";
        private zza zzt;
        private zze zzu;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzd, zza> implements zzkl {
            public final int zza() {
                return ((zzd) this.zza).zzb();
            }

            public final zzc zza(int i) {
                return ((zzd) this.zza).zza(i);
            }

            public final zza zzb() {
                zzad();
                ((zzd) this.zza).zzt();
                return this;
            }

            public final zza zza(int i, zzc.zza zza) {
                zzad();
                ((zzd) this.zza).zza(i, (zzc) ((zzix) zza.zzab()));
                return this;
            }

            public final String zzc() {
                return ((zzd) this.zza).zzk();
            }

            public final List<zzew.zza> zzd() {
                return Collections.unmodifiableList(((zzd) this.zza).zzl());
            }

            public final List<zzb> zze() {
                return Collections.unmodifiableList(((zzd) this.zza).zzm());
            }

            private zza() {
                super(zzd.zzc);
            }

            /* synthetic */ zza(zzfb zzfb) {
                this();
            }
        }

        public final int zza() {
            return this.zzn.size();
        }

        public final int zzb() {
            return this.zzj.size();
        }

        public final long zzc() {
            return this.zzf;
        }

        public final zza zzd() {
            zza zza2 = this.zzt;
            return zza2 == null ? zza.zzb() : zza2;
        }

        public final zzc zza(int i) {
            return (zzc) this.zzj.get(i);
        }

        public static zza zze() {
            return (zza) zzc.zzbx();
        }

        public static zzd zzg() {
            return zzc;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzfb) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\fဈ\u0006\rဈ\u0007\u000eဈ\b\u000fဉ\t\u0010ဉ\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzg.class, "zzj", zzc.class, "zzk", zzew.zza.class, "zzl", "zzm", "zzn", zzfp.zzc.class, "zzo", zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zzd> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (zzd.class) {
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

        public final String zzh() {
            return this.zzg;
        }

        public final String zzi() {
            return this.zzr;
        }

        public final String zzj() {
            return this.zzq;
        }

        public final String zzk() {
            return this.zzp;
        }

        public final List<zzew.zza> zzl() {
            return this.zzk;
        }

        public final List<zzb> zzm() {
            return this.zzo;
        }

        public final List<zzfp.zzc> zzn() {
            return this.zzn;
        }

        public final List<zzg> zzo() {
            return this.zzi;
        }

        static {
            zzd zzd2 = new zzd();
            zzc = zzd2;
            zzix.zza(zzd.class, zzd2);
        }

        private zzd() {
        }

        /* access modifiers changed from: private */
        public final void zzt() {
            this.zzk = zzcc();
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzjf<zzc> zzjf = this.zzj;
            if (!zzjf.zzc()) {
                this.zzj = zzix.zza(zzjf);
            }
            this.zzj.set(i, zzc2);
        }

        public final boolean zzp() {
            return this.zzm;
        }

        public final boolean zzq() {
            return (this.zze & 512) != 0;
        }

        public final boolean zzr() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzs() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zze extends zzix<zze, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zze zzc;
        private static volatile zzkw<zze> zzd;
        private int zze;
        private int zzf = 14;
        private int zzg = 11;
        private int zzh = 60;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zze, zza> implements zzkl {
            private zza() {
                super(zze.zzc);
            }

            /* synthetic */ zza(zzfb zzfb) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzfb) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zze> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (zze.class) {
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

        static {
            zze zze2 = new zze();
            zzc = zze2;
            zzix.zza(zze.class, zze2);
        }

        private zze() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzf extends zzix<zzf, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzf zzc;
        private static volatile zzkw<zzf> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzf, zza> implements zzkl {
            private zza() {
                super(zzf.zzc);
            }

            /* synthetic */ zza(zzfb zzfb) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzfb) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zzf> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (zzf.class) {
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

        static {
            zzf zzf2 = new zzf();
            zzc = zzf2;
            zzix.zza(zzf.class, zzf2);
        }

        private zzf() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzg extends zzix<zzg, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzg zzc;
        private static volatile zzkw<zzg> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzg, zza> implements zzkl {
            private zza() {
                super(zzg.zzc);
            }

            /* synthetic */ zza(zzfb zzfb) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzfb) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzkw<zzg> zzkw = zzd;
                    if (zzkw == null) {
                        synchronized (zzg.class) {
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

        public final String zzc() {
            return this.zzg;
        }

        static {
            zzg zzg2 = new zzg();
            zzc = zzg2;
            zzix.zza(zzg.class, zzg2);
        }

        private zzg() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public static final class zzc extends zzix<zzc, zza> implements zzkl {
        /* access modifiers changed from: private */
        public static final zzc zzc;
        private static volatile zzkw<zzc> zzd;
        private int zze;
        private String zzf = "";
        private boolean zzg;
        private boolean zzh;
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
        public static final class zza extends zzix.zzb<zzc, zza> implements zzkl {
            public final int zza() {
                return ((zzc) this.zza).zza();
            }

            public final zza zza(String str) {
                zzad();
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final String zzb() {
                return ((zzc) this.zza).zzc();
            }

            private zza() {
                super(zzc.zzc);
            }

            /* synthetic */ zza(zzfb zzfb) {
                this();
            }

            public final boolean zzc() {
                return ((zzc) this.zza).zzd();
            }

            public final boolean zzd() {
                return ((zzc) this.zza).zze();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzf();
            }

            public final boolean zzf() {
                return ((zzc) this.zza).zzg();
            }

            public final boolean zzg() {
                return ((zzc) this.zza).zzh();
            }
        }

        public final int zza() {
            return this.zzi;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzfb.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzfb) null);
                case 3:
                    return zza((zzkj) zzc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        public final String zzc() {
            return this.zzf;
        }

        static {
            zzc zzc2 = new zzc();
            zzc = zzc2;
            zzix.zza(zzc.class, zzc2);
        }

        private zzc() {
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zze |= 1;
            this.zzf = str;
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }
    }
}
