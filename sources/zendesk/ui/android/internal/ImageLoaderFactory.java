package zendesk.ui.android.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.decode.GifDecoder;
import coil.decode.ImageDecoderDecoder;
import coil.decode.SvgDecoder;
import coil.disk.DiskCache;
import coil.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import zendesk.ui.android.internal.ZendeskContentUriFetcher;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lzendesk/ui/android/internal/ImageLoaderFactory;", "", "()V", "CACHE_MAX_SIZE_20MB", "", "CACHE_NAME", "", "imageLoader", "Lcoil/ImageLoader;", "getImageLoader", "context", "Landroid/content/Context;", "setImageLoader", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageLoaderFactory.kt */
public final class ImageLoaderFactory {
    private static final long CACHE_MAX_SIZE_20MB = 20000000;
    private static final String CACHE_NAME = "zendesk_conversationkit_image_cache";
    public static final ImageLoaderFactory INSTANCE = new ImageLoaderFactory();
    private static ImageLoader imageLoader;

    private ImageLoaderFactory() {
    }

    public final void setImageLoader(ImageLoader imageLoader2) {
        Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
        imageLoader = imageLoader2;
    }

    public final ImageLoader getImageLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageLoader imageLoader2 = imageLoader;
        if (imageLoader2 != null) {
            return imageLoader2;
        }
        ImageLoader.Builder memoryCache = new ImageLoader.Builder(context).okHttpClient((Function0<? extends OkHttpClient>) ImageLoaderFactory$getImageLoader$1.INSTANCE).diskCache((Function0<? extends DiskCache>) new ImageLoaderFactory$getImageLoader$2(context)).memoryCache((Function0<? extends MemoryCache>) new ImageLoaderFactory$getImageLoader$3(context));
        ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
        if (Build.VERSION.SDK_INT >= 28) {
            builder.add((Decoder.Factory) new ImageDecoderDecoder.Factory(false, 1, (DefaultConstructorMarker) null));
        }
        builder.add((Decoder.Factory) new GifDecoder.Factory(false, 1, (DefaultConstructorMarker) null));
        builder.add((Decoder.Factory) new SvgDecoder.Factory(false, 1, (DefaultConstructorMarker) null));
        builder.add(new ZendeskContentUriFetcher.Factory(context), Uri.class);
        ImageLoader build = memoryCache.components(builder.build()).logger(new ImageLoaderFactory$getImageLoader$5()).build();
        imageLoader = build;
        return build;
    }
}
