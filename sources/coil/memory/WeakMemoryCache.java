package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004H&J4\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0015H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcoil/memory/WeakMemoryCache;", "", "keys", "", "Lcoil/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "clearMemory", "", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "extras", "", "", "size", "", "trimMemory", "level", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WeakMemoryCache.kt */
public interface WeakMemoryCache {
    void clearMemory();

    MemoryCache.Value get(MemoryCache.Key key);

    Set<MemoryCache.Key> getKeys();

    boolean remove(MemoryCache.Key key);

    void set(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> map, int i);

    void trimMemory(int i);
}
