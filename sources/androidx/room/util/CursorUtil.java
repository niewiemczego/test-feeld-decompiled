package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a#\u0010\u0003\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00120\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"copyAndClose", "Landroid/database/Cursor;", "c", "findColumnIndexBySuffix", "", "cursor", "name", "", "columnNames", "", "([Ljava/lang/String;Ljava/lang/String;)I", "getColumnIndex", "getColumnIndexOrThrow", "wrapMappedColumns", "mapping", "", "(Landroid/database/Cursor;[Ljava/lang/String;[I)Landroid/database/Cursor;", "useCursor", "R", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CursorUtil.kt */
public final class CursorUtil {
    public static final int getColumnIndex(Cursor cursor, String str) {
        Intrinsics.checkNotNullParameter(cursor, "c");
        Intrinsics.checkNotNullParameter(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex('`' + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(cursor, "c");
        Intrinsics.checkNotNullParameter(str, "name");
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "c.columnNames");
            str2 = ArraysKt.joinToString$default((Object[]) columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            str2 = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25) {
            return -1;
        }
        if (str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(columnNames, "columnNames");
        return findColumnIndexBySuffix(columnNames, str);
    }

    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        Intrinsics.checkNotNullParameter(strArr, "columnNames");
        Intrinsics.checkNotNullParameter(str, "name");
        String str2 = '.' + str;
        String str3 = '.' + str + '`';
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str4 = strArr[i];
            int i3 = i2 + 1;
            if (str4.length() >= str.length() + 2) {
                if (StringsKt.endsWith$default(str4, str2, false, 2, (Object) null)) {
                    return i2;
                }
                if (str4.charAt(0) == '`' && StringsKt.endsWith$default(str4, str3, false, 2, (Object) null)) {
                    return i2;
                }
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> R useCursor(android.database.Cursor r3, kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends R> r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 15
            if (r0 <= r2) goto L_0x002f
            java.io.Closeable r3 = (java.io.Closeable) r3
            r0 = 0
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0022 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            return r4
        L_0x0022:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x002f:
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x003d }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            r3.close()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            return r4
        L_0x003d:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            r3.close()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.CursorUtil.useCursor(android.database.Cursor, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(strArr, "columnNames");
        Intrinsics.checkNotNullParameter(iArr, "mapping");
        if (strArr.length == iArr.length) {
            return new CursorUtil$wrapMappedColumns$2(cursor, strArr, iArr);
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.database.Cursor copyAndClose(android.database.Cursor r14) {
        /*
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 0
            r6 = 1
            r7 = 15
            if (r0 <= r7) goto L_0x0084
            r0 = r14
            java.io.Closeable r0 = (java.io.Closeable) r0
            r7 = r0
            android.database.Cursor r7 = (android.database.Cursor) r7     // Catch:{ all -> 0x007d }
            android.database.MatrixCursor r8 = new android.database.MatrixCursor     // Catch:{ all -> 0x007d }
            java.lang.String[] r9 = r7.getColumnNames()     // Catch:{ all -> 0x007d }
            int r10 = r7.getCount()     // Catch:{ all -> 0x007d }
            r8.<init>(r9, r10)     // Catch:{ all -> 0x007d }
        L_0x0024:
            boolean r9 = r7.moveToNext()     // Catch:{ all -> 0x007d }
            if (r9 == 0) goto L_0x0078
            int r9 = r7.getColumnCount()     // Catch:{ all -> 0x007d }
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x007d }
            int r10 = r14.getColumnCount()     // Catch:{ all -> 0x007d }
            r11 = r4
        L_0x0035:
            if (r11 >= r10) goto L_0x0074
            int r12 = r7.getType(r11)     // Catch:{ all -> 0x007d }
            if (r12 == 0) goto L_0x006f
            if (r12 == r6) goto L_0x0064
            if (r12 == r3) goto L_0x0059
            if (r12 == r2) goto L_0x0052
            if (r12 != r1) goto L_0x004c
            byte[] r12 = r7.getBlob(r11)     // Catch:{ all -> 0x007d }
            r9[r11] = r12     // Catch:{ all -> 0x007d }
            goto L_0x0071
        L_0x004c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007d }
            r14.<init>()     // Catch:{ all -> 0x007d }
            throw r14     // Catch:{ all -> 0x007d }
        L_0x0052:
            java.lang.String r12 = r7.getString(r11)     // Catch:{ all -> 0x007d }
            r9[r11] = r12     // Catch:{ all -> 0x007d }
            goto L_0x0071
        L_0x0059:
            double r12 = r7.getDouble(r11)     // Catch:{ all -> 0x007d }
            java.lang.Double r12 = java.lang.Double.valueOf(r12)     // Catch:{ all -> 0x007d }
            r9[r11] = r12     // Catch:{ all -> 0x007d }
            goto L_0x0071
        L_0x0064:
            long r12 = r7.getLong(r11)     // Catch:{ all -> 0x007d }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x007d }
            r9[r11] = r12     // Catch:{ all -> 0x007d }
            goto L_0x0071
        L_0x006f:
            r9[r11] = r5     // Catch:{ all -> 0x007d }
        L_0x0071:
            int r11 = r11 + 1
            goto L_0x0035
        L_0x0074:
            r8.addRow(r9)     // Catch:{ all -> 0x007d }
            goto L_0x0024
        L_0x0078:
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            goto L_0x00e8
        L_0x007d:
            r14 = move-exception
            throw r14     // Catch:{ all -> 0x007f }
        L_0x007f:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r14)
            throw r1
        L_0x0084:
            android.database.MatrixCursor r8 = new android.database.MatrixCursor     // Catch:{ all -> 0x00eb }
            java.lang.String[] r0 = r14.getColumnNames()     // Catch:{ all -> 0x00eb }
            int r7 = r14.getCount()     // Catch:{ all -> 0x00eb }
            r8.<init>(r0, r7)     // Catch:{ all -> 0x00eb }
        L_0x0091:
            boolean r0 = r14.moveToNext()     // Catch:{ all -> 0x00eb }
            if (r0 == 0) goto L_0x00e5
            int r0 = r14.getColumnCount()     // Catch:{ all -> 0x00eb }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00eb }
            int r7 = r14.getColumnCount()     // Catch:{ all -> 0x00eb }
            r9 = r4
        L_0x00a2:
            if (r9 >= r7) goto L_0x00e1
            int r10 = r14.getType(r9)     // Catch:{ all -> 0x00eb }
            if (r10 == 0) goto L_0x00dc
            if (r10 == r6) goto L_0x00d1
            if (r10 == r3) goto L_0x00c6
            if (r10 == r2) goto L_0x00bf
            if (r10 != r1) goto L_0x00b9
            byte[] r10 = r14.getBlob(r9)     // Catch:{ all -> 0x00eb }
            r0[r9] = r10     // Catch:{ all -> 0x00eb }
            goto L_0x00de
        L_0x00b9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00eb }
            r0.<init>()     // Catch:{ all -> 0x00eb }
            throw r0     // Catch:{ all -> 0x00eb }
        L_0x00bf:
            java.lang.String r10 = r14.getString(r9)     // Catch:{ all -> 0x00eb }
            r0[r9] = r10     // Catch:{ all -> 0x00eb }
            goto L_0x00de
        L_0x00c6:
            double r10 = r14.getDouble(r9)     // Catch:{ all -> 0x00eb }
            java.lang.Double r10 = java.lang.Double.valueOf(r10)     // Catch:{ all -> 0x00eb }
            r0[r9] = r10     // Catch:{ all -> 0x00eb }
            goto L_0x00de
        L_0x00d1:
            long r10 = r14.getLong(r9)     // Catch:{ all -> 0x00eb }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x00eb }
            r0[r9] = r10     // Catch:{ all -> 0x00eb }
            goto L_0x00de
        L_0x00dc:
            r0[r9] = r5     // Catch:{ all -> 0x00eb }
        L_0x00de:
            int r9 = r9 + 1
            goto L_0x00a2
        L_0x00e1:
            r8.addRow(r0)     // Catch:{ all -> 0x00eb }
            goto L_0x0091
        L_0x00e5:
            r14.close()
        L_0x00e8:
            android.database.Cursor r8 = (android.database.Cursor) r8
            return r8
        L_0x00eb:
            r0 = move-exception
            r14.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.CursorUtil.copyAndClose(android.database.Cursor):android.database.Cursor");
    }
}
