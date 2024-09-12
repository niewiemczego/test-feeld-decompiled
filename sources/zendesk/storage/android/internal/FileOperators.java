package zendesk.storage.android.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\nJ'\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\b\n¨\u0006\u000e"}, d2 = {"Lzendesk/storage/android/internal/FileOperators;", "", "()V", "reader", "", "file", "Ljava/io/File;", "block", "Lkotlin/Function1;", "Ljava/io/FileReader;", "Lkotlin/ExtensionFunctionType;", "writer", "", "Ljava/io/FileWriter;", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileOperators.kt */
public final class FileOperators {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String reader(java.io.File r2, kotlin.jvm.functions.Function1<? super java.io.FileReader, java.lang.String> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.FileReader r0 = new java.io.FileReader
            r0.<init>(r2)
            java.io.Closeable r0 = (java.io.Closeable) r0
            java.lang.Object r2 = r3.invoke(r0)     // Catch:{ all -> 0x001c }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            java.lang.String r2 = (java.lang.String) r2
            return r2
        L_0x001c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001e:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.storage.android.internal.FileOperators.reader(java.io.File, kotlin.jvm.functions.Function1):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writer(java.io.File r2, kotlin.jvm.functions.Function1<? super java.io.FileWriter, kotlin.Unit> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.FileWriter r0 = new java.io.FileWriter
            r0.<init>(r2)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r3.invoke(r0)     // Catch:{ all -> 0x0019 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return
        L_0x0019:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001b }
        L_0x001b:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.storage.android.internal.FileOperators.writer(java.io.File, kotlin.jvm.functions.Function1):void");
    }
}
