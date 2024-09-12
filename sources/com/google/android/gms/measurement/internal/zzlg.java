package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzlg implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzkp zzb;

    zzlg(zzkp zzkp, zzo zzo) {
        this.zzb = zzkp;
        this.zza = zzo;
    }

    public final void run() {
        zzfk zza2 = this.zzb.zzb;
        if (zza2 == null) {
            this.zzb.zzj().zzg().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zza2.zze(this.zza);
            this.zzb.zzal();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send consent settings to the service", e);
        }
    }
}
