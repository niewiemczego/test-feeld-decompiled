package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcv;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzkx implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzcv zzb;
    private final /* synthetic */ zzkp zzc;

    zzkx(zzkp zzkp, zzo zzo, zzcv zzcv) {
        this.zzc = zzkp;
        this.zza = zzo;
        this.zzb = zzcv;
    }

    public final void run() {
        try {
            if (!this.zzc.zzk().zzm().zzh()) {
                this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zza((String) null);
                this.zzc.zzk().zze.zza((String) null);
                return;
            }
            zzfk zza2 = this.zzc.zzb;
            if (zza2 == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                this.zzc.zzq().zza(this.zzb, (String) null);
                return;
            }
            Preconditions.checkNotNull(this.zza);
            String zzb2 = zza2.zzb(this.zza);
            if (zzb2 != null) {
                this.zzc.zzm().zza(zzb2);
                this.zzc.zzk().zze.zza(zzb2);
            }
            this.zzc.zzal();
            this.zzc.zzq().zza(this.zzb, zzb2);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzq().zza(this.zzb, (String) null);
        }
    }
}
