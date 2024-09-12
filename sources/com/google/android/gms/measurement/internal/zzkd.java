package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final /* synthetic */ class zzkd implements Runnable {
    private /* synthetic */ zzke zza;
    private /* synthetic */ int zzb;
    private /* synthetic */ Exception zzc;
    private /* synthetic */ byte[] zzd;
    private /* synthetic */ Map zze;

    public /* synthetic */ zzkd(zzke zzke, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zzke;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
