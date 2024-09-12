package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzlh implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzo zze;
    private final /* synthetic */ zzkp zzf;

    zzlh(zzkp zzkp, AtomicReference atomicReference, String str, String str2, String str3, zzo zzo) {
        this.zzf = zzkp;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzo;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzfk zza2 = this.zzf.zzb;
                if (zza2 == null) {
                    this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; not connected to service", zzfr.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    Preconditions.checkNotNull(this.zze);
                    this.zza.set(zza2.zza(this.zzc, this.zzd, this.zze));
                } else {
                    this.zza.set(zza2.zza(this.zzb, this.zzc, this.zzd));
                }
                this.zzf.zzal();
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; remote exception", zzfr.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
