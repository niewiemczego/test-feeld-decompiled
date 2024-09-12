package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzow implements zzox {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;
    private static final zzgn<Long> zzd;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zza2.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zza2.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zza2.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean zza() {
        return zzc.zza().booleanValue();
    }
}
