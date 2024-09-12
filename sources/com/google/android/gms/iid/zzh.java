package com.google.android.gms.iid;

import android.content.Intent;
import android.util.Log;

final class zzh implements Runnable {
    private final /* synthetic */ Intent zzbf;
    private final /* synthetic */ zzg zzbl;

    zzh(zzg zzg, Intent intent) {
        this.zzbl = zzg;
        this.zzbf = intent;
    }

    public final void run() {
        String action = this.zzbf.getAction();
        Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.").toString());
        this.zzbl.finish();
    }
}
