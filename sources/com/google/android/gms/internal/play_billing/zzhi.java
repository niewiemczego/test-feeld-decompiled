package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzhi extends AbstractList implements RandomAccess, zzfk {
    /* access modifiers changed from: private */
    public final zzfk zza;

    public zzhi(zzfk zzfk) {
        this.zza = zzfk;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((zzfj) this.zza).get(i);
    }

    public final Iterator iterator() {
        return new zzhh(this);
    }

    public final ListIterator listIterator(int i) {
        return new zzhg(this, i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final zzfk zze() {
        return this;
    }

    public final Object zzf(int i) {
        return this.zza.zzf(i);
    }

    public final List zzh() {
        return this.zza.zzh();
    }
}
