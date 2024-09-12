package coil.decode;

import coil.decode.ImageSource;
import coil.util.Utils;
import java.io.Closeable;
import java.io.File;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil/decode/SourceImageSource;", "Lcoil/decode/ImageSource;", "source", "Lokio/BufferedSource;", "cacheDirectory", "Ljava/io/File;", "metadata", "Lcoil/decode/ImageSource$Metadata;", "(Lokio/BufferedSource;Ljava/io/File;Lcoil/decode/ImageSource$Metadata;)V", "file", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "isClosed", "", "getMetadata", "()Lcoil/decode/ImageSource$Metadata;", "assertNotClosed", "", "close", "fileOrNull", "sourceOrNull", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageSource.kt */
public final class SourceImageSource extends ImageSource {
    private final File cacheDirectory;
    private Path file;
    private boolean isClosed;
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    public SourceImageSource(BufferedSource bufferedSource, File file2, ImageSource.Metadata metadata2) {
        super((DefaultConstructorMarker) null);
        this.cacheDirectory = file2;
        this.metadata = metadata2;
        this.source = bufferedSource;
        if (!file2.isDirectory()) {
            throw new IllegalArgumentException("cacheDirectory must be a directory.".toString());
        }
    }

    public FileSystem getFileSystem() {
        return FileSystem.SYSTEM;
    }

    public synchronized BufferedSource source() {
        assertNotClosed();
        BufferedSource bufferedSource = this.source;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        FileSystem fileSystem = getFileSystem();
        Path path = this.file;
        Intrinsics.checkNotNull(path);
        BufferedSource buffer = Okio.buffer(fileSystem.source(path));
        this.source = buffer;
        return buffer;
    }

    public BufferedSource sourceOrNull() {
        return source();
    }

    public synchronized Path file() {
        Long l;
        assertNotClosed();
        Path path = this.file;
        if (path != null) {
            return path;
        }
        Path path2 = Path.Companion.get$default(Path.Companion, File.createTempFile("tmp", (String) null, this.cacheDirectory), false, 1, (Object) null);
        Closeable buffer = Okio.buffer(getFileSystem().sink(path2, false));
        try {
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            l = Long.valueOf(((BufferedSink) buffer).writeAll(bufferedSource));
            th = null;
        } catch (Throwable th) {
            th = th;
            l = null;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    ExceptionsKt.addSuppressed(th, th2);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(l);
            this.source = null;
            this.file = path2;
            return path2;
        }
        throw th;
    }

    public synchronized Path fileOrNull() {
        assertNotClosed();
        return this.file;
    }

    public synchronized void close() {
        this.isClosed = true;
        BufferedSource bufferedSource = this.source;
        if (bufferedSource != null) {
            Utils.closeQuietly(bufferedSource);
        }
        Path path = this.file;
        if (path != null) {
            getFileSystem().delete(path);
        }
    }

    private final void assertNotClosed() {
        if (!(!this.isClosed)) {
            throw new IllegalStateException("closed".toString());
        }
    }
}
