package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcv;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzlk implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzo zzc;
    private final /* synthetic */ zzcv zzd;
    private final /* synthetic */ zzkp zze;

    zzlk(zzkp zzkp, String str, String str2, zzo zzo, zzcv zzcv) {
        this.zze = zzkp;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzo;
        this.zzd = zzcv;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzfk zza2 = this.zze.zzb;
            if (zza2 == null) {
                this.zze.zzj().zzg().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            arrayList = zznd.zzb(zza2.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzal();
            this.zze.zzq().zza(this.zzd, arrayList);
        } catch (RemoteException e) {
            this.zze.zzj().zzg().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } finally {
            this.zze.zzq().zza(this.zzd, arrayList);
        }
    }
}
