package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;

public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new CacheKeyFactory$$ExternalSyntheticLambda0();

    String buildCacheKey(DataSpec dataSpec);

    static /* synthetic */ String lambda$static$0(DataSpec dataSpec) {
        return dataSpec.key != null ? dataSpec.key : dataSpec.uri.toString();
    }
}
