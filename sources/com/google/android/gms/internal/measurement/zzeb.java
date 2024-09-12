package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzeb extends zzdf.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzcs zzd;
    private final /* synthetic */ zzdf zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeb(zzdf zzdf, Bundle bundle, zzcs zzcs) {
        super(zzdf);
        this.zze = zzdf;
        this.zzc = bundle;
        this.zzd = zzcs;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zze.zzj)).performAction(this.zzc, this.zzd, this.zza);
    }
}
