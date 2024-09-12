package com.google.android.gms.internal.auth;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzcf extends ContentObserver {
    final /* synthetic */ zzcg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcf(zzcg zzcg, Handler handler) {
        super((Handler) null);
        this.zza = zzcg;
    }

    public final void onChange(boolean z) {
        this.zza.zze();
    }
}
