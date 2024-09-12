package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpb implements zzoy {
    private static final zzgn<Long> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zza2.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzc = zza2.zza("measurement.lifecycle.app_in_background_parameter", false);
    }

    public final boolean zza() {
        return zzc.zza().booleanValue();
    }
}
