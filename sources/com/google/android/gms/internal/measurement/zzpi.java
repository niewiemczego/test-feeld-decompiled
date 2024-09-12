package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpi implements zzpj {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;
    private static final zzgn<Boolean> zzd;
    private static final zzgn<Boolean> zze;
    private static final zzgn<Long> zzf;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.rb.attribution.client2", false);
        zzb = zza2.zza("measurement.rb.attribution.followup1.service", false);
        zzc = zza2.zza("measurement.rb.attribution.service", false);
        zzd = zza2.zza("measurement.rb.attribution.enable_trigger_redaction", true);
        zze = zza2.zza("measurement.rb.attribution.uuid_generation", true);
        zzf = zza2.zza("measurement.id.rb.attribution.service", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }

    public final boolean zze() {
        return zzd.zza().booleanValue();
    }

    public final boolean zzf() {
        return zze.zza().booleanValue();
    }
}
