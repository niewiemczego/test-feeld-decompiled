package com.google.android.gms.internal.play_billing;

import java.util.Set;
import java.util.logging.Level;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzch implements zzca {
    private final String zza;
    private final zzbd zzb;
    private final Level zzc;
    private final Set zzd;
    private final zzbq zze;

    private zzch() {
        zzbe zzbe = zzbe.DEFAULT;
        throw null;
    }

    private zzch(String str, boolean z, zzbd zzbd, Level level, boolean z2, Set set, zzbq zzbq) {
        this.zza = "";
        this.zzb = zzbd;
        this.zzc = level;
        this.zzd = set;
        this.zze = zzbq;
    }

    public final zzbf zza(String str) {
        return new zzck(this.zza, str, true, this.zzb, this.zzc, this.zzd, this.zze, (zzcj) null);
    }

    public final zzch zzb(boolean z) {
        Set set = this.zzd;
        zzbq zzbq = this.zze;
        return new zzch(this.zza, true, this.zzb, Level.OFF, false, set, zzbq);
    }

    /* synthetic */ zzch(zzcg zzcg) {
        this("", true, zzbe.NO_OP, Level.ALL, false, zzck.zza, zzck.zzb);
    }
}
