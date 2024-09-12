package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcv;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzle implements Runnable {
    private final /* synthetic */ zzbg zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzcv zzc;
    private final /* synthetic */ zzkp zzd;

    zzle(zzkp zzkp, zzbg zzbg, String str, zzcv zzcv) {
        this.zzd = zzkp;
        this.zza = zzbg;
        this.zzb = str;
        this.zzc = zzcv;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzfk zza2 = this.zzd.zzb;
            if (zza2 == null) {
                this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = zza2.zza(this.zza, this.zzb);
            this.zzd.zzal();
            this.zzd.zzq().zza(this.zzc, bArr);
        } catch (RemoteException e) {
            this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzq().zza(this.zzc, bArr);
        }
    }
}
