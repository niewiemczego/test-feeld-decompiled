package okio.internal;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\f\u0010(\u001a\u00020)*\u00020\nH\u0002R-\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006+"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", "", "(Ljava/lang/ClassLoader;Z)V", "roots", "", "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "appendingSink", "Lokio/Sink;", "file", "mustExist", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toRelativePath", "", "Companion", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResourceFileSystem.kt */
public final class ResourceFileSystem extends FileSystem {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final Lazy roots$delegate;

    public ResourceFileSystem(ClassLoader classLoader, boolean z) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.roots$delegate = LazyKt.lazy(new ResourceFileSystem$roots$2(classLoader));
        if (z) {
            getRoots().size();
        }
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    public Path canonicalize(Path path) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        return canonicalizeInternal(path);
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    public List<Path> list(Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        String relativePath = toRelativePath(path);
        Set linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair next : getRoots()) {
            FileSystem fileSystem = (FileSystem) next.component1();
            Path path2 = (Path) next.component2();
            try {
                Collection collection = linkedHashSet;
                Collection arrayList = new ArrayList();
                for (Object next2 : fileSystem.list(path2.resolve(relativePath))) {
                    if (Companion.keepPath((Path) next2)) {
                        arrayList.add(next2);
                    }
                }
                Iterable<Path> iterable = (List) arrayList;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Path removeBase : iterable) {
                    arrayList2.add(Companion.removeBase(removeBase, path2));
                }
                CollectionsKt.addAll(collection, (List) arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt.toList(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.util.Set} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<okio.Path> listOrNull(okio.Path r10) {
        /*
            r9 = this;
            java.lang.String r0 = "dir"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r10 = r9.toRelativePath(r10)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Set r0 = (java.util.Set) r0
            java.util.List r1 = r9.getRoots()
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x0019:
            boolean r3 = r1.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x009d
            java.lang.Object r3 = r1.next()
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r5 = r3.component1()
            okio.FileSystem r5 = (okio.FileSystem) r5
            java.lang.Object r3 = r3.component2()
            okio.Path r3 = (okio.Path) r3
            okio.Path r6 = r3.resolve((java.lang.String) r10)
            java.util.List r5 = r5.listOrNull(r6)
            if (r5 == 0) goto L_0x0090
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r5 = r5.iterator()
        L_0x0049:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0062
            java.lang.Object r6 = r5.next()
            r7 = r6
            okio.Path r7 = (okio.Path) r7
            okio.internal.ResourceFileSystem$Companion r8 = Companion
            boolean r7 = r8.keepPath(r7)
            if (r7 == 0) goto L_0x0049
            r4.add(r6)
            goto L_0x0049
        L_0x0062:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0077:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x008d
            java.lang.Object r6 = r4.next()
            okio.Path r6 = (okio.Path) r6
            okio.internal.ResourceFileSystem$Companion r7 = Companion
            okio.Path r6 = r7.removeBase(r6, r3)
            r5.add(r6)
            goto L_0x0077
        L_0x008d:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
        L_0x0090:
            if (r4 == 0) goto L_0x0019
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.collections.CollectionsKt.addAll(r2, r4)
            r2 = 1
            goto L_0x0019
        L_0x009d:
            if (r2 == 0) goto L_0x00a5
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r4 = kotlin.collections.CollectionsKt.toList(r0)
        L_0x00a5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ResourceFileSystem.listOrNull(okio.Path):java.util.List");
    }

    public FileHandle openReadOnly(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (Companion.keepPath(path)) {
            String relativePath = toRelativePath(path);
            for (Pair next : getRoots()) {
                try {
                    return ((FileSystem) next.component1()).openReadOnly(((Path) next.component2()).resolve(relativePath));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + path);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    public FileHandle openReadWrite(Path path, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException("resources are not writable");
    }

    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair next : getRoots()) {
            FileMetadata metadataOrNull = ((FileSystem) next.component1()).metadataOrNull(((Path) next.component2()).resolve(relativePath));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    public Source source(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        if (Companion.keepPath(path)) {
            String relativePath = toRelativePath(path);
            for (Pair next : getRoots()) {
                try {
                    return ((FileSystem) next.component1()).source(((Path) next.component2()).resolve(relativePath));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + path);
        }
        throw new FileNotFoundException("file not found: " + path);
    }

    public Sink sink(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException(this + " is read-only");
    }

    public Sink appendingSink(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new IOException(this + " is read-only");
    }

    public void createDirectory(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, "dir");
        throw new IOException(this + " is read-only");
    }

    public void atomicMove(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        throw new IOException(this + " is read-only");
    }

    public void delete(Path path, boolean z) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        throw new IOException(this + " is read-only");
    }

    public void createSymlink(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TouchesHelper.TARGET_KEY);
        throw new IOException(this + " is read-only");
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e0\r*\u00020\u0010J\u0018\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012J\u0018\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "keepPath", "", "path", "removeBase", "base", "toClasspathRoots", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "okio"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ResourceFileSystem.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path path, Path path2) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            Intrinsics.checkNotNullParameter(path2, "base");
            return getROOT().resolve(StringsKt.replace$default(StringsKt.removePrefix(path.toString(), (CharSequence) path2.toString()), (char) IOUtils.DIR_SEPARATOR_WINDOWS, (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null));
        }

        public final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader classLoader) {
            Intrinsics.checkNotNullParameter(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(\"\")");
            ArrayList<T> list = Collections.list(resources);
            Intrinsics.checkNotNullExpressionValue(list, "list(this)");
            Collection arrayList = new ArrayList();
            for (T t : list) {
                Companion access$getCompanion$p = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(t, "it");
                Pair<FileSystem, Path> fileRoot = access$getCompanion$p.toFileRoot(t);
                if (fileRoot != null) {
                    arrayList.add(fileRoot);
                }
            }
            Collection collection = (List) arrayList;
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<T> list2 = Collections.list(resources2);
            Intrinsics.checkNotNullExpressionValue(list2, "list(this)");
            Collection arrayList2 = new ArrayList();
            for (T t2 : list2) {
                Companion access$getCompanion$p2 = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(t2, "it");
                Pair<FileSystem, Path> jarRoot = access$getCompanion$p2.toJarRoot(t2);
                if (jarRoot != null) {
                    arrayList2.add(jarRoot);
                }
            }
            return CollectionsKt.plus(collection, (List) arrayList2);
        }

        public final Pair<FileSystem, Path> toFileRoot(URL url) {
            Intrinsics.checkNotNullParameter(url, "<this>");
            if (!Intrinsics.areEqual((Object) url.getProtocol(), (Object) "file")) {
                return null;
            }
            return TuplesKt.to(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
        }

        public final Pair<FileSystem, Path> toJarRoot(URL url) {
            int lastIndexOf$default;
            Intrinsics.checkNotNullParameter(url, "<this>");
            String url2 = url.toString();
            Intrinsics.checkNotNullExpressionValue(url2, "toString()");
            if (!StringsKt.startsWith$default(url2, "jar:file:", false, 2, (Object) null) || (lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) url2, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Path.Companion companion = Path.Companion;
            String substring = url2.substring(4, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return TuplesKt.to(ZipKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.SYSTEM, ResourceFileSystem$Companion$toJarRoot$zip$1.INSTANCE), getROOT());
        }

        /* access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !StringsKt.endsWith(path.name(), ".class", true);
        }
    }
}
