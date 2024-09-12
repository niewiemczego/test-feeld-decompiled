package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhl implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzhj zzb;

    zzhl(zzhj zzhj, zzo zzo) {
        this.zzb = zzhj;
        this.zza = zzo;
    }

    public final void run() {
        this.zzb.zza.zzr();
        zzmp zza2 = this.zzb.zza;
        zzo zzo = this.zza;
        zza2.zzl().zzt();
        zza2.zzs();
        Preconditions.checkNotEmpty(zzo.zza);
        zza2.zza(zzo);
    }
}
