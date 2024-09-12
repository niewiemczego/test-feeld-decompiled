package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzao extends zzaj {
    private final transient zzai zza;
    private final transient zzaf zzb;

    zzao(zzai zzai, zzaf zzaf) {
        this.zza = zzai;
        this.zzb = zzaf;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzaf zzd() {
        return this.zzb;
    }

    public final zzas zze() {
        return this.zzb.listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }
}
