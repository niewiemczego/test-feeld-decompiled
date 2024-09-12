package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhu implements Callable<zzam> {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzhj zzb;

    public final /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzr();
        return new zzam(this.zzb.zza.zza(this.zza.zza));
    }

    zzhu(zzhj zzhj, zzo zzo) {
        this.zzb = zzhj;
        this.zza = zzo;
    }
}
