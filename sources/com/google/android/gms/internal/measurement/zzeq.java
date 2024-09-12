package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzeq extends zzdf.zza {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzdf.zzd zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeq(zzdf.zzd zzd2, Activity activity) {
        super(zzdf.this);
        this.zzd = zzd2;
        this.zzc = activity;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(zzdf.this.zzj)).onActivityStarted(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
