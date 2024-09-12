package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import java.util.Map;
import javax.annotation.Nullable;

public interface CountingMemoryCache<K, V> extends MemoryCache<K, V>, MemoryTrimmable {

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    @Nullable
    CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver);

    void clear();

    CountingLruMap<K, Entry<K, V>> getCachedEntries();

    int getEvictionQueueCount();

    int getEvictionQueueSizeInBytes();

    int getInUseSizeInBytes();

    MemoryCacheParams getMemoryCacheParams();

    Map<Bitmap, Object> getOtherEntries();

    void maybeEvictEntries();

    @Nullable
    CloseableReference<V> reuse(K k);

    public static class Entry<K, V> {
        public int accessCount;
        public int clientCount = 0;
        public boolean isOrphan = false;
        public final K key;
        @Nullable
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        private Entry(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            this.key = Preconditions.checkNotNull(k);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeableReference));
            this.observer = entryStateObserver;
            this.accessCount = 0;
        }

        public static <K, V> Entry<K, V> of(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            return new Entry<>(k, closeableReference, entryStateObserver);
        }
    }
}
