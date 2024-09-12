package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzji implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zziq zzc;

    zzji(zziq zziq, AtomicReference atomicReference, boolean z) {
        this.zzc = zziq;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzo().zza((AtomicReference<List<zznc>>) this.zza, this.zzb);
    }
}
