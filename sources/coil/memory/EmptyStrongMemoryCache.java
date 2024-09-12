package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import coil.util.Bitmaps;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J,\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcoil/memory/EmptyStrongMemoryCache;", "Lcoil/memory/StrongMemoryCache;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "(Lcoil/memory/WeakMemoryCache;)V", "keys", "", "Lcoil/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clearMemory", "", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "extras", "", "", "", "trimMemory", "level", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StrongMemoryCache.kt */
public final class EmptyStrongMemoryCache implements StrongMemoryCache {
    private final WeakMemoryCache weakMemoryCache;

    public void clearMemory() {
    }

    public MemoryCache.Value get(MemoryCache.Key key) {
        return null;
    }

    public int getMaxSize() {
        return 0;
    }

    public int getSize() {
        return 0;
    }

    public boolean remove(MemoryCache.Key key) {
        return false;
    }

    public void trimMemory(int i) {
    }

    public EmptyStrongMemoryCache(WeakMemoryCache weakMemoryCache2) {
        this.weakMemoryCache = weakMemoryCache2;
    }

    public Set<MemoryCache.Key> getKeys() {
        return SetsKt.emptySet();
    }

    public void set(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> map) {
        this.weakMemoryCache.set(key, bitmap, map, Bitmaps.getAllocationByteCountCompat(bitmap));
    }
}
