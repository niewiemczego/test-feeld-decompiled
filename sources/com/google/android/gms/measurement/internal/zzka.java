package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzka implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ Uri zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzjx zze;

    zzka(zzjx zzjx, boolean z, Uri uri, String str, String str2) {
        this.zze = zzjx;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    public final void run() {
        zzjx.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
