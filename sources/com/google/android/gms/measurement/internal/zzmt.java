package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzmt implements Callable<String> {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzmp zzb;

    public final /* synthetic */ Object call() throws Exception {
        if (!this.zzb.zzb((String) Preconditions.checkNotNull(this.zza.zza)).zzh() || !zzih.zza(this.zza.zzt).zzh()) {
            this.zzb.zzj().zzp().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        zzh zza2 = this.zzb.zza(this.zza);
        if (zza2 != null) {
            return zza2.zzy();
        }
        this.zzb.zzj().zzu().zza("App info was null when attempting to get app instance id");
        return null;
    }

    zzmt(zzmp zzmp, zzo zzo) {
        this.zzb = zzmp;
        this.zza = zzo;
    }
}
