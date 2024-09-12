package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzx;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final /* synthetic */ class zzgt implements Callable {
    private /* synthetic */ zzgp zza;
    private /* synthetic */ String zzb;

    public /* synthetic */ zzgt(zzgp zzgp, String str) {
        this.zza = zzgp;
        this.zzb = str;
    }

    public final Object call() {
        return new zzx("internal.appMetadata", new zzgr(this.zza, this.zzb));
    }
}
