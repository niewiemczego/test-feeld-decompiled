package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzoh implements Supplier<zzog> {
    private static zzoh zza = new zzoh();
    private final Supplier<zzog> zzb = Suppliers.ofInstance(new zzoj());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzog) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzog) zza.get()).zzb();
    }
}
