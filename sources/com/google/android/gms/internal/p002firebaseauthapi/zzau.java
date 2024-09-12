package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import org.apache.commons.io.FileUtils;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzau  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzau<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zza = new Map.Entry[0];
    @CheckForNull
    private transient zzav<Map.Entry<K, V>> zzb;
    @CheckForNull
    private transient zzav<K> zzc;
    @CheckForNull
    private transient zzal<V> zzd;

    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    public int hashCode() {
        return zzbe.zza((zzav) entrySet());
    }

    /* access modifiers changed from: package-private */
    public abstract zzal<V> zza();

    /* access modifiers changed from: package-private */
    public abstract zzav<Map.Entry<K, V>> zzb();

    /* access modifiers changed from: package-private */
    public abstract zzav<K> zzc();

    /* access modifiers changed from: package-private */
    public abstract boolean zzd();

    public static <K, V> zzau<K, V> zza(Map<? extends K, ? extends V> map) {
        if (!(map instanceof zzau) || (map instanceof SortedMap)) {
            Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
            zzat zzat = new zzat(entrySet instanceof Collection ? entrySet.size() : 4);
            zzat.zza(entrySet);
            return zzat.zza();
        }
        zzau<K, V> zzau = (zzau) map;
        zzau.zzd();
        return zzau;
    }

    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @CheckForNull
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        zzaj.zza(size, "size");
        StringBuilder append = new StringBuilder((int) Math.min(((long) size) << 3, FileUtils.ONE_GB)).append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                append.append(", ");
            }
            z = false;
            append.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return append.append('}').toString();
    }

    public /* synthetic */ Collection values() {
        zzal<V> zzal = this.zzd;
        if (zzal != null) {
            return zzal;
        }
        zzal<V> zza2 = zza();
        this.zzd = zza2;
        return zza2;
    }

    public /* synthetic */ Set entrySet() {
        zzav<Map.Entry<K, V>> zzav = this.zzb;
        if (zzav != null) {
            return zzav;
        }
        zzav<Map.Entry<K, V>> zzb2 = zzb();
        this.zzb = zzb2;
        return zzb2;
    }

    public /* synthetic */ Set keySet() {
        zzav<K> zzav = this.zzc;
        if (zzav != null) {
            return zzav;
        }
        zzav<K> zzc2 = zzc();
        this.zzc = zzc2;
        return zzc2;
    }

    zzau() {
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return ((zzal) values()).contains(obj);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
