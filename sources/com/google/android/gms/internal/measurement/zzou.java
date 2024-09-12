package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzou implements Supplier<zzox> {
    private static zzou zza = new zzou();
    private final Supplier<zzox> zzb = Suppliers.ofInstance(new zzow());

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }

    public static boolean zza() {
        return ((zzox) zza.get()).zza();
    }
}
