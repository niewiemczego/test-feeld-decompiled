package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzih;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public enum zzig {
    STORAGE(zzih.zza.AD_STORAGE, zzih.zza.ANALYTICS_STORAGE),
    DMA(zzih.zza.AD_USER_DATA);
    
    /* access modifiers changed from: private */
    public final zzih.zza[] zzd;

    private zzig(zzih.zza... zzaArr) {
        this.zzd = zzaArr;
    }

    public final zzih.zza[] zza() {
        return this.zzd;
    }
}
