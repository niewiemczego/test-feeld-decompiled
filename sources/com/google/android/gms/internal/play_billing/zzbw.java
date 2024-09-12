package com.google.android.gms.internal.play_billing;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public abstract class zzbw {
    private static String zza = "com.google.android.gms.internal.play_billing.zzcb";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    /* access modifiers changed from: private */
    public static final String[] zzd = {"com.google.android.gms.internal.play_billing.zzcb", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzdc.zza();
    }

    public static long zzb() {
        return zzbu.zza.zzc();
    }

    public static zzbf zzd(String str) {
        return zzbu.zza.zze(str);
    }

    public static zzbh zzf() {
        return zzi().zza();
    }

    public static zzbv zzg() {
        return zzbu.zza.zzh();
    }

    public static zzcl zzi() {
        return zzbu.zza.zzj();
    }

    public static zzcy zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        return zzbu.zza.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z) {
        zzi().zzd(str, level, z);
        return false;
    }

    /* access modifiers changed from: protected */
    public long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public abstract zzbf zze(String str);

    /* access modifiers changed from: protected */
    public abstract zzbv zzh();

    /* access modifiers changed from: protected */
    public zzcl zzj() {
        return zzcl.zze();
    }

    /* access modifiers changed from: protected */
    public abstract String zzm();
}
