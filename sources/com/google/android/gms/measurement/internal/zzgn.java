package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzgn {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzgn(zza zza2) {
        Preconditions.checkNotNull(zza2);
        this.zza = zza2;
    }

    public final void zza(Context context, Intent intent) {
        zzfr zzj = zzhf.zza(context, (zzdd) null, (Long) null).zzj();
        if (intent == null) {
            zzj.zzu().zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzj.zzp().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzj.zzp().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzj.zzu().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
