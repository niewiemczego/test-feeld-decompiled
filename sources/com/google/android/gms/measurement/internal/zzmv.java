package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzmv implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzmw zzd;

    zzmv(zzmw zzmw, String str, String str2, Bundle bundle) {
        this.zzd = zzmw;
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    public final void run() {
        this.zzd.zza.zza((zzbg) Preconditions.checkNotNull(this.zzd.zza.zzq().zza(this.zza, this.zzb, this.zzc, "auto", this.zzd.zza.zzb().currentTimeMillis(), false, true)), this.zza);
    }
}
