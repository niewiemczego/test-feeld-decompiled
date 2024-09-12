package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
abstract class zzr {
    final int zza;
    final TaskCompletionSource zzb = new TaskCompletionSource();
    final int zzc;
    final Bundle zzd;

    zzr(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    public final String toString() {
        return "Request { what=" + this.zzc + " id=" + this.zza + " oneWay=" + zzb() + "}";
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public final void zzc(zzs zzs) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj = toString();
            String obj2 = zzs.toString();
            Log.d("MessengerIpcClient", "Failing " + obj + " with " + obj2);
        }
        this.zzb.setException(zzs);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj2 = toString();
            String valueOf = String.valueOf(obj);
            Log.d("MessengerIpcClient", "Finishing " + obj2 + " with " + valueOf);
        }
        this.zzb.setResult(obj);
    }
}
