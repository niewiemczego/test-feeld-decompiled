package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzoj implements zzog {
    private static final zzgn<Boolean> zza;
    private static final zzgn<Boolean> zzb;
    private static final zzgn<Boolean> zzc;

    static {
        zzgv zza2 = new zzgv(zzgk.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zza2.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zza2.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
