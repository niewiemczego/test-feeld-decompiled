package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzhh implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzhi zzb;

    zzhh(zzhi zzhi) {
        this.zzb = zzhi;
        this.zza = zzhi.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
