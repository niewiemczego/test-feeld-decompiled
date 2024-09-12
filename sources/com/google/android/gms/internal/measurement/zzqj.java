package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzqj implements Supplier<zzqi> {
    private static zzqj zza = new zzqj();
    private final Supplier<zzqi> zzb = Suppliers.ofInstance(new zzql());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzqi) zza.get()).zza();
    }
}
