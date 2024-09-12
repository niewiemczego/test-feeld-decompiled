package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeUtils;
import coil.intercept.EngineInterceptor;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.Utils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J5\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001cJ0\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000bJ \u0010(\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006,"}, d2 = {"Lcoil/memory/MemoryCacheService;", "", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "diskCacheKey", "", "Lcoil/memory/MemoryCache$Value;", "getDiskCacheKey", "(Lcoil/memory/MemoryCache$Value;)Ljava/lang/String;", "isSampled", "", "(Lcoil/memory/MemoryCache$Value;)Z", "getCacheValue", "request", "Lcoil/request/ImageRequest;", "cacheKey", "Lcoil/memory/MemoryCache$Key;", "size", "Lcoil/size/Size;", "scale", "Lcoil/size/Scale;", "isCacheValueValid", "cacheValue", "isCacheValueValid$coil_base_release", "isSizeValid", "newCacheKey", "mappedData", "options", "Lcoil/request/Options;", "eventListener", "Lcoil/EventListener;", "newResult", "Lcoil/request/SuccessResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "setCacheValue", "result", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "Companion", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MemoryCacheService.kt */
public final class MemoryCacheService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_DISK_CACHE_KEY = "coil#disk_cache_key";
    public static final String EXTRA_IS_SAMPLED = "coil#is_sampled";
    public static final String EXTRA_TRANSFORMATION_INDEX = "coil#transformation_";
    public static final String EXTRA_TRANSFORMATION_SIZE = "coil#transformation_size";
    private static final String TAG = "MemoryCacheService";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final RequestService requestService;

    public MemoryCacheService(ImageLoader imageLoader2, RequestService requestService2, Logger logger2) {
        this.imageLoader = imageLoader2;
        this.requestService = requestService2;
        this.logger = logger2;
    }

    public final MemoryCache.Key newCacheKey(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener) {
        MemoryCache.Key memoryCacheKey = imageRequest.getMemoryCacheKey();
        if (memoryCacheKey != null) {
            return memoryCacheKey;
        }
        eventListener.keyStart(imageRequest, obj);
        String key = this.imageLoader.getComponents().key(obj, options);
        eventListener.keyEnd(imageRequest, key);
        if (key == null) {
            return null;
        }
        List<Transformation> transformations = imageRequest.getTransformations();
        Map<String, String> memoryCacheKeys = imageRequest.getParameters().memoryCacheKeys();
        if (transformations.isEmpty() && memoryCacheKeys.isEmpty()) {
            return new MemoryCache.Key(key, (Map) null, 2, (DefaultConstructorMarker) null);
        }
        Map<String, String> mutableMap = MapsKt.toMutableMap(memoryCacheKeys);
        if (!transformations.isEmpty()) {
            List<Transformation> transformations2 = imageRequest.getTransformations();
            int size = transformations2.size();
            for (int i = 0; i < size; i++) {
                mutableMap.put(EXTRA_TRANSFORMATION_INDEX + i, transformations2.get(i).getCacheKey());
            }
            mutableMap.put(EXTRA_TRANSFORMATION_SIZE, options.getSize().toString());
        }
        return new MemoryCache.Key(key, mutableMap);
    }

    public final MemoryCache.Value getCacheValue(ImageRequest imageRequest, MemoryCache.Key key, Size size, Scale scale) {
        if (!imageRequest.getMemoryCachePolicy().getReadEnabled()) {
            return null;
        }
        MemoryCache memoryCache = this.imageLoader.getMemoryCache();
        MemoryCache.Value value = memoryCache != null ? memoryCache.get(key) : null;
        if (value == null || !isCacheValueValid$coil_base_release(imageRequest, key, value, size, scale)) {
            return null;
        }
        return value;
    }

    public final boolean isCacheValueValid$coil_base_release(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        if (this.requestService.isConfigValidForHardware(imageRequest, Bitmaps.getSafeConfig(value.getBitmap()))) {
            return isSizeValid(imageRequest, key, value, size, scale);
        }
        Logger logger2 = this.logger;
        if (logger2 == null || logger2.getLevel() > 3) {
            return false;
        }
        logger2.log(TAG, 3, imageRequest.getData() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", (Throwable) null);
        return false;
    }

    private final boolean isSizeValid(ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value, Size size, Scale scale) {
        Scale scale2 = scale;
        boolean isSampled = isSampled(value);
        if (!Sizes.isOriginal(size)) {
            String str = key.getExtras().get(EXTRA_TRANSFORMATION_SIZE);
            if (str != null) {
                return Intrinsics.areEqual((Object) str, (Object) size.toString());
            }
            int width = value.getBitmap().getWidth();
            int height = value.getBitmap().getHeight();
            Dimension width2 = size.getWidth();
            int i = Integer.MAX_VALUE;
            int i2 = width2 instanceof Dimension.Pixels ? ((Dimension.Pixels) width2).px : Integer.MAX_VALUE;
            Dimension height2 = size.getHeight();
            if (height2 instanceof Dimension.Pixels) {
                i = ((Dimension.Pixels) height2).px;
            }
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, i2, i, scale2);
            boolean allowInexactSize = Requests.getAllowInexactSize(imageRequest);
            if (allowInexactSize) {
                double coerceAtMost = RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
                if (Math.abs(((double) i2) - (((double) width) * coerceAtMost)) <= 1.0d || Math.abs(((double) i) - (coerceAtMost * ((double) height))) <= 1.0d) {
                    return true;
                }
            } else if ((Utils.isMinOrMax(i2) || Math.abs(i2 - width) <= 1) && (Utils.isMinOrMax(i) || Math.abs(i - height) <= 1)) {
                return true;
            }
            if (!(computeSizeMultiplier == 1.0d) && !allowInexactSize) {
                Logger logger2 = this.logger;
                if (logger2 == null || logger2.getLevel() > 3) {
                    return false;
                }
                logger2.log(TAG, 3, imageRequest.getData() + ": Cached image's request size (" + width + ", " + height + ") does not exactly match the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale2 + ").", (Throwable) null);
                return false;
            } else if (computeSizeMultiplier <= 1.0d || !isSampled) {
                return true;
            } else {
                Logger logger3 = this.logger;
                if (logger3 == null || logger3.getLevel() > 3) {
                    return false;
                }
                logger3.log(TAG, 3, imageRequest.getData() + ": Cached image's request size (" + width + ", " + height + ") is smaller than the requested size (" + size.getWidth() + ", " + size.getHeight() + ", " + scale2 + ").", (Throwable) null);
                return false;
            }
        } else if (!isSampled) {
            return true;
        } else {
            Logger logger4 = this.logger;
            if (logger4 != null && logger4.getLevel() <= 3) {
                logger4.log(TAG, 3, imageRequest.getData() + ": Requested original size, but cached image is sampled.", (Throwable) null);
            }
            return false;
        }
    }

    public final boolean setCacheValue(MemoryCache.Key key, ImageRequest imageRequest, EngineInterceptor.ExecuteResult executeResult) {
        MemoryCache memoryCache;
        Bitmap bitmap;
        if (!(!imageRequest.getMemoryCachePolicy().getWriteEnabled() || (memoryCache = this.imageLoader.getMemoryCache()) == null || key == null)) {
            Drawable drawable = executeResult.getDrawable();
            BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
            if (!(bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null)) {
                Map linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(EXTRA_IS_SAMPLED, Boolean.valueOf(executeResult.isSampled()));
                String diskCacheKey = executeResult.getDiskCacheKey();
                if (diskCacheKey != null) {
                    linkedHashMap.put(EXTRA_DISK_CACHE_KEY, diskCacheKey);
                }
                memoryCache.set(key, new MemoryCache.Value(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }

    public final SuccessResult newResult(Interceptor.Chain chain, ImageRequest imageRequest, MemoryCache.Key key, MemoryCache.Value value) {
        return new SuccessResult(new BitmapDrawable(imageRequest.getContext().getResources(), value.getBitmap()), imageRequest, DataSource.MEMORY_CACHE, key, getDiskCacheKey(value), isSampled(value), Utils.isPlaceholderCached(chain));
    }

    private final boolean isSampled(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_IS_SAMPLED);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final String getDiskCacheKey(MemoryCache.Value value) {
        Object obj = value.getExtras().get(EXTRA_DISK_CACHE_KEY);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcoil/memory/MemoryCacheService$Companion;", "", "()V", "EXTRA_DISK_CACHE_KEY", "", "getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations", "EXTRA_IS_SAMPLED", "getEXTRA_IS_SAMPLED$coil_base_release$annotations", "EXTRA_TRANSFORMATION_INDEX", "getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations", "EXTRA_TRANSFORMATION_SIZE", "getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations", "TAG", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MemoryCacheService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_IS_SAMPLED$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations() {
        }

        private Companion() {
        }
    }
}
