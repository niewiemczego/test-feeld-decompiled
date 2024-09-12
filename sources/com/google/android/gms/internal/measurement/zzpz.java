package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpz implements zzpw {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;
    private static final zzgn<Boolean> zzd;
    private static final zzgn<Boolean> zze;
    private static final zzgn<Long> zzf;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.client.sessions.background_sessions_enabled", true);
        zzb = zza2.zza("measurement.client.sessions.enable_fix_background_engagement", false);
        zzc = zza2.zza("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzd = zza2.zza("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zze = zza2.zza("measurement.client.sessions.session_id_enabled", true);
        zzf = zza2.zza("measurement.id.client.sessions.enable_fix_background_engagement", 0);
    }

    public final boolean zza() {
        return zzb.zza().booleanValue();
    }
}
