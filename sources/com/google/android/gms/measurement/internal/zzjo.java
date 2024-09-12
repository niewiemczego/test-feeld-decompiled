package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzjo implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb = null;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zziq zze;

    zzjo(zziq zziq, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zze = zziq;
        this.zza = atomicReference;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final void run() {
        this.zze.zzu.zzr().zza((AtomicReference<List<zzad>>) this.zza, (String) null, this.zzc, this.zzd);
    }
}
