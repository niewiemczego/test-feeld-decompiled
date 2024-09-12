package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzty  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzty extends zzaja<zzty, zza> implements zzakm {
    /* access modifiers changed from: private */
    public static final zzty zzc;
    private static volatile zzakx<zzty> zzd;
    private int zze;
    private zzahm zzf = zzahm.zza;
    private zzvi zzg;

    public static zza zza() {
        return (zza) zzc.zzl();
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzty$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static final class zza extends zzaja.zzb<zzty, zza> implements zzakm {
        public final zza zza() {
            zzh();
            ((zzty) this.zza).zzd();
            return this;
        }

        public final zza zza(zzahm zzahm) {
            zzh();
            ((zzty) this.zza).zza(zzahm);
            return this;
        }

        public final zza zza(zzvi zzvi) {
            zzh();
            ((zzty) this.zza).zza(zzvi);
            return this;
        }

        private zza() {
            super(zzty.zzc);
        }

        /* synthetic */ zza(zzua zzua) {
            this();
        }
    }

    public static zzty zza(InputStream inputStream, zzaip zzaip) throws IOException {
        return (zzty) zzaja.zza(zzc, inputStream, zzaip);
    }

    public final zzahm zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzua.zza[i - 1]) {
            case 1:
                return new zzty();
            case 2:
                return new zza((zzua) null);
            case 3:
                return zza((zzakk) zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakx<zzty> zzakx = zzd;
                if (zzakx == null) {
                    synchronized (zzty.class) {
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
        zzty zzty = new zzty();
        zzc = zzty;
        zzaja.zza(zzty.class, zzty);
    }

    private zzty() {
    }

    /* access modifiers changed from: private */
    public final void zzd() {
        this.zzg = null;
        this.zze &= -2;
    }

    /* access modifiers changed from: private */
    public final void zza(zzahm zzahm) {
        zzahm.getClass();
        this.zzf = zzahm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzvi zzvi) {
        zzvi.getClass();
        this.zzg = zzvi;
        this.zze |= 1;
    }
}
