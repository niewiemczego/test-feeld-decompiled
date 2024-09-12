package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

final class CachedContent {
    private static final String TAG = "CachedContent";
    private final TreeSet<SimpleCacheSpan> cachedSpans;
    public final int id;
    public final String key;
    private final ArrayList<Range> lockedRanges;
    private DefaultContentMetadata metadata;

    public CachedContent(int i, String str) {
        this(i, str, DefaultContentMetadata.EMPTY);
    }

    public CachedContent(int i, String str, DefaultContentMetadata defaultContentMetadata) {
        this.id = i;
        this.key = str;
        this.metadata = defaultContentMetadata;
        this.cachedSpans = new TreeSet<>();
        this.lockedRanges = new ArrayList<>();
    }

    public DefaultContentMetadata getMetadata() {
        return this.metadata;
    }

    public boolean applyMetadataMutations(ContentMetadataMutations contentMetadataMutations) {
        DefaultContentMetadata defaultContentMetadata = this.metadata;
        DefaultContentMetadata copyWithMutationsApplied = defaultContentMetadata.copyWithMutationsApplied(contentMetadataMutations);
        this.metadata = copyWithMutationsApplied;
        return !copyWithMutationsApplied.equals(defaultContentMetadata);
    }

    public boolean isFullyUnlocked() {
        return this.lockedRanges.isEmpty();
    }

    public boolean isFullyLocked(long j, long j2) {
        for (int i = 0; i < this.lockedRanges.size(); i++) {
            if (this.lockedRanges.get(i).contains(j, j2)) {
                return true;
            }
        }
        return false;
    }

    public boolean lockRange(long j, long j2) {
        for (int i = 0; i < this.lockedRanges.size(); i++) {
            if (this.lockedRanges.get(i).intersects(j, j2)) {
                return false;
            }
        }
        this.lockedRanges.add(new Range(j, j2));
        return true;
    }

    public void unlockRange(long j) {
        for (int i = 0; i < this.lockedRanges.size(); i++) {
            if (this.lockedRanges.get(i).position == j) {
                this.lockedRanges.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public TreeSet<SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public SimpleCacheSpan getSpan(long j, long j2) {
        SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j);
        SimpleCacheSpan floor = this.cachedSpans.floor(createLookup);
        if (floor != null && floor.position + floor.length > j) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.cachedSpans.ceiling(createLookup);
        if (ceiling != null) {
            long j3 = ceiling.position - j;
            if (j2 == -1) {
                j2 = j3;
            } else {
                j2 = Math.min(j3, j2);
            }
        }
        return SimpleCacheSpan.createHole(this.key, j, j2);
    }

    public long getCachedBytesLength(long j, long j2) {
        boolean z = true;
        Assertions.checkArgument(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        Assertions.checkArgument(z);
        SimpleCacheSpan span = getSpan(j, j2);
        long j3 = Long.MAX_VALUE;
        if (span.isHoleSpan()) {
            if (!span.isOpenEnded()) {
                j3 = span.length;
            }
            return -Math.min(j3, j2);
        }
        long j4 = j + j2;
        if (j4 >= 0) {
            j3 = j4;
        }
        long j5 = span.position + span.length;
        if (j5 < j3) {
            for (SimpleCacheSpan next : this.cachedSpans.tailSet(span, false)) {
                if (next.position <= j5) {
                    j5 = Math.max(j5, next.position + next.length);
                    if (j5 >= j3) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Math.min(j5 - j, j2);
    }

    public SimpleCacheSpan setLastTouchTimestamp(SimpleCacheSpan simpleCacheSpan, long j, boolean z) {
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        File file = (File) Assertions.checkNotNull(simpleCacheSpan.file);
        if (z) {
            File cacheFile = SimpleCacheSpan.getCacheFile((File) Assertions.checkNotNull(file.getParentFile()), this.id, simpleCacheSpan.position, j);
            if (file.renameTo(cacheFile)) {
                file = cacheFile;
            } else {
                Log.w(TAG, "Failed to rename " + file + " to " + cacheFile);
            }
        }
        SimpleCacheSpan copyWithFileAndLastTouchTimestamp = simpleCacheSpan.copyWithFileAndLastTouchTimestamp(file, j);
        this.cachedSpans.add(copyWithFileAndLastTouchTimestamp);
        return copyWithFileAndLastTouchTimestamp;
    }

    public boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public boolean removeSpan(CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        if (cacheSpan.file == null) {
            return true;
        }
        cacheSpan.file.delete();
        return true;
    }

    public int hashCode() {
        return (((this.id * 31) + this.key.hashCode()) * 31) + this.metadata.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CachedContent cachedContent = (CachedContent) obj;
        if (this.id != cachedContent.id || !this.key.equals(cachedContent.key) || !this.cachedSpans.equals(cachedContent.cachedSpans) || !this.metadata.equals(cachedContent.metadata)) {
            return false;
        }
        return true;
    }

    private static final class Range {
        public final long length;
        public final long position;

        public Range(long j, long j2) {
            this.position = j;
            this.length = j2;
        }

        public boolean contains(long j, long j2) {
            long j3 = this.length;
            if (j3 == -1) {
                if (j >= this.position) {
                    return true;
                }
                return false;
            } else if (j2 == -1) {
                return false;
            } else {
                long j4 = this.position;
                if (j4 > j || j + j2 > j4 + j3) {
                    return false;
                }
                return true;
            }
        }

        public boolean intersects(long j, long j2) {
            long j3 = this.position;
            if (j3 <= j) {
                long j4 = this.length;
                if (j4 == -1 || j3 + j4 > j) {
                    return true;
                }
                return false;
            } else if (j2 == -1 || j + j2 > j3) {
                return true;
            } else {
                return false;
            }
        }
    }
}
