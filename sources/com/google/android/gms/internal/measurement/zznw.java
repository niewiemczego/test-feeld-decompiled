package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zznw implements Supplier<zznz> {
    private static zznw zza = new zznw();
    private final Supplier<zznz> zzb = Suppliers.ofInstance(new zzny());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznz) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznz) zza.get()).zzb();
    }
}
