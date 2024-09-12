package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzca implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzcb zza;

    zzca(zzcb zzcb) {
        this.zza = zzcb;
    }

    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            this.zza.zzc = true;
            this.zza.zza();
            return;
        }
        this.zza.zzc = false;
        if (this.zza.zzb()) {
            this.zza.zzb.zzc();
        }
    }
}
