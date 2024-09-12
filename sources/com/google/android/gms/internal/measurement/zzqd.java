package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzqd implements Supplier<zzqc> {
    private static zzqd zza = new zzqd();
    private final Supplier<zzqc> zzb = Suppliers.ofInstance(new zzqf());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzqc) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqc) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzqc) zza.get()).zzc();
    }
}
