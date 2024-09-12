package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.braze.Constants;
import com.google.android.gms.internal.measurement.zzpm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final /* synthetic */ class zzme implements Runnable {
    private /* synthetic */ zzmb zza;

    public /* synthetic */ zzme(zzmb zzmb) {
        this.zza = zzmb;
    }

    public final void run() {
        zzmb zzmb = this.zza;
        zzmc zzmc = zzmb.zzc;
        long j = zzmb.zza;
        long j2 = zzmb.zzb;
        zzmc.zza.zzt();
        zzmc.zza.zzj().zzc().zza("Application going to the background");
        zzmc.zza.zzk().zzn.zza(true);
        zzmc.zza.zza(true);
        if (!zzmc.zza.zze().zzu()) {
            zzmc.zza.zzb.zzb(j2);
            zzmc.zza.zza(false, false, j2);
        }
        if (!zzpm.zza() || !zzmc.zza.zze().zza(zzbi.zzce)) {
            zzmc.zza.zzm().zza("auto", Constants.BRAZE_PUSH_BRAZE_KEY, j, new Bundle());
        } else {
            zzmc.zza.zzj().zzn().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j));
        }
    }
}
