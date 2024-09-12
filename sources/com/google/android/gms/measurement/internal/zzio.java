package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzio {
    final Context zza;
    String zzb;
    String zzc;
    String zzd;
    Boolean zze;
    long zzf;
    zzdd zzg;
    boolean zzh = true;
    Long zzi;
    String zzj;

    public zzio(Context context, zzdd zzdd, Long l) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l;
        if (zzdd != null) {
            this.zzg = zzdd;
            this.zzb = zzdd.zzf;
            this.zzc = zzdd.zze;
            this.zzd = zzdd.zzd;
            this.zzh = zzdd.zzc;
            this.zzf = zzdd.zzb;
            this.zzj = zzdd.zzh;
            if (zzdd.zzg != null) {
                this.zze = Boolean.valueOf(zzdd.zzg.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
