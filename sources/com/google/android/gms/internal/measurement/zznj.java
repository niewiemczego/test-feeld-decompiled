package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zznj implements Supplier<zzni> {
    private static zznj zza = new zznj();
    private final Supplier<zzni> zzb = Suppliers.ofInstance(new zznl());

    public static long zza() {
        return ((zzni) zza.get()).zza();
    }

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }
}
