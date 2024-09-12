package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpc implements zzpd {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Double> zzb;
    private static final zzgn<Long> zzc;
    private static final zzgn<Long> zzd;
    private static final zzgn<String> zze;

    public final double zza() {
        return zzb.zza().doubleValue();
    }

    public final long zzb() {
        return zzc.zza().longValue();
    }

    public final long zzc() {
        return zzd.zza().longValue();
    }

    public final String zzd() {
        return zze.zza();
    }

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.test.boolean_flag", false);
        zzb = zza2.zza("measurement.test.double_flag", -3.0d);
        zzc = zza2.zza("measurement.test.int_flag", -2);
        zzd = zza2.zza("measurement.test.long_flag", -1);
        zze = zza2.zza("measurement.test.string_flag", "---");
    }

    public final boolean zze() {
        return zza.zza().booleanValue();
    }
}
