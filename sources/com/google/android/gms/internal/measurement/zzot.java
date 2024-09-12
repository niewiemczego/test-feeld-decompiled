package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzot implements Supplier<zzos> {
    private static zzot zza = new zzot();
    private final Supplier<zzos> zzb = Suppliers.ofInstance(new zzov());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzos) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzos) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzos) zza.get()).zzc();
    }
}
