package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzjl implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zziq zzb;

    zzjl(zziq zziq, Bundle bundle) {
        this.zzb = zziq;
        this.zza = bundle;
    }

    public final void run() {
        zziq zziq = this.zzb;
        Bundle bundle = this.zza;
        zziq.zzt();
        zziq.zzu();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zziq.zzu.zzac()) {
            zziq.zzj().zzp().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zznc zznc = new zznc(checkNotEmpty, 0, (Object) null, "");
        try {
            zzad zzad = r4;
            zzad zzad2 = new zzad(bundle.getString("app_id"), "", zznc, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean("active"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzbg) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzbg) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zziq.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true));
            zziq.zzo().zza(zzad);
        } catch (IllegalArgumentException unused) {
        }
    }
}
