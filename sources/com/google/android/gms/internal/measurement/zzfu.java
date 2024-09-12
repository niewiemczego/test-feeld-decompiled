package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzfu extends ContentObserver {
    zzfu(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzfr.zze.set(true);
    }
}
