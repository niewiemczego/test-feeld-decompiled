package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzjt extends zzjs {
    private static <E> zzjf<E> zzc(Object obj, long j) {
        return (zzjf) zzmg.zze(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzjf zzc = zzc(obj, j);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzjf zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzmg.zza(obj, j, (Object) zza);
        return zza;
    }

    private zzjt() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).i_();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzjf zzc = zzc(obj, j);
        zzjf zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzmg.zza(obj, j, (Object) zzc2);
    }
}
