package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzam extends zzaf {
    final /* synthetic */ zzan zza;

    zzam(zzan zzan) {
        this.zza = zzan;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzx.zza(i, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzan zzan = this.zza;
        int i2 = i + i;
        Object obj = zzan.zzb[i2];
        obj.getClass();
        Object obj2 = zzan.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
