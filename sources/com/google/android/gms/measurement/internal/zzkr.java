package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcv;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzkr implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzo zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzcv zze;
    private final /* synthetic */ zzkp zzf;

    zzkr(zzkp zzkp, String str, String str2, zzo zzo, boolean z, zzcv zzcv) {
        this.zzf = zzkp;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzo;
        this.zzd = z;
        this.zze = zzcv;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzfk zza2 = this.zzf.zzb;
            if (zza2 == null) {
                this.zzf.zzj().zzg().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            bundle = zznd.zza(zza2.zza(this.zza, this.zzb, this.zzd, this.zzc));
            this.zzf.zzal();
            this.zzf.zzq().zza(this.zze, bundle);
        } catch (RemoteException e) {
            this.zzf.zzj().zzg().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzq().zza(this.zze, bundle);
        }
    }
}
