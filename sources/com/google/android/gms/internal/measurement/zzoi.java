package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzoi implements Supplier<zzol> {
    private static zzoi zza = new zzoi();
    private final Supplier<zzol> zzb = Suppliers.ofInstance(new zzok());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzol) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzol) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzol) zza.get()).zzc();
    }
}
