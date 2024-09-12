package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzkz implements Runnable {
    private final /* synthetic */ zzki zza;
    private final /* synthetic */ zzkp zzb;

    zzkz(zzkp zzkp, zzki zzki) {
        this.zzb = zzkp;
        this.zza = zzki;
    }

    public final void run() {
        zzfk zza2 = this.zzb.zzb;
        if (zza2 == null) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzki zzki = this.zza;
            if (zzki == null) {
                zza2.zza(0, (String) null, (String) null, this.zzb.zza().getPackageName());
            } else {
                zza2.zza(zzki.zzc, this.zza.zza, this.zza.zzb, this.zzb.zza().getPackageName());
            }
            this.zzb.zzal();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to the service", e);
        }
    }
}
