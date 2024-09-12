package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzz<T> {
    final int what;
    final int zzcp;
    final TaskCompletionSource<T> zzcq = new TaskCompletionSource<>();
    final Bundle zzcr;

    zzz(int i, int i2, Bundle bundle) {
        this.zzcp = i;
        this.what = i2;
        this.zzcr = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzh(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean zzw();

    /* access modifiers changed from: package-private */
    public final void zzd(zzaa zzaa) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzaa);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2).toString());
        }
        this.zzcq.setException(zzaa);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzcp;
        zzw();
        return new StringBuilder(55).append("Request { what=").append(i).append(" id=").append(i2).append(" oneWay=false}").toString();
    }
}
