package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzkv implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzkp zzb;

    zzkv(zzkp zzkp, zzo zzo) {
        this.zzb = zzkp;
        this.zza = zzo;
    }

    public final void run() {
        zzfk zza2 = this.zzb.zzb;
        if (zza2 == null) {
            this.zzb.zzj().zzg().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zza2.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzal();
    }
}
