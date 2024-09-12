package coil.fetch;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.AssetMetadata;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.Okio;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcoil/fetch/AssetUriFetcher;", "Lcoil/fetch/Fetcher;", "data", "Landroid/net/Uri;", "options", "Lcoil/request/Options;", "(Landroid/net/Uri;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AssetUriFetcher.kt */
public final class AssetUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    public AssetUriFetcher(Uri uri, Options options2) {
        this.data = uri;
        this.options = options2;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.drop(this.data.getPathSegments(), 1), "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        BufferedSource buffer = Okio.buffer(Okio.source(this.options.getContext().getAssets().open(joinToString$default)));
        Context context = this.options.getContext();
        String lastPathSegment = this.data.getLastPathSegment();
        Intrinsics.checkNotNull(lastPathSegment);
        return new SourceResult(ImageSources.create(buffer, context, (ImageSource.Metadata) new AssetMetadata(lastPathSegment)), Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), joinToString$default), DataSource.DISK);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcoil/fetch/AssetUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AssetUriFetcher.kt */
    public static final class Factory implements Fetcher.Factory<Uri> {
        public Fetcher create(Uri uri, Options options, ImageLoader imageLoader) {
            if (!Utils.isAssetUri(uri)) {
                return null;
            }
            return new AssetUriFetcher(uri, options);
        }
    }
}
