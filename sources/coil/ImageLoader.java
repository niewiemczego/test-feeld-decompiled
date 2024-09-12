package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.decode.ExifOrientationPolicy;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import coil.request.CachePolicy;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Precision;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Contexts;
import coil.util.ImageLoaderOptions;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.Utils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcoil/ImageLoader;", "", "components", "Lcoil/ComponentRegistry;", "getComponents", "()Lcoil/ComponentRegistry;", "defaults", "Lcoil/request/DefaultRequestOptions;", "getDefaults", "()Lcoil/request/DefaultRequestOptions;", "diskCache", "Lcoil/disk/DiskCache;", "getDiskCache", "()Lcoil/disk/DiskCache;", "memoryCache", "Lcoil/memory/MemoryCache;", "getMemoryCache", "()Lcoil/memory/MemoryCache;", "enqueue", "Lcoil/request/Disposable;", "request", "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newBuilder", "Lcoil/ImageLoader$Builder;", "shutdown", "", "Builder", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageLoader.kt */
public interface ImageLoader {
    Disposable enqueue(ImageRequest imageRequest);

    Object execute(ImageRequest imageRequest, Continuation<? super ImageResult> continuation);

    ComponentRegistry getComponents();

    DefaultRequestOptions getDefaults();

    DiskCache getDiskCache();

    MemoryCache getMemoryCache();

    Builder newBuilder();

    void shutdown();

    @Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010 \u001a\u00020!H\u0007J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020+J\u0014\u0010\t\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\rH\u0007J!\u0010\f\u001a\u00020\u00002\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3H\u0007J\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u00020\rJ\"\u00104\u001a\u00020\u00002\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200¢\u0006\u0002\b3H\bJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020)J\u000e\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0016\u0010\u0010\u001a\u00020\u00002\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110-J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010%\u001a\u00020;J\u000e\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0010\u0010<\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010<\u001a\u00020\u00002\b\b\u0001\u0010?\u001a\u00020)J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u0013J\u0010\u0010D\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010D\u001a\u00020\u00002\b\b\u0001\u0010?\u001a\u00020)J\u000e\u0010E\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u000e\u0010F\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0010\u0010G\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\u00002\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170-J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010%\u001a\u00020;J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010%\u001a\u00020;J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010K\u001a\u00020\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020L0-J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010K\u001a\u00020LJ\u0010\u0010M\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010>J\u0010\u0010M\u001a\u00020\u00002\b\b\u0001\u0010?\u001a\u00020)J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010Q\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u000e\u0010R\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\u0010\u0010S\u001a\u00020\u00002\u0006\u0010S\u001a\u00020TH\u0007J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010C\u001a\u00020VR\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcoil/ImageLoader$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imageLoader", "Lcoil/RealImageLoader;", "(Lcoil/RealImageLoader;)V", "applicationContext", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "componentRegistry", "Lcoil/ComponentRegistry;", "defaults", "Lcoil/request/DefaultRequestOptions;", "diskCache", "Lcoil/disk/DiskCache;", "eventListenerFactory", "Lcoil/EventListener$Factory;", "logger", "Lcoil/util/Logger;", "memoryCache", "Lcoil/memory/MemoryCache;", "options", "Lcoil/util/ImageLoaderOptions;", "addLastModifiedToFileCacheKey", "enable", "", "allowHardware", "allowRgb565", "availableMemoryPercentage", "percent", "", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "bitmapFactoryExifOrientationPolicy", "policy", "Lcoil/decode/ExifOrientationPolicy;", "bitmapFactoryMaxParallelism", "maxParallelism", "", "build", "Lcoil/ImageLoader;", "initializer", "Lkotlin/Function0;", "registry", "builder", "Lkotlin/Function1;", "Lcoil/ComponentRegistry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "components", "crossfade", "durationMillis", "decoderDispatcher", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "diskCachePolicy", "Lcoil/request/CachePolicy;", "error", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableResId", "eventListener", "listener", "Lcoil/EventListener;", "factory", "fallback", "fetcherDispatcher", "interceptorDispatcher", "launchInterceptorChainOnMainThread", "memoryCachePolicy", "networkCachePolicy", "networkObserverEnabled", "okHttpClient", "Lokhttp3/OkHttpClient;", "placeholder", "precision", "Lcoil/size/Precision;", "respectCacheHeaders", "trackWeakReferences", "transformationDispatcher", "transition", "Lcoil/transition/Transition;", "transitionFactory", "Lcoil/transition/Transition$Factory;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImageLoader.kt */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final Context applicationContext;
        private Lazy<? extends Call.Factory> callFactory;
        private ComponentRegistry componentRegistry;
        private DefaultRequestOptions defaults;
        private Lazy<? extends DiskCache> diskCache;
        private EventListener.Factory eventListenerFactory;
        private Logger logger;
        private Lazy<? extends MemoryCache> memoryCache;
        private ImageLoaderOptions options;

        public Builder(Context context) {
            this.applicationContext = context.getApplicationContext();
            this.defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
            this.memoryCache = null;
            this.diskCache = null;
            this.callFactory = null;
            this.eventListenerFactory = null;
            this.componentRegistry = null;
            this.options = new ImageLoaderOptions(false, false, false, 0, (ExifOrientationPolicy) null, 31, (DefaultConstructorMarker) null);
            this.logger = null;
        }

        public Builder(RealImageLoader realImageLoader) {
            this.applicationContext = realImageLoader.getContext().getApplicationContext();
            this.defaults = realImageLoader.getDefaults();
            this.memoryCache = realImageLoader.getMemoryCacheLazy();
            this.diskCache = realImageLoader.getDiskCacheLazy();
            this.callFactory = realImageLoader.getCallFactoryLazy();
            this.eventListenerFactory = realImageLoader.getEventListenerFactory();
            this.componentRegistry = realImageLoader.getComponentRegistry();
            this.options = realImageLoader.getOptions();
            this.logger = realImageLoader.getLogger();
        }

        public final Builder okHttpClient(OkHttpClient okHttpClient) {
            return callFactory((Call.Factory) okHttpClient);
        }

        public final Builder okHttpClient(Function0<? extends OkHttpClient> function0) {
            return callFactory((Function0<? extends Call.Factory>) function0);
        }

        public final Builder callFactory(Call.Factory factory) {
            Builder builder = this;
            this.callFactory = LazyKt.lazyOf(factory);
            return this;
        }

        public final Builder callFactory(Function0<? extends Call.Factory> function0) {
            Builder builder = this;
            this.callFactory = LazyKt.lazy(function0);
            return this;
        }

        public final /* synthetic */ Builder components(Function1<? super ComponentRegistry.Builder, Unit> function1) {
            ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
            function1.invoke(builder);
            return components(builder.build());
        }

        public final Builder components(ComponentRegistry componentRegistry2) {
            Builder builder = this;
            this.componentRegistry = componentRegistry2;
            return this;
        }

        public final Builder memoryCache(MemoryCache memoryCache2) {
            Builder builder = this;
            this.memoryCache = LazyKt.lazyOf(memoryCache2);
            return this;
        }

        public final Builder memoryCache(Function0<? extends MemoryCache> function0) {
            Builder builder = this;
            this.memoryCache = LazyKt.lazy(function0);
            return this;
        }

        public final Builder diskCache(DiskCache diskCache2) {
            Builder builder = this;
            this.diskCache = LazyKt.lazyOf(diskCache2);
            return this;
        }

        public final Builder diskCache(Function0<? extends DiskCache> function0) {
            Builder builder = this;
            this.diskCache = LazyKt.lazy(function0);
            return this;
        }

        public final Builder allowHardware(boolean z) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, z, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32639, (Object) null);
            return this;
        }

        public final Builder allowRgb565(boolean z) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, z, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32511, (Object) null);
            return this;
        }

        public final Builder addLastModifiedToFileCacheKey(boolean z) {
            Builder builder = this;
            this.options = ImageLoaderOptions.copy$default(this.options, z, false, false, 0, (ExifOrientationPolicy) null, 30, (Object) null);
            return this;
        }

        public final Builder networkObserverEnabled(boolean z) {
            Builder builder = this;
            this.options = ImageLoaderOptions.copy$default(this.options, false, z, false, 0, (ExifOrientationPolicy) null, 29, (Object) null);
            return this;
        }

        public final Builder respectCacheHeaders(boolean z) {
            Builder builder = this;
            this.options = ImageLoaderOptions.copy$default(this.options, false, false, z, 0, (ExifOrientationPolicy) null, 27, (Object) null);
            return this;
        }

        public final Builder bitmapFactoryMaxParallelism(int i) {
            Builder builder = this;
            if (i > 0) {
                this.options = ImageLoaderOptions.copy$default(this.options, false, false, false, i, (ExifOrientationPolicy) null, 23, (Object) null);
                return this;
            }
            throw new IllegalArgumentException("maxParallelism must be > 0.".toString());
        }

        public final Builder bitmapFactoryExifOrientationPolicy(ExifOrientationPolicy exifOrientationPolicy) {
            Builder builder = this;
            this.options = ImageLoaderOptions.copy$default(this.options, false, false, false, 0, exifOrientationPolicy, 15, (Object) null);
            return this;
        }

        public final Builder eventListener(EventListener eventListener) {
            return eventListenerFactory(new ImageLoader$Builder$eventListener$1(eventListener));
        }

        public final Builder eventListenerFactory(EventListener.Factory factory) {
            Builder builder = this;
            this.eventListenerFactory = factory;
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
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, factory, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32751, (Object) null);
            return this;
        }

        public final Builder precision(Precision precision) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, precision, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32735, (Object) null);
            return this;
        }

        public final Builder bitmapConfig(Bitmap.Config config) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, config, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32703, (Object) null);
            return this;
        }

        public final Builder dispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, coroutineDispatcher, coroutineDispatcher, coroutineDispatcher, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32753, (Object) null);
            return this;
        }

        public final Builder interceptorDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, coroutineDispatcher, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32766, (Object) null);
            return this;
        }

        public final Builder fetcherDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, coroutineDispatcher, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32765, (Object) null);
            return this;
        }

        public final Builder decoderDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, coroutineDispatcher, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32763, (Object) null);
            return this;
        }

        public final Builder transformationDispatcher(CoroutineDispatcher coroutineDispatcher) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, coroutineDispatcher, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32759, (Object) null);
            return this;
        }

        public final Builder placeholder(int i) {
            return placeholder(Contexts.getDrawableCompat(this.applicationContext, i));
        }

        public final Builder placeholder(Drawable drawable) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, drawable != null ? drawable.mutate() : null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32255, (Object) null);
            return this;
        }

        public final Builder error(int i) {
            return error(Contexts.getDrawableCompat(this.applicationContext, i));
        }

        public final Builder error(Drawable drawable) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, drawable != null ? drawable.mutate() : null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 31743, (Object) null);
            return this;
        }

        public final Builder fallback(int i) {
            return fallback(Contexts.getDrawableCompat(this.applicationContext, i));
        }

        public final Builder fallback(Drawable drawable) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, drawable != null ? drawable.mutate() : null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 30719, (Object) null);
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, cachePolicy, (CachePolicy) null, (CachePolicy) null, 28671, (Object) null);
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, cachePolicy, (CachePolicy) null, 24575, (Object) null);
            return this;
        }

        public final Builder networkCachePolicy(CachePolicy cachePolicy) {
            Builder builder = this;
            this.defaults = DefaultRequestOptions.copy$default(this.defaults, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, cachePolicy, 16383, (Object) null);
            return this;
        }

        public final Builder logger(Logger logger2) {
            Builder builder = this;
            this.logger = logger2;
            return this;
        }

        public final ImageLoader build() {
            Context context = this.applicationContext;
            DefaultRequestOptions defaultRequestOptions = this.defaults;
            Lazy<? extends MemoryCache> lazy = this.memoryCache;
            if (lazy == null) {
                lazy = LazyKt.lazy(new ImageLoader$Builder$build$1(this));
            }
            Lazy<? extends MemoryCache> lazy2 = lazy;
            Lazy<? extends DiskCache> lazy3 = this.diskCache;
            if (lazy3 == null) {
                lazy3 = LazyKt.lazy(new ImageLoader$Builder$build$2(this));
            }
            Lazy<? extends DiskCache> lazy4 = lazy3;
            Lazy<? extends Call.Factory> lazy5 = this.callFactory;
            if (lazy5 == null) {
                lazy5 = LazyKt.lazy(ImageLoader$Builder$build$3.INSTANCE);
            }
            Lazy<? extends Call.Factory> lazy6 = lazy5;
            EventListener.Factory factory = this.eventListenerFactory;
            if (factory == null) {
                factory = EventListener.Factory.NONE;
            }
            EventListener.Factory factory2 = factory;
            ComponentRegistry componentRegistry2 = this.componentRegistry;
            if (componentRegistry2 == null) {
                componentRegistry2 = new ComponentRegistry();
            }
            return new RealImageLoader(context, defaultRequestOptions, lazy2, lazy4, lazy6, factory2, componentRegistry2, this.options, this.logger);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'memoryCache'.", replaceWith = @ReplaceWith(expression = "memoryCache { MemoryCache.Builder(context).maxSizePercent(percent).build() }", imports = {"coil.memory.MemoryCache"}))
        public final Builder availableMemoryPercentage(double d) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'memoryCache'.", replaceWith = @ReplaceWith(expression = "memoryCache { MemoryCache.Builder(context).weakReferencesEnabled(enable).build() }", imports = {"coil.memory.MemoryCache"}))
        public final Builder trackWeakReferences(boolean z) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'interceptorDispatcher'.", replaceWith = @ReplaceWith(expression = "interceptorDispatcher(if (enable) Dispatchers.Main.immediate else Dispatchers.IO)", imports = {"kotlinx.coroutines.Dispatchers"}))
        public final Builder launchInterceptorChainOnMainThread(boolean z) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'components'.", replaceWith = @ReplaceWith(expression = "components(builder)", imports = {}))
        public final /* synthetic */ Builder componentRegistry(Function1 function1) {
            Utils.unsupported();
            throw new KotlinNothingValueException();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'components'.", replaceWith = @ReplaceWith(expression = "components(registry)", imports = {}))
        public final Builder componentRegistry(ComponentRegistry componentRegistry2) {
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
