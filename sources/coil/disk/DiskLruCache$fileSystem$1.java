package coil.disk;

import kotlin.Metadata;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Path;
import okio.Sink;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"coil/disk/DiskLruCache$fileSystem$1", "Lokio/ForwardingFileSystem;", "sink", "Lokio/Sink;", "file", "Lokio/Path;", "mustCreate", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DiskLruCache.kt */
public final class DiskLruCache$fileSystem$1 extends ForwardingFileSystem {
    DiskLruCache$fileSystem$1(FileSystem fileSystem) {
        super(fileSystem);
    }

    public Sink sink(Path path, boolean z) {
        Path parent = path.parent();
        if (parent != null) {
            createDirectories(parent);
        }
        return super.sink(path, z);
    }
}
