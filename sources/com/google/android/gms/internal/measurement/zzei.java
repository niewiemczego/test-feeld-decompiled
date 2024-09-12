package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzei extends zzdf.zza {
    private final /* synthetic */ zzcs zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzdf zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzei(zzdf zzdf, zzcs zzcs, int i) {
        super(zzdf);
        this.zze = zzdf;
        this.zzc = zzcs;
        this.zzd = i;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zze.zzj)).getTestFlag(this.zzc, this.zzd);
    }
}
