package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzkj implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzki zzb;
    private final /* synthetic */ zzki zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzkh zze;

    zzkj(zzkh zzkh, Bundle bundle, zzki zzki, zzki zzki2, long j) {
        this.zze = zzkh;
        this.zza = bundle;
        this.zzb = zzki;
        this.zzc = zzki2;
        this.zzd = j;
    }

    public final void run() {
        zzkh.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
