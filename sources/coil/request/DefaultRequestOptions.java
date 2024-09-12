package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.size.Precision;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015¢\u0006\u0002\u0010\u0018J¢\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015J\u0013\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00102\u001a\u000203H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0017\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcoil/request/DefaultRequestOptions;", "", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "transitionFactory", "Lcoil/transition/Transition$Factory;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "placeholder", "Landroid/graphics/drawable/Drawable;", "error", "fallback", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition$Factory;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Z", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDecoderDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getError", "()Landroid/graphics/drawable/Drawable;", "getFallback", "getFetcherDispatcher", "getInterceptorDispatcher", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPlaceholder", "getPrecision", "()Lcoil/size/Precision;", "getTransformationDispatcher", "getTransitionFactory", "()Lcoil/transition/Transition$Factory;", "copy", "equals", "other", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DefaultRequestOptions.kt */
public final class DefaultRequestOptions {
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final CoroutineDispatcher decoderDispatcher;
    private final CachePolicy diskCachePolicy;
    private final Drawable error;
    private final Drawable fallback;
    private final CoroutineDispatcher fetcherDispatcher;
    private final CoroutineDispatcher interceptorDispatcher;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Drawable placeholder;
    private final Precision precision;
    private final CoroutineDispatcher transformationDispatcher;
    private final Transition.Factory transitionFactory;

    public DefaultRequestOptions() {
        this((CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32767, (DefaultConstructorMarker) null);
    }

    public DefaultRequestOptions(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision2, Bitmap.Config config, boolean z, boolean z2, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.interceptorDispatcher = coroutineDispatcher;
        this.fetcherDispatcher = coroutineDispatcher2;
        this.decoderDispatcher = coroutineDispatcher3;
        this.transformationDispatcher = coroutineDispatcher4;
        this.transitionFactory = factory;
        this.precision = precision2;
        this.bitmapConfig = config;
        this.allowHardware = z;
        this.allowRgb565 = z2;
        this.placeholder = drawable;
        this.error = drawable2;
        this.fallback = drawable3;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultRequestOptions(kotlinx.coroutines.CoroutineDispatcher r16, kotlinx.coroutines.CoroutineDispatcher r17, kotlinx.coroutines.CoroutineDispatcher r18, kotlinx.coroutines.CoroutineDispatcher r19, coil.transition.Transition.Factory r20, coil.size.Precision r21, android.graphics.Bitmap.Config r22, boolean r23, boolean r24, android.graphics.drawable.Drawable r25, android.graphics.drawable.Drawable r26, android.graphics.drawable.Drawable r27, coil.request.CachePolicy r28, coil.request.CachePolicy r29, coil.request.CachePolicy r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r15 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0011
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r1 = r1.getImmediate()
            kotlinx.coroutines.CoroutineDispatcher r1 = (kotlinx.coroutines.CoroutineDispatcher) r1
            goto L_0x0013
        L_0x0011:
            r1 = r16
        L_0x0013:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001c
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            goto L_0x001e
        L_0x001c:
            r2 = r17
        L_0x001e:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()
            goto L_0x0029
        L_0x0027:
            r3 = r18
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0032
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
            goto L_0x0034
        L_0x0032:
            r4 = r19
        L_0x0034:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003b
            coil.transition.Transition$Factory r5 = coil.transition.Transition.Factory.NONE
            goto L_0x003d
        L_0x003b:
            r5 = r20
        L_0x003d:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0044
            coil.size.Precision r6 = coil.size.Precision.AUTOMATIC
            goto L_0x0046
        L_0x0044:
            r6 = r21
        L_0x0046:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x004f
            android.graphics.Bitmap$Config r7 = coil.util.Utils.getDEFAULT_BITMAP_CONFIG()
            goto L_0x0051
        L_0x004f:
            r7 = r22
        L_0x0051:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0057
            r8 = 1
            goto L_0x0059
        L_0x0057:
            r8 = r23
        L_0x0059:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x005f
            r9 = 0
            goto L_0x0061
        L_0x005f:
            r9 = r24
        L_0x0061:
            r10 = r0 & 512(0x200, float:7.175E-43)
            r11 = 0
            if (r10 == 0) goto L_0x0068
            r10 = r11
            goto L_0x006a
        L_0x0068:
            r10 = r25
        L_0x006a:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0070
            r12 = r11
            goto L_0x0072
        L_0x0070:
            r12 = r26
        L_0x0072:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r11 = r27
        L_0x0079:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0080
            coil.request.CachePolicy r13 = coil.request.CachePolicy.ENABLED
            goto L_0x0082
        L_0x0080:
            r13 = r28
        L_0x0082:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0089
            coil.request.CachePolicy r14 = coil.request.CachePolicy.ENABLED
            goto L_0x008b
        L_0x0089:
            r14 = r29
        L_0x008b:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0092
            coil.request.CachePolicy r0 = coil.request.CachePolicy.ENABLED
            goto L_0x0094
        L_0x0092:
            r0 = r30
        L_0x0094:
            r16 = r15
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r12
            r28 = r11
            r29 = r13
            r30 = r14
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.request.DefaultRequestOptions.<init>(kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher, coil.transition.Transition$Factory, coil.size.Precision, android.graphics.Bitmap$Config, boolean, boolean, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, coil.request.CachePolicy, coil.request.CachePolicy, coil.request.CachePolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final Drawable getPlaceholder() {
        return this.placeholder;
    }

    public final Drawable getError() {
        return this.error;
    }

    public final Drawable getFallback() {
        return this.fallback;
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

    public static /* synthetic */ DefaultRequestOptions copy$default(DefaultRequestOptions defaultRequestOptions, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision2, Bitmap.Config config, boolean z, boolean z2, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i, Object obj) {
        CachePolicy cachePolicy4;
        DefaultRequestOptions defaultRequestOptions2 = defaultRequestOptions;
        int i2 = i;
        CoroutineDispatcher coroutineDispatcher5 = (i2 & 1) != 0 ? defaultRequestOptions2.interceptorDispatcher : coroutineDispatcher;
        CoroutineDispatcher coroutineDispatcher6 = (i2 & 2) != 0 ? defaultRequestOptions2.fetcherDispatcher : coroutineDispatcher2;
        CoroutineDispatcher coroutineDispatcher7 = (i2 & 4) != 0 ? defaultRequestOptions2.decoderDispatcher : coroutineDispatcher3;
        CoroutineDispatcher coroutineDispatcher8 = (i2 & 8) != 0 ? defaultRequestOptions2.transformationDispatcher : coroutineDispatcher4;
        Transition.Factory factory2 = (i2 & 16) != 0 ? defaultRequestOptions2.transitionFactory : factory;
        Precision precision3 = (i2 & 32) != 0 ? defaultRequestOptions2.precision : precision2;
        Bitmap.Config config2 = (i2 & 64) != 0 ? defaultRequestOptions2.bitmapConfig : config;
        boolean z3 = (i2 & 128) != 0 ? defaultRequestOptions2.allowHardware : z;
        boolean z4 = (i2 & 256) != 0 ? defaultRequestOptions2.allowRgb565 : z2;
        Drawable drawable4 = (i2 & 512) != 0 ? defaultRequestOptions2.placeholder : drawable;
        Drawable drawable5 = (i2 & 1024) != 0 ? defaultRequestOptions2.error : drawable2;
        Drawable drawable6 = (i2 & 2048) != 0 ? defaultRequestOptions2.fallback : drawable3;
        CachePolicy cachePolicy5 = (i2 & 4096) != 0 ? defaultRequestOptions2.memoryCachePolicy : cachePolicy;
        CachePolicy cachePolicy6 = (i2 & 8192) != 0 ? defaultRequestOptions2.diskCachePolicy : cachePolicy2;
        if ((i2 & 16384) != 0) {
            cachePolicy4 = defaultRequestOptions2.networkCachePolicy;
        } else {
            cachePolicy4 = cachePolicy3;
        }
        return defaultRequestOptions.copy(coroutineDispatcher5, coroutineDispatcher6, coroutineDispatcher7, coroutineDispatcher8, factory2, precision3, config2, z3, z4, drawable4, drawable5, drawable6, cachePolicy5, cachePolicy6, cachePolicy4);
    }

    public final DefaultRequestOptions copy(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Transition.Factory factory, Precision precision2, Bitmap.Config config, boolean z, boolean z2, Drawable drawable, Drawable drawable2, Drawable drawable3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        return new DefaultRequestOptions(coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, factory, precision2, config, z, z2, drawable, drawable2, drawable3, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultRequestOptions) {
            DefaultRequestOptions defaultRequestOptions = (DefaultRequestOptions) obj;
            if (!Intrinsics.areEqual((Object) this.interceptorDispatcher, (Object) defaultRequestOptions.interceptorDispatcher) || !Intrinsics.areEqual((Object) this.fetcherDispatcher, (Object) defaultRequestOptions.fetcherDispatcher) || !Intrinsics.areEqual((Object) this.decoderDispatcher, (Object) defaultRequestOptions.decoderDispatcher) || !Intrinsics.areEqual((Object) this.transformationDispatcher, (Object) defaultRequestOptions.transformationDispatcher) || !Intrinsics.areEqual((Object) this.transitionFactory, (Object) defaultRequestOptions.transitionFactory) || this.precision != defaultRequestOptions.precision || this.bitmapConfig != defaultRequestOptions.bitmapConfig || this.allowHardware != defaultRequestOptions.allowHardware || this.allowRgb565 != defaultRequestOptions.allowRgb565 || !Intrinsics.areEqual((Object) this.placeholder, (Object) defaultRequestOptions.placeholder) || !Intrinsics.areEqual((Object) this.error, (Object) defaultRequestOptions.error) || !Intrinsics.areEqual((Object) this.fallback, (Object) defaultRequestOptions.fallback) || this.memoryCachePolicy != defaultRequestOptions.memoryCachePolicy || this.diskCachePolicy != defaultRequestOptions.diskCachePolicy || this.networkCachePolicy != defaultRequestOptions.networkCachePolicy) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.interceptorDispatcher.hashCode() * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.bitmapConfig.hashCode()) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31;
        Drawable drawable = this.placeholder;
        int i = 0;
        int hashCode2 = (hashCode + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.error;
        int hashCode3 = (hashCode2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.fallback;
        if (drawable3 != null) {
            i = drawable3.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    }
}
