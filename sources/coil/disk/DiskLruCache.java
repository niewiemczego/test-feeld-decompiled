package coil.disk;

import coil.util.FileSystems;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u0014\b\u0000\u0018\u0000 C2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004CDEFB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0016J\u001c\u0010)\u001a\u00020'2\n\u0010*\u001a\u00060+R\u00020\u00002\u0006\u0010,\u001a\u00020\u0013H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u0014\u0010.\u001a\b\u0018\u00010+R\u00020\u00002\u0006\u0010/\u001a\u00020\u001fJ\u0006\u00100\u001a\u00020'J\b\u00101\u001a\u00020'H\u0016J\u0017\u00102\u001a\b\u0018\u000103R\u00020\u00002\u0006\u0010/\u001a\u00020\u001fH\u0002J\u0006\u00104\u001a\u00020'J\b\u00105\u001a\u00020\u0013H\u0002J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u00020\u001cH\u0002J\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020'H\u0002J\u0010\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020\u001fH\u0002J\u000e\u0010<\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u001fJ\u0014\u0010=\u001a\u00020\u00132\n\u0010>\u001a\u00060 R\u00020\u0000H\u0002J\b\u0010?\u001a\u00020\u0013H\u0002J\u0006\u0010%\u001a\u00020\u000bJ\b\u0010@\u001a\u00020'H\u0002J\u0010\u0010A\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020'H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u001f\u0012\b\u0012\u00060 R\u00020\u00000\u001ej\u0012\u0012\u0004\u0012\u00020\u001f\u0012\b\u0012\u00060 R\u00020\u0000`!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcoil/disk/DiskLruCache;", "Ljava/io/Closeable;", "Lokio/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokio/FileSystem;", "directory", "Lokio/Path;", "cleanupDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "maxSize", "", "appVersion", "", "valueCount", "(Lokio/FileSystem;Lokio/Path;Lkotlinx/coroutines/CoroutineDispatcher;JII)V", "cleanupScope", "Lkotlinx/coroutines/CoroutineScope;", "closed", "", "coil/disk/DiskLruCache$fileSystem$1", "Lcoil/disk/DiskLruCache$fileSystem$1;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lcoil/disk/DiskLruCache$Entry;", "Lkotlin/collections/LinkedHashMap;", "mostRecentRebuildFailed", "mostRecentTrimFailed", "operationsSinceRewrite", "size", "checkNotClosed", "", "close", "completeEdit", "editor", "Lcoil/disk/DiskLruCache$Editor;", "success", "delete", "edit", "key", "evictAll", "flush", "get", "Lcoil/disk/DiskLruCache$Snapshot;", "initialize", "journalRewriteRequired", "launchCleanup", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "remove", "removeEntry", "entry", "removeOldestEntry", "trimToSize", "validateKey", "writeJournal", "Companion", "Editor", "Entry", "Snapshot", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DiskLruCache.kt */
public final class DiskLruCache implements Closeable, Flushable {
    private static final String CLEAN = "CLEAN";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TMP = "journal.tmp";
    private static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    public static final String VERSION = "1";
    private final int appVersion;
    private final CoroutineScope cleanupScope;
    /* access modifiers changed from: private */
    public boolean closed;
    /* access modifiers changed from: private */
    public final Path directory;
    /* access modifiers changed from: private */
    public final DiskLruCache$fileSystem$1 fileSystem;
    /* access modifiers changed from: private */
    public boolean hasJournalErrors;
    /* access modifiers changed from: private */
    public boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    /* access modifiers changed from: private */
    public BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private final long maxSize;
    /* access modifiers changed from: private */
    public boolean mostRecentRebuildFailed;
    /* access modifiers changed from: private */
    public boolean mostRecentTrimFailed;
    private int operationsSinceRewrite;
    private long size;
    /* access modifiers changed from: private */
    public final int valueCount;

    public DiskLruCache(FileSystem fileSystem2, Path path, CoroutineDispatcher coroutineDispatcher, long j, int i, int i2) {
        this.directory = path;
        this.maxSize = j;
        this.appVersion = i;
        this.valueCount = i2;
        if (j > 0) {
            if (i2 > 0) {
                this.journalFile = path.resolve(JOURNAL_FILE);
                this.journalFileTmp = path.resolve(JOURNAL_FILE_TMP);
                this.journalFileBackup = path.resolve(JOURNAL_FILE_BACKUP);
                this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
                this.cleanupScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatcher.limitedParallelism(1)));
                this.fileSystem = new DiskLruCache$fileSystem$1(fileSystem2);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public final synchronized void initialize() {
        if (!this.initialized) {
            this.fileSystem.delete(this.journalFileTmp);
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException unused) {
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
            writeJournal();
            this.initialized = true;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|(1:22)(1:23)|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r12.operationsSinceRewrite = r10 - r12.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        if (r3.exhausted() == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        writeJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        r12.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readJournal() {
        /*
            r12 = this;
            java.lang.String r0 = ", "
            coil.disk.DiskLruCache$fileSystem$1 r1 = r12.fileSystem
            okio.FileSystem r1 = (okio.FileSystem) r1
            okio.Path r2 = r12.journalFile
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = 0
            r3 = r1
            okio.BufferedSource r3 = (okio.BufferedSource) r3     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c6 }
            java.lang.String r5 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c6 }
            java.lang.String r6 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c6 }
            java.lang.String r7 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c6 }
            java.lang.String r8 = r3.readUtf8LineStrict()     // Catch:{ all -> 0x00c6 }
            java.lang.String r9 = "libcore.io.DiskLruCache"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)     // Catch:{ all -> 0x00c6 }
            if (r9 == 0) goto L_0x0087
            java.lang.String r9 = "1"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)     // Catch:{ all -> 0x00c6 }
            if (r9 == 0) goto L_0x0087
            int r9 = r12.appVersion     // Catch:{ all -> 0x00c6 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00c6 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r6)     // Catch:{ all -> 0x00c6 }
            if (r9 == 0) goto L_0x0087
            int r9 = r12.valueCount     // Catch:{ all -> 0x00c6 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00c6 }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)     // Catch:{ all -> 0x00c6 }
            if (r9 == 0) goto L_0x0087
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ all -> 0x00c6 }
            int r9 = r9.length()     // Catch:{ all -> 0x00c6 }
            r10 = 0
            if (r9 <= 0) goto L_0x005e
            r9 = 1
            goto L_0x005f
        L_0x005e:
            r9 = r10
        L_0x005f:
            if (r9 != 0) goto L_0x0087
        L_0x0061:
            java.lang.String r0 = r3.readUtf8LineStrict()     // Catch:{ EOFException -> 0x006b }
            r12.readJournalLine(r0)     // Catch:{ EOFException -> 0x006b }
            int r10 = r10 + 1
            goto L_0x0061
        L_0x006b:
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$Entry> r0 = r12.lruEntries     // Catch:{ all -> 0x00c6 }
            int r0 = r0.size()     // Catch:{ all -> 0x00c6 }
            int r10 = r10 - r0
            r12.operationsSinceRewrite = r10     // Catch:{ all -> 0x00c6 }
            boolean r0 = r3.exhausted()     // Catch:{ all -> 0x00c6 }
            if (r0 != 0) goto L_0x007e
            r12.writeJournal()     // Catch:{ all -> 0x00c6 }
            goto L_0x0084
        L_0x007e:
            okio.BufferedSink r0 = r12.newJournalWriter()     // Catch:{ all -> 0x00c6 }
            r12.journalWriter = r0     // Catch:{ all -> 0x00c6 }
        L_0x0084:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c6 }
            goto L_0x00ca
        L_0x0087:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
            r9.<init>()     // Catch:{ all -> 0x00c6 }
            java.lang.String r10 = "unexpected journal header: ["
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r4 = r9.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r0 = r0.append(r8)     // Catch:{ all -> 0x00c6 }
            r4 = 93
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c6 }
            r3.<init>(r0)     // Catch:{ all -> 0x00c6 }
            throw r3     // Catch:{ all -> 0x00c6 }
        L_0x00c6:
            r0 = move-exception
            r11 = r2
            r2 = r0
            r0 = r11
        L_0x00ca:
            if (r1 == 0) goto L_0x00d8
            r1.close()     // Catch:{ all -> 0x00d0 }
            goto L_0x00d8
        L_0x00d0:
            r1 = move-exception
            if (r2 != 0) goto L_0x00d5
            r2 = r1
            goto L_0x00d8
        L_0x00d5:
            kotlin.ExceptionsKt.addSuppressed(r2, r1)
        L_0x00d8:
            if (r2 != 0) goto L_0x00de
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return
        L_0x00de:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.readJournal():void");
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer((Sink) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void readJournalLine(String str) {
        String str2;
        String str3 = str;
        CharSequence charSequence = str3;
        int indexOf$default = StringsKt.indexOf$default(charSequence, ' ', 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, ' ', i, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                str2 = str3.substring(i);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
                if (indexOf$default == 6 && StringsKt.startsWith$default(str3, REMOVE, false, 2, (Object) null)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str3.substring(i, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            Map map = this.lruEntries;
            Object obj = map.get(str2);
            if (obj == null) {
                obj = new Entry(str2);
                map.put(str2, obj);
            }
            Entry entry = (Entry) obj;
            if (indexOf$default2 != -1 && indexOf$default == 5 && StringsKt.startsWith$default(str3, CLEAN, false, 2, (Object) null)) {
                String substring = str3.substring(indexOf$default2 + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                List split$default = StringsKt.split$default((CharSequence) substring, new char[]{' '}, false, 0, 6, (Object) null);
                entry.setReadable(true);
                entry.setCurrentEditor((Editor) null);
                entry.setLengths(split$default);
            } else if (indexOf$default2 == -1 && indexOf$default == 5 && StringsKt.startsWith$default(str3, DIRTY, false, 2, (Object) null)) {
                entry.setCurrentEditor(new Editor(entry));
            } else if (indexOf$default2 != -1 || indexOf$default != 4 || !StringsKt.startsWith$default(str3, READ, false, 2, (Object) null)) {
                throw new IOException("unexpected journal line: " + str3);
            }
        } else {
            throw new IOException("unexpected journal line: " + str3);
        }
    }

    private final void processJournal() {
        Iterator<Entry> it = this.lruEntries.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.getCurrentEditor() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    j += next.getLengths()[i];
                    i++;
                }
            } else {
                next.setCurrentEditor((Editor) null);
                int i3 = this.valueCount;
                while (i < i3) {
                    this.fileSystem.delete(next.getCleanFiles().get(i));
                    this.fileSystem.delete(next.getDirtyFiles().get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.size = j;
    }

    /* access modifiers changed from: private */
    public final synchronized void writeJournal() {
        Unit unit;
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        Closeable buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp, false));
        Throwable th = null;
        try {
            BufferedSink bufferedSink2 = (BufferedSink) buffer;
            bufferedSink2.writeUtf8(MAGIC).writeByte(10);
            bufferedSink2.writeUtf8("1").writeByte(10);
            bufferedSink2.writeDecimalLong((long) this.appVersion).writeByte(10);
            bufferedSink2.writeDecimalLong((long) this.valueCount).writeByte(10);
            bufferedSink2.writeByte(10);
            for (Entry next : this.lruEntries.values()) {
                if (next.getCurrentEditor() != null) {
                    bufferedSink2.writeUtf8(DIRTY);
                    bufferedSink2.writeByte(32);
                    bufferedSink2.writeUtf8(next.getKey());
                    bufferedSink2.writeByte(10);
                } else {
                    bufferedSink2.writeUtf8(CLEAN);
                    bufferedSink2.writeByte(32);
                    bufferedSink2.writeUtf8(next.getKey());
                    next.writeLengths(bufferedSink2);
                    bufferedSink2.writeByte(10);
                }
            }
            unit = Unit.INSTANCE;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            unit = null;
            th = th3;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                } else {
                    ExceptionsKt.addSuppressed(th, th4);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(unit);
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            this.journalWriter = newJournalWriter();
            this.operationsSinceRewrite = 0;
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } else {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized coil.disk.DiskLruCache.Snapshot get(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.checkNotClosed()     // Catch:{ all -> 0x0046 }
            r3.validateKey(r4)     // Catch:{ all -> 0x0046 }
            r3.initialize()     // Catch:{ all -> 0x0046 }
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$Entry> r0 = r3.lruEntries     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0046 }
            coil.disk.DiskLruCache$Entry r0 = (coil.disk.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0043
            coil.disk.DiskLruCache$Snapshot r0 = r0.snapshot()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x001b
            goto L_0x0043
        L_0x001b:
            int r1 = r3.operationsSinceRewrite     // Catch:{ all -> 0x0046 }
            int r1 = r1 + 1
            r3.operationsSinceRewrite = r1     // Catch:{ all -> 0x0046 }
            okio.BufferedSink r1 = r3.journalWriter     // Catch:{ all -> 0x0046 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "READ"
            r1.writeUtf8(r2)     // Catch:{ all -> 0x0046 }
            r2 = 32
            r1.writeByte(r2)     // Catch:{ all -> 0x0046 }
            r1.writeUtf8(r4)     // Catch:{ all -> 0x0046 }
            r4 = 10
            r1.writeByte(r4)     // Catch:{ all -> 0x0046 }
            boolean r4 = r3.journalRewriteRequired()     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0041
            r3.launchCleanup()     // Catch:{ all -> 0x0046 }
        L_0x0041:
            monitor-exit(r3)
            return r0
        L_0x0043:
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x0046:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.get(java.lang.String):coil.disk.DiskLruCache$Snapshot");
    }

    public final synchronized Editor edit(String str) {
        checkNotClosed();
        validateKey(str);
        initialize();
        Entry entry = this.lruEntries.get(str);
        if ((entry != null ? entry.getCurrentEditor() : null) != null) {
            return null;
        }
        if (entry != null) {
            if (entry.getLockingSnapshotCount() != 0) {
                return null;
            }
        }
        if (!this.mostRecentTrimFailed) {
            if (!this.mostRecentRebuildFailed) {
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(str);
                bufferedSink.writeByte(10);
                bufferedSink.flush();
                if (this.hasJournalErrors) {
                    return null;
                }
                if (entry == null) {
                    entry = new Entry(str);
                    this.lruEntries.put(str, entry);
                }
                Editor editor = new Editor(entry);
                entry.setCurrentEditor(editor);
                return editor;
            }
        }
        launchCleanup();
        return null;
    }

    public final synchronized long size() {
        initialize();
        return this.size;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0124, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void completeEdit(coil.disk.DiskLruCache.Editor r9, boolean r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            coil.disk.DiskLruCache$Entry r0 = r9.getEntry()     // Catch:{ all -> 0x0131 }
            coil.disk.DiskLruCache$Editor r1 = r0.getCurrentEditor()     // Catch:{ all -> 0x0131 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x0125
            r1 = 0
            if (r10 == 0) goto L_0x009e
            boolean r2 = r0.getZombie()     // Catch:{ all -> 0x0131 }
            if (r2 != 0) goto L_0x009e
            int r2 = r8.valueCount     // Catch:{ all -> 0x0131 }
            r3 = r1
        L_0x001b:
            if (r3 >= r2) goto L_0x003f
            boolean[] r4 = r9.getWritten()     // Catch:{ all -> 0x0131 }
            boolean r4 = r4[r3]     // Catch:{ all -> 0x0131 }
            if (r4 == 0) goto L_0x003c
            coil.disk.DiskLruCache$fileSystem$1 r4 = r8.fileSystem     // Catch:{ all -> 0x0131 }
            java.util.ArrayList r5 = r0.getDirtyFiles()     // Catch:{ all -> 0x0131 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0131 }
            okio.Path r5 = (okio.Path) r5     // Catch:{ all -> 0x0131 }
            boolean r4 = r4.exists(r5)     // Catch:{ all -> 0x0131 }
            if (r4 != 0) goto L_0x003c
            r9.abort()     // Catch:{ all -> 0x0131 }
            monitor-exit(r8)
            return
        L_0x003c:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x003f:
            int r9 = r8.valueCount     // Catch:{ all -> 0x0131 }
        L_0x0041:
            if (r1 >= r9) goto L_0x00b4
            java.util.ArrayList r2 = r0.getDirtyFiles()     // Catch:{ all -> 0x0131 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0131 }
            okio.Path r2 = (okio.Path) r2     // Catch:{ all -> 0x0131 }
            java.util.ArrayList r3 = r0.getCleanFiles()     // Catch:{ all -> 0x0131 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0131 }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x0131 }
            coil.disk.DiskLruCache$fileSystem$1 r4 = r8.fileSystem     // Catch:{ all -> 0x0131 }
            boolean r4 = r4.exists(r2)     // Catch:{ all -> 0x0131 }
            if (r4 == 0) goto L_0x0065
            coil.disk.DiskLruCache$fileSystem$1 r4 = r8.fileSystem     // Catch:{ all -> 0x0131 }
            r4.atomicMove(r2, r3)     // Catch:{ all -> 0x0131 }
            goto L_0x0076
        L_0x0065:
            coil.disk.DiskLruCache$fileSystem$1 r2 = r8.fileSystem     // Catch:{ all -> 0x0131 }
            okio.FileSystem r2 = (okio.FileSystem) r2     // Catch:{ all -> 0x0131 }
            java.util.ArrayList r4 = r0.getCleanFiles()     // Catch:{ all -> 0x0131 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0131 }
            okio.Path r4 = (okio.Path) r4     // Catch:{ all -> 0x0131 }
            coil.util.FileSystems.createFile(r2, r4)     // Catch:{ all -> 0x0131 }
        L_0x0076:
            long[] r2 = r0.getLengths()     // Catch:{ all -> 0x0131 }
            r4 = r2[r1]     // Catch:{ all -> 0x0131 }
            coil.disk.DiskLruCache$fileSystem$1 r2 = r8.fileSystem     // Catch:{ all -> 0x0131 }
            okio.FileMetadata r2 = r2.metadata(r3)     // Catch:{ all -> 0x0131 }
            java.lang.Long r2 = r2.getSize()     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x008d
            long r2 = r2.longValue()     // Catch:{ all -> 0x0131 }
            goto L_0x008f
        L_0x008d:
            r2 = 0
        L_0x008f:
            long[] r6 = r0.getLengths()     // Catch:{ all -> 0x0131 }
            r6[r1] = r2     // Catch:{ all -> 0x0131 }
            long r6 = r8.size     // Catch:{ all -> 0x0131 }
            long r6 = r6 - r4
            long r6 = r6 + r2
            r8.size = r6     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            goto L_0x0041
        L_0x009e:
            int r9 = r8.valueCount     // Catch:{ all -> 0x0131 }
        L_0x00a0:
            if (r1 >= r9) goto L_0x00b4
            coil.disk.DiskLruCache$fileSystem$1 r2 = r8.fileSystem     // Catch:{ all -> 0x0131 }
            java.util.ArrayList r3 = r0.getDirtyFiles()     // Catch:{ all -> 0x0131 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0131 }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x0131 }
            r2.delete(r3)     // Catch:{ all -> 0x0131 }
            int r1 = r1 + 1
            goto L_0x00a0
        L_0x00b4:
            r9 = 0
            r0.setCurrentEditor(r9)     // Catch:{ all -> 0x0131 }
            boolean r9 = r0.getZombie()     // Catch:{ all -> 0x0131 }
            if (r9 == 0) goto L_0x00c3
            r8.removeEntry(r0)     // Catch:{ all -> 0x0131 }
            monitor-exit(r8)
            return
        L_0x00c3:
            int r9 = r8.operationsSinceRewrite     // Catch:{ all -> 0x0131 }
            r1 = 1
            int r9 = r9 + r1
            r8.operationsSinceRewrite = r9     // Catch:{ all -> 0x0131 }
            okio.BufferedSink r9 = r8.journalWriter     // Catch:{ all -> 0x0131 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ all -> 0x0131 }
            r2 = 10
            r3 = 32
            if (r10 != 0) goto L_0x00f7
            boolean r10 = r0.getReadable()     // Catch:{ all -> 0x0131 }
            if (r10 == 0) goto L_0x00db
            goto L_0x00f7
        L_0x00db:
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$Entry> r10 = r8.lruEntries     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = r0.getKey()     // Catch:{ all -> 0x0131 }
            r10.remove(r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = "REMOVE"
            r9.writeUtf8(r10)     // Catch:{ all -> 0x0131 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = r0.getKey()     // Catch:{ all -> 0x0131 }
            r9.writeUtf8(r10)     // Catch:{ all -> 0x0131 }
            r9.writeByte(r2)     // Catch:{ all -> 0x0131 }
            goto L_0x010f
        L_0x00f7:
            r0.setReadable(r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = "CLEAN"
            r9.writeUtf8(r10)     // Catch:{ all -> 0x0131 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = r0.getKey()     // Catch:{ all -> 0x0131 }
            r9.writeUtf8(r10)     // Catch:{ all -> 0x0131 }
            r0.writeLengths(r9)     // Catch:{ all -> 0x0131 }
            r9.writeByte(r2)     // Catch:{ all -> 0x0131 }
        L_0x010f:
            r9.flush()     // Catch:{ all -> 0x0131 }
            long r9 = r8.size     // Catch:{ all -> 0x0131 }
            long r0 = r8.maxSize     // Catch:{ all -> 0x0131 }
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 > 0) goto L_0x0120
            boolean r9 = r8.journalRewriteRequired()     // Catch:{ all -> 0x0131 }
            if (r9 == 0) goto L_0x0123
        L_0x0120:
            r8.launchCleanup()     // Catch:{ all -> 0x0131 }
        L_0x0123:
            monitor-exit(r8)
            return
        L_0x0125:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0131 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0131 }
            r10.<init>(r9)     // Catch:{ all -> 0x0131 }
            throw r10     // Catch:{ all -> 0x0131 }
        L_0x0131:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.completeEdit(coil.disk.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    public final boolean journalRewriteRequired() {
        return this.operationsSinceRewrite >= 2000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkNotClosed()     // Catch:{ all -> 0x0029 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0029 }
            r5.initialize()     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, coil.disk.DiskLruCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x0029 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0029 }
            coil.disk.DiskLruCache$Entry r6 = (coil.disk.DiskLruCache.Entry) r6     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r6 != 0) goto L_0x0017
            monitor-exit(r5)
            return r0
        L_0x0017:
            boolean r6 = r5.removeEntry(r6)     // Catch:{ all -> 0x0029 }
            if (r6 == 0) goto L_0x0027
            long r1 = r5.size     // Catch:{ all -> 0x0029 }
            long r3 = r5.maxSize     // Catch:{ all -> 0x0029 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0027
            r5.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r5)
            return r6
        L_0x0029:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache.remove(java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final boolean removeEntry(Entry entry) {
        BufferedSink bufferedSink;
        if (entry.getLockingSnapshotCount() > 0 && (bufferedSink = this.journalWriter) != null) {
            bufferedSink.writeUtf8(DIRTY);
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (entry.getLockingSnapshotCount() > 0 || entry.getCurrentEditor() != null) {
            entry.setZombie(true);
            return true;
        }
        Editor currentEditor = entry.getCurrentEditor();
        if (currentEditor != null) {
            currentEditor.detach();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.fileSystem.delete(entry.getCleanFiles().get(i2));
            this.size -= entry.getLengths()[i2];
            entry.getLengths()[i2] = 0;
        }
        this.operationsSinceRewrite++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey());
        if (journalRewriteRequired()) {
            launchCleanup();
        }
        return true;
    }

    private final void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public synchronized void close() {
        Editor currentEditor;
        if (this.initialized) {
            if (!this.closed) {
                Object[] array = this.lruEntries.values().toArray(new Entry[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                for (Entry entry : (Entry[]) array) {
                    if (!(entry.getCurrentEditor() == null || (currentEditor = entry.getCurrentEditor()) == null)) {
                        currentEditor.detach();
                    }
                }
                trimToSize();
                CoroutineScopeKt.cancel$default(this.cleanupScope, (CancellationException) null, 1, (Object) null);
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    public synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    /* access modifiers changed from: private */
    public final void trimToSize() {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() {
        for (Entry next : this.lruEntries.values()) {
            if (!next.getZombie()) {
                removeEntry(next);
                return true;
            }
        }
        return false;
    }

    private final void delete() {
        close();
        FileSystems.deleteContents(this.fileSystem, this.directory);
    }

    public final synchronized void evictAll() {
        initialize();
        Object[] array = this.lruEntries.values().toArray(new Entry[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        for (Entry removeEntry : (Entry[]) array) {
            removeEntry(removeEntry);
        }
        this.mostRecentTrimFailed = false;
    }

    private final void launchCleanup() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.cleanupScope, (CoroutineContext) null, (CoroutineStart) null, new DiskLruCache$launchCleanup$1(this, (Continuation<? super DiskLruCache$launchCleanup$1>) null), 3, (Object) null);
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + Typography.quote).toString());
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0003\u001a\u00060\u0004R\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcoil/disk/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "Lokio/Closeable;", "entry", "Lcoil/disk/DiskLruCache$Entry;", "Lcoil/disk/DiskLruCache;", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$Entry;)V", "closed", "", "getEntry", "()Lcoil/disk/DiskLruCache$Entry;", "close", "", "closeAndEdit", "Lcoil/disk/DiskLruCache$Editor;", "file", "Lokio/Path;", "index", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public final class Snapshot implements Closeable {
        private boolean closed;
        private final Entry entry;

        public Snapshot(Entry entry2) {
            this.entry = entry2;
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final Path file(int i) {
            if (!this.closed) {
                return this.entry.getCleanFiles().get(i);
            }
            throw new IllegalStateException("snapshot is closed".toString());
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    Entry entry2 = this.entry;
                    entry2.setLockingSnapshotCount(entry2.getLockingSnapshotCount() - 1);
                    if (this.entry.getLockingSnapshotCount() == 0 && this.entry.getZombie()) {
                        boolean unused = diskLruCache.removeEntry(this.entry);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public final Editor closeAndEdit() {
            Editor edit;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                close();
                edit = diskLruCache.edit(this.entry.getKey());
            }
            return edit;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\f\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcoil/disk/DiskLruCache$Editor;", "", "entry", "Lcoil/disk/DiskLruCache$Entry;", "Lcoil/disk/DiskLruCache;", "(Lcoil/disk/DiskLruCache;Lcoil/disk/DiskLruCache$Entry;)V", "closed", "", "getEntry", "()Lcoil/disk/DiskLruCache$Entry;", "written", "", "getWritten", "()[Z", "abort", "", "commit", "commitAndGet", "Lcoil/disk/DiskLruCache$Snapshot;", "complete", "success", "detach", "file", "Lokio/Path;", "index", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public final class Editor {
        private boolean closed;
        private final Entry entry;
        private final boolean[] written;

        public Editor(Entry entry2) {
            this.entry = entry2;
            this.written = new boolean[DiskLruCache.this.valueCount];
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final boolean[] getWritten() {
            return this.written;
        }

        public final Path file(int i) {
            Path path;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (!this.closed) {
                    this.written[i] = true;
                    Path path2 = this.entry.getDirtyFiles().get(i);
                    FileSystems.createFile(diskLruCache.fileSystem, path2);
                    path = path2;
                } else {
                    throw new IllegalStateException("editor is closed".toString());
                }
            }
            return path;
        }

        public final void detach() {
            if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor(), (Object) this)) {
                this.entry.setZombie(true);
            }
        }

        public final void commit() {
            complete(true);
        }

        public final Snapshot commitAndGet() {
            Snapshot snapshot;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                commit();
                snapshot = diskLruCache.get(this.entry.getKey());
            }
            return snapshot;
        }

        public final void abort() {
            complete(false);
        }

        private final void complete(boolean z) {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (!this.closed) {
                    if (Intrinsics.areEqual((Object) this.entry.getCurrentEditor(), (Object) this)) {
                        diskLruCache.completeEdit(this, z);
                    }
                    this.closed = true;
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("editor is closed".toString());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030,J\f\u0010-\u001a\b\u0018\u00010.R\u00020\rJ\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0018\u00010\fR\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u00062"}, d2 = {"Lcoil/disk/DiskLruCache$Entry;", "", "key", "", "(Lcoil/disk/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "Ljava/util/ArrayList;", "Lokio/Path;", "Lkotlin/collections/ArrayList;", "getCleanFiles", "()Ljava/util/ArrayList;", "currentEditor", "Lcoil/disk/DiskLruCache$Editor;", "Lcoil/disk/DiskLruCache;", "getCurrentEditor", "()Lcoil/disk/DiskLruCache$Editor;", "setCurrentEditor", "(Lcoil/disk/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles", "getKey", "()Ljava/lang/String;", "lengths", "", "getLengths", "()[J", "lockingSnapshotCount", "", "getLockingSnapshotCount", "()I", "setLockingSnapshotCount", "(I)V", "readable", "", "getReadable", "()Z", "setReadable", "(Z)V", "zombie", "getZombie", "setZombie", "setLengths", "", "strings", "", "snapshot", "Lcoil/disk/DiskLruCache$Snapshot;", "writeLengths", "writer", "Lokio/BufferedSink;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public final class Entry {
        private final ArrayList<Path> cleanFiles;
        private Editor currentEditor;
        private final ArrayList<Path> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSnapshotCount;
        private boolean readable;
        private boolean zombie;

        public Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            this.dirtyFiles = new ArrayList<>(DiskLruCache.this.valueCount);
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            int access$getValueCount$p = DiskLruCache.this.valueCount;
            for (int i = 0; i < access$getValueCount$p; i++) {
                append.append(i);
                this.cleanFiles.add(DiskLruCache.this.directory.resolve(append.toString()));
                append.append(DefaultDiskStorage.FileType.TEMP);
                this.dirtyFiles.add(DiskLruCache.this.directory.resolve(append.toString()));
                append.setLength(length);
            }
        }

        public final String getKey() {
            return this.key;
        }

        public final long[] getLengths() {
            return this.lengths;
        }

        public final ArrayList<Path> getCleanFiles() {
            return this.cleanFiles;
        }

        public final ArrayList<Path> getDirtyFiles() {
            return this.dirtyFiles;
        }

        public final boolean getReadable() {
            return this.readable;
        }

        public final void setReadable(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setZombie(boolean z) {
            this.zombie = z;
        }

        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        public final void setCurrentEditor(Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        public final void setLockingSnapshotCount(int i) {
            this.lockingSnapshotCount = i;
        }

        public final void setLengths(List<String> list) {
            if (list.size() == DiskLruCache.this.valueCount) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.lengths[i] = Long.parseLong(list.get(i));
                    }
                } catch (NumberFormatException unused) {
                    throw new IOException("unexpected journal line: " + list);
                }
            } else {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void writeLengths(BufferedSink bufferedSink) {
            for (long writeDecimalLong : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }

        public final Snapshot snapshot() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            List list = this.cleanFiles;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!diskLruCache.fileSystem.exists((Path) list.get(i))) {
                    try {
                        boolean unused = diskLruCache.removeEntry(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
            this.lockingSnapshotCount++;
            return new Snapshot(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0016\u0010\b\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcoil/disk/DiskLruCache$Companion;", "", "()V", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "getJOURNAL_FILE$coil_base_release$annotations", "JOURNAL_FILE_BACKUP", "getJOURNAL_FILE_BACKUP$coil_base_release$annotations", "JOURNAL_FILE_TMP", "getJOURNAL_FILE_TMP$coil_base_release$annotations", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "getMAGIC$coil_base_release$annotations", "READ", "REMOVE", "VERSION", "getVERSION$coil_base_release$annotations", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DiskLruCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getJOURNAL_FILE$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_BACKUP$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getJOURNAL_FILE_TMP$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getMAGIC$coil_base_release$annotations() {
        }

        public static /* synthetic */ void getVERSION$coil_base_release$annotations() {
        }

        private Companion() {
        }
    }
}
