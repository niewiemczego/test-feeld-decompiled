package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzpg implements Supplier<zzpj> {
    private static zzpg zza = new zzpg();
    private final Supplier<zzpj> zzb = Suppliers.ofInstance(new zzpi());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzpj) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpj) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzpj) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzpj) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzpj) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzpj) zza.get()).zzf();
    }
}
