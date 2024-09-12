package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.0 */
public final class zzg implements zza {
    /* access modifiers changed from: private */
    public AnalyticsConnector.AnalyticsConnectorListener zza;
    private AppMeasurementSdk zzb;
    private zzf zzc;

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    public final void zza(Set<String> set) {
    }

    public final void zzb() {
    }

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurementSdk;
        zzf zzf = new zzf(this);
        this.zzc = zzf;
        this.zzb.registerOnMeasurementEventListener(zzf);
    }
}
