package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final /* synthetic */ class zzhi implements Runnable {
    private /* synthetic */ zzhj zza;
    private /* synthetic */ String zzb;
    private /* synthetic */ Bundle zzc;

    public /* synthetic */ zzhi(zzhj zzhj, String str, Bundle bundle) {
        this.zza = zzhj;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
