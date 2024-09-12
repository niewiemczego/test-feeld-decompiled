package com.adapty.internal.data.cache;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005H\u0002R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u00028\u00008\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/data/cache/CacheEntity;", "T", "", "value", "cachedAt", "", "(Ljava/lang/Object;J)V", "getCachedAt", "()J", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CacheEntity.kt */
public final class CacheEntity<T> {
    @SerializedName("cached_at")
    private final long cachedAt;
    @SerializedName("value")
    private final T value;

    public CacheEntity(T t, long j) {
        this.value = t;
        this.cachedAt = j;
    }

    public final T getValue() {
        return this.value;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CacheEntity(Object obj, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? System.currentTimeMillis() : j);
    }

    public final long getCachedAt() {
        return this.cachedAt;
    }

    public final T component1() {
        return this.value;
    }

    public final long component2() {
        return this.cachedAt;
    }
}
