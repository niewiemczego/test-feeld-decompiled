package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzdo extends zzdf.zza {
    private final /* synthetic */ Boolean zzc;
    private final /* synthetic */ zzdf zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdo(zzdf zzdf, Boolean bool) {
        super(zzdf);
        this.zzd = zzdf;
        this.zzc = bool;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        if (this.zzc != null) {
            ((zzcu) Preconditions.checkNotNull(this.zzd.zzj)).setMeasurementEnabled(this.zzc.booleanValue(), this.zza);
        } else {
            ((zzcu) Preconditions.checkNotNull(this.zzd.zzj)).clearMeasurementEnabled(this.zza);
        }
    }
}
