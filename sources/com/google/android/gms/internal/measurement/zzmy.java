package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzmy implements Supplier<zznb> {
    private static zzmy zza = new zzmy();
    private final Supplier<zznb> zzb = Suppliers.ofInstance(new zzna());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznb) zza.get()).zza();
    }
}
