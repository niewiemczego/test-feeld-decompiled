package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcb;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzgl implements ServiceConnection {
    final /* synthetic */ zzgm zza;
    /* access modifiers changed from: private */
    public final String zzb;

    zzgl(zzgm zzgm, String str) {
        this.zza = zzgm;
        this.zzb = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzj().zzu().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzby zza2 = zzcb.zza(iBinder);
            if (zza2 == null) {
                this.zza.zza.zzj().zzu().zza("Install Referrer Service implementation was not found");
                return;
            }
            this.zza.zza.zzj().zzp().zza("Install Referrer Service connected");
            this.zza.zza.zzl().zzb((Runnable) new zzgo(this, zza2, this));
        } catch (RuntimeException e) {
            this.zza.zza.zzj().zzu().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzj().zzp().zza("Install Referrer Service disconnected");
    }
}
