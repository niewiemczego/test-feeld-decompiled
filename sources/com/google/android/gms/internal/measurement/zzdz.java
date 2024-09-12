package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzdz extends zzdf.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzcs zzf;
    private final /* synthetic */ zzdf zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdz(zzdf zzdf, String str, String str2, boolean z, zzcs zzcs) {
        super(zzdf);
        this.zzg = zzdf;
        this.zzc = str;
        this.zzd = str2;
        this.zze = z;
        this.zzf = zzcs;
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzf.zza((Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zzg.zzj)).getUserProperties(this.zzc, this.zzd, this.zze, this.zzf);
    }
}
