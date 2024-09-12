package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzdj extends zzdf.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzcs zze;
    private final /* synthetic */ zzdf zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdj(zzdf zzdf, String str, String str2, zzcs zzcs) {
        super(zzdf);
        this.zzf = zzdf;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzcs;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zze.zza((Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zzf.zzj)).getConditionalUserProperties(this.zzc, this.zzd, this.zze);
    }
}
