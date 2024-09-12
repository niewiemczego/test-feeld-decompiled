package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
abstract class zzjs {
    private static final zzjs zza = new zzjr();
    private static final zzjs zzb = new zzjt();

    static zzjs zza() {
        return zza;
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzjs zzb() {
        return zzb;
    }

    private zzjs() {
    }
}
