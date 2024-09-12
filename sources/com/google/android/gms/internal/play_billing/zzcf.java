package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzcf extends zzcl {
    private static final zzcf zza = new zzcf(zzcl.zze());
    private final AtomicReference zzb;

    zzcf(zzcl zzcl) {
        this.zzb = new AtomicReference(zzcl);
    }

    public static final zzcf zzb() {
        return zza;
    }

    public final zzbh zza() {
        return ((zzcl) this.zzb.get()).zza();
    }

    public final zzcy zzc() {
        return ((zzcl) this.zzb.get()).zzc();
    }

    public final boolean zzd(String str, Level level, boolean z) {
        ((zzcl) this.zzb.get()).zzd(str, level, z);
        return false;
    }
}
