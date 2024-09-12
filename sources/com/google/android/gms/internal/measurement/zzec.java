package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.0 */
final class zzec extends zzdf.zza {
    private final /* synthetic */ int zzc = 5;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ Object zzf;
    private final /* synthetic */ Object zzg;
    private final /* synthetic */ zzdf zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzec(zzdf zzdf, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.zzh = zzdf;
        this.zzd = str;
        this.zze = obj;
        this.zzf = null;
        this.zzg = null;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcu) Preconditions.checkNotNull(this.zzh.zzj)).logHealthData(this.zzc, this.zzd, ObjectWrapper.wrap(this.zze), ObjectWrapper.wrap(null), ObjectWrapper.wrap(null));
    }
}
