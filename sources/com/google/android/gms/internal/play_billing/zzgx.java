package com.google.android.gms.internal.play_billing;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzgx extends AbstractSet {
    final /* synthetic */ zzgz zza;

    /* synthetic */ zzgx(zzgz zzgz, zzgw zzgw) {
        this.zza = zzgz;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zza.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zza.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value || (obj2 != null && obj2.equals(value))) {
            return true;
        }
        return false;
    }

    public final Iterator iterator() {
        return new zzgv(this.zza, (zzgu) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zza.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
