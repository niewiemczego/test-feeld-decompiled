package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzpy;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzgo implements Runnable {
    private final /* synthetic */ zzby zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzgl zzc;

    zzgo(zzgl zzgl, zzby zzby, ServiceConnection serviceConnection) {
        this.zzc = zzgl;
        this.zza = zzby;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzgm zzgm = this.zzc.zza;
        String zza2 = this.zzc.zzb;
        zzby zzby = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza3 = zzgm.zza(zza2, zzby);
        zzgm.zza.zzl().zzt();
        zzgm.zza.zzy();
        if (zza3 != null) {
            long j = zza3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzgm.zza.zzj().zzu().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzgm.zza.zzj().zzg().zza("No referrer defined in Install Referrer response");
                } else {
                    zzgm.zza.zzj().zzp().zza("InstallReferrer API result", string);
                    Bundle zza4 = zzgm.zza.zzt().zza(Uri.parse("?" + string), zzpy.zza() && zzgm.zza.zzf().zza(zzbi.zzbz), zzoi.zza() && zzgm.zza.zzf().zza(zzbi.zzct));
                    if (zza4 == null) {
                        zzgm.zza.zzj().zzg().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zza4.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzgm.zza.zzj().zzg().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza4.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzgm.zza.zzn().zzd.zza()) {
                            zzgm.zza.zzj().zzp().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzgm.zza.zzac()) {
                            zzgm.zza.zzn().zzd.zza(j);
                            zzgm.zza.zzj().zzp().zza("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zza4.putString("_cis", "referrer API v2");
                            zzgm.zza.zzp().zza("auto", "_cmp", zza4, zza2);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzgm.zza.zza(), serviceConnection);
        }
    }
}
