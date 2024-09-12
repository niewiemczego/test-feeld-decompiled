package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpn implements zzpk {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;
    private static final zzgn<Boolean> zzd;
    private static final zzgn<Boolean> zze;
    private static final zzgn<Boolean> zzf;
    private static final zzgn<Boolean> zzg;
    private static final zzgn<Boolean> zzh;
    private static final zzgn<Boolean> zzi;
    private static final zzgn<Boolean> zzj;
    private static final zzgn<Boolean> zzk;
    private static final zzgn<Boolean> zzl;
    private static final zzgn<Boolean> zzm;
    private static final zzgn<Boolean> zzn;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.redaction.app_instance_id", true);
        zzb = zza2.zza("measurement.redaction.client_ephemeral_aiid_generation", true);
        zzc = zza2.zza("measurement.redaction.config_redacted_fields", true);
        zzd = zza2.zza("measurement.redaction.device_info", true);
        zze = zza2.zza("measurement.redaction.e_tag", true);
        zzf = zza2.zza("measurement.redaction.enhanced_uid", true);
        zzg = zza2.zza("measurement.redaction.populate_ephemeral_app_instance_id", true);
        zzh = zza2.zza("measurement.redaction.google_signals", true);
        zzi = zza2.zza("measurement.redaction.no_aiid_in_config_request", true);
        zzj = zza2.zza("measurement.redaction.retain_major_os_version", true);
        zzk = zza2.zza("measurement.redaction.scion_payload_generator", true);
        zzl = zza2.zza("measurement.redaction.upload_redacted_fields", true);
        zzm = zza2.zza("measurement.redaction.upload_subdomain_override", true);
        zzn = zza2.zza("measurement.redaction.user_id", true);
    }

    public final boolean zza() {
        return zzj.zza().booleanValue();
    }

    public final boolean zzb() {
        return zzk.zza().booleanValue();
    }
}
