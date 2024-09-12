package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zznk implements Supplier<zznn> {
    private static zznk zza = new zznk();
    private final Supplier<zznn> zzb = Suppliers.ofInstance(new zznm());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zznn) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznn) zza.get()).zzb();
    }
}
