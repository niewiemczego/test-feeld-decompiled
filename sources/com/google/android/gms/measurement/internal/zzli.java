package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzli implements Runnable {
    private final /* synthetic */ boolean zza = true;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzad zzd;
    private final /* synthetic */ zzad zze;
    private final /* synthetic */ zzkp zzf;

    zzli(zzkp zzkp, boolean z, zzo zzo, boolean z2, zzad zzad, zzad zzad2) {
        this.zzf = zzkp;
        this.zzb = zzo;
        this.zzc = z2;
        this.zzd = zzad;
        this.zze = zzad2;
    }

    public final void run() {
        zzfk zza2 = this.zzf.zzb;
        if (zza2 == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zza2, (AbstractSafeParcelable) this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    Preconditions.checkNotNull(this.zzb);
                    zza2.zza(this.zzd, this.zzb);
                } else {
                    zza2.zza(this.zzd);
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzal();
    }
}
