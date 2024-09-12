package coil.memory;

import coil.memory.MemoryCache;
import coil.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0019\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\rH\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcoil/memory/RealMemoryCache;", "Lcoil/memory/MemoryCache;", "strongMemoryCache", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "(Lcoil/memory/StrongMemoryCache;Lcoil/memory/WeakMemoryCache;)V", "keys", "", "Lcoil/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clear", "", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "value", "trimMemory", "level", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RealMemoryCache.kt */
public final class RealMemoryCache implements MemoryCache {
    private final StrongMemoryCache strongMemoryCache;
    private final WeakMemoryCache weakMemoryCache;

    public RealMemoryCache(StrongMemoryCache strongMemoryCache2, WeakMemoryCache weakMemoryCache2) {
        this.strongMemoryCache = strongMemoryCache2;
        this.weakMemoryCache = weakMemoryCache2;
    }

    public int getSize() {
        return this.strongMemoryCache.getSize();
    }

    public int getMaxSize() {
        return this.strongMemoryCache.getMaxSize();
    }

    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.plus(this.strongMemoryCache.getKeys(), this.weakMemoryCache.getKeys());
    }

    public MemoryCache.Value get(MemoryCache.Key key) {
        MemoryCache.Value value = this.strongMemoryCache.get(key);
        return value == null ? this.weakMemoryCache.get(key) : value;
    }

    public void set(MemoryCache.Key key, MemoryCache.Value value) {
        this.strongMemoryCache.set(MemoryCache.Key.copy$default(key, (String) null, Collections.toImmutableMap(key.getExtras()), 1, (Object) null), value.getBitmap(), Collections.toImmutableMap(value.getExtras()));
    }

    public boolean remove(MemoryCache.Key key) {
        return this.strongMemoryCache.remove(key) || this.weakMemoryCache.remove(key);
    }

    public void clear() {
        this.strongMemoryCache.clearMemory();
        this.weakMemoryCache.clearMemory();
    }

    public void trimMemory(int i) {
        this.strongMemoryCache.trimMemory(i);
        this.weakMemoryCache.trimMemory(i);
    }
}
