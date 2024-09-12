package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zznm implements zznn {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Long> zzb;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.service.deferred_first_open", false);
        zzb = zza2.zza("measurement.id.service.deferred_first_open", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
