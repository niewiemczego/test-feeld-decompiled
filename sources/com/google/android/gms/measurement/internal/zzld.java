package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzld implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzkp zzb;

    zzld(zzkp zzkp, zzo zzo) {
        this.zzb = zzkp;
        this.zza = zzo;
    }

    public final void run() {
        zzfk zza2 = this.zzb.zzb;
        if (zza2 == null) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zza2.zzf(this.zza);
            this.zzb.zzal();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
