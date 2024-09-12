package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.RequestService;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.Utils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J1\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010#J9\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010+J3\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "options", "Lcoil/request/Options;", "transformations", "", "Lcoil/transform/Transformation;", "decode", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "fetchResult", "Lcoil/fetch/SourceResult;", "components", "Lcoil/ComponentRegistry;", "request", "Lcoil/request/ImageRequest;", "mappedData", "", "eventListener", "Lcoil/EventListener;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "_options", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ExecuteResult", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EngineInterceptor.kt */
public final class EngineInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    /* access modifiers changed from: private */
    public final MemoryCacheService memoryCacheService;
    private final RequestService requestService;

    public EngineInterceptor(ImageLoader imageLoader2, RequestService requestService2, Logger logger2) {
        this.imageLoader = imageLoader2;
        this.requestService = requestService2;
        this.logger = logger2;
        this.memoryCacheService = new MemoryCacheService(imageLoader2, requestService2, logger2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object intercept(coil.intercept.Interceptor.Chain r14, kotlin.coroutines.Continuation<? super coil.request.ImageResult> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil.intercept.EngineInterceptor$intercept$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            coil.intercept.EngineInterceptor$intercept$1 r0 = (coil.intercept.EngineInterceptor$intercept$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            coil.intercept.EngineInterceptor$intercept$1 r0 = new coil.intercept.EngineInterceptor$intercept$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r14 = r0.L$1
            coil.intercept.Interceptor$Chain r14 = (coil.intercept.Interceptor.Chain) r14
            java.lang.Object r0 = r0.L$0
            coil.intercept.EngineInterceptor r0 = (coil.intercept.EngineInterceptor) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0032 }
            goto L_0x00a0
        L_0x0032:
            r15 = move-exception
            goto L_0x00a3
        L_0x0034:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r15)
            coil.request.ImageRequest r6 = r14.getRequest()     // Catch:{ all -> 0x00a1 }
            java.lang.Object r15 = r6.getData()     // Catch:{ all -> 0x00a1 }
            coil.size.Size r2 = r14.getSize()     // Catch:{ all -> 0x00a1 }
            coil.EventListener r9 = coil.util.Utils.getEventListener(r14)     // Catch:{ all -> 0x00a1 }
            coil.request.RequestService r4 = r13.requestService     // Catch:{ all -> 0x00a1 }
            coil.request.Options r8 = r4.options(r6, r2)     // Catch:{ all -> 0x00a1 }
            coil.size.Scale r4 = r8.getScale()     // Catch:{ all -> 0x00a1 }
            r9.mapStart(r6, r15)     // Catch:{ all -> 0x00a1 }
            coil.ImageLoader r5 = r13.imageLoader     // Catch:{ all -> 0x00a1 }
            coil.ComponentRegistry r5 = r5.getComponents()     // Catch:{ all -> 0x00a1 }
            java.lang.Object r7 = r5.map(r15, r8)     // Catch:{ all -> 0x00a1 }
            r9.mapEnd(r6, r7)     // Catch:{ all -> 0x00a1 }
            coil.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch:{ all -> 0x00a1 }
            coil.memory.MemoryCache$Key r10 = r15.newCacheKey(r6, r7, r8, r9)     // Catch:{ all -> 0x00a1 }
            if (r10 == 0) goto L_0x0078
            coil.memory.MemoryCacheService r15 = r13.memoryCacheService     // Catch:{ all -> 0x00a1 }
            coil.memory.MemoryCache$Value r15 = r15.getCacheValue(r6, r10, r2, r4)     // Catch:{ all -> 0x00a1 }
            goto L_0x0079
        L_0x0078:
            r15 = 0
        L_0x0079:
            if (r15 == 0) goto L_0x0082
            coil.memory.MemoryCacheService r0 = r13.memoryCacheService     // Catch:{ all -> 0x00a1 }
            coil.request.SuccessResult r14 = r0.newResult(r14, r6, r10, r15)     // Catch:{ all -> 0x00a1 }
            return r14
        L_0x0082:
            kotlinx.coroutines.CoroutineDispatcher r15 = r6.getFetcherDispatcher()     // Catch:{ all -> 0x00a1 }
            kotlin.coroutines.CoroutineContext r15 = (kotlin.coroutines.CoroutineContext) r15     // Catch:{ all -> 0x00a1 }
            coil.intercept.EngineInterceptor$intercept$2 r2 = new coil.intercept.EngineInterceptor$intercept$2     // Catch:{ all -> 0x00a1 }
            r12 = 0
            r4 = r2
            r5 = r13
            r11 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00a1 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ all -> 0x00a1 }
            r0.L$0 = r13     // Catch:{ all -> 0x00a1 }
            r0.L$1 = r14     // Catch:{ all -> 0x00a1 }
            r0.label = r3     // Catch:{ all -> 0x00a1 }
            java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r15, r2, r0)     // Catch:{ all -> 0x00a1 }
            if (r15 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            return r15
        L_0x00a1:
            r15 = move-exception
            r0 = r13
        L_0x00a3:
            boolean r1 = r15 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L_0x00b2
            coil.request.RequestService r0 = r0.requestService
            coil.request.ImageRequest r14 = r14.getRequest()
            coil.request.ErrorResult r14 = r0.errorResult(r14, r15)
            return r14
        L_0x00b2:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.intercept(coil.intercept.Interceptor$Chain, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: coil.fetch.SourceResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x015c A[Catch:{ all -> 0x0219 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a0 A[SYNTHETIC, Splitter:B:54:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object execute(coil.request.ImageRequest r36, java.lang.Object r37, coil.request.Options r38, coil.EventListener r39, kotlin.coroutines.Continuation<? super coil.intercept.EngineInterceptor.ExecuteResult> r40) {
        /*
            r35 = this;
            r8 = r35
            r0 = r40
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$execute$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            coil.intercept.EngineInterceptor$execute$1 r1 = (coil.intercept.EngineInterceptor$execute$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001d
        L_0x0018:
            coil.intercept.EngineInterceptor$execute$1 r1 = new coil.intercept.EngineInterceptor$execute$1
            r1.<init>(r8, r0)
        L_0x001d:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r10 = 3
            r11 = 2
            r3 = 1
            r12 = 0
            if (r2 == 0) goto L_0x0088
            if (r2 == r3) goto L_0x005b
            if (r2 == r11) goto L_0x003f
            if (r2 != r10) goto L_0x0037
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x01fa
        L_0x0037:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003f:
            java.lang.Object r2 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r0.L$2
            coil.EventListener r4 = (coil.EventListener) r4
            java.lang.Object r5 = r0.L$1
            coil.request.ImageRequest r5 = (coil.request.ImageRequest) r5
            java.lang.Object r6 = r0.L$0
            coil.intercept.EngineInterceptor r6 = (coil.intercept.EngineInterceptor) r6
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x0058 }
            goto L_0x0194
        L_0x0058:
            r0 = move-exception
            goto L_0x021b
        L_0x005b:
            java.lang.Object r2 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$6
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r0.L$5
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r0.L$3
            coil.EventListener r6 = (coil.EventListener) r6
            java.lang.Object r7 = r0.L$2
            java.lang.Object r13 = r0.L$1
            coil.request.ImageRequest r13 = (coil.request.ImageRequest) r13
            java.lang.Object r14 = r0.L$0
            coil.intercept.EngineInterceptor r14 = (coil.intercept.EngineInterceptor) r14
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x0084 }
            r15 = r3
            r19 = r4
            r3 = r5
            r21 = r7
            goto L_0x0152
        L_0x0084:
            r0 = move-exception
            r2 = r3
            goto L_0x021b
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            r1 = r38
            r13.element = r1
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            coil.ImageLoader r1 = r8.imageLoader
            coil.ComponentRegistry r1 = r1.getComponents()
            r14.element = r1
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            coil.request.RequestService r1 = r8.requestService     // Catch:{ all -> 0x0219 }
            T r2 = r13.element     // Catch:{ all -> 0x0219 }
            coil.request.Options r2 = (coil.request.Options) r2     // Catch:{ all -> 0x0219 }
            boolean r1 = r1.allowHardwareWorkerThread(r2)     // Catch:{ all -> 0x0219 }
            if (r1 != 0) goto L_0x00e0
            T r1 = r13.element     // Catch:{ all -> 0x0219 }
            r16 = r1
            coil.request.Options r16 = (coil.request.Options) r16     // Catch:{ all -> 0x0219 }
            r17 = 0
            android.graphics.Bitmap$Config r18 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0219 }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 32765(0x7ffd, float:4.5914E-41)
            r33 = 0
            coil.request.Options r1 = coil.request.Options.copy$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x0219 }
            r13.element = r1     // Catch:{ all -> 0x0219 }
        L_0x00e0:
            kotlin.Pair r1 = r36.getFetcherFactory()     // Catch:{ all -> 0x0219 }
            if (r1 != 0) goto L_0x00ec
            coil.decode.Decoder$Factory r1 = r36.getDecoderFactory()     // Catch:{ all -> 0x0219 }
            if (r1 == 0) goto L_0x0115
        L_0x00ec:
            T r1 = r14.element     // Catch:{ all -> 0x0219 }
            coil.ComponentRegistry r1 = (coil.ComponentRegistry) r1     // Catch:{ all -> 0x0219 }
            coil.ComponentRegistry$Builder r1 = r1.newBuilder()     // Catch:{ all -> 0x0219 }
            kotlin.Pair r2 = r36.getFetcherFactory()     // Catch:{ all -> 0x0219 }
            r4 = 0
            if (r2 == 0) goto L_0x0102
            java.util.List r5 = r1.getFetcherFactories$coil_base_release()     // Catch:{ all -> 0x0219 }
            r5.add(r4, r2)     // Catch:{ all -> 0x0219 }
        L_0x0102:
            coil.decode.Decoder$Factory r2 = r36.getDecoderFactory()     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x010f
            java.util.List r5 = r1.getDecoderFactories$coil_base_release()     // Catch:{ all -> 0x0219 }
            r5.add(r4, r2)     // Catch:{ all -> 0x0219 }
        L_0x010f:
            coil.ComponentRegistry r1 = r1.build()     // Catch:{ all -> 0x0219 }
            r14.element = r1     // Catch:{ all -> 0x0219 }
        L_0x0115:
            T r1 = r14.element     // Catch:{ all -> 0x0219 }
            r2 = r1
            coil.ComponentRegistry r2 = (coil.ComponentRegistry) r2     // Catch:{ all -> 0x0219 }
            T r1 = r13.element     // Catch:{ all -> 0x0219 }
            r5 = r1
            coil.request.Options r5 = (coil.request.Options) r5     // Catch:{ all -> 0x0219 }
            r0.L$0 = r8     // Catch:{ all -> 0x0219 }
            r7 = r36
            r0.L$1 = r7     // Catch:{ all -> 0x0219 }
            r6 = r37
            r0.L$2 = r6     // Catch:{ all -> 0x0219 }
            r4 = r39
            r0.L$3 = r4     // Catch:{ all -> 0x0219 }
            r0.L$4 = r13     // Catch:{ all -> 0x0219 }
            r0.L$5 = r14     // Catch:{ all -> 0x0219 }
            r0.L$6 = r15     // Catch:{ all -> 0x0219 }
            r0.L$7 = r15     // Catch:{ all -> 0x0219 }
            r0.label = r3     // Catch:{ all -> 0x0219 }
            r1 = r35
            r3 = r36
            r4 = r37
            r6 = r39
            r7 = r0
            java.lang.Object r1 = r1.fetch(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0219 }
            if (r1 != r9) goto L_0x0147
            return r9
        L_0x0147:
            r21 = r37
            r6 = r39
            r3 = r13
            r19 = r14
            r2 = r15
            r13 = r36
            r14 = r8
        L_0x0152:
            r2.element = r1     // Catch:{ all -> 0x0219 }
            T r1 = r15.element     // Catch:{ all -> 0x0219 }
            coil.fetch.FetchResult r1 = (coil.fetch.FetchResult) r1     // Catch:{ all -> 0x0219 }
            boolean r2 = r1 instanceof coil.fetch.SourceResult     // Catch:{ all -> 0x0219 }
            if (r2 == 0) goto L_0x01a0
            kotlinx.coroutines.CoroutineDispatcher r1 = r13.getDecoderDispatcher()     // Catch:{ all -> 0x0219 }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ all -> 0x0219 }
            coil.intercept.EngineInterceptor$execute$executeResult$1 r2 = new coil.intercept.EngineInterceptor$execute$executeResult$1     // Catch:{ all -> 0x0219 }
            r24 = 0
            r16 = r2
            r17 = r14
            r18 = r15
            r20 = r13
            r22 = r3
            r23 = r6
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0219 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ all -> 0x0219 }
            r0.L$0 = r14     // Catch:{ all -> 0x0219 }
            r0.L$1 = r13     // Catch:{ all -> 0x0219 }
            r0.L$2 = r6     // Catch:{ all -> 0x0219 }
            r0.L$3 = r3     // Catch:{ all -> 0x0219 }
            r0.L$4 = r15     // Catch:{ all -> 0x0219 }
            r0.L$5 = r12     // Catch:{ all -> 0x0219 }
            r0.L$6 = r12     // Catch:{ all -> 0x0219 }
            r0.L$7 = r12     // Catch:{ all -> 0x0219 }
            r0.label = r11     // Catch:{ all -> 0x0219 }
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r2, r0)     // Catch:{ all -> 0x0219 }
            if (r1 != r9) goto L_0x0190
            return r9
        L_0x0190:
            r4 = r6
            r5 = r13
            r6 = r14
            r2 = r15
        L_0x0194:
            coil.intercept.EngineInterceptor$ExecuteResult r1 = (coil.intercept.EngineInterceptor.ExecuteResult) r1     // Catch:{ all -> 0x0058 }
            r15 = r2
            r2 = r6
            r6 = r4
            r4 = r5
        L_0x019a:
            r34 = r3
            r3 = r1
            r1 = r34
            goto L_0x01c4
        L_0x01a0:
            boolean r1 = r1 instanceof coil.fetch.DrawableResult     // Catch:{ all -> 0x0219 }
            if (r1 == 0) goto L_0x0213
            coil.intercept.EngineInterceptor$ExecuteResult r1 = new coil.intercept.EngineInterceptor$ExecuteResult     // Catch:{ all -> 0x0219 }
            T r2 = r15.element     // Catch:{ all -> 0x0219 }
            coil.fetch.DrawableResult r2 = (coil.fetch.DrawableResult) r2     // Catch:{ all -> 0x0219 }
            android.graphics.drawable.Drawable r2 = r2.getDrawable()     // Catch:{ all -> 0x0219 }
            T r4 = r15.element     // Catch:{ all -> 0x0219 }
            coil.fetch.DrawableResult r4 = (coil.fetch.DrawableResult) r4     // Catch:{ all -> 0x0219 }
            boolean r4 = r4.isSampled()     // Catch:{ all -> 0x0219 }
            T r5 = r15.element     // Catch:{ all -> 0x0219 }
            coil.fetch.DrawableResult r5 = (coil.fetch.DrawableResult) r5     // Catch:{ all -> 0x0219 }
            coil.decode.DataSource r5 = r5.getDataSource()     // Catch:{ all -> 0x0219 }
            r1.<init>(r2, r4, r5, r12)     // Catch:{ all -> 0x0219 }
            r4 = r13
            r2 = r14
            goto L_0x019a
        L_0x01c4:
            T r5 = r15.element
            boolean r7 = r5 instanceof coil.fetch.SourceResult
            if (r7 == 0) goto L_0x01cd
            coil.fetch.SourceResult r5 = (coil.fetch.SourceResult) r5
            goto L_0x01ce
        L_0x01cd:
            r5 = r12
        L_0x01ce:
            if (r5 == 0) goto L_0x01db
            coil.decode.ImageSource r5 = r5.getSource()
            if (r5 == 0) goto L_0x01db
            java.io.Closeable r5 = (java.io.Closeable) r5
            coil.util.Utils.closeQuietly(r5)
        L_0x01db:
            T r1 = r1.element
            r5 = r1
            coil.request.Options r5 = (coil.request.Options) r5
            r0.L$0 = r12
            r0.L$1 = r12
            r0.L$2 = r12
            r0.L$3 = r12
            r0.L$4 = r12
            r0.L$5 = r12
            r0.L$6 = r12
            r0.L$7 = r12
            r0.label = r10
            r7 = r0
            java.lang.Object r1 = r2.transform$coil_base_release(r3, r4, r5, r6, r7)
            if (r1 != r9) goto L_0x01fa
            return r9
        L_0x01fa:
            coil.intercept.EngineInterceptor$ExecuteResult r1 = (coil.intercept.EngineInterceptor.ExecuteResult) r1
            android.graphics.drawable.Drawable r0 = r1.getDrawable()
            boolean r2 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r2 == 0) goto L_0x0207
            r12 = r0
            android.graphics.drawable.BitmapDrawable r12 = (android.graphics.drawable.BitmapDrawable) r12
        L_0x0207:
            if (r12 == 0) goto L_0x0212
            android.graphics.Bitmap r0 = r12.getBitmap()
            if (r0 == 0) goto L_0x0212
            r0.prepareToDraw()
        L_0x0212:
            return r1
        L_0x0213:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0219 }
            r0.<init>()     // Catch:{ all -> 0x0219 }
            throw r0     // Catch:{ all -> 0x0219 }
        L_0x0219:
            r0 = move-exception
            r2 = r15
        L_0x021b:
            T r1 = r2.element
            boolean r2 = r1 instanceof coil.fetch.SourceResult
            if (r2 == 0) goto L_0x0224
            r12 = r1
            coil.fetch.SourceResult r12 = (coil.fetch.SourceResult) r12
        L_0x0224:
            if (r12 == 0) goto L_0x0231
            coil.decode.ImageSource r1 = r12.getSource()
            if (r1 == 0) goto L_0x0231
            java.io.Closeable r1 = (java.io.Closeable) r1
            coil.util.Utils.closeQuietly(r1)
        L_0x0231:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.execute(coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetch(coil.ComponentRegistry r10, coil.request.ImageRequest r11, java.lang.Object r12, coil.request.Options r13, coil.EventListener r14, kotlin.coroutines.Continuation<? super coil.fetch.FetchResult> r15) {
        /*
            r9 = this;
            boolean r0 = r15 instanceof coil.intercept.EngineInterceptor$fetch$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            coil.intercept.EngineInterceptor$fetch$1 r0 = (coil.intercept.EngineInterceptor$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            coil.intercept.EngineInterceptor$fetch$1 r0 = new coil.intercept.EngineInterceptor$fetch$1
            r0.<init>(r9, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 != r3) goto L_0x0051
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$6
            coil.fetch.Fetcher r11 = (coil.fetch.Fetcher) r11
            java.lang.Object r12 = r0.L$5
            coil.EventListener r12 = (coil.EventListener) r12
            java.lang.Object r13 = r0.L$4
            coil.request.Options r13 = (coil.request.Options) r13
            java.lang.Object r14 = r0.L$3
            java.lang.Object r2 = r0.L$2
            coil.request.ImageRequest r2 = (coil.request.ImageRequest) r2
            java.lang.Object r4 = r0.L$1
            coil.ComponentRegistry r4 = (coil.ComponentRegistry) r4
            java.lang.Object r5 = r0.L$0
            coil.intercept.EngineInterceptor r5 = (coil.intercept.EngineInterceptor) r5
            kotlin.ResultKt.throwOnFailure(r15)
            r6 = r0
            r0 = r10
            r10 = r4
            r4 = r1
            r1 = r6
            r7 = r2
            r2 = r11
            r11 = r7
            r8 = r14
            r14 = r12
            r12 = r8
            goto L_0x0098
        L_0x0051:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            r5 = r9
        L_0x005e:
            coil.ImageLoader r2 = r5.imageLoader
            kotlin.Pair r15 = r10.newFetcher(r12, r13, r2, r15)
            if (r15 == 0) goto L_0x00bb
            java.lang.Object r2 = r15.getFirst()
            coil.fetch.Fetcher r2 = (coil.fetch.Fetcher) r2
            java.lang.Object r15 = r15.getSecond()
            java.lang.Number r15 = (java.lang.Number) r15
            int r15 = r15.intValue()
            int r15 = r15 + r3
            r14.fetchStart(r11, r2, r13)
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r11
            r0.L$3 = r12
            r0.L$4 = r13
            r0.L$5 = r14
            r0.L$6 = r2
            r0.I$0 = r15
            r0.label = r3
            java.lang.Object r4 = r2.fetch(r0)
            if (r4 != r1) goto L_0x0093
            return r1
        L_0x0093:
            r6 = r0
            r0 = r15
            r15 = r4
            r4 = r1
            r1 = r6
        L_0x0098:
            coil.fetch.FetchResult r15 = (coil.fetch.FetchResult) r15
            r14.fetchEnd(r11, r2, r13, r15)     // Catch:{ all -> 0x00a4 }
            if (r15 == 0) goto L_0x00a0
            return r15
        L_0x00a0:
            r15 = r0
            r0 = r1
            r1 = r4
            goto L_0x005e
        L_0x00a4:
            r10 = move-exception
            boolean r11 = r15 instanceof coil.fetch.SourceResult
            if (r11 == 0) goto L_0x00ac
            coil.fetch.SourceResult r15 = (coil.fetch.SourceResult) r15
            goto L_0x00ad
        L_0x00ac:
            r15 = 0
        L_0x00ad:
            if (r15 == 0) goto L_0x00ba
            coil.decode.ImageSource r11 = r15.getSource()
            if (r11 == 0) goto L_0x00ba
            java.io.Closeable r11 = (java.io.Closeable) r11
            coil.util.Utils.closeQuietly(r11)
        L_0x00ba:
            throw r10
        L_0x00bb:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unable to create a fetcher that supports: "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r10 = r10.append(r12)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.fetch(coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object decode(coil.fetch.SourceResult r17, coil.ComponentRegistry r18, coil.request.ImageRequest r19, java.lang.Object r20, coil.request.Options r21, coil.EventListener r22, kotlin.coroutines.Continuation<? super coil.intercept.EngineInterceptor.ExecuteResult> r23) {
        /*
            r16 = this;
            r0 = r23
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$decode$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            coil.intercept.EngineInterceptor$decode$1 r1 = (coil.intercept.EngineInterceptor$decode$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r16
            goto L_0x001f
        L_0x0018:
            coil.intercept.EngineInterceptor$decode$1 r1 = new coil.intercept.EngineInterceptor$decode$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L_0x0061
            if (r4 != r5) goto L_0x0059
            int r4 = r1.I$0
            java.lang.Object r6 = r1.L$7
            coil.decode.Decoder r6 = (coil.decode.Decoder) r6
            java.lang.Object r7 = r1.L$6
            coil.EventListener r7 = (coil.EventListener) r7
            java.lang.Object r8 = r1.L$5
            coil.request.Options r8 = (coil.request.Options) r8
            java.lang.Object r9 = r1.L$4
            java.lang.Object r10 = r1.L$3
            coil.request.ImageRequest r10 = (coil.request.ImageRequest) r10
            java.lang.Object r11 = r1.L$2
            coil.ComponentRegistry r11 = (coil.ComponentRegistry) r11
            java.lang.Object r12 = r1.L$1
            coil.fetch.SourceResult r12 = (coil.fetch.SourceResult) r12
            java.lang.Object r13 = r1.L$0
            coil.intercept.EngineInterceptor r13 = (coil.intercept.EngineInterceptor) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r10
            r10 = r1
            r1 = r11
            r11 = r3
            r3 = r14
            r15 = r9
            r9 = r4
            r4 = r15
            goto L_0x00b5
        L_0x0059:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = 0
            r4 = r20
            r6 = r21
            r7 = r22
            r8 = r0
            r9 = r1
            r13 = r2
            r10 = r3
            r0 = r17
            r1 = r18
            r3 = r19
        L_0x0075:
            coil.ImageLoader r11 = r13.imageLoader
            kotlin.Pair r8 = r1.newDecoder(r0, r6, r11, r8)
            if (r8 == 0) goto L_0x00e7
            java.lang.Object r11 = r8.getFirst()
            coil.decode.Decoder r11 = (coil.decode.Decoder) r11
            java.lang.Object r8 = r8.getSecond()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            int r8 = r8 + r5
            r7.decodeStart(r3, r11, r6)
            r9.L$0 = r13
            r9.L$1 = r0
            r9.L$2 = r1
            r9.L$3 = r3
            r9.L$4 = r4
            r9.L$5 = r6
            r9.L$6 = r7
            r9.L$7 = r11
            r9.I$0 = r8
            r9.label = r5
            java.lang.Object r12 = r11.decode(r9)
            if (r12 != r10) goto L_0x00ac
            return r10
        L_0x00ac:
            r14 = r12
            r12 = r0
            r0 = r14
            r15 = r8
            r8 = r6
            r6 = r11
            r11 = r10
            r10 = r9
            r9 = r15
        L_0x00b5:
            coil.decode.DecodeResult r0 = (coil.decode.DecodeResult) r0
            r7.decodeEnd(r3, r6, r8, r0)
            if (r0 == 0) goto L_0x00e1
            coil.intercept.EngineInterceptor$ExecuteResult r1 = new coil.intercept.EngineInterceptor$ExecuteResult
            android.graphics.drawable.Drawable r3 = r0.getDrawable()
            boolean r0 = r0.isSampled()
            coil.decode.DataSource r4 = r12.getDataSource()
            coil.decode.ImageSource r5 = r12.getSource()
            boolean r6 = r5 instanceof coil.decode.FileImageSource
            r7 = 0
            if (r6 == 0) goto L_0x00d6
            coil.decode.FileImageSource r5 = (coil.decode.FileImageSource) r5
            goto L_0x00d7
        L_0x00d6:
            r5 = r7
        L_0x00d7:
            if (r5 == 0) goto L_0x00dd
            java.lang.String r7 = r5.getDiskCacheKey$coil_base_release()
        L_0x00dd:
            r1.<init>(r3, r0, r4, r7)
            return r1
        L_0x00e1:
            r6 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0 = r12
            goto L_0x0075
        L_0x00e7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to create a decoder that supports: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.decode(coil.fetch.SourceResult, coil.ComponentRegistry, coil.request.ImageRequest, java.lang.Object, coil.request.Options, coil.EventListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object transform$coil_base_release(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Transformation> transformations = imageRequest.getTransformations();
        if (transformations.isEmpty()) {
            return executeResult;
        }
        if ((executeResult.getDrawable() instanceof BitmapDrawable) || imageRequest.getAllowConversionToBitmap()) {
            return BuildersKt.withContext(imageRequest.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, executeResult, options, transformations, eventListener, imageRequest, (Continuation<? super EngineInterceptor$transform$3>) null), continuation);
        }
        Logger logger2 = this.logger;
        if (logger2 != null && logger2.getLevel() <= 4) {
            logger2.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.getDrawable().getClass().getCanonicalName() + '.', (Throwable) null);
        }
        return executeResult;
    }

    /* access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> list) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains((T[]) Utils.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, "Converting bitmap with config " + safeConfig + " to apply transformations: " + list + '.', (Throwable) null);
            }
        } else {
            Logger logger3 = this.logger;
            if (logger3 != null && logger3.getLevel() <= 4) {
                logger3.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + list + '.', (Throwable) null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "copy", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: EngineInterceptor.kt */
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable2, boolean z, DataSource dataSource2, String str) {
            this.drawable = drawable2;
            this.isSampled = z;
            this.dataSource = dataSource2;
            this.diskCacheKey = str;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable2, boolean z, DataSource dataSource2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable2 = executeResult.drawable;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource2 = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable2, z, dataSource2, str);
        }

        public final ExecuteResult copy(Drawable drawable2, boolean z, DataSource dataSource2, String str) {
            return new ExecuteResult(drawable2, z, dataSource2, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/intercept/EngineInterceptor$Companion;", "", "()V", "TAG", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: EngineInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
