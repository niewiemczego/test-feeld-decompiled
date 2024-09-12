package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzib implements Callable<List<zzmh>> {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzhj zzc;

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza.zzr();
        zzmp zza2 = this.zzc.zza;
        zzo zzo = this.zza;
        Bundle bundle = this.zzb;
        zza2.zzl().zzt();
        if (!zzpg.zza() || !zza2.zze().zze(zzo.zza, zzbi.zzcf) || zzo.zza == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zza2.zzj().zzg().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzao zzf = zza2.zzf();
                        String str = zzo.zza;
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzf.zzt();
                        zzf.zzak();
                        try {
                            zzf.zzj().zzp().zza("Pruned " + zzf.e_().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)}) + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzf.zzj().zzg().zza("Error pruning trigger URIs. appId", zzfr.zza(str), e);
                        }
                    }
                }
            }
        }
        return zza2.zzf().zzh(zzo.zza);
    }

    zzib(zzhj zzhj, zzo zzo, Bundle bundle) {
        this.zzc = zzhj;
        this.zza = zzo;
        this.zzb = bundle;
    }
}
