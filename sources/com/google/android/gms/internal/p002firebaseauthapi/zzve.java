package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzve extends zzaja<zzve, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzve zzc;
    private static volatile zzakx<zzve> zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private boolean zzh;
    private String zzi = "";

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzve$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzve, zza> implements zzakm {
        private zza() {
            super(zzve.zzc);
        }

        /* synthetic */ zza(zzvf zzvf) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvf.zza[i - 1]) {
            case 1:
                return new zzve();
            case 2:
                return new zza((zzvf) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzve> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzve.class) {
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
        zzve zzve = new zzve();
        zzc = zzve;
        zzaja.zza(zzve.class, zzve);
    }

    private zzve() {
    }
}
