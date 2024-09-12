package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.memory.MemoryCache;
import coil.request.Parameters;
import coil.size.Dimension;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import coil.size.Sizes;
import coil.size.ViewSizeResolver;
import coil.size.ViewSizeResolvers;
import coil.target.ImageViewTarget;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.transform.Transformation;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Collections;
import coil.util.Contexts;
import coil.util.Requests;
import coil.util.Utils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0004\u0001\u0001Bõ\u0002\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u001c\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020,\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00100\u001a\u000201\u0012\u0006\u00102\u001a\u000203\u0012\u0006\u00104\u001a\u000205\u0012\u0006\u00106\u001a\u000207\u0012\b\u00108\u001a\u0004\u0018\u00010\n\u0012\b\u00109\u001a\u0004\u0018\u00010:\u0012\b\u0010;\u001a\u0004\u0018\u00010<\u0012\b\u0010=\u001a\u0004\u0018\u00010:\u0012\b\u0010>\u001a\u0004\u0018\u00010<\u0012\b\u0010?\u001a\u0004\u0018\u00010:\u0012\b\u0010@\u001a\u0004\u0018\u00010<\u0012\u0006\u0010A\u001a\u00020B\u0012\u0006\u0010C\u001a\u00020D¢\u0006\u0002\u0010EJ\u0015\u0010\u0001\u001a\u00020#2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020:H\u0016J\u0014\u0010\u0001\u001a\u00030\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010$\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bH\u0010GR\u0011\u0010%\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bI\u0010GR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010.\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010C\u001a\u00020D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010)\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0013\u0010^\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0010\u0010>\u001a\u0004\u0018\u00010<X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u0004\u0018\u00010:X\u0004¢\u0006\u0004\n\u0002\u0010aR\u0013\u0010b\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\bc\u0010`R\u0010\u0010@\u001a\u0004\u0018\u00010<X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u0004\u0018\u00010:X\u0004¢\u0006\u0004\n\u0002\u0010aR\u0011\u0010-\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bd\u0010SR'\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\bi\u0010SR\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bp\u0010]R\u0011\u0010*\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\bq\u0010]R\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0013\u0010t\u001a\u0004\u0018\u00010<8F¢\u0006\u0006\u001a\u0004\bu\u0010`R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0004¢\u0006\u0002\n\u0000R\u0013\u00108\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bv\u0010oR\u0012\u00109\u001a\u0004\u0018\u00010:X\u0004¢\u0006\u0004\n\u0002\u0010aR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0011\u0010&\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\by\u0010GR\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b~\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0012\u0010/\u001a\u00020,¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010SR\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010\u001c\u001a\u00020\u001d¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcoil/request/ImageRequest;", "", "context", "Landroid/content/Context;", "data", "target", "Lcoil/target/Target;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "diskCacheKey", "", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "precision", "Lcoil/size/Precision;", "fetcherFactory", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "decoderFactory", "Lcoil/decode/Decoder$Factory;", "transformations", "", "Lcoil/transform/Transformation;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "headers", "Lokhttp3/Headers;", "tags", "Lcoil/request/Tags;", "allowConversionToBitmap", "", "allowHardware", "allowRgb565", "premultipliedAlpha", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "parameters", "Lcoil/request/Parameters;", "placeholderMemoryCacheKey", "placeholderResId", "", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "defined", "Lcoil/request/DefinedRequestOptions;", "defaults", "Lcoil/request/DefaultRequestOptions;", "(Landroid/content/Context;Ljava/lang/Object;Lcoil/target/Target;Lcoil/request/ImageRequest$Listener;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Precision;Lkotlin/Pair;Lcoil/decode/Decoder$Factory;Ljava/util/List;Lcoil/transition/Transition$Factory;Lokhttp3/Headers;Lcoil/request/Tags;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lcoil/request/Parameters;Lcoil/memory/MemoryCache$Key;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/DefinedRequestOptions;Lcoil/request/DefaultRequestOptions;)V", "getAllowConversionToBitmap", "()Z", "getAllowHardware", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getColorSpace", "()Landroid/graphics/ColorSpace;", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/lang/Object;", "getDecoderDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDecoderFactory", "()Lcoil/decode/Decoder$Factory;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "getDefined", "()Lcoil/request/DefinedRequestOptions;", "getDiskCacheKey", "()Ljava/lang/String;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "error", "getError", "()Landroid/graphics/drawable/Drawable;", "Ljava/lang/Integer;", "fallback", "getFallback", "getFetcherDispatcher", "getFetcherFactory", "()Lkotlin/Pair;", "getHeaders", "()Lokhttp3/Headers;", "getInterceptorDispatcher", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getListener", "()Lcoil/request/ImageRequest$Listener;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getParameters", "()Lcoil/request/Parameters;", "placeholder", "getPlaceholder", "getPlaceholderMemoryCacheKey", "getPrecision", "()Lcoil/size/Precision;", "getPremultipliedAlpha", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTags", "()Lcoil/request/Tags;", "getTarget", "()Lcoil/target/Target;", "getTransformationDispatcher", "getTransformations", "()Ljava/util/List;", "getTransitionFactory", "()Lcoil/transition/Transition$Factory;", "equals", "other", "hashCode", "newBuilder", "Lcoil/request/ImageRequest$Builder;", "Builder", "Listener", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageRequest.kt */
public final class ImageRequest {
    private final boolean allowConversionToBitmap;
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final ColorSpace colorSpace;
    private final Context context;
    private final Object data;
    private final CoroutineDispatcher decoderDispatcher;
    private final Decoder.Factory decoderFactory;
    private final DefaultRequestOptions defaults;
    private final DefinedRequestOptions defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    /* access modifiers changed from: private */
    public final Drawable errorDrawable;
    /* access modifiers changed from: private */
    public final Integer errorResId;
    /* access modifiers changed from: private */
    public final Drawable fallbackDrawable;
    /* access modifiers changed from: private */
    public final Integer fallbackResId;
    private final CoroutineDispatcher fetcherDispatcher;
    private final Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory;
    private final Headers headers;
    private final CoroutineDispatcher interceptorDispatcher;
    private final Lifecycle lifecycle;
    private final Listener listener;
    private final MemoryCache.Key memoryCacheKey;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    /* access modifiers changed from: private */
    public final Drawable placeholderDrawable;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    /* access modifiers changed from: private */
    public final Integer placeholderResId;
    private final Precision precision;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Tags tags;
    private final Target target;
    private final CoroutineDispatcher transformationDispatcher;
    private final List<Transformation> transformations;
    private final Transition.Factory transitionFactory;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Lcoil/request/ImageRequest$Listener;", "", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "result", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImageRequest.kt */
    public interface Listener {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: ImageRequest.kt */
        public static final class DefaultImpls {
            public static void onCancel(Listener listener, ImageRequest imageRequest) {
            }

            public static void onError(Listener listener, ImageRequest imageRequest, ErrorResult errorResult) {
            }

            public static void onStart(Listener listener, ImageRequest imageRequest) {
            }

            public static void onSuccess(Listener listener, ImageRequest imageRequest, SuccessResult successResult) {
            }
        }

        void onCancel(ImageRequest imageRequest);

        void onError(ImageRequest imageRequest, ErrorResult errorResult);

        void onStart(ImageRequest imageRequest);

        void onSuccess(ImageRequest imageRequest, SuccessResult successResult);
    }

    public /* synthetic */ ImageRequest(Context context2, Object obj, Target target2, Listener listener2, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace2, Precision precision2, Pair pair, Decoder.Factory factory, List list, Transition.Factory factory2, Headers headers2, Tags tags2, boolean z, boolean z2, boolean z3, boolean z4, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, Parameters parameters2, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, obj, target2, listener2, key, str, config, colorSpace2, precision2, pair, factory, list, factory2, headers2, tags2, z, z2, z3, z4, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle2, sizeResolver2, scale2, parameters2, key2, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, defaultRequestOptions);
    }

    public final Builder newBuilder() {
        return newBuilder$default(this, (Context) null, 1, (Object) null);
    }

    private ImageRequest(Context context2, Object obj, Target target2, Listener listener2, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace2, Precision precision2, Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair, Decoder.Factory factory, List<? extends Transformation> list, Transition.Factory factory2, Headers headers2, Tags tags2, boolean z, boolean z2, boolean z3, boolean z4, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, Parameters parameters2, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.context = context2;
        this.data = obj;
        this.target = target2;
        this.listener = listener2;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.bitmapConfig = config;
        this.colorSpace = colorSpace2;
        this.precision = precision2;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.transformations = list;
        this.transitionFactory = factory2;
        this.headers = headers2;
        this.tags = tags2;
        this.allowConversionToBitmap = z;
        this.allowHardware = z2;
        this.allowRgb565 = z3;
        this.premultipliedAlpha = z4;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.interceptorDispatcher = coroutineDispatcher;
        this.fetcherDispatcher = coroutineDispatcher2;
        this.decoderDispatcher = coroutineDispatcher3;
        this.transformationDispatcher = coroutineDispatcher4;
        this.lifecycle = lifecycle2;
        this.sizeResolver = sizeResolver2;
        this.scale = scale2;
        this.parameters = parameters2;
        this.placeholderMemoryCacheKey = key2;
        this.placeholderResId = num;
        this.placeholderDrawable = drawable;
        this.errorResId = num2;
        this.errorDrawable = drawable2;
        this.fallbackResId = num3;
        this.fallbackDrawable = drawable3;
        this.defined = definedRequestOptions;
        this.defaults = defaultRequestOptions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Pair<Fetcher.Factory<?>, Class<?>> getFetcherFactory() {
        return this.fetcherFactory;
    }

    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    public final List<Transformation> getTransformations() {
        return this.transformations;
    }

    public final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Tags getTags() {
        return this.tags;
    }

    public final boolean getAllowConversionToBitmap() {
        return this.allowConversionToBitmap;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final CoroutineDispatcher getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    public final CoroutineDispatcher getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    public final CoroutineDispatcher getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    public final CoroutineDispatcher getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final DefinedRequestOptions getDefined() {
        return this.defined;
    }

    public final DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Drawable getPlaceholder() {
        return Requests.getDrawableCompat(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    public final Drawable getError() {
        return Requests.getDrawableCompat(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    public final Drawable getFallback() {
        return Requests.getDrawableCompat(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context2, int i, Object obj) {
        if ((i & 1) != 0) {
            context2 = imageRequest.context;
        }
        return imageRequest.newBuilder(context2);
    }

    public final Builder newBuilder(Context context2) {
        return new Builder(this, context2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageRequest) {
            ImageRequest imageRequest = (ImageRequest) obj;
            if (!Intrinsics.areEqual((Object) this.context, (Object) imageRequest.context) || !Intrinsics.areEqual(this.data, imageRequest.data) || !Intrinsics.areEqual((Object) this.target, (Object) imageRequest.target) || !Intrinsics.areEqual((Object) this.listener, (Object) imageRequest.listener) || !Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) imageRequest.memoryCacheKey) || !Intrinsics.areEqual((Object) this.diskCacheKey, (Object) imageRequest.diskCacheKey) || this.bitmapConfig != imageRequest.bitmapConfig || ((Build.VERSION.SDK_INT >= 26 && !Intrinsics.areEqual((Object) this.colorSpace, (Object) imageRequest.colorSpace)) || this.precision != imageRequest.precision || !Intrinsics.areEqual((Object) this.fetcherFactory, (Object) imageRequest.fetcherFactory) || !Intrinsics.areEqual((Object) this.decoderFactory, (Object) imageRequest.decoderFactory) || !Intrinsics.areEqual((Object) this.transformations, (Object) imageRequest.transformations) || !Intrinsics.areEqual((Object) this.transitionFactory, (Object) imageRequest.transitionFactory) || !Intrinsics.areEqual((Object) this.headers, (Object) imageRequest.headers) || !Intrinsics.areEqual((Object) this.tags, (Object) imageRequest.tags) || this.allowConversionToBitmap != imageRequest.allowConversionToBitmap || this.allowHardware != imageRequest.allowHardware || this.allowRgb565 != imageRequest.allowRgb565 || this.premultipliedAlpha != imageRequest.premultipliedAlpha || this.memoryCachePolicy != imageRequest.memoryCachePolicy || this.diskCachePolicy != imageRequest.diskCachePolicy || this.networkCachePolicy != imageRequest.networkCachePolicy || !Intrinsics.areEqual((Object) this.interceptorDispatcher, (Object) imageRequest.interceptorDispatcher) || !Intrinsics.areEqual((Object) this.fetcherDispatcher, (Object) imageRequest.fetcherDispatcher) || !Intrinsics.areEqual((Object) this.decoderDispatcher, (Object) imageRequest.decoderDispatcher) || !Intrinsics.areEqual((Object) this.transformationDispatcher, (Object) imageRequest.transformationDispatcher) || !Intrinsics.areEqual((Object) this.placeholderMemoryCacheKey, (Object) imageRequest.placeholderMemoryCacheKey) || !Intrinsics.areEqual((Object) this.placeholderResId, (Object) imageRequest.placeholderResId) || !Intrinsics.areEqual((Object) this.placeholderDrawable, (Object) imageRequest.placeholderDrawable) || !Intrinsics.areEqual((Object) this.errorResId, (Object) imageRequest.errorResId) || !Intrinsics.areEqual((Object) this.errorDrawable, (Object) imageRequest.errorDrawable) || !Intrinsics.areEqual((Object) this.fallbackResId, (Object) imageRequest.fallbackResId) || !Intrinsics.areEqual((Object) this.fallbackDrawable, (Object) imageRequest.fallbackDrawable) || !Intrinsics.areEqual((Object) this.lifecycle, (Object) imageRequest.lifecycle) || !Intrinsics.areEqual((Object) this.sizeResolver, (Object) imageRequest.sizeResolver) || this.scale != imageRequest.scale || !Intrinsics.areEqual((Object) this.parameters, (Object) imageRequest.parameters) || !Intrinsics.areEqual((Object) this.defined, (Object) imageRequest.defined) || !Intrinsics.areEqual((Object) this.defaults, (Object) imageRequest.defaults))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target2 = this.target;
        int i = 0;
        int hashCode2 = (hashCode + (target2 != null ? target2.hashCode() : 0)) * 31;
        Listener listener2 = this.listener;
        int hashCode3 = (hashCode2 + (listener2 != null ? listener2.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int hashCode4 = (hashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        int hashCode5 = (((hashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.bitmapConfig.hashCode()) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        int hashCode6 = (((hashCode5 + (colorSpace2 != null ? colorSpace2.hashCode() : 0)) * 31) + this.precision.hashCode()) * 31;
        Pair<Fetcher.Factory<?>, Class<?>> pair = this.fetcherFactory;
        int hashCode7 = (hashCode6 + (pair != null ? pair.hashCode() : 0)) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int hashCode8 = (((((((((((((((((((((((((((((((((((((((hashCode7 + (factory != null ? factory.hashCode() : 0)) * 31) + this.transformations.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + Boolean.hashCode(this.allowConversionToBitmap)) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.interceptorDispatcher.hashCode()) * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.parameters.hashCode()) * 31;
        MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
        int hashCode9 = (hashCode8 + (key2 != null ? key2.hashCode() : 0)) * 31;
        Integer num = this.placeholderResId;
        int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.placeholderDrawable;
        int hashCode11 = (hashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.errorResId;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.errorDrawable;
        int hashCode13 = (hashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.fallbackResId;
        int hashCode14 = (hashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.fallbackDrawable;
        if (drawable3 != null) {
            i = drawable3.hashCode();
        }
        return ((((hashCode14 + i) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    @Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u0019J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u000eJ\u0006\u0010Q\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\u001fJ\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010T\u001a\u00020UH\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u001bJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u0010\u0010Z\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010Z\u001a\u00020\u00002\b\b\u0001\u0010\\\u001a\u00020\u001fJ\u0010\u0010]\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010]\u001a\u00020\u00002\b\b\u0001\u0010\\\u001a\u00020\u001fJ\u0010\u0010^\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_H\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J#\u0010$\u001a\u00020\u0000\"\n\b\u0000\u0010`\u0018\u0001*\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002H`0&H\bJ,\u0010$\u001a\u00020\u0000\"\b\b\u0000\u0010`*\u00020\u00012\f\u0010W\u001a\b\u0012\u0004\u0012\u0002H`0&2\f\u0010a\u001a\b\u0012\u0004\u0012\u0002H`0'J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020bJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J\u0010\u0010+\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010+\u001a\u00020\u00002\b\u0010c\u001a\u0004\u0018\u00010dJÇ\u0001\u0010-\u001a\u00020\u00002#\b\u0006\u0010e\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020h0f2#\b\u0006\u0010i\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020h0f28\b\u0006\u0010j\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110l¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020h0k28\b\u0006\u0010n\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110o¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020h0kH\bJ\u0010\u0010-\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010.J\u0010\u0010/\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u000100J\u0010\u0010/\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u0019J\u000e\u00101\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u001bJ\u000e\u00102\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u001bJ\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u00020pJ\u0010\u0010q\u001a\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010q\u001a\u00020\u00002\b\b\u0001\u0010\\\u001a\u00020\u001fJ\u0010\u00106\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u000100J\u0010\u00106\u001a\u00020\u00002\b\u0010X\u001a\u0004\u0018\u00010\u0019J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\tJ\u000e\u0010r\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u0019J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u0019J\b\u0010t\u001a\u00020hH\u0002J\b\u0010u\u001a\u00020hH\u0002J\b\u0010v\u001a\u00020,H\u0002J\b\u0010w\u001a\u00020=H\u0002J\b\u0010x\u001a\u00020?H\u0002J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020=J\u0016\u0010y\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u0019J&\u0010z\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u00192\b\u0010N\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0019H\u0007J\u0016\u0010{\u001a\u00020\u00002\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020}J\u000e\u0010{\u001a\u00020\u00002\u0006\u0010{\u001a\u00020J\u000f\u0010{\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020?J\u0010\u0010{\u001a\u00020\u00002\b\b\u0001\u0010{\u001a\u00020\u001fJ\u001a\u0010{\u001a\u00020\u00002\b\b\u0001\u0010|\u001a\u00020\u001f2\b\b\u0001\u0010~\u001a\u00020\u001fJ'\u0010\u0001\u001a\u00020\u0000\"\n\b\u0000\u0010`\u0018\u0001*\u00020\u00012\t\u0010\u0001\u001a\u0004\u0018\u0001H`H\b¢\u0006\u0003\u0010\u0001J2\u0010\u0001\u001a\u00020\u0000\"\b\b\u0000\u0010`*\u00020\u00012\u000e\u0010a\u001a\n\u0012\u0006\b\u0000\u0012\u0002H`0'2\t\u0010\u0001\u001a\u0004\u0018\u0001H`¢\u0006\u0003\u0010\u0001J\u000f\u0010B\u001a\u00020\u00002\u0007\u0010B\u001a\u00030\u0001J|\u0010D\u001a\u00020\u00002%\b\u0006\u0010e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020h0f2%\b\u0006\u0010j\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020h0f2#\b\u0006\u0010n\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\bg\u0012\b\bM\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020h0fH\bJ\u0010\u0010D\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001J\u0010\u0010D\u001a\u00020\u00002\b\u0010D\u001a\u0004\u0018\u00010EJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0013J!\u0010G\u001a\u00020\u00002\u0013\u0010G\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020I0\u0001\"\u00020I¢\u0006\u0003\u0010\u0001J\u0014\u0010G\u001a\u00020\u00002\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0013\u0010\u0001\u001a\u00020\u00002\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u000f\u0010J\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020KR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0012\b\u0012\u0006\u0012\u0002\b\u00030'\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R \u0010B\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030'\u0012\u0004\u0012\u00020\u0001\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcoil/request/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "request", "Lcoil/request/ImageRequest;", "(Lcoil/request/ImageRequest;Landroid/content/Context;)V", "allowConversionToBitmap", "", "allowHardware", "Ljava/lang/Boolean;", "allowRgb565", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "colorSpace", "Landroid/graphics/ColorSpace;", "data", "decoderDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "decoderFactory", "Lcoil/decode/Decoder$Factory;", "defaults", "Lcoil/request/DefaultRequestOptions;", "diskCacheKey", "", "diskCachePolicy", "Lcoil/request/CachePolicy;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "errorResId", "", "Ljava/lang/Integer;", "fallbackDrawable", "fallbackResId", "fetcherDispatcher", "fetcherFactory", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "headers", "Lokhttp3/Headers$Builder;", "interceptorDispatcher", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "listener", "Lcoil/request/ImageRequest$Listener;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "memoryCachePolicy", "networkCachePolicy", "parameters", "Lcoil/request/Parameters$Builder;", "placeholderDrawable", "placeholderMemoryCacheKey", "placeholderResId", "precision", "Lcoil/size/Precision;", "premultipliedAlpha", "resolvedLifecycle", "resolvedScale", "Lcoil/size/Scale;", "resolvedSizeResolver", "Lcoil/size/SizeResolver;", "scale", "sizeResolver", "tags", "", "target", "Lcoil/target/Target;", "transformationDispatcher", "transformations", "", "Lcoil/transform/Transformation;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "addHeader", "name", "value", "enable", "config", "build", "crossfade", "durationMillis", "decoder", "Lcoil/decode/Decoder;", "dispatcher", "factory", "key", "policy", "error", "drawable", "drawableResId", "fallback", "fetcher", "Lcoil/fetch/Fetcher;", "T", "type", "Lokhttp3/Headers;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "onCancel", "onError", "Lkotlin/Function2;", "Lcoil/request/ErrorResult;", "result", "onSuccess", "Lcoil/request/SuccessResult;", "Lcoil/request/Parameters;", "placeholder", "removeHeader", "removeParameter", "resetResolvedScale", "resetResolvedValues", "resolveLifecycle", "resolveScale", "resolveSizeResolver", "setHeader", "setParameter", "size", "width", "Lcoil/size/Dimension;", "height", "Lcoil/size/Size;", "resolver", "tag", "(Ljava/lang/Object;)Lcoil/request/ImageRequest$Builder;", "(Ljava/lang/Class;Ljava/lang/Object;)Lcoil/request/ImageRequest$Builder;", "Lcoil/request/Tags;", "imageView", "Landroid/widget/ImageView;", "", "([Lcoil/transform/Transformation;)Lcoil/request/ImageRequest$Builder;", "transition", "Lcoil/transition/Transition;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImageRequest.kt */
    public static final class Builder {
        private boolean allowConversionToBitmap;
        private Boolean allowHardware;
        private Boolean allowRgb565;
        private Bitmap.Config bitmapConfig;
        private ColorSpace colorSpace;
        private final Context context;
        private Object data;
        private CoroutineDispatcher decoderDispatcher;
        private Decoder.Factory decoderFactory;
        private DefaultRequestOptions defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Drawable errorDrawable;
        private Integer errorResId;
        private Drawable fallbackDrawable;
        private Integer fallbackResId;
        private CoroutineDispatcher fetcherDispatcher;
        private Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> fetcherFactory;
        private Headers.Builder headers;
        private CoroutineDispatcher interceptorDispatcher;
        private Lifecycle lifecycle;
        private Listener listener;
        private MemoryCache.Key memoryCacheKey;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Parameters.Builder parameters;
        private Drawable placeholderDrawable;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Integer placeholderResId;
        private Precision precision;
        private boolean premultipliedAlpha;
        private Lifecycle resolvedLifecycle;
        private Scale resolvedScale;
        private SizeResolver resolvedSizeResolver;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Map<Class<?>, Object> tags;
        private Target target;
        private CoroutineDispatcher transformationDispatcher;
        private List<? extends Transformation> transformations;
        private Transition.Factory transitionFactory;

        public Builder(ImageRequest imageRequest) {
            this(imageRequest, (Context) null, 2, (DefaultConstructorMarker) null);
        }

        public final Builder setParameter(String str, Object obj) {
            return setParameter$default(this, str, obj, (String) null, 4, (Object) null);
        }

        public Builder(Context context2) {
            this.context = context2;
            this.defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.diskCacheKey = null;
            this.bitmapConfig = null;
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = null;
            }
            this.precision = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.transformations = CollectionsKt.emptyList();
            this.transitionFactory = null;
            this.headers = null;
            this.tags = null;
            this.allowConversionToBitmap = true;
            this.allowHardware = null;
            this.allowRgb565 = null;
            this.premultipliedAlpha = true;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.interceptorDispatcher = null;
            this.fetcherDispatcher = null;
            this.decoderDispatcher = null;
            this.transformationDispatcher = null;
            this.parameters = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderResId = null;
            this.placeholderDrawable = null;
            this.errorResId = null;
            this.errorDrawable = null;
            this.fallbackResId = null;
            this.fallbackDrawable = null;
            this.lifecycle = null;
            this.sizeResolver = null;
            this.scale = null;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public Builder(ImageRequest imageRequest, Context context2) {
            this.context = context2;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.bitmapConfig = imageRequest.getDefined().getBitmapConfig();
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = imageRequest.getColorSpace();
            }
            this.precision = imageRequest.getDefined().getPrecision();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.transformations = imageRequest.getTransformations();
            this.transitionFactory = imageRequest.getDefined().getTransitionFactory();
            this.headers = imageRequest.getHeaders().newBuilder();
            this.tags = MapsKt.toMutableMap(imageRequest.getTags().asMap());
            this.allowConversionToBitmap = imageRequest.getAllowConversionToBitmap();
            this.allowHardware = imageRequest.getDefined().getAllowHardware();
            this.allowRgb565 = imageRequest.getDefined().getAllowRgb565();
            this.premultipliedAlpha = imageRequest.getPremultipliedAlpha();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.interceptorDispatcher = imageRequest.getDefined().getInterceptorDispatcher();
            this.fetcherDispatcher = imageRequest.getDefined().getFetcherDispatcher();
            this.decoderDispatcher = imageRequest.getDefined().getDecoderDispatcher();
            this.transformationDispatcher = imageRequest.getDefined().getTransformationDispatcher();
            this.parameters = imageRequest.getParameters().newBuilder();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderResId = imageRequest.placeholderResId;
            this.placeholderDrawable = imageRequest.placeholderDrawable;
            this.errorResId = imageRequest.errorResId;
            this.errorDrawable = imageRequest.errorDrawable;
            this.fallbackResId = imageRequest.fallbackResId;
            this.fallbackDrawable = imageRequest.fallbackDrawable;
            this.lifecycle = imageRequest.getDefined().getLifecycle();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            if (imageRequest.getContext() == context2) {
                this.resolvedLifecycle = imageRequest.getLifecycle();
                this.resolvedSizeResolver = imageRequest.getSizeResolver();
                this.resolvedScale = imageRequest.getScale();
                return;
            }
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ImageRequest imageRequest, Context context2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageRequest, (i & 2) != 0 ? imageRequest.getContext() : context2);
        }

        public final Builder data(Object obj) {
            Builder builder = this;
            this.data = obj;
            return this;
        }

        public final Builder memoryCacheKey(String str) {
            MemoryCache.Key key = null;
            if (str != null) {
                key = new MemoryCache.Key(str, (Map) null, 2, (DefaultConstructorMarker) null);
            }
            return memoryCacheKey(key);
        }

        public final Builder memoryCacheKey(MemoryCache.Key key) {
            Builder builder = this;
            this.memoryCacheKey = key;
            return this;
        }

        public final Builder diskCacheKey(String str) {
            Builder builder = this;
            this.diskCacheKey = str;
            return this;
        }

        public static /* synthetic */ Builder listener$default(Builder builder, Function1 function1, Function1 function12, Function2 function2, Function2 function22, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = ImageRequest$Builder$listener$1.INSTANCE;
            }
            if ((i & 2) != 0) {
                function12 = ImageRequest$Builder$listener$2.INSTANCE;
            }
            if ((i & 4) != 0) {
                function2 = ImageRequest$Builder$listener$3.INSTANCE;
            }
            if ((i & 8) != 0) {
                function22 = ImageRequest$Builder$listener$4.INSTANCE;
            }
            return builder.listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function12, Function2<? super ImageRequest, ? super ErrorResult, Unit> function2, Function2<? super ImageRequest, ? super SuccessResult, Unit> function22) {
            return listener(new ImageRequest$Builder$listener$5(function1, function12, function2, function22));
        }

        public final Builder listener(Listener listener2) {
            Builder builder = this;
            this.listener = listener2;
            return this;
        }

        public final Builder dispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.fetcherDispatcher = coroutineDispatcher;
            this.decoderDispatcher = coroutineDispatcher;
            this.transformationDispatcher = coroutineDispatcher;
            return this;
        }

        public final Builder interceptorDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.interceptorDispatcher = coroutineDispatcher;
            return this;
        }

        public final Builder fetcherDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.fetcherDispatcher = coroutineDispatcher;
            return this;
        }

        public final Builder decoderDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.decoderDispatcher = coroutineDispatcher;
            return this;
        }

        public final Builder transformationDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.transformationDispatcher = coroutineDispatcher;
            return this;
        }

        public final Builder transformations(Transformation... transformationArr) {
            return transformations((List<? extends Transformation>) ArraysKt.toList((T[]) transformationArr));
        }

        public final Builder transformations(List<? extends Transformation> list) {
            Builder builder = this;
            this.transformations = Collections.toImmutableList(list);
            return this;
        }

        public final Builder bitmapConfig(Bitmap.Config config) {
            Builder builder = this;
            this.bitmapConfig = config;
            return this;
        }

        public final Builder colorSpace(ColorSpace colorSpace2) {
            Builder builder = this;
            this.colorSpace = colorSpace2;
            return this;
        }

        public final Builder size(int i) {
            return size(i, i);
        }

        public final Builder size(int i, int i2) {
            return size(Sizes.Size(i, i2));
        }

        public final Builder size(Dimension dimension, Dimension dimension2) {
            return size(new Size(dimension, dimension2));
        }

        public final Builder size(Size size) {
            return size(SizeResolvers.create(size));
        }

        public final Builder size(SizeResolver sizeResolver2) {
            Builder builder = this;
            this.sizeResolver = sizeResolver2;
            resetResolvedValues();
            return this;
        }

        public final Builder scale(Scale scale2) {
            Builder builder = this;
            this.scale = scale2;
            return this;
        }

        public final Builder precision(Precision precision2) {
            Builder builder = this;
            this.precision = precision2;
            return this;
        }

        public final /* synthetic */ <T> Builder fetcherFactory(Fetcher.Factory<T> factory) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            Class<Object> cls = Object.class;
            Class cls2 = cls;
            return fetcherFactory(factory, cls);
        }

        public final <T> Builder fetcherFactory(Fetcher.Factory<T> factory, Class<T> cls) {
            Builder builder = this;
            this.fetcherFactory = TuplesKt.to(factory, cls);
            return this;
        }

        public final Builder decoderFactory(Decoder.Factory factory) {
            Builder builder = this;
            this.decoderFactory = factory;
            return this;
        }

        public final Builder allowConversionToBitmap(boolean z) {
            Builder builder = this;
            this.allowConversionToBitmap = z;
            return this;
        }

        public final Builder allowHardware(boolean z) {
            Builder builder = this;
            this.allowHardware = Boolean.valueOf(z);
            return this;
        }

        public final Builder allowRgb565(boolean z) {
            Builder builder = this;
            this.allowRgb565 = Boolean.valueOf(z);
            return this;
        }

        public final Builder premultipliedAlpha(boolean z) {
            Builder builder = this;
            this.premultipliedAlpha = z;
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.memoryCachePolicy = cachePolicy;
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.diskCachePolicy = cachePolicy;
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.networkCachePolicy = cachePolicy;
            return this;
        }

        public final Builder headers(Headers headers2) {
            Builder builder = this;
            this.headers = headers2.newBuilder();
            return this;
        }

        public final Builder addHeader(String str, String str2) {
            Builder builder = this;
            Headers.Builder builder2 = this.headers;
            if (builder2 == null) {
                builder2 = new Headers.Builder();
                this.headers = builder2;
            }
            builder2.add(str, str2);
            return this;
        }

        public final Builder setHeader(String str, String str2) {
            Builder builder = this;
            Headers.Builder builder2 = this.headers;
            if (builder2 == null) {
                builder2 = new Headers.Builder();
                this.headers = builder2;
            }
            builder2.set(str, str2);
            return this;
        }

        public final Builder removeHeader(String str) {
            Builder builder = this;
            Headers.Builder builder2 = this.headers;
            if (builder2 != null) {
                builder2.removeAll(str);
            }
            return this;
        }

        public final /* synthetic */ <T> Builder tag(T t) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            Class<Object> cls = Object.class;
            Class cls2 = cls;
            return tag(cls, t);
        }

        public final <T> Builder tag(Class<? super T> cls, T t) {
            Builder builder = this;
            if (t == null) {
                Map<Class<?>, Object> map = this.tags;
                if (map != null) {
                    map.remove(cls);
                }
            } else {
                Map<Class<?>, Object> map2 = this.tags;
                if (map2 == null) {
                    map2 = new LinkedHashMap<>();
                    this.tags = map2;
                }
                Object cast = cls.cast(t);
                Intrinsics.checkNotNull(cast);
                map2.put(cls, cast);
            }
            return this;
        }

        public final Builder tags(Tags tags2) {
            Builder builder = this;
            this.tags = MapsKt.toMutableMap(tags2.asMap());
            return this;
        }

        public final Builder placeholderMemoryCacheKey(String str) {
            MemoryCache.Key key = null;
            if (str != null) {
                key = new MemoryCache.Key(str, (Map) null, 2, (DefaultConstructorMarker) null);
            }
            return placeholderMemoryCacheKey(key);
        }

        public final Builder placeholderMemoryCacheKey(MemoryCache.Key key) {
            Builder builder = this;
            this.placeholderMemoryCacheKey = key;
            return this;
        }

        public final Builder placeholder(int i) {
            Builder builder = this;
            this.placeholderResId = Integer.valueOf(i);
            this.placeholderDrawable = null;
            return this;
        }

        public final Builder placeholder(Drawable drawable) {
            Builder builder = this;
            this.placeholderDrawable = drawable;
            this.placeholderResId = 0;
            return this;
        }

        public final Builder error(int i) {
            Builder builder = this;
            this.errorResId = Integer.valueOf(i);
            this.errorDrawable = null;
            return this;
        }

        public final Builder error(Drawable drawable) {
            Builder builder = this;
            this.errorDrawable = drawable;
            this.errorResId = 0;
            return this;
        }

        public final Builder fallback(int i) {
            Builder builder = this;
            this.fallbackResId = Integer.valueOf(i);
            this.fallbackDrawable = null;
            return this;
        }

        public final Builder fallback(Drawable drawable) {
            Builder builder = this;
            this.fallbackDrawable = drawable;
            this.fallbackResId = 0;
            return this;
        }

        public final Builder target(ImageView imageView) {
            return target((Target) new ImageViewTarget(imageView));
        }

        public static /* synthetic */ Builder target$default(Builder builder, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = ImageRequest$Builder$target$1.INSTANCE;
            }
            if ((i & 2) != 0) {
                function12 = ImageRequest$Builder$target$2.INSTANCE;
            }
            if ((i & 4) != 0) {
                function13 = ImageRequest$Builder$target$3.INSTANCE;
            }
            return builder.target((Target) new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Function1<? super Drawable, Unit> function1, Function1<? super Drawable, Unit> function12, Function1<? super Drawable, Unit> function13) {
            return target((Target) new ImageRequest$Builder$target$4(function1, function12, function13));
        }

        public final Builder target(Target target2) {
            Builder builder = this;
            this.target = target2;
            resetResolvedValues();
            return this;
        }

        public final Builder crossfade(boolean z) {
            return crossfade(z ? 100 : 0);
        }

        public final Builder crossfade(int i) {
            Transition.Factory factory;
            Builder builder = this;
            if (i > 0) {
                factory = new CrossfadeTransition.Factory(i, false, 2, (DefaultConstructorMarker) null);
            } else {
                factory = Transition.Factory.NONE;
            }
            transitionFactory(factory);
            return this;
        }

        public final Builder transitionFactory(Transition.Factory factory) {
            Builder builder = this;
            this.transitionFactory = factory;
            return this;
        }

        public final Builder lifecycle(LifecycleOwner lifecycleOwner) {
            return lifecycle(lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null);
        }

        public final Builder lifecycle(Lifecycle lifecycle2) {
            Builder builder = this;
            this.lifecycle = lifecycle2;
            return this;
        }

        public static /* synthetic */ Builder setParameter$default(Builder builder, String str, Object obj, String str2, int i, Object obj2) {
            if ((i & 4) != 0) {
                str2 = obj != null ? obj.toString() : null;
            }
            return builder.setParameter(str, obj, str2);
        }

        public final Builder setParameter(String str, Object obj, String str2) {
            Builder builder = this;
            Parameters.Builder builder2 = this.parameters;
            if (builder2 == null) {
                builder2 = new Parameters.Builder();
                this.parameters = builder2;
            }
            builder2.set(str, obj, str2);
            return this;
        }

        public final Builder removeParameter(String str) {
            Builder builder = this;
            Parameters.Builder builder2 = this.parameters;
            if (builder2 != null) {
                builder2.remove(str);
            }
            return this;
        }

        public final Builder parameters(Parameters parameters2) {
            Builder builder = this;
            this.parameters = parameters2.newBuilder();
            return this;
        }

        public final Builder defaults(DefaultRequestOptions defaultRequestOptions) {
            Builder builder = this;
            this.defaults = defaultRequestOptions;
            resetResolvedScale();
            return this;
        }

        public final ImageRequest build() {
            Context context2 = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target2 = this.target;
            Listener listener2 = this.listener;
            MemoryCache.Key key = this.memoryCacheKey;
            String str = this.diskCacheKey;
            Bitmap.Config config = this.bitmapConfig;
            if (config == null) {
                config = this.defaults.getBitmapConfig();
            }
            Bitmap.Config config2 = config;
            ColorSpace colorSpace2 = this.colorSpace;
            Precision precision2 = this.precision;
            if (precision2 == null) {
                precision2 = this.defaults.getPrecision();
            }
            Precision precision3 = precision2;
            Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            List<? extends Transformation> list = this.transformations;
            Transition.Factory factory2 = this.transitionFactory;
            if (factory2 == null) {
                factory2 = this.defaults.getTransitionFactory();
            }
            Transition.Factory factory3 = factory2;
            Headers.Builder builder = this.headers;
            Headers orEmpty = Utils.orEmpty(builder != null ? builder.build() : null);
            Map<Class<?>, Object> map = this.tags;
            Tags orEmpty2 = Utils.orEmpty(map != null ? Tags.Companion.from(map) : null);
            boolean z = this.allowConversionToBitmap;
            Boolean bool = this.allowHardware;
            boolean booleanValue = bool != null ? bool.booleanValue() : this.defaults.getAllowHardware();
            Boolean bool2 = this.allowRgb565;
            boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : this.defaults.getAllowRgb565();
            boolean z2 = this.premultipliedAlpha;
            CachePolicy cachePolicy = this.memoryCachePolicy;
            if (cachePolicy == null) {
                cachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.diskCachePolicy;
            if (cachePolicy3 == null) {
                cachePolicy3 = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.networkCachePolicy;
            if (cachePolicy5 == null) {
                cachePolicy5 = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            CoroutineDispatcher coroutineDispatcher = this.interceptorDispatcher;
            if (coroutineDispatcher == null) {
                coroutineDispatcher = this.defaults.getInterceptorDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            CoroutineDispatcher coroutineDispatcher3 = this.fetcherDispatcher;
            if (coroutineDispatcher3 == null) {
                coroutineDispatcher3 = this.defaults.getFetcherDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher4 = coroutineDispatcher3;
            CoroutineDispatcher coroutineDispatcher5 = this.decoderDispatcher;
            if (coroutineDispatcher5 == null) {
                coroutineDispatcher5 = this.defaults.getDecoderDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher6 = coroutineDispatcher5;
            CoroutineDispatcher coroutineDispatcher7 = this.transformationDispatcher;
            if (coroutineDispatcher7 == null) {
                coroutineDispatcher7 = this.defaults.getTransformationDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher8 = coroutineDispatcher7;
            Lifecycle lifecycle2 = this.lifecycle;
            if (lifecycle2 == null && (lifecycle2 = this.resolvedLifecycle) == null) {
                lifecycle2 = resolveLifecycle();
            }
            Lifecycle lifecycle3 = lifecycle2;
            SizeResolver sizeResolver2 = this.sizeResolver;
            if (sizeResolver2 == null && (sizeResolver2 = this.resolvedSizeResolver) == null) {
                sizeResolver2 = resolveSizeResolver();
            }
            SizeResolver sizeResolver3 = sizeResolver2;
            Scale scale2 = this.scale;
            if (scale2 == null && (scale2 = this.resolvedScale) == null) {
                scale2 = resolveScale();
            }
            Scale scale3 = scale2;
            Parameters.Builder builder2 = this.parameters;
            Parameters orEmpty3 = Utils.orEmpty(builder2 != null ? builder2.build() : null);
            MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
            Integer num = this.placeholderResId;
            Drawable drawable = this.placeholderDrawable;
            Integer num2 = this.errorResId;
            Drawable drawable2 = this.errorDrawable;
            Integer num3 = this.fallbackResId;
            Drawable drawable3 = this.fallbackDrawable;
            DefinedRequestOptions definedRequestOptions = r43;
            boolean z3 = z;
            Transition.Factory factory4 = factory3;
            List<? extends Transformation> list2 = list;
            Decoder.Factory factory5 = factory;
            Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair2 = pair;
            Precision precision4 = precision3;
            ColorSpace colorSpace3 = colorSpace2;
            Bitmap.Config config3 = config2;
            String str2 = str;
            MemoryCache.Key key3 = key;
            Listener listener3 = listener2;
            Target target3 = target2;
            Object obj3 = obj2;
            DefinedRequestOptions definedRequestOptions2 = new DefinedRequestOptions(this.lifecycle, this.sizeResolver, this.scale, this.interceptorDispatcher, this.fetcherDispatcher, this.decoderDispatcher, this.transformationDispatcher, this.transitionFactory, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy);
            return new ImageRequest(context2, obj3, target3, listener3, key3, str2, config3, colorSpace3, precision4, pair2, factory5, list2, factory4, orEmpty, orEmpty2, z3, booleanValue, booleanValue2, z2, cachePolicy2, cachePolicy4, cachePolicy6, coroutineDispatcher2, coroutineDispatcher4, coroutineDispatcher6, coroutineDispatcher8, lifecycle3, sizeResolver3, scale3, orEmpty3, key2, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, this.defaults, (DefaultConstructorMarker) null);
        }

        private final void resetResolvedValues() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final void resetResolvedScale() {
            this.resolvedScale = null;
        }

        private final Lifecycle resolveLifecycle() {
            Target target2 = this.target;
            Lifecycle lifecycle2 = Contexts.getLifecycle(target2 instanceof ViewTarget ? ((ViewTarget) target2).getView().getContext() : this.context);
            return lifecycle2 == null ? GlobalLifecycle.INSTANCE : lifecycle2;
        }

        private final SizeResolver resolveSizeResolver() {
            Target target2 = this.target;
            if (!(target2 instanceof ViewTarget)) {
                return new DisplaySizeResolver(this.context);
            }
            View view = ((ViewTarget) target2).getView();
            if (view instanceof ImageView) {
                ImageView.ScaleType scaleType = ((ImageView) view).getScaleType();
                if (scaleType == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX) {
                    return SizeResolvers.create(Size.ORIGINAL);
                }
            }
            return ViewSizeResolvers.create$default(view, false, 2, (Object) null);
        }

        private final Scale resolveScale() {
            View view;
            SizeResolver sizeResolver2 = this.sizeResolver;
            View view2 = null;
            ViewSizeResolver viewSizeResolver = sizeResolver2 instanceof ViewSizeResolver ? (ViewSizeResolver) sizeResolver2 : null;
            if (viewSizeResolver == null || (view = viewSizeResolver.getView()) == null) {
                Target target2 = this.target;
                ViewTarget viewTarget = target2 instanceof ViewTarget ? (ViewTarget) target2 : null;
                if (viewTarget != null) {
                    view2 = viewTarget.getView();
                }
            } else {
                view2 = view;
            }
            if (view2 instanceof ImageView) {
                return Utils.getScale((ImageView) view2);
            }
            return Scale.FIT;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'fetcherFactory'.", replaceWith = @ReplaceWith(expression = "fetcherFactory<Any> { _, _, _ -> fetcher }", imports = {}))
        public final Builder fetcher(Fetcher fetcher) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'decoderFactory'.", replaceWith = @ReplaceWith(expression = "decoderFactory { _, _, _ -> decoder }", imports = {}))
        public final Builder decoder(Decoder decoder) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'transitionFactory'.", replaceWith = @ReplaceWith(expression = "transitionFactory { _, _ -> transition }", imports = {}))
        public final Builder transition(Transition transition) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }
    }
}
