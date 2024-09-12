package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzej extends zzdf.zza {
    private final /* synthetic */ zzdf.zzb zzc;
    private final /* synthetic */ zzdf zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzej(zzdf zzdf, zzdf.zzb zzb) {
        super(zzdf);
        this.zzd = zzdf;
        this.zzc = zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zzd.zzj)).registerOnMeasurementEventListener(this.zzc);
    }
}
