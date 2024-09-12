package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzoo implements Supplier<zzor> {
    private static zzoo zza = new zzoo();
    private final Supplier<zzor> zzb = Suppliers.ofInstance(new zzoq());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzor) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzor) zza.get()).zzb();
    }
}
