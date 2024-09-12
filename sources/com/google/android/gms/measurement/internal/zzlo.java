package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzlo implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzlm zzb;

    zzlo(zzlm zzlm, ComponentName componentName) {
        this.zzb = zzlm;
        this.zza = componentName;
    }

    public final void run() {
        zzkp.zza(this.zzb.zza, this.zza);
    }
}
