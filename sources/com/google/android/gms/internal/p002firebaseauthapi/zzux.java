package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzux  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzux extends zzaja<zzux, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzux zzc;
    private static volatile zzakx<zzux> zzd;
    private String zze = "";
    private zzahm zzf = zzahm.zza;
    private int zzg;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    public final zzb zzb() {
        zzb zza2 = zzb.zza(this.zzg);
        return zza2 == null ? zzb.UNRECOGNIZED : zza2;
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzux$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzux, zza> implements zzakm {
        public final zza zza(zzb zzb) {
            zzh();
            ((zzux) this.zza).zza(zzb);
            return this;
        }

        public final zza zza(String str) {
            zzh();
            ((zzux) this.zza).zza(str);
            return this;
        }

        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzux) this.zza).zza(zzahm);
            return this;
        }

        private zza() {
            super(zzux.zzc);
        }

        /* synthetic */ zza(zzuy zzuy) {
            this();
        }
    }

    public static zzux zzd() {
        return zzc;
    }

    public final zzahm zze() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuy.zza[i - 1]) {
            case 1:
                return new zzux();
            case 2:
                return new zza((zzuy) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzux> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzux.class) {
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

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzux$zzb */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public enum zzb implements zzajf {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzaje<zzb> zzg = null;
        private final int zzi;

        public final int zza() {
            if (this != UNRECOGNIZED) {
                return this.zzi;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zzb zza(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=").append(zza());
            }
            return sb.append(" name=").append(name()).append(Typography.greater).toString();
        }

        static {
            zzg = new zzuz();
        }

        private zzb(int i) {
            this.zzi = i;
        }
    }

    public final String zzf() {
        return this.zze;
    }

    static {
        zzux zzux = new zzux();
        zzc = zzux;
        zzaja.zza(zzux.class, zzux);
    }

    private zzux() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzg = zzb2.zza();
    }

    /* access modifiers changed from: private */
    public final void zza(String str) {
        str.getClass();
        this.zze = str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzf = zzahm;
    }
}
