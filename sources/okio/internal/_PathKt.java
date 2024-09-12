package okio.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\b\u001a\u0014\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\b¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, d2 = {"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: -Path.kt */
public final class _PathKt {
    private static final ByteString ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
    /* access modifiers changed from: private */
    public static final ByteString BACKSLASH = ByteString.Companion.encodeUtf8("\\");
    /* access modifiers changed from: private */
    public static final ByteString DOT = ByteString.Companion.encodeUtf8(".");
    /* access modifiers changed from: private */
    public static final ByteString DOT_DOT = ByteString.Companion.encodeUtf8("..");
    /* access modifiers changed from: private */
    public static final ByteString SLASH = ByteString.Companion.encodeUtf8("/");

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    public static final Path commonRoot(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(path.getBytes$okio().substring(0, access$rootLength));
    }

    public static final List<ByteString> commonSegmentsBytes(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        List<ByteString> arrayList = new ArrayList<>();
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (path.getBytes$okio().getByte(access$rootLength) == ((byte) 47) || path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(path.getBytes$okio().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i, path.getBytes$okio().size()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final int rootLength(Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        boolean z = false;
        if (path.getBytes$okio().getByte(0) == ((byte) 47)) {
            return 1;
        }
        byte b = (byte) 92;
        if (path.getBytes$okio().getByte(0) == b) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != b) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            return indexOf == -1 ? path.getBytes$okio().size() : indexOf;
        } else if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != ((byte) 58) || path.getBytes$okio().getByte(2) != b) {
            return -1;
        } else {
            char c = (char) path.getBytes$okio().getByte(0);
            if ('a' <= c && c < '{') {
                return 3;
            }
            if ('A' <= c && c < '[') {
                z = true;
            }
            if (!z) {
                return -1;
            }
            return 3;
        }
    }

    public static final boolean commonIsAbsolute(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return rootLength(path) != -1;
    }

    public static final boolean commonIsRelative(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return rootLength(path) == -1;
    }

    public static final Character commonVolumeLetter(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean z = false;
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || path.getBytes$okio().size() < 2 || path.getBytes$okio().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c = (char) path.getBytes$okio().getByte(0);
        if (!('a' <= c && c < '{')) {
            if ('A' <= c && c < '[') {
                z = true;
            }
            if (!z) {
                return null;
            }
        }
        return Character.valueOf(c);
    }

    /* access modifiers changed from: private */
    public static final int getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        if (lastIndexOf$default != -1) {
            return lastIndexOf$default;
        }
        return ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    public static final ByteString commonNameBytes(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int access$getIndexOfLastSlash = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(path.getBytes$okio(), access$getIndexOfLastSlash + 1, 0, 2, (Object) null);
        }
        if (path.volumeLetter() == null || path.getBytes$okio().size() != 2) {
            return path.getBytes$okio();
        }
        return ByteString.EMPTY;
    }

    public static final String commonName(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.nameBytes().utf8();
    }

    public static final Path commonParent(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (Intrinsics.areEqual((Object) path.getBytes$okio(), (Object) DOT) || Intrinsics.areEqual((Object) path.getBytes$okio(), (Object) SLASH) || Intrinsics.areEqual((Object) path.getBytes$okio(), (Object) BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int access$getIndexOfLastSlash = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash != 2 || path.volumeLetter() == null) {
            if (access$getIndexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
                return null;
            }
            if (access$getIndexOfLastSlash != -1 || path.volumeLetter() == null) {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(DOT);
                }
                if (access$getIndexOfLastSlash == 0) {
                    return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, (Object) null));
                }
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, access$getIndexOfLastSlash, 1, (Object) null));
            } else if (path.getBytes$okio().size() == 2) {
                return null;
            } else {
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, (Object) null));
            }
        } else if (path.getBytes$okio().size() == 3) {
            return null;
        } else {
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean lastSegmentIsDotDot(Path path) {
        if (!path.getBytes$okio().endsWith(DOT_DOT) || (path.getBytes$okio().size() != 2 && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1) && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1))) {
            return false;
        }
        return true;
    }

    public static final boolean commonIsRoot(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return rootLength(path) == path.getBytes$okio().size();
    }

    public static final Path commonResolve(Path path, String str, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(str, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(str), false), z);
    }

    public static final Path commonResolve(Path path, ByteString byteString, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "child");
        return commonResolve(path, toPath(new Buffer().write(byteString), false), z);
    }

    public static final Path commonResolve(Path path, Buffer buffer, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "child");
        return commonResolve(path, toPath(buffer, false), z);
    }

    public static final Path commonResolve(Path path, Path path2, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "child");
        if (path2.isAbsolute() || path2.volumeLetter() != null) {
            return path2;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(path2)) == null) {
            slash = toSlash(Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(path2.getBytes$okio());
        return toPath(buffer, z);
    }

    public static final Path commonRelativeTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        if (Intrinsics.areEqual((Object) path.getRoot(), (Object) path2.getRoot())) {
            List<ByteString> segmentsBytes = path.getSegmentsBytes();
            List<ByteString> segmentsBytes2 = path2.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i = 0;
            while (i < min && Intrinsics.areEqual((Object) segmentsBytes.get(i), (Object) segmentsBytes2.get(i))) {
                i++;
            }
            boolean z = true;
            if (i == min && path.getBytes$okio().size() == path2.getBytes$okio().size()) {
                return Path.Companion.get$default(Path.Companion, ".", false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(DOT_DOT) != -1) {
                z = false;
            }
            if (z) {
                Buffer buffer = new Buffer();
                ByteString access$getSlash = getSlash(path2);
                if (access$getSlash == null && (access$getSlash = getSlash(path)) == null) {
                    access$getSlash = toSlash(Path.DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i2 = i; i2 < size; i2++) {
                    buffer.write(DOT_DOT);
                    buffer.write(access$getSlash);
                }
                int size2 = segmentsBytes.size();
                while (i < size2) {
                    buffer.write(segmentsBytes.get(i));
                    buffer.write(access$getSlash);
                    i++;
                }
                return toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + path2).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + path2).toString());
    }

    public static final Path commonNormalized(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Path.Companion.get(path.toString(), true);
    }

    /* access modifiers changed from: private */
    public static final ByteString getSlash(Path path) {
        ByteString bytes$okio = path.getBytes$okio();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes$okio, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString bytes$okio2 = path.getBytes$okio();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes$okio2, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    public static final int commonCompareTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(path2, "other");
        return path.getBytes$okio().compareTo(path2.getBytes$okio());
    }

    public static final boolean commonEquals(Path path, Object obj) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return (obj instanceof Path) && Intrinsics.areEqual((Object) ((Path) obj).getBytes$okio(), (Object) path.getBytes$okio());
    }

    public static final int commonHashCode(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final String commonToString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes$okio().utf8();
    }

    public static final Path commonToPath(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z);
    }

    public static final Path toPath(Buffer buffer, boolean z) {
        ByteString byteString;
        ByteString byteString2;
        Buffer buffer2 = buffer;
        Intrinsics.checkNotNullParameter(buffer2, "<this>");
        Buffer buffer3 = new Buffer();
        ByteString byteString3 = null;
        int i = 0;
        while (true) {
            if (!buffer2.rangeEquals(0, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer2.rangeEquals(0, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString3 == null) {
                byteString3 = toSlash(readByte);
            }
            i++;
        }
        boolean z2 = i >= 2 && Intrinsics.areEqual((Object) byteString3, (Object) byteString);
        if (z2) {
            Intrinsics.checkNotNull(byteString3);
            buffer3.write(byteString3);
            buffer3.write(byteString3);
        } else if (i > 0) {
            Intrinsics.checkNotNull(byteString3);
            buffer3.write(byteString3);
        } else {
            long indexOfElement = buffer2.indexOfElement(ANY_SLASH);
            if (byteString3 == null) {
                if (indexOfElement == -1) {
                    byteString3 = toSlash(Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString3 = toSlash(buffer2.getByte(indexOfElement));
                }
            }
            if (startsWithVolumeLetterAndColon(buffer2, byteString3)) {
                if (indexOfElement == 2) {
                    buffer3.write(buffer2, 3);
                } else {
                    buffer3.write(buffer2, 2);
                }
            }
        }
        boolean z3 = buffer3.size() > 0;
        List arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer2.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                byteString2 = buffer.readByteString();
            } else {
                byteString2 = buffer2.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString4 = DOT_DOT;
            if (Intrinsics.areEqual((Object) byteString2, (Object) byteString4)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (!z || (!z3 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt.last(arrayList), (Object) byteString4)))) {
                        arrayList.add(byteString2);
                    } else if (!z2 || arrayList.size() != 1) {
                        CollectionsKt.removeLastOrNull(arrayList);
                    }
                }
            } else if (!Intrinsics.areEqual((Object) byteString2, (Object) DOT) && !Intrinsics.areEqual((Object) byteString2, (Object) ByteString.EMPTY)) {
                arrayList.add(byteString2);
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                buffer3.write(byteString3);
            }
            buffer3.write((ByteString) arrayList.get(i2));
        }
        if (buffer3.size() == 0) {
            buffer3.write(DOT);
        }
        return new Path(buffer3.readByteString());
    }

    /* access modifiers changed from: private */
    public static final ByteString toSlash(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    private static final ByteString toSlash(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + b);
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if (!Intrinsics.areEqual((Object) byteString, (Object) BACKSLASH) || buffer.size() < 2 || buffer.getByte(1) != ((byte) 58)) {
            return false;
        }
        char c = (char) buffer.getByte(0);
        if (!('a' <= c && c < '{')) {
            if (!('A' <= c && c < '[')) {
                return false;
            }
        }
        return true;
    }

    public static final List<String> commonSegments(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        List arrayList = new ArrayList();
        int access$rootLength = rootLength(path);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = path.getBytes$okio().size();
        int i = access$rootLength;
        while (access$rootLength < size) {
            if (path.getBytes$okio().getByte(access$rootLength) == ((byte) 47) || path.getBytes$okio().getByte(access$rootLength) == ((byte) 92)) {
                arrayList.add(path.getBytes$okio().substring(i, access$rootLength));
                i = access$rootLength + 1;
            }
            access$rootLength++;
        }
        if (i < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(i, path.getBytes$okio().size()));
        }
        Iterable<ByteString> iterable = arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ByteString utf8 : iterable) {
            arrayList2.add(utf8.utf8());
        }
        return (List) arrayList2;
    }
}
