package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzod implements zzoa {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;
    private static final zzgn<Boolean> zzd;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zza2.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zza2.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zza2.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zzb.zza().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zza().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zza().booleanValue();
    }
}
