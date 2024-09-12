package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.decode.DataSource;
import coil.decode.Decoder;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.memory.MemoryCache;
import coil.request.Parameters;
import coil.request.Tags;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Deferred;
import okhttp3.Headers;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020A2\u0006\u0010M\u001a\u00020\rH\u0000\u001a\u0010\u0010N\u001a\u00020\r2\u0006\u0010L\u001a\u00020AH\u0000\u001a\u0010\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020&H\u0000\u001a\b\u0010Q\u001a\u000202H\u0000\u001a\b\u0010R\u001a\u00020SH\u0000\u001a\f\u0010T\u001a\u00020U*\u00020VH\u0000\u001a\u0017\u0010W\u001a\u00020X*\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\b\u001a+\u0010W\u001a\u00020X*\u00020X2\u001c\u0010[\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030]\u0012\b\u0012\u0006\u0012\u0002\b\u00030^\u0018\u00010\\H\b\u001a\f\u0010_\u001a\u00020U*\u00020`H\u0000\u001a\u0019\u0010a\u001a\u0004\u0018\u00010b*\u00020c2\b\u0010d\u001a\u0004\u0018\u00010eH\n\u001a\u001f\u0010f\u001a\u0004\u0018\u0001Hg\"\u0004\b\u0000\u0010g*\b\u0012\u0004\u0012\u0002Hg0hH\u0000¢\u0006\u0002\u0010i\u001a\u0018\u0010j\u001a\u0004\u0018\u00010\u0001*\u00020k2\b\u0010l\u001a\u0004\u0018\u00010\u0001H\u0000\u001a#\u0010m\u001a\u00020\u0007*\u00020n2\u0006\u0010D\u001a\u00020E2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070pH\b\u001a\f\u0010q\u001a\u000202*\u00020\u0007H\u0000\u001a\u000e\u0010r\u001a\u00020s*\u0004\u0018\u00010sH\u0000\u001a\u000e\u0010r\u001a\u00020t*\u0004\u0018\u00010tH\u0000\u001a\u000e\u0010r\u001a\u00020\t*\u0004\u0018\u00010\tH\u0000\u001a\u0014\u0010u\u001a\u00020\u0007*\u00020\u00012\u0006\u0010v\u001a\u00020\u0007H\u0000\u001a\u0014\u0010w\u001a\u00020\u0007*\u00020x2\u0006\u0010D\u001a\u00020EH\u0000\u001a#\u0010y\u001a\u00020\u0007*\u00020n2\u0006\u0010D\u001a\u00020E2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070pH\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018X\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a\"\u0018\u0010\u001c\u001a\u00020\u0001*\u00020\u001d8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0018\u0010 \u001a\u00020!*\u00020\"8@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001a\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020&8@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0018\u0010)\u001a\u00020\u0007*\u00020*8@X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0019\u0010-\u001a\u00020\u0007*\u00020.8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0018\u00101\u001a\u000202*\u00020\"8@X\u0004¢\u0006\u0006\u001a\u0004\b1\u00103\"\u0018\u00104\u001a\u000202*\u00020*8@X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0018\u00106\u001a\u00020\u0007*\u0002078@X\u0004¢\u0006\u0006\u001a\u0004\b8\u00109\"\u0018\u0010:\u001a\u00020;*\u00020<8@X\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0018\u0010?\u001a\u00020@*\u00020A8@X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C\"\u0018\u0010D\u001a\u00020E*\u00020F8@X\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H\"\u0018\u0010I\u001a\u00020\u0007*\u00020*8@X\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010,¨\u0006z"}, d2 = {"ASSET_FILE_PATH_ROOT", "", "DEFAULT_BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getDEFAULT_BITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "DEFAULT_MEMORY_CLASS_MEGABYTES", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "getEMPTY_HEADERS", "()Lokhttp3/Headers;", "LOW_MEMORY_MULTIPLIER", "", "MIME_TYPE_HEIC", "MIME_TYPE_HEIF", "MIME_TYPE_JPEG", "MIME_TYPE_WEBP", "NULL_COLOR_SPACE", "Landroid/graphics/ColorSpace;", "getNULL_COLOR_SPACE", "()Landroid/graphics/ColorSpace;", "STANDARD_MEMORY_MULTIPLIER", "VALID_TRANSFORMATION_CONFIGS", "", "getVALID_TRANSFORMATION_CONFIGS", "()[Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "emoji", "Lcoil/decode/DataSource;", "getEmoji", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "eventListener", "Lcoil/EventListener;", "Lcoil/intercept/Interceptor$Chain;", "getEventListener", "(Lcoil/intercept/Interceptor$Chain;)Lcoil/EventListener;", "firstPathSegment", "Landroid/net/Uri;", "getFirstPathSegment", "(Landroid/net/Uri;)Ljava/lang/String;", "height", "Landroid/graphics/drawable/Drawable;", "getHeight", "(Landroid/graphics/drawable/Drawable;)I", "identityHashCode", "", "getIdentityHashCode", "(Ljava/lang/Object;)I", "isPlaceholderCached", "", "(Lcoil/intercept/Interceptor$Chain;)Z", "isVector", "(Landroid/graphics/drawable/Drawable;)Z", "nightMode", "Landroid/content/res/Configuration;", "getNightMode", "(Landroid/content/res/Configuration;)I", "requestManager", "Lcoil/request/ViewTargetRequestManager;", "Landroid/view/View;", "getRequestManager", "(Landroid/view/View;)Lcoil/request/ViewTargetRequestManager;", "safeCacheDir", "Ljava/io/File;", "Landroid/content/Context;", "getSafeCacheDir", "(Landroid/content/Context;)Ljava/io/File;", "scale", "Lcoil/size/Scale;", "Landroid/widget/ImageView;", "getScale", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "width", "getWidth", "calculateMemoryCacheSize", "context", "percent", "defaultMemoryCacheSizePercent", "isAssetUri", "uri", "isMainThread", "unsupported", "", "abortQuietly", "", "Lcoil/disk/DiskCache$Editor;", "addFirst", "Lcoil/ComponentRegistry$Builder;", "factory", "Lcoil/decode/Decoder$Factory;", "pair", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "closeQuietly", "Ljava/io/Closeable;", "get", "Lcoil/memory/MemoryCache$Value;", "Lcoil/memory/MemoryCache;", "key", "Lcoil/memory/MemoryCache$Key;", "getCompletedOrNull", "T", "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;)Ljava/lang/Object;", "getMimeTypeFromUrl", "Landroid/webkit/MimeTypeMap;", "url", "heightPx", "Lcoil/size/Size;", "original", "Lkotlin/Function0;", "isMinOrMax", "orEmpty", "Lcoil/request/Parameters;", "Lcoil/request/Tags;", "toNonNegativeInt", "defaultValue", "toPx", "Lcoil/size/Dimension;", "widthPx", "coil-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-Utils  reason: invalid class name */
/* compiled from: Utils.kt */
public final class Utils {
    public static final String ASSET_FILE_PATH_ROOT = "android_asset";
    private static final Bitmap.Config DEFAULT_BITMAP_CONFIG;
    private static final int DEFAULT_MEMORY_CLASS_MEGABYTES = 256;
    private static final Headers EMPTY_HEADERS = new Headers.Builder().build();
    private static final double LOW_MEMORY_MULTIPLIER = 0.15d;
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_HEIF = "image/heif";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_WEBP = "image/webp";
    private static final ColorSpace NULL_COLOR_SPACE = null;
    private static final double STANDARD_MEMORY_MULTIPLIER = 0.2d;
    private static final Bitmap.Config[] VALID_TRANSFORMATION_CONFIGS = (Build.VERSION.SDK_INT >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888});

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: coil.util.-Utils$WhenMappings */
    /* compiled from: Utils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DataSource.values().length];
            iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            iArr[DataSource.MEMORY.ordinal()] = 2;
            iArr[DataSource.DISK.ordinal()] = 3;
            iArr[DataSource.NETWORK.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Scale.values().length];
            iArr3[Scale.FILL.ordinal()] = 1;
            iArr3[Scale.FIT.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final boolean isMinOrMax(int i) {
        return i == Integer.MIN_VALUE || i == Integer.MAX_VALUE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: coil.request.ViewTargetRequestManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final coil.request.ViewTargetRequestManager getRequestManager(android.view.View r3) {
        /*
            int r0 = coil.base.R.id.coil_request_manager
            java.lang.Object r0 = r3.getTag(r0)
            boolean r1 = r0 instanceof coil.request.ViewTargetRequestManager
            r2 = 0
            if (r1 == 0) goto L_0x000e
            coil.request.ViewTargetRequestManager r0 = (coil.request.ViewTargetRequestManager) r0
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            if (r0 != 0) goto L_0x0038
            monitor-enter(r3)
            int r0 = coil.base.R.id.coil_request_manager     // Catch:{ all -> 0x0035 }
            java.lang.Object r0 = r3.getTag(r0)     // Catch:{ all -> 0x0035 }
            boolean r1 = r0 instanceof coil.request.ViewTargetRequestManager     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x001f
            r2 = r0
            coil.request.ViewTargetRequestManager r2 = (coil.request.ViewTargetRequestManager) r2     // Catch:{ all -> 0x0035 }
        L_0x001f:
            if (r2 == 0) goto L_0x0023
            r0 = r2
            goto L_0x0033
        L_0x0023:
            coil.request.ViewTargetRequestManager r0 = new coil.request.ViewTargetRequestManager     // Catch:{ all -> 0x0035 }
            r0.<init>(r3)     // Catch:{ all -> 0x0035 }
            r1 = r0
            android.view.View$OnAttachStateChangeListener r1 = (android.view.View.OnAttachStateChangeListener) r1     // Catch:{ all -> 0x0035 }
            r3.addOnAttachStateChangeListener(r1)     // Catch:{ all -> 0x0035 }
            int r1 = coil.base.R.id.coil_request_manager     // Catch:{ all -> 0x0035 }
            r3.setTag(r1, r0)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r3)
            goto L_0x0038
        L_0x0035:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Utils.getRequestManager(android.view.View):coil.request.ViewTargetRequestManager");
    }

    public static final String getEmoji(DataSource dataSource) {
        int i = WhenMappings.$EnumSwitchMapping$0[dataSource.ordinal()];
        if (i == 1 || i == 2) {
            return Emoji.BRAIN;
        }
        if (i == 3) {
            return Emoji.FLOPPY;
        }
        if (i == 4) {
            return Emoji.CLOUD;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int getWidth(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final int getHeight(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final boolean isVector(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    public static final void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final Scale getScale(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[scaleType.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    public static final String getMimeTypeFromUrl(MimeTypeMap mimeTypeMap, String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt.substringAfterLast(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(str, '#', (String) null, 2, (Object) null), '?', (String) null, 2, (Object) null), (char) IOUtils.DIR_SEPARATOR_UNIX, (String) null, 2, (Object) null), '.', ""));
    }

    public static final String getFirstPathSegment(Uri uri) {
        return (String) CollectionsKt.firstOrNull(uri.getPathSegments());
    }

    public static final int getNightMode(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    static {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.HARDWARE;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        DEFAULT_BITMAP_CONFIG = config;
    }

    public static final Bitmap.Config[] getVALID_TRANSFORMATION_CONFIGS() {
        return VALID_TRANSFORMATION_CONFIGS;
    }

    public static final Bitmap.Config getDEFAULT_BITMAP_CONFIG() {
        return DEFAULT_BITMAP_CONFIG;
    }

    public static final ColorSpace getNULL_COLOR_SPACE() {
        return NULL_COLOR_SPACE;
    }

    public static final Headers getEMPTY_HEADERS() {
        return EMPTY_HEADERS;
    }

    public static final Headers orEmpty(Headers headers) {
        return headers == null ? EMPTY_HEADERS : headers;
    }

    public static final Tags orEmpty(Tags tags) {
        return tags == null ? Tags.EMPTY : tags;
    }

    public static final Parameters orEmpty(Parameters parameters) {
        return parameters == null ? Parameters.EMPTY : parameters;
    }

    public static final boolean isMainThread() {
        return Intrinsics.areEqual((Object) Looper.myLooper(), (Object) Looper.getMainLooper());
    }

    public static final int getIdentityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    public static final <T> T getCompletedOrNull(Deferred<? extends T> deferred) {
        try {
            return deferred.getCompleted();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final MemoryCache.Value get(MemoryCache memoryCache, MemoryCache.Key key) {
        if (key != null) {
            return memoryCache.get(key);
        }
        return null;
    }

    public static final File getSafeCacheDir(Context context) {
        File cacheDir = context.getCacheDir();
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, Pair<? extends Fetcher.Factory<?>, ? extends Class<?>> pair) {
        if (pair != null) {
            builder.getFetcherFactories$coil_base_release().add(0, pair);
        }
        return builder;
    }

    public static final ComponentRegistry.Builder addFirst(ComponentRegistry.Builder builder, Decoder.Factory factory) {
        if (factory != null) {
            builder.getDecoderFactories$coil_base_release().add(0, factory);
        }
        return builder;
    }

    public static final int toNonNegativeInt(String str, int i) {
        Long longOrNull = StringsKt.toLongOrNull(str);
        if (longOrNull == null) {
            return i;
        }
        long longValue = longOrNull.longValue();
        if (longValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final void abortQuietly(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    public static final boolean isPlaceholderCached(Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).isPlaceholderCached();
    }

    public static final EventListener getEventListener(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).getEventListener() : EventListener.NONE;
    }

    public static final int widthPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getWidth(), scale);
    }

    public static final int heightPx(Size size, Scale scale, Function0<Integer> function0) {
        return Sizes.isOriginal(size) ? function0.invoke().intValue() : toPx(size.getHeight(), scale);
    }

    public static final Void unsupported() {
        throw new IllegalStateException("Unsupported".toString());
    }

    public static final boolean isAssetUri(Uri uri) {
        return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "file") && Intrinsics.areEqual((Object) getFirstPathSegment(uri), (Object) ASSET_FILE_PATH_ROOT);
    }

    public static final int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int i = WhenMappings.$EnumSwitchMapping$2[scale.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double defaultMemoryCacheSizePercent(Context context) {
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            if (((ActivityManager) systemService).isLowRamDevice()) {
                return LOW_MEMORY_MULTIPLIER;
            }
            return STANDARD_MEMORY_MULTIPLIER;
        } catch (Exception unused) {
            return STANDARD_MEMORY_MULTIPLIER;
        }
    }

    public static final int calculateMemoryCacheSize(Context context, double d) {
        int i;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            i = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            i = 256;
        }
        double d2 = (double) 1024;
        return (int) (d * ((double) i) * d2 * d2);
    }
}
