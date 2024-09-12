package com.bumptech.glide.integration.webp.decoder;

public final class WebpFrameCacheStrategy {
    public static final WebpFrameCacheStrategy ALL = new Builder().cacheAll().build();
    public static final WebpFrameCacheStrategy AUTO = new Builder().cacheAuto().build();
    public static final WebpFrameCacheStrategy NONE = new Builder().noCache().build();
    private int mCacheSize;
    private CacheControl mCacheStrategy;

    public enum CacheControl {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    private WebpFrameCacheStrategy(Builder builder) {
        this.mCacheStrategy = builder.cacheControl;
        this.mCacheSize = builder.cacheSize;
    }

    public CacheControl getCacheControl() {
        return this.mCacheStrategy;
    }

    public boolean noCache() {
        return this.mCacheStrategy == CacheControl.CACHE_NONE;
    }

    public boolean cacheAuto() {
        return this.mCacheStrategy == CacheControl.CACHE_AUTO;
    }

    public boolean cacheAll() {
        return this.mCacheStrategy == CacheControl.CACHE_ALL;
    }

    public int getCacheSize() {
        return this.mCacheSize;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public CacheControl cacheControl;
        /* access modifiers changed from: private */
        public int cacheSize;

        public Builder noCache() {
            this.cacheControl = CacheControl.CACHE_NONE;
            return this;
        }

        public Builder cacheAll() {
            this.cacheControl = CacheControl.CACHE_ALL;
            return this;
        }

        public Builder cacheAuto() {
            this.cacheControl = CacheControl.CACHE_AUTO;
            return this;
        }

        public Builder cacheLimited() {
            this.cacheControl = CacheControl.CACHE_LIMITED;
            return this;
        }

        public Builder cacheControl(CacheControl cacheControl2) {
            this.cacheControl = cacheControl2;
            return this;
        }

        public Builder cacheSize(int i) {
            this.cacheSize = i;
            if (i == 0) {
                this.cacheControl = CacheControl.CACHE_NONE;
            } else if (i == Integer.MAX_VALUE) {
                this.cacheControl = CacheControl.CACHE_ALL;
            } else {
                this.cacheControl = CacheControl.CACHE_LIMITED;
            }
            return this;
        }

        public WebpFrameCacheStrategy build() {
            return new WebpFrameCacheStrategy(this);
        }
    }
}
