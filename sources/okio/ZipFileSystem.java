package okio;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "entries", "", "Lokio/internal/ZipEntry;", "comment", "", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "appendingSink", "Lokio/Sink;", "file", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "Companion", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZipFileSystem.kt */
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    public ZipFileSystem(Path path, FileSystem fileSystem2, Map<Path, ZipEntry> map, String str) {
        Intrinsics.checkNotNullParameter(path, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(map, "entries");
        this.zipPath = path;
        this.fileSystem = fileSystem2;
        this.entries = map;
        this.comment = str;
    }

    public Path canonicalize(Path path) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Path canonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(canonicalizeInternal)) {
            return canonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    public FileMetadata metadataOrNull(Path path) {
        BufferedSource bufferedSource;
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        Throwable th = null;
        if (zipEntry == null) {
            return null;
        }
        FileMetadata fileMetadata = new FileMetadata(!zipEntry.isDirectory(), zipEntry.isDirectory(), (Path) null, zipEntry.isDirectory() ? null : Long.valueOf(zipEntry.getSize()), (Long) null, zipEntry.getLastModifiedAtMillis(), (Long) null, (Map) null, 128, (DefaultConstructorMarker) null);
        if (zipEntry.getOffset() == -1) {
            return fileMetadata;
        }
        Closeable openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            bufferedSource = Okio.buffer(((FileHandle) openReadOnly).source(zipEntry.getOffset()));
        } catch (Throwable th2) {
            th = th2;
            bufferedSource = null;
        }
        if (openReadOnly != null) {
            try {
                openReadOnly.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(bufferedSource);
            return ZipKt.readLocalHeader(bufferedSource, fileMetadata);
        }
        throw th;
    }

    public FileHandle openReadOnly(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public FileHandle openReadWrite(Path path, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip entries are not writable");
    }

    public List<Path> list(Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        List<Path> list = list(path, true);
        Intrinsics.checkNotNull(list);
        return list;
    }

    public List<Path> listOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return list(path, false);
    }

    private final List<Path> list(Path path, boolean z) {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            return CollectionsKt.toList(zipEntry.getChildren());
        }
        if (!z) {
            return null;
        }
        throw new IOException("not a directory: " + path);
    }

    public Source source(Path path) throws IOException {
        BufferedSource bufferedSource;
        Intrinsics.checkNotNullParameter(path, "file");
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            Closeable openReadOnly = this.fileSystem.openReadOnly(this.zipPath);
            Throwable th = null;
            try {
                bufferedSource = Okio.buffer(((FileHandle) openReadOnly).source(zipEntry.getOffset()));
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedSource = null;
                th = th3;
            }
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        ExceptionsKt.addSuppressed(th, th4);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(bufferedSource);
                ZipKt.skipLocalHeader(bufferedSource);
                if (zipEntry.getCompressionMethod() == 0) {
                    return new FixedLengthSource(bufferedSource, zipEntry.getSize(), true);
                }
                return new FixedLengthSource(new InflaterSource((Source) new FixedLengthSource(bufferedSource, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
            }
            throw th;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public Sink sink(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    public Sink appendingSink(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("zip file systems are read-only");
    }

    public void createDirectory(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "dir");
        throw new IOException("zip file systems are read-only");
    }

    public void atomicMove(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        throw new IOException("zip file systems are read-only");
    }

    public void delete(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        throw new IOException("zip file systems are read-only");
    }

    public void createSymlink(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        throw new IOException("zip file systems are read-only");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokio/ZipFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZipFileSystem.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }
}
