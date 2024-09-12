package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public final class zzkb<K, V> {
    static <K, V> int zza(zzke<K, V> zzke, K k, V v) {
        return zziq.zza(zzke.zza, 1, k) + zziq.zza(zzke.zzc, 2, v);
    }

    static <K, V> void zza(zzig zzig, zzke<K, V> zzke, K k, V v) throws IOException {
        zziq.zza(zzig, zzke.zza, 1, k);
        zziq.zza(zzig, zzke.zzc, 2, v);
    }
}
