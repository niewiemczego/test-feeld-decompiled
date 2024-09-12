package coil.request;

import android.graphics.Bitmap;
import androidx.lifecycle.Lifecycle;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.SizeResolver;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u001aJ¿\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00142\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00108\u001a\u000209H\u0016R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006:"}, d2 = {"Lcoil/request/DefinedRequestOptions;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "sizeResolver", "Lcoil/size/SizeResolver;", "scale", "Lcoil/size/Scale;", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "transitionFactory", "Lcoil/transition/Transition$Factory;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition$Factory;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDecoderDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getFetcherDispatcher", "getInterceptorDispatcher", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPrecision", "()Lcoil/size/Precision;", "getScale", "()Lcoil/size/Scale;", "getSizeResolver", "()Lcoil/size/SizeResolver;", "getTransformationDispatcher", "getTransitionFactory", "()Lcoil/transition/Transition$Factory;", "copy", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/SizeResolver;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition$Factory;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)Lcoil/request/DefinedRequestOptions;", "equals", "other", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DefinedRequestOptions.kt */
public final class DefinedRequestOptions {
    private final Boolean allowHardware;
    private final Boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final CoroutineDispatcher decoderDispatcher;
    private final CachePolicy diskCachePolicy;
    private final CoroutineDispatcher fetcherDispatcher;
    private final CoroutineDispatcher interceptorDispatcher;
    private final Lifecycle lifecycle;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Precision precision;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final CoroutineDispatcher transformationDispatcher;
    private final Transition.Factory transitionFactory;

    public DefinedRequestOptions(Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision2, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.lifecycle = lifecycle2;
        this.sizeResolver = sizeResolver2;
        this.scale = scale2;
        this.interceptorDispatcher = coroutineDispatcher;
        this.fetcherDispatcher = coroutineDispatcher2;
        this.decoderDispatcher = coroutineDispatcher3;
        this.transformationDispatcher = coroutineDispatcher4;
        this.transitionFactory = factory;
        this.precision = precision2;
        this.bitmapConfig = config;
        this.allowHardware = bool;
        this.allowRgb565 = bool2;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
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

    public final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final Boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final Boolean getAllowRgb565() {
        return this.allowRgb565;
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

    public static /* synthetic */ DefinedRequestOptions copy$default(DefinedRequestOptions definedRequestOptions, Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision2, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i, Object obj) {
        CachePolicy cachePolicy4;
        DefinedRequestOptions definedRequestOptions2 = definedRequestOptions;
        int i2 = i;
        Lifecycle lifecycle3 = (i2 & 1) != 0 ? definedRequestOptions2.lifecycle : lifecycle2;
        SizeResolver sizeResolver3 = (i2 & 2) != 0 ? definedRequestOptions2.sizeResolver : sizeResolver2;
        Scale scale3 = (i2 & 4) != 0 ? definedRequestOptions2.scale : scale2;
        CoroutineDispatcher coroutineDispatcher5 = (i2 & 8) != 0 ? definedRequestOptions2.interceptorDispatcher : coroutineDispatcher;
        CoroutineDispatcher coroutineDispatcher6 = (i2 & 16) != 0 ? definedRequestOptions2.fetcherDispatcher : coroutineDispatcher2;
        CoroutineDispatcher coroutineDispatcher7 = (i2 & 32) != 0 ? definedRequestOptions2.decoderDispatcher : coroutineDispatcher3;
        CoroutineDispatcher coroutineDispatcher8 = (i2 & 64) != 0 ? definedRequestOptions2.transformationDispatcher : coroutineDispatcher4;
        Transition.Factory factory2 = (i2 & 128) != 0 ? definedRequestOptions2.transitionFactory : factory;
        Precision precision3 = (i2 & 256) != 0 ? definedRequestOptions2.precision : precision2;
        Bitmap.Config config2 = (i2 & 512) != 0 ? definedRequestOptions2.bitmapConfig : config;
        Boolean bool3 = (i2 & 1024) != 0 ? definedRequestOptions2.allowHardware : bool;
        Boolean bool4 = (i2 & 2048) != 0 ? definedRequestOptions2.allowRgb565 : bool2;
        CachePolicy cachePolicy5 = (i2 & 4096) != 0 ? definedRequestOptions2.memoryCachePolicy : cachePolicy;
        CachePolicy cachePolicy6 = (i2 & 8192) != 0 ? definedRequestOptions2.diskCachePolicy : cachePolicy2;
        if ((i2 & 16384) != 0) {
            cachePolicy4 = definedRequestOptions2.networkCachePolicy;
        } else {
            cachePolicy4 = cachePolicy3;
        }
        return definedRequestOptions.copy(lifecycle3, sizeResolver3, scale3, coroutineDispatcher5, coroutineDispatcher6, coroutineDispatcher7, coroutineDispatcher8, factory2, precision3, config2, bool3, bool4, cachePolicy5, cachePolicy6, cachePolicy4);
    }

    public final DefinedRequestOptions copy(Lifecycle lifecycle2, SizeResolver sizeResolver2, Scale scale2, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision2, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        return new DefinedRequestOptions(lifecycle2, sizeResolver2, scale2, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, factory, precision2, config, bool, bool2, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefinedRequestOptions) {
            DefinedRequestOptions definedRequestOptions = (DefinedRequestOptions) obj;
            if (!Intrinsics.areEqual((Object) this.lifecycle, (Object) definedRequestOptions.lifecycle) || !Intrinsics.areEqual((Object) this.sizeResolver, (Object) definedRequestOptions.sizeResolver) || this.scale != definedRequestOptions.scale || !Intrinsics.areEqual((Object) this.interceptorDispatcher, (Object) definedRequestOptions.interceptorDispatcher) || !Intrinsics.areEqual((Object) this.fetcherDispatcher, (Object) definedRequestOptions.fetcherDispatcher) || !Intrinsics.areEqual((Object) this.decoderDispatcher, (Object) definedRequestOptions.decoderDispatcher) || !Intrinsics.areEqual((Object) this.transformationDispatcher, (Object) definedRequestOptions.transformationDispatcher) || !Intrinsics.areEqual((Object) this.transitionFactory, (Object) definedRequestOptions.transitionFactory) || this.precision != definedRequestOptions.precision || this.bitmapConfig != definedRequestOptions.bitmapConfig || !Intrinsics.areEqual((Object) this.allowHardware, (Object) definedRequestOptions.allowHardware) || !Intrinsics.areEqual((Object) this.allowRgb565, (Object) definedRequestOptions.allowRgb565) || this.memoryCachePolicy != definedRequestOptions.memoryCachePolicy || this.diskCachePolicy != definedRequestOptions.diskCachePolicy || this.networkCachePolicy != definedRequestOptions.networkCachePolicy) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Lifecycle lifecycle2 = this.lifecycle;
        int i = 0;
        int hashCode = (lifecycle2 != null ? lifecycle2.hashCode() : 0) * 31;
        SizeResolver sizeResolver2 = this.sizeResolver;
        int hashCode2 = (hashCode + (sizeResolver2 != null ? sizeResolver2.hashCode() : 0)) * 31;
        Scale scale2 = this.scale;
        int hashCode3 = (hashCode2 + (scale2 != null ? scale2.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher = this.interceptorDispatcher;
        int hashCode4 = (hashCode3 + (coroutineDispatcher != null ? coroutineDispatcher.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher2 = this.fetcherDispatcher;
        int hashCode5 = (hashCode4 + (coroutineDispatcher2 != null ? coroutineDispatcher2.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher3 = this.decoderDispatcher;
        int hashCode6 = (hashCode5 + (coroutineDispatcher3 != null ? coroutineDispatcher3.hashCode() : 0)) * 31;
        CoroutineDispatcher coroutineDispatcher4 = this.transformationDispatcher;
        int hashCode7 = (hashCode6 + (coroutineDispatcher4 != null ? coroutineDispatcher4.hashCode() : 0)) * 31;
        Transition.Factory factory = this.transitionFactory;
        int hashCode8 = (hashCode7 + (factory != null ? factory.hashCode() : 0)) * 31;
        Precision precision2 = this.precision;
        int hashCode9 = (hashCode8 + (precision2 != null ? precision2.hashCode() : 0)) * 31;
        Bitmap.Config config = this.bitmapConfig;
        int hashCode10 = (hashCode9 + (config != null ? config.hashCode() : 0)) * 31;
        Boolean bool = this.allowHardware;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.allowRgb565;
        int hashCode12 = (hashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CachePolicy cachePolicy = this.memoryCachePolicy;
        int hashCode13 = (hashCode12 + (cachePolicy != null ? cachePolicy.hashCode() : 0)) * 31;
        CachePolicy cachePolicy2 = this.diskCachePolicy;
        int hashCode14 = (hashCode13 + (cachePolicy2 != null ? cachePolicy2.hashCode() : 0)) * 31;
        CachePolicy cachePolicy3 = this.networkCachePolicy;
        if (cachePolicy3 != null) {
            i = cachePolicy3.hashCode();
        }
        return hashCode14 + i;
    }
}
