package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpu implements zzpv {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;
    private static final zzgn<Boolean> zzd;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.collection.enable_session_stitching_token.client.dev", true);
        zzb = zza2.zza("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zzc = zza2.zza("measurement.session_stitching_token_enabled", false);
        zzd = zza2.zza("measurement.link_sst_to_sid", true);
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
}
