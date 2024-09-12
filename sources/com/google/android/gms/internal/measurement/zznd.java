package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zznd implements Supplier<zznc> {
    private static zznd zza = new zznd();
    private final Supplier<zznc> zzb = Suppliers.ofInstance(new zznf());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznc) zza.get()).zza();
    }
}
