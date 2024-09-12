package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzhq implements Callable<List<zzad>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzhj zzd;

    public final /* synthetic */ Object call() throws Exception {
        this.zzd.zza.zzr();
        return this.zzd.zza.zzf().zza(this.zza, this.zzb, this.zzc);
    }

    zzhq(zzhj zzhj, String str, String str2, String str3) {
        this.zzd = zzhj;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}
