package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final /* synthetic */ class zzgs implements Callable {
    private /* synthetic */ zzgp zza;

    public /* synthetic */ zzgs(zzgp zzgp) {
        this.zza = zzgp;
    }

    public final Object call() {
        return new zzr(this.zza.zzb);
    }
}
