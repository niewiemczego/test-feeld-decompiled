package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzed extends zzdf.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzcs zzd;
    private final /* synthetic */ zzdf zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzed(zzdf zzdf, String str, zzcs zzcs) {
        super(zzdf);
        this.zze = zzdf;
        this.zzc = str;
        this.zzd = zzcs;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zze.zzj)).getMaxUserProperties(this.zzc, this.zzd);
    }
}
