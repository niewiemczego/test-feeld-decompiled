package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.0 */
public final class zze implements zza {
    Set<String> zza = new HashSet();
    /* access modifiers changed from: private */
    public AnalyticsConnector.AnalyticsConnectorListener zzb;
    private AppMeasurementSdk zzc;
    private zzd zzd;

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzd zzd2 = new zzd(this);
        this.zzd = zzd2;
        this.zzc.registerOnMeasurementEventListener(zzd2);
    }

    public final void zza(Set<String> set) {
        this.zza.clear();
        Set<String> set2 = this.zza;
        HashSet hashSet = new HashSet();
        for (String next : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzb.zzc(next) && zzb.zzd(next)) {
                String zzb2 = zzb.zzb(next);
                Preconditions.checkNotNull(zzb2);
                hashSet.add(zzb2);
            }
        }
        set2.addAll(hashSet);
    }

    public final void zzb() {
        this.zza.clear();
    }
}
