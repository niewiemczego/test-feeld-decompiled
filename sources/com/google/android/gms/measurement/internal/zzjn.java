package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzjn implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb = null;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zziq zzf;

    zzjn(zziq zziq, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzf = zziq;
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zzu.zzr().zza(this.zza, (String) null, this.zzc, this.zzd, this.zze);
    }
}
