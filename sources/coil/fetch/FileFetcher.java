package coil.fetch;

import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.fetch.Fetcher;
import coil.request.Options;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcoil/fetch/FileFetcher;", "Lcoil/fetch/Fetcher;", "data", "Ljava/io/File;", "(Ljava/io/File;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileFetcher.kt */
public final class FileFetcher implements Fetcher {
    private final File data;

    public FileFetcher(File file) {
        this.data = file;
    }

    public Object fetch(Continuation<? super FetchResult> continuation) {
        return new SourceResult(ImageSources.create$default(Path.Companion.get$default(Path.Companion, this.data, false, 1, (Object) null), (FileSystem) null, (String) null, (Closeable) null, 14, (Object) null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(this.data)), DataSource.DISK);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcoil/fetch/FileFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/io/File;", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FileFetcher.kt */
    public static final class Factory implements Fetcher.Factory<File> {
        public Fetcher create(File file, Options options, ImageLoader imageLoader) {
            return new FileFetcher(file);
        }
    }
}
