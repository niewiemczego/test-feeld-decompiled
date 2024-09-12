package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzpg;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzp extends BroadcastReceiver {
    private final zzhf zza;

    public zzp(zzhf zzhf) {
        this.zza = zzhf;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzj().zzu().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzj().zzu().zza("App receiver called with null action");
            return;
        }
        action.hashCode();
        if (!action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            this.zza.zzj().zzu().zza("App receiver called with unknown action");
            return;
        }
        zzhf zzhf = this.zza;
        if (zzpg.zza() && zzhf.zzf().zzf((String) null, zzbi.zzcg)) {
            zzhf.zzj().zzp().zza("App receiver notified triggers are available");
            zzhf.zzl().zzb((Runnable) new zzr(zzhf));
        }
    }
}
