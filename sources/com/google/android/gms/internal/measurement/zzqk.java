package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzqk implements Supplier<zzqn> {
    private static zzqk zza = new zzqk();
    private final Supplier<zzqn> zzb = Suppliers.ofInstance(new zzqm());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzqn) zza.get()).zza();
    }
}
