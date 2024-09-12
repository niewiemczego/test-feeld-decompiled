package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzgx implements zzo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzgp zzb;

    public final String zza(String str) {
        Map map = (Map) this.zzb.zzc.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }

    zzgx(zzgp zzgp, String str) {
        this.zzb = zzgp;
        this.zza = str;
    }
}
