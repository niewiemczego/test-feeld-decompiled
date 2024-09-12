package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzvv extends zzaja<zzvv, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzvv zzc;
    private static volatile zzakx<zzvv> zzd;
    private String zze = "";
    private zzajg<zzve> zzf = zzo();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvv$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzvv, zza> implements zzakm {
        private zza() {
            super(zzvv.zzc);
        }

        /* synthetic */ zza(zzvu zzvu) {
            this();
        }
    }

    public static zzvv zzb() {
        return zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvu.zza[i - 1]) {
            case 1:
                return new zzvv();
            case 2:
                return new zza((zzvu) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzve.class});
            case 4:
                return zzc;
            case 5:
                zzakx<zzvv> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzvv.class) {
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
        zzvv zzvv = new zzvv();
        zzc = zzvv;
        zzaja.zza(zzvv.class, zzvv);
    }

    private zzvv() {
    }
}
