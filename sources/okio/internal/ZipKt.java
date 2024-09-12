package okio.internal;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: zip.kt */
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = ZipKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r11.close();
        r5 = r5 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005e, code lost:
        if (r5 <= 0) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
        r5 = okio.Okio.buffer(r4.source(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r6 = (okio.BufferedSource) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0074, code lost:
        if (r6.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0076, code lost:
        r11 = r6.readIntLe();
        r13 = r6.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
        if (r6.readIntLe() != 1) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0085, code lost:
        if (r11 != 0) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0087, code lost:
        r6 = okio.Okio.buffer(r4.source(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r11 = (okio.BufferedSource) r6;
        r13 = r11.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        if (r13 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        r9 = readZip64EocdRecord(r11, r9);
        r11 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d1, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d6, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00da, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e3, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e4, code lost:
        r6 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00eb, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ee, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f2, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f3, code lost:
        r5 = new java.util.ArrayList();
        r4 = okio.Okio.buffer(r4.source(r9.getCentralDirectoryOffset()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r6 = (okio.BufferedSource) r4;
        r13 = r9.getEntryCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0111, code lost:
        if (r7 >= r13) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0113, code lost:
        r11 = readEntry(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0121, code lost:
        if (r11.getOffset() >= r9.getCentralDirectoryOffset()) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012d, code lost:
        if (r2.invoke(r11).booleanValue() == false) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012f, code lost:
        r5.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0135, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0140, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0141, code lost:
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, (java.lang.Throwable) null);
        r4 = new okio.ZipFileSystem(r0, r1, buildIndex(r5), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x014f, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0152, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0153, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0154, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0156, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0157, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x015b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0047, code lost:
        r9 = readEocdRecord(r11);
        r10 = r11.readUtf8((long) r9.getCommentByteCount());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(okio.Path r19, okio.FileSystem r20, kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r21) throws java.io.IOException {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            okio.FileHandle r3 = r1.openReadOnly(r0)
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = r3
            okio.FileHandle r4 = (okio.FileHandle) r4     // Catch:{ all -> 0x0192 }
            long r5 = r4.size()     // Catch:{ all -> 0x0192 }
            r7 = 22
            long r7 = (long) r7     // Catch:{ all -> 0x0192 }
            long r5 = r5 - r7
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x0175
            r9 = 65536(0x10000, double:3.2379E-319)
            long r9 = r5 - r9
            long r9 = java.lang.Math.max(r9, r7)     // Catch:{ all -> 0x0192 }
        L_0x0036:
            okio.Source r11 = r4.source(r5)     // Catch:{ all -> 0x0192 }
            okio.BufferedSource r11 = okio.Okio.buffer((okio.Source) r11)     // Catch:{ all -> 0x0192 }
            int r12 = r11.readIntLe()     // Catch:{ all -> 0x0170 }
            r13 = 101010256(0x6054b50, float:2.506985E-35)
            if (r12 != r13) goto L_0x015c
            okio.internal.EocdRecord r9 = readEocdRecord(r11)     // Catch:{ all -> 0x0170 }
            int r10 = r9.getCommentByteCount()     // Catch:{ all -> 0x0170 }
            long r12 = (long) r10     // Catch:{ all -> 0x0170 }
            java.lang.String r10 = r11.readUtf8(r12)     // Catch:{ all -> 0x0170 }
            r11.close()     // Catch:{ all -> 0x0192 }
            r11 = 20
            long r11 = (long) r11     // Catch:{ all -> 0x0192 }
            long r5 = r5 - r11
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r12 = 0
            if (r11 <= 0) goto L_0x00f3
            okio.Source r5 = r4.source(r5)     // Catch:{ all -> 0x0192 }
            okio.BufferedSource r5 = okio.Okio.buffer((okio.Source) r5)     // Catch:{ all -> 0x0192 }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x0192 }
            r6 = r5
            okio.BufferedSource r6 = (okio.BufferedSource) r6     // Catch:{ all -> 0x00ea }
            int r11 = r6.readIntLe()     // Catch:{ all -> 0x00ea }
            r13 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r11 != r13) goto L_0x00e4
            int r11 = r6.readIntLe()     // Catch:{ all -> 0x00ea }
            long r13 = r6.readLongLe()     // Catch:{ all -> 0x00ea }
            int r6 = r6.readIntLe()     // Catch:{ all -> 0x00ea }
            r15 = 1
            if (r6 != r15) goto L_0x00db
            if (r11 != 0) goto L_0x00db
            okio.Source r6 = r4.source(r13)     // Catch:{ all -> 0x00ea }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r6)     // Catch:{ all -> 0x00ea }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x00ea }
            r11 = r6
            okio.BufferedSource r11 = (okio.BufferedSource) r11     // Catch:{ all -> 0x00d2 }
            int r13 = r11.readIntLe()     // Catch:{ all -> 0x00d2 }
            r14 = 101075792(0x6064b50, float:2.525793E-35)
            if (r13 != r14) goto L_0x00a7
            okio.internal.EocdRecord r9 = readZip64EocdRecord(r11, r9)     // Catch:{ all -> 0x00d2 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d2 }
            kotlin.io.CloseableKt.closeFinally(r6, r12)     // Catch:{ all -> 0x00ea }
            goto L_0x00e4
        L_0x00a7:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r1.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = "bad zip: expected "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = getHex(r14)     // Catch:{ all -> 0x00d2 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = " but was "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = getHex(r13)     // Catch:{ all -> 0x00d2 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00d2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d2 }
            r0.<init>(r1)     // Catch:{ all -> 0x00d2 }
            throw r0     // Catch:{ all -> 0x00d2 }
        L_0x00d2:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r6, r1)     // Catch:{ all -> 0x00ea }
            throw r2     // Catch:{ all -> 0x00ea }
        L_0x00db:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x00ea }
            throw r0     // Catch:{ all -> 0x00ea }
        L_0x00e4:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ea }
            kotlin.io.CloseableKt.closeFinally(r5, r12)     // Catch:{ all -> 0x0192 }
            goto L_0x00f3
        L_0x00ea:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00ed }
        L_0x00ed:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch:{ all -> 0x0192 }
            throw r2     // Catch:{ all -> 0x0192 }
        L_0x00f3:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0192 }
            r5.<init>()     // Catch:{ all -> 0x0192 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0192 }
            long r13 = r9.getCentralDirectoryOffset()     // Catch:{ all -> 0x0192 }
            okio.Source r4 = r4.source(r13)     // Catch:{ all -> 0x0192 }
            okio.BufferedSource r4 = okio.Okio.buffer((okio.Source) r4)     // Catch:{ all -> 0x0192 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x0192 }
            r6 = r4
            okio.BufferedSource r6 = (okio.BufferedSource) r6     // Catch:{ all -> 0x0153 }
            long r13 = r9.getEntryCount()     // Catch:{ all -> 0x0153 }
        L_0x010f:
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x0141
            okio.internal.ZipEntry r11 = readEntry(r6)     // Catch:{ all -> 0x0153 }
            long r15 = r11.getOffset()     // Catch:{ all -> 0x0153 }
            long r17 = r9.getCentralDirectoryOffset()     // Catch:{ all -> 0x0153 }
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0139
            java.lang.Object r15 = r2.invoke(r11)     // Catch:{ all -> 0x0153 }
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x0153 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x0153 }
            if (r15 == 0) goto L_0x0135
            r15 = r5
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x0153 }
            r15.add(r11)     // Catch:{ all -> 0x0153 }
        L_0x0135:
            r15 = 1
            long r7 = r7 + r15
            goto L_0x010f
        L_0x0139:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0153 }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x0153 }
            throw r0     // Catch:{ all -> 0x0153 }
        L_0x0141:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0153 }
            kotlin.io.CloseableKt.closeFinally(r4, r12)     // Catch:{ all -> 0x0192 }
            java.util.Map r2 = buildIndex(r5)     // Catch:{ all -> 0x0192 }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x0192 }
            r4.<init>(r0, r1, r2, r10)     // Catch:{ all -> 0x0192 }
            kotlin.io.CloseableKt.closeFinally(r3, r12)
            return r4
        L_0x0153:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0156 }
        L_0x0156:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ all -> 0x0192 }
            throw r2     // Catch:{ all -> 0x0192 }
        L_0x015c:
            r11.close()     // Catch:{ all -> 0x0192 }
            r11 = -1
            long r5 = r5 + r11
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0168
            goto L_0x0036
        L_0x0168:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0192 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x0192 }
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0170:
            r0 = move-exception
            r11.close()     // Catch:{ all -> 0x0192 }
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0175:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0192 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0192 }
            r1.<init>()     // Catch:{ all -> 0x0192 }
            java.lang.String r2 = "not a zip: size="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0192 }
            long r4 = r4.size()     // Catch:{ all -> 0x0192 }
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ all -> 0x0192 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0192 }
            r0.<init>(r1)     // Catch:{ all -> 0x0192 }
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0192:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0195 }
        L_0x0195:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(path, new ZipEntry(path, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null)));
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new ZipKt$buildIndex$$inlined$sortedBy$1())) {
            if (mutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = mutableMapOf.get(parent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = r4;
                    ZipEntry zipEntry4 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null);
                    ZipEntry zipEntry5 = zipEntry3;
                    mutableMapOf.put(parent, zipEntry5);
                    zipEntry5.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry5;
                }
            }
        }
        return mutableMapOf;
    }

    public static final ZipEntry readEntry(BufferedSource bufferedSource) throws IOException {
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.checkNotNullParameter(bufferedSource2, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & UShort.MAX_VALUE, bufferedSource.readShortLe() & UShort.MAX_VALUE);
                long readIntLe2 = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe4 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                short readShortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(8);
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                String readUtf8 = bufferedSource2.readUtf8((long) readShortLe3);
                if (!StringsKt.contains$default((CharSequence) readUtf8, 0, false, 2, (Object) null)) {
                    String str = readUtf8;
                    long j = longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? ((long) 8) + 0 : 0;
                    long j2 = longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? j + ((long) 8) : j;
                    if (longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j2 += (long) 8;
                    }
                    long j3 = j2;
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    Long l = dosDateTimeToEpochMillis;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    short s = readShortLe2;
                    String str2 = str;
                    Ref.LongRef longRef4 = longRef3;
                    short s2 = readShortLe5;
                    readExtra(bufferedSource2, readShortLe4, new ZipKt$readEntry$1(booleanRef, j3, longRef2, bufferedSource, longRef, longRef4));
                    if (j3 <= 0 || booleanRef2.element) {
                        String str3 = str2;
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null).resolve(str3), StringsKt.endsWith$default(str3, "/", false, 2, (Object) null), bufferedSource2.readUtf8((long) s2), readIntLe2, longRef.element, longRef2.element, s, l, longRef4.element);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        short readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & UShort.MAX_VALUE);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & UShort.MAX_VALUE)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & UShort.MAX_VALUE);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = (long) i;
        while (j != 0) {
            if (j >= 4) {
                short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j2 = j - ((long) 4);
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i2 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, (FileMetadata) null);
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(fileMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final FileMetadata readOrSkipLocalHeader(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        BufferedSource bufferedSource2 = bufferedSource;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(2);
            short readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            if ((readShortLe & 1) == 0) {
                bufferedSource2.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
                bufferedSource2.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) readShortLe3);
                    return null;
                }
                readExtra(bufferedSource2, readShortLe3, new ZipKt$readOrSkipLocalHeader$1(bufferedSource2, objectRef, objectRef2, objectRef3));
                return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), (Path) null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, (Map) null, 128, (DefaultConstructorMarker) null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(readShortLe));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i) {
        StringBuilder append = new StringBuilder().append("0x");
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return append.append(num).toString();
    }
}
