package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpm implements Supplier<zzpp> {
    private static zzpm zza = new zzpm();
    private final Supplier<zzpp> zzb = Suppliers.ofInstance(new zzpo());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzpp) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpp) zza.get()).zzb();
    }
}