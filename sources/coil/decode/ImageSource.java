package coil.decode;

import java.io.Closeable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000f\u001a\u00020\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcoil/decode/ImageSource;", "Ljava/io/Closeable;", "()V", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "metadata", "Lcoil/decode/ImageSource$Metadata;", "getMetadata$annotations", "getMetadata", "()Lcoil/decode/ImageSource$Metadata;", "file", "Lokio/Path;", "fileOrNull", "source", "Lokio/BufferedSource;", "sourceOrNull", "Metadata", "Lcoil/decode/FileImageSource;", "Lcoil/decode/SourceImageSource;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageSource.kt */
public abstract class ImageSource implements Closeable {

    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcoil/decode/ImageSource$Metadata;", "", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImageSource.kt */
    public static abstract class Metadata {
    }

    public /* synthetic */ ImageSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public abstract Path file();

    public abstract Path fileOrNull();

    public abstract FileSystem getFileSystem();

    public abstract Metadata getMetadata();

    public abstract BufferedSource source();

    public abstract BufferedSource sourceOrNull();

    private ImageSource() {
    }
}
