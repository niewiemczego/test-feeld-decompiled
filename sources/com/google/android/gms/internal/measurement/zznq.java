package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zznq implements Supplier<zznt> {
    private static zznq zza = new zznq();
    private final Supplier<zznt> zzb = Suppliers.ofInstance(new zzns());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznt) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznt) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zznt) zza.get()).zzc();
    }
}
