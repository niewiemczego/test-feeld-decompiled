package expo.modules.core.logging;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J;\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032+\b\u0002\u0010\u000b\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\rj\u0004\u0018\u0001`\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\fJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J1\u0010\u0014\u001a\u00020\t2)\u0010\u000b\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\rj\u0004\u0018\u0001`\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\fJ\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002JT\u0010\u0019\u001a\u00020\t2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u001b0\f2)\u0010\u000b\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\rj\u0004\u0018\u0001`\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\fJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0002J\u0016\u0010\u001f\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0002R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lexpo/modules/core/logging/PersistentFileLog;", "", "category", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "filePath", "appendEntry", "", "entry", "completionHandler", "Lkotlin/Function1;", "Ljava/lang/Error;", "Lkotlin/Error;", "Lkotlin/ParameterName;", "name", "_", "appendTextToFile", "text", "clearEntries", "deleteFileSync", "ensureFileExists", "getFileSize", "", "purgeEntriesNotMatchingFilter", "filter", "", "readEntries", "", "readFileLinesSync", "writeFileLinesSync", "entries", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PersistentFileLog.kt */
public final class PersistentFileLog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FILE_NAME_PREFIX = "dev.expo.modules.core.logging";
    private static final PersistentFileLogSerialDispatchQueue queue = new PersistentFileLogSerialDispatchQueue();
    private final String filePath;

    public PersistentFileLog(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(context, "context");
        this.filePath = context.getFilesDir().getPath() + "/dev.expo.modules.core.logging." + str;
    }

    public final List<String> readEntries() {
        if (0 == getFileSize()) {
            return CollectionsKt.emptyList();
        }
        return readFileLinesSync();
    }

    public static /* synthetic */ void appendEntry$default(PersistentFileLog persistentFileLog, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = PersistentFileLog$appendEntry$1.INSTANCE;
        }
        persistentFileLog.appendEntry(str, function1);
    }

    public final void appendEntry(String str, Function1<? super Error, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "entry");
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        queue.add(new PersistentFileLog$appendEntry$2(this, str, function1));
    }

    public final void purgeEntriesNotMatchingFilter(Function1<? super String, Boolean> function1, Function1<? super Error, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "filter");
        Intrinsics.checkNotNullParameter(function12, "completionHandler");
        queue.add(new PersistentFileLog$purgeEntriesNotMatchingFilter$1(this, function1, function12));
    }

    public final void clearEntries(Function1<? super Error, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "completionHandler");
        queue.add(new PersistentFileLog$clearEntries$1(this, function1));
    }

    /* access modifiers changed from: private */
    public final void ensureFileExists() {
        File file = new File(this.filePath);
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("Unable to create file at path " + this.filePath);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long getFileSize() {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r6.filePath
            r0.<init>(r1)
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 != 0) goto L_0x0010
            return r2
        L_0x0010:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002f }
            r1.<init>(r0)     // Catch:{ IOException -> 0x002f }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ IOException -> 0x002f }
            r0 = 0
            r4 = r1
            java.io.FileInputStream r4 = (java.io.FileInputStream) r4     // Catch:{ all -> 0x0028 }
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ all -> 0x0028 }
            long r4 = r4.size()     // Catch:{ all -> 0x0028 }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ IOException -> 0x002f }
            r2 = r4
            goto L_0x002f
        L_0x0028:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002a }
        L_0x002a:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ IOException -> 0x002f }
            throw r4     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.core.logging.PersistentFileLog.getFileSize():long");
    }

    /* access modifiers changed from: private */
    public final void appendTextToFile(String str) {
        File file = new File(this.filePath);
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        FilesKt.appendText(file, str, defaultCharset);
    }

    /* access modifiers changed from: private */
    public final List<String> readFileLinesSync() {
        File file = new File(this.filePath);
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        Collection arrayList = new ArrayList();
        for (Object next : FilesKt.readLines(file, defaultCharset)) {
            if (((String) next).length() > 0) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public final void writeFileLinesSync(List<String> list) {
        File file = new File(this.filePath);
        String joinToString$default = CollectionsKt.joinToString$default(list, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
        FilesKt.writeText(file, joinToString$default, defaultCharset);
    }

    /* access modifiers changed from: private */
    public final void deleteFileSync() {
        File file = new File(this.filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lexpo/modules/core/logging/PersistentFileLog$Companion;", "", "()V", "FILE_NAME_PREFIX", "", "queue", "Lexpo/modules/core/logging/PersistentFileLogSerialDispatchQueue;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PersistentFileLog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
