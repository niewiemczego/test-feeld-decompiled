package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
class zzalt extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzalh zza;

    public int size() {
        return this.zza.size();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzalr(this.zza);
    }

    private zzalt(zzalh zzalh) {
        this.zza = zzalh;
    }

    public void clear() {
        this.zza.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zza.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zza.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zza.remove(entry.getKey());
        return true;
    }
}
