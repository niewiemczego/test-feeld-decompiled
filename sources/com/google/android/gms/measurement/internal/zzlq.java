package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzlq implements Runnable {
    private final /* synthetic */ zzlm zza;

    zzlq(zzlm zzlm) {
        this.zza = zzlm;
    }

    public final void run() {
        zzkp.zza(this.zza.zza, new ComponentName(this.zza.zza.zza(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
