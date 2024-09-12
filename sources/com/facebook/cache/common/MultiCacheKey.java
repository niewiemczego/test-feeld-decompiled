package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

public class MultiCacheKey implements CacheKey {
    final List<CacheKey> mCacheKeys;

    public boolean isResourceIdForDebugging() {
        return false;
    }

    public MultiCacheKey(List<CacheKey> list) {
        this.mCacheKeys = (List) Preconditions.checkNotNull(list);
    }

    public List<CacheKey> getCacheKeys() {
        return this.mCacheKeys;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mCacheKeys.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiCacheKey) {
            return this.mCacheKeys.equals(((MultiCacheKey) obj).mCacheKeys);
        }
        return false;
    }

    public int hashCode() {
        return this.mCacheKeys.hashCode();
    }

    public boolean containsUri(Uri uri) {
        for (int i = 0; i < this.mCacheKeys.size(); i++) {
            if (this.mCacheKeys.get(i).containsUri(uri)) {
                return true;
            }
        }
        return false;
    }

    public String getUriString() {
        return this.mCacheKeys.get(0).getUriString();
    }
}
