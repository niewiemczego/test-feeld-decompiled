package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzdp extends zzdf.zza {
    private final /* synthetic */ zzdf zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdp(zzdf zzdf) {
        super(zzdf);
        this.zzc = zzdf;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zzc.zzj)).resetAnalyticsData(this.zza);
    }
}
