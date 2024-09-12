package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final /* synthetic */ class zzir implements Runnable {
    private /* synthetic */ zziq zza;
    private /* synthetic */ AtomicReference zzb;

    public /* synthetic */ zzir(zziq zziq, AtomicReference atomicReference) {
        this.zza = zziq;
        this.zzb = atomicReference;
    }

    public final void run() {
        zziq zziq = this.zza;
        AtomicReference atomicReference = this.zzb;
        Bundle zza2 = zziq.zzk().zzi.zza();
        zzkp zzo = zziq.zzo();
        if (zza2 == null) {
            zza2 = new Bundle();
        }
        zzo.zza((AtomicReference<List<zzmh>>) atomicReference, zza2);
    }
}
