package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    /* access modifiers changed from: protected */
    public abstract Map.Entry<K, V> delegate();

    protected ForwardingMapEntry() {
    }

    @ParametricNullness
    public K getKey() {
        return delegate().getKey();
    }

    @ParametricNullness
    public V getValue() {
        return delegate().getValue();
    }

    @ParametricNullness
    public V setValue(@ParametricNullness V v) {
        return delegate().setValue(v);
    }

    public boolean equals(@CheckForNull Object obj) {
        return delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equal(getKey(), entry.getKey()) || !Objects.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        int i;
        Object key = getKey();
        Object value = getValue();
        int i2 = 0;
        if (key == null) {
            i = 0;
        } else {
            i = key.hashCode();
        }
        if (value != null) {
            i2 = value.hashCode();
        }
        return i ^ i2;
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }
}
