package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
public final class zzu {
    private static zzu zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    private zzn zzd = new zzn(this, (zzm) null);
    private int zze = 1;

    zzu(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzu zzb(Context context) {
        zzu zzu;
        synchronized (zzu.class) {
            if (zza == null) {
                zze.zza();
                zza = new zzu(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            zzu = zza;
        }
        return zzu;
    }

    private final synchronized int zzf() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }

    private final synchronized Task zzg(zzr zzr) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Queueing ".concat(zzr.toString()));
        }
        if (!this.zzd.zzg(zzr)) {
            zzn zzn = new zzn(this, (zzm) null);
            this.zzd = zzn;
            zzn.zzg(zzr);
        }
        return zzr.zzb.getTask();
    }

    public final Task zzc(int i, Bundle bundle) {
        return zzg(new zzq(zzf(), i, bundle));
    }

    public final Task zzd(int i, Bundle bundle) {
        return zzg(new zzt(zzf(), 1, bundle));
    }
}
