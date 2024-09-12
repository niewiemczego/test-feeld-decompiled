package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzmw implements zznf {
    final /* synthetic */ zzmp zza;

    zzmw(zzmp zzmp) {
        this.zza = zzmp;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzl().zzb((Runnable) new zzmv(this, str, str2, bundle));
        } else if (this.zza.zzm != null) {
            this.zza.zzm.zzj().zzg().zza("AppId not known when logging event", str2);
        }
    }
}
