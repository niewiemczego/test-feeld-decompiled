package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzv {
    public static final zzv zza = new zzv();
    private static final ConcurrentHashMap zzb = new ConcurrentHashMap();

    private zzv() {
    }

    public static final void zza(int i, long j) {
        ConcurrentHashMap concurrentHashMap = zzb;
        Integer valueOf = Integer.valueOf(i);
        Object obj = concurrentHashMap.get(valueOf);
        if (obj == null) {
            obj = new zzu();
        }
        zzu zzu = (zzu) obj;
        zzu.zzg(zzu.zzb() + 1);
        zzu.zzf(zzu.zzd() + j);
        zzu.zze(Math.max(j, zzu.zzc()));
        concurrentHashMap.put(valueOf, zzu);
    }
}
