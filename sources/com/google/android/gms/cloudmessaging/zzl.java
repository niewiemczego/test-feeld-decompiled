package com.google.android.gms.cloudmessaging;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
public final /* synthetic */ class zzl implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ zzr zzb;

    public /* synthetic */ zzl(zzn zzn, zzr zzr) {
        this.zza = zzn;
        this.zzb = zzr;
    }

    public final void run() {
        this.zza.zze(this.zzb.zza);
    }
}
