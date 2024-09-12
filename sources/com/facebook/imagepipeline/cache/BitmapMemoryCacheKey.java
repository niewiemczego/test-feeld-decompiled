package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Locale;
import javax.annotation.Nullable;

public class BitmapMemoryCacheKey implements CacheKey {
    private final long mCacheTime;
    @Nullable
    private final Object mCallerContext;
    private final int mHash;
    private final ImageDecodeOptions mImageDecodeOptions;
    @Nullable
    private final CacheKey mPostprocessorCacheKey;
    @Nullable
    private final String mPostprocessorName;
    @Nullable
    private final ResizeOptions mResizeOptions;
    private final RotationOptions mRotationOptions;
    private final String mSourceString;

    public boolean isResourceIdForDebugging() {
        return false;
    }

    public BitmapMemoryCacheKey(String str, @Nullable ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, @Nullable CacheKey cacheKey, @Nullable String str2, @Nullable Object obj) {
        this.mSourceString = (String) Preconditions.checkNotNull(str);
        this.mResizeOptions = resizeOptions;
        this.mRotationOptions = rotationOptions;
        this.mImageDecodeOptions = imageDecodeOptions;
        this.mPostprocessorCacheKey = cacheKey;
        this.mPostprocessorName = str2;
        this.mHash = HashCodeUtil.hashCode((Object) Integer.valueOf(str.hashCode()), (Object) Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0), (Object) Integer.valueOf(rotationOptions.hashCode()), (Object) imageDecodeOptions, (Object) cacheKey, (Object) str2);
        this.mCallerContext = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof BitmapMemoryCacheKey)) {
            return false;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        if (this.mHash != bitmapMemoryCacheKey.mHash || !this.mSourceString.equals(bitmapMemoryCacheKey.mSourceString) || !Objects.equal(this.mResizeOptions, bitmapMemoryCacheKey.mResizeOptions) || !Objects.equal(this.mRotationOptions, bitmapMemoryCacheKey.mRotationOptions) || !Objects.equal(this.mImageDecodeOptions, bitmapMemoryCacheKey.mImageDecodeOptions) || !Objects.equal(this.mPostprocessorCacheKey, bitmapMemoryCacheKey.mPostprocessorCacheKey) || !Objects.equal(this.mPostprocessorName, bitmapMemoryCacheKey.mPostprocessorName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.mHash;
    }

    public boolean containsUri(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    public String getUriString() {
        return this.mSourceString;
    }

    @Nullable
    public String getPostprocessorName() {
        return this.mPostprocessorName;
    }

    public String toString() {
        Locale locale = null;
        return String.format((Locale) null, "%s_%s_%s_%s_%s_%s_%d", new Object[]{this.mSourceString, this.mResizeOptions, this.mRotationOptions, this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash)});
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public long getInBitmapCacheSince() {
        return this.mCacheTime;
    }
}
