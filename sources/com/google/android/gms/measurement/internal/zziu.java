package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final /* synthetic */ class zziu implements Runnable {
    private /* synthetic */ zziq zza;
    private /* synthetic */ List zzb;

    public /* synthetic */ zziu(zziq zziq, List list) {
        this.zza = zziq;
        this.zzb = list;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
