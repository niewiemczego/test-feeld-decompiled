package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zznp;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhv implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzhj zzb;

    zzhv(zzhj zzhj, zzo zzo) {
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
        zzih zza3 = zzih.zza(zzo.zzt, (!zznp.zza() || !zza2.zze().zza(zzbi.zzcm)) ? 100 : zzo.zzy);
        zzih zzb2 = zza2.zzb(zzo.zza);
        zza2.zzj().zzp().zza("Setting consent, package, consent", zzo.zza, zza3);
        zza2.zza(zzo.zza, zza3);
        if (zza3.zzc(zzb2)) {
            zza2.zzd(zzo);
        }
        if (zznp.zza() && zza2.zze().zza(zzbi.zzcm)) {
            zzay zza4 = zzay.zza(zzo.zzz);
            if (!zzay.zza.equals(zza4)) {
                zza2.zzj().zzp().zza("Setting DMA consent. package, consent", zzo.zza, zza4);
                zza2.zza(zzo.zza, zza4);
            }
        }
    }
}
