package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzlf implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzbg zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzkp zzf;

    zzlf(zzkp zzkp, boolean z, zzo zzo, boolean z2, zzbg zzbg, String str) {
        this.zzf = zzkp;
        this.zza = z;
        this.zzb = zzo;
        this.zzc = z2;
        this.zzd = zzbg;
        this.zze = str;
    }

    public final void run() {
        zzfk zza2 = this.zzf.zzb;
        if (zza2 == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zza2, (AbstractSafeParcelable) this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    Preconditions.checkNotNull(this.zzb);
                    zza2.zza(this.zzd, this.zzb);
                } else {
                    zza2.zza(this.zzd, this.zze, this.zzf.zzj().zzx());
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzal();
    }
}
