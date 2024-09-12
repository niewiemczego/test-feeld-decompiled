package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzkw implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zznc zzc;
    private final /* synthetic */ zzkp zzd;

    zzkw(zzkp zzkp, zzo zzo, boolean z, zznc zznc) {
        this.zzd = zzkp;
        this.zza = zzo;
        this.zzb = z;
        this.zzc = zznc;
    }

    public final void run() {
        zzfk zza2 = this.zzd.zzb;
        if (zza2 == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zza(zza2, (AbstractSafeParcelable) this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzal();
    }
}
