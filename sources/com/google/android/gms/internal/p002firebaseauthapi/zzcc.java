package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import com.google.android.gms.internal.p002firebaseauthapi.zzvh;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzcc {
    private final zzvh.zzb zza;

    private final synchronized int zza(zzvd zzvd, boolean z) throws GeneralSecurityException {
        zzvh.zza zza2;
        zza2 = zza(zzvd);
        this.zza.zza(zza2);
        return zza2.zza();
    }

    private final synchronized int zzc() {
        int zza2;
        zza2 = zzpg.zza();
        while (zzb(zza2)) {
            zza2 = zzpg.zza();
        }
        return zza2;
    }

    public final synchronized zzby zza() throws GeneralSecurityException {
        return zzby.zza((zzvh) ((zzaja) this.zza.zzf()));
    }

    public final synchronized zzcc zza(zzbv zzbv) throws GeneralSecurityException {
        zza(zzbv.zza(), false);
        return this;
    }

    public final synchronized zzcc zza(int i) throws GeneralSecurityException {
        int i2 = 0;
        while (i2 < this.zza.zza()) {
            zzvh.zza zzb = this.zza.zzb(i2);
            if (zzb.zza() != i) {
                i2++;
            } else if (zzb.zzc().equals(zzvb.ENABLED)) {
                this.zza.zza(i);
            } else {
                throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public static zzcc zzb() {
        return new zzcc(zzvh.zzc());
    }

    public static zzcc zza(zzby zzby) {
        zzaja.zzb zzm = zzby.zzb().zzm();
        zzaja.zzb zzb = zzm;
        return new zzcc((zzvh.zzb) zzm);
    }

    private final synchronized zzvh.zza zza(zzux zzux, zzvt zzvt) throws GeneralSecurityException {
        int zzc;
        zzc = zzc();
        if (zzvt != zzvt.UNKNOWN_PREFIX) {
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zzvh.zza) ((zzaja) zzvh.zza.zzd().zza(zzux).zza(zzc).zza(zzvb.ENABLED).zza(zzvt).zzf());
    }

    private final synchronized zzvh.zza zza(zzvd zzvd) throws GeneralSecurityException {
        return zza(zzcu.zza(zzvd), zzvd.zzd());
    }

    private zzcc(zzvh.zzb zzb) {
        this.zza = zzb;
    }

    private final synchronized boolean zzb(int i) {
        for (zzvh.zza zza2 : this.zza.zzb()) {
            if (zza2.zza() == i) {
                return true;
            }
        }
        return false;
    }
}
