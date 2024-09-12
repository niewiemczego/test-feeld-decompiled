package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzeu extends zzdf.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzcs zzd;
    private final /* synthetic */ zzdf.zzd zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeu(zzdf.zzd zzd2, Activity activity, zzcs zzcs) {
        super(zzdf.this);
        this.zze = zzd2;
        this.zzc = activity;
        this.zzd = zzcs;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(zzdf.this.zzj)).onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
