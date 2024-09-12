package com.google.android.gms.internal.play_billing;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzbl {
    private static final zzbp zza = new zzbi();
    private static final zzbo zzb = new zzbj();
    /* access modifiers changed from: private */
    public final Map zzc = new HashMap();
    /* access modifiers changed from: private */
    public final Map zzd = new HashMap();
    /* access modifiers changed from: private */
    public final zzbp zze;
    /* access modifiers changed from: private */
    public zzbo zzf = null;

    /* synthetic */ zzbl(zzbp zzbp, zzbk zzbk) {
        this.zze = zzbp;
    }

    public final zzbl zza(zzbo zzbo) {
        this.zzf = zzbo;
        return this;
    }

    public final zzbq zzd() {
        return new zzbn(this, (zzbm) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzba zzba) {
        zzda.zza(zzba, "key");
        if (zzba.zzb()) {
            zzbo zzbo = zzb;
            zzda.zza(zzba, "key");
            if (zzba.zzb()) {
                this.zzc.remove(zzba);
                this.zzd.put(zzba, zzbo);
                return;
            }
            throw new IllegalArgumentException("key must be repeating");
        }
        zzbp zzbp = zza;
        zzda.zza(zzba, "key");
        this.zzd.remove(zzba);
        this.zzc.put(zzba, zzbp);
    }
}
