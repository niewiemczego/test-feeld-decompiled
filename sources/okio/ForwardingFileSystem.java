package okio;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006)"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadataOrNull", "Lokio/FileMetadata;", "onPathParameter", "functionName", "", "parameterName", "onPathResult", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ForwardingFileSystem.kt */
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public Path onPathParameter(Path path, String str, String str2) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(str, "functionName");
        Intrinsics.checkNotNullParameter(str2, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String str) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(str, "functionName");
        return path;
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public ForwardingFileSystem(FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(fileSystem, "delegate");
        this.delegate = fileSystem;
    }

    public Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)), "canonicalize");
    }

    public FileMetadata metadataOrNull(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH));
        if (metadataOrNull == null) {
            return null;
        }
        if (metadataOrNull.getSymlinkTarget() == null) {
            return metadataOrNull;
        }
        return FileMetadata.copy$default(metadataOrNull, false, false, onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 251, (Object) null);
    }

    public List<Path> list(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        Path onPathParameter = onPathParameter(path, "list", "dir");
        Collection arrayList = new ArrayList();
        for (Path onPathResult : this.delegate.list(onPathParameter)) {
            arrayList.add(onPathResult(onPathResult, "list"));
        }
        List<Path> list = (List) arrayList;
        CollectionsKt.sort(list);
        return list;
    }

    public List<Path> listOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(path, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (Path onPathResult : listOrNull) {
            arrayList.add(onPathResult(onPathResult, "listOrNull"));
        }
        List<Path> list = (List) arrayList;
        CollectionsKt.sort(list);
        return list;
    }

    public Sequence<Path> listRecursively(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "dir");
        return SequencesKt.map(this.delegate.listRecursively(onPathParameter(path, "listRecursively", "dir"), z), new ForwardingFileSystem$listRecursively$1(this));
    }

    public FileHandle openReadOnly(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.openReadOnly(onPathParameter(path, "openReadOnly", "file"));
    }

    public FileHandle openReadWrite(Path path, boolean z, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.openReadWrite(onPathParameter(path, "openReadWrite", "file"), z, z2);
    }

    public Source source(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.source(onPathParameter(path, "source", "file"));
    }

    public Sink sink(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.sink(onPathParameter(path, "sink", "file"), z);
    }

    public Sink appendingSink(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.appendingSink(onPathParameter(path, "appendingSink", "file"), z);
    }

    public void createDirectory(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        this.delegate.createDirectory(onPathParameter(path, "createDirectory", "dir"), z);
    }

    public void atomicMove(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        this.delegate.atomicMove(onPathParameter(path, "atomicMove", "source"), onPathParameter(path2, "atomicMove", TouchesHelper.TARGET_KEY));
    }

    public void delete(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        this.delegate.delete(onPathParameter(path, "delete", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH), z);
    }

    public void createSymlink(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        this.delegate.createSymlink(onPathParameter(path, "createSymlink", "source"), onPathParameter(path2, "createSymlink", TouchesHelper.TARGET_KEY));
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
