package okio;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\f\u0010!\u001a\u00020\n*\u00020\u0006H\u0002J\f\u0010\"\u001a\u00020\n*\u00020\u0006H\u0002¨\u0006#"}, d2 = {"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "", "requireCreate", "requireExist", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JvmSystemFileSystem.kt */
public class JvmSystemFileSystem extends FileSystem {
    public String toString() {
        return "JvmSystemFileSystem";
    }

    public Path canonicalize(Path path) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            Path.Companion companion = Path.Companion;
            Intrinsics.checkNotNullExpressionValue(canonicalFile, "canonicalFile");
            return Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(isFile, isDirectory, (Path) null, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null, (Map) null, 128, (DefaultConstructorMarker) null);
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
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            Collection arrayList = new ArrayList();
            for (String str : list) {
                Intrinsics.checkNotNullExpressionValue(str, "it");
                arrayList.add(path.resolve(str));
            }
            List<Path> list2 = (List) arrayList;
            CollectionsKt.sort(list2);
            return list2;
        } else if (!z) {
            return null;
        } else {
            if (!file.exists()) {
                throw new FileNotFoundException("no such file: " + path);
            }
            throw new IOException("failed to list " + path);
        }
    }

    public FileHandle openReadOnly(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        return new JvmFileHandle(false, new RandomAccessFile(path.toFile(), "r"));
    }

    public FileHandle openReadWrite(Path path, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (!z || !z2) {
            if (z) {
                requireCreate(path);
            }
            if (z2) {
                requireExist(path);
            }
            return new JvmFileHandle(true, new RandomAccessFile(path.toFile(), "rw"));
        }
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
    }

    public Source source(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        return Okio.source(path.toFile());
    }

    public Sink sink(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (z) {
            requireCreate(path);
        }
        return Okio__JvmOkioKt.sink$default(path.toFile(), false, 1, (Object) null);
    }

    public Sink appendingSink(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (z) {
            requireExist(path);
        }
        return Okio.sink(path.toFile(), true);
    }

    public void createDirectory(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "dir");
        if (!path.toFile().mkdir()) {
            FileMetadata metadataOrNull = metadataOrNull(path);
            boolean z2 = true;
            if (metadataOrNull == null || !metadataOrNull.isDirectory()) {
                z2 = false;
            }
            if (!z2) {
                throw new IOException("failed to create directory: " + path);
            } else if (z) {
                throw new IOException(path + " already exist.");
            }
        }
    }

    public void atomicMove(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        if (!path.toFile().renameTo(path2.toFile())) {
            throw new IOException("failed to move " + path + " to " + path2);
        }
    }

    public void delete(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException("failed to delete " + path);
        } else if (z) {
            throw new FileNotFoundException("no such file: " + path);
        }
    }

    public void createSymlink(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        throw new IOException("unsupported");
    }

    private final void requireExist(Path path) {
        if (!exists(path)) {
            throw new IOException(path + " doesn't exist.");
        }
    }

    private final void requireCreate(Path path) {
        if (exists(path)) {
            throw new IOException(path + " already exists.");
        }
    }
}
