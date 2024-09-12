package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzjm implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zziq zzb;

    zzjm(zziq zziq, Bundle bundle) {
        this.zzb = zziq;
        this.zza = bundle;
    }

    public final void run() {
        zziq zziq = this.zzb;
        Bundle bundle = this.zza;
        zziq.zzt();
        zziq.zzu();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zziq.zzu.zzac()) {
            zziq.zzj().zzp().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zznc zznc = new zznc(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string2);
        try {
            zzbg zza2 = zziq.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0, true, true);
            zzbg zza3 = zziq.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0, true, true);
            zzbg zza4 = zziq.zzq().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0, true, true);
            zziq.zzo().zza(new zzad(bundle.getString("app_id"), string2, zznc, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zza3, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza4));
        } catch (IllegalArgumentException unused) {
        }
    }
}
