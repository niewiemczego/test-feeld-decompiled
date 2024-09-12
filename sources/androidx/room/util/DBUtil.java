package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.facebook.appevents.UserDataStore;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016¨\u0006\u0017"}, d2 = {"createCancellationSignal", "Landroid/os/CancellationSignal;", "dropFtsSyncTriggers", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "foreignKeyCheck", "tableName", "", "processForeignKeyCheckFailure", "cursor", "Landroid/database/Cursor;", "query", "Landroidx/room/RoomDatabase;", "sqLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "maybeCopy", "", "signal", "readVersion", "", "databaseFile", "Ljava/io/File;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DBUtil.kt */
public final class DBUtil {
    @Deprecated(message = "This is only used in the generated code and shouldn't be called directly.")
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z) {
        Intrinsics.checkNotNullParameter(roomDatabase, UserDataStore.DATE_OF_BIRTH);
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "sqLiteQuery");
        return query(roomDatabase, supportSQLiteQuery, z, (CancellationSignal) null);
    }

    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(roomDatabase, UserDataStore.DATE_OF_BIRTH);
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "sqLiteQuery");
        Cursor query = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? CursorUtil.copyAndClose(query) : query;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void dropFtsSyncTriggers(androidx.sqlite.db.SupportSQLiteDatabase r6) {
        /*
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.createListBuilder()
            java.lang.String r1 = "SELECT name FROM sqlite_master WHERE type = 'trigger'"
            android.database.Cursor r1 = r6.query((java.lang.String) r1)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 0
            r4 = 0
            r5 = 15
            if (r2 <= r5) goto L_0x0037
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x0030 }
        L_0x001c:
            boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x002a
            java.lang.String r5 = r2.getString(r4)     // Catch:{ all -> 0x0030 }
            r0.add(r5)     // Catch:{ all -> 0x0030 }
            goto L_0x001c
        L_0x002a:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0030 }
            kotlin.io.CloseableKt.closeFinally(r1, r3)
            goto L_0x004a
        L_0x0030:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r6)
            throw r0
        L_0x0037:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x0045
            java.lang.String r2 = r1.getString(r4)     // Catch:{ all -> 0x0086 }
            r0.add(r2)     // Catch:{ all -> 0x0086 }
            goto L_0x0037
        L_0x0045:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0086 }
            r1.close()
        L_0x004a:
            java.util.List r0 = kotlin.collections.CollectionsKt.build(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0054:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0085
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "triggerName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 2
            java.lang.String r5 = "room_fts_content_sync_"
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r1, r5, r4, r2, r3)
            if (r2 == 0) goto L_0x0054
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "DROP TRIGGER IF EXISTS "
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r6.execSQL(r1)
            goto L_0x0054
        L_0x0085:
            return
        L_0x0086:
            r6 = move-exception
            r1.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil.dropFtsSyncTriggers(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void foreignKeyCheck(androidx.sqlite.db.SupportSQLiteDatabase r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "tableName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PRAGMA foreign_key_check(`"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r3 = r0.append(r3)
            java.lang.String r0 = "`)"
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            android.database.Cursor r2 = r2.query((java.lang.String) r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 15
            if (r3 <= r0) goto L_0x0050
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = 0
            r0 = r2
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0049 }
            int r1 = r0.getCount()     // Catch:{ all -> 0x0049 }
            if (r1 > 0) goto L_0x003f
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0049 }
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            goto L_0x005b
        L_0x003f:
            java.lang.String r3 = processForeignKeyCheckFailure(r0)     // Catch:{ all -> 0x0049 }
            android.database.sqlite.SQLiteConstraintException r0 = new android.database.sqlite.SQLiteConstraintException     // Catch:{ all -> 0x0049 }
            r0.<init>(r3)     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x004b }
        L_0x004b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        L_0x0050:
            int r3 = r2.getCount()     // Catch:{ all -> 0x0066 }
            if (r3 > 0) goto L_0x005c
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0066 }
            r2.close()
        L_0x005b:
            return
        L_0x005c:
            java.lang.String r3 = processForeignKeyCheckFailure(r2)     // Catch:{ all -> 0x0066 }
            android.database.sqlite.SQLiteConstraintException r0 = new android.database.sqlite.SQLiteConstraintException     // Catch:{ all -> 0x0066 }
            r0.<init>(r3)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r3 = move-exception
            r2.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil.foreignKeyCheck(androidx.sqlite.db.SupportSQLiteDatabase, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        kotlin.io.CloseableKt.closeFinally(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int readVersion(java.io.File r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "databaseFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r9)
            java.nio.channels.FileChannel r9 = r0.getChannel()
            java.io.Closeable r9 = (java.io.Closeable) r9
            r6 = r9
            java.nio.channels.FileChannel r6 = (java.nio.channels.FileChannel) r6     // Catch:{ all -> 0x0040 }
            r7 = 4
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r7)     // Catch:{ all -> 0x0040 }
            r1 = 60
            r3 = 4
            r5 = 1
            r0 = r6
            r0.tryLock(r1, r3, r5)     // Catch:{ all -> 0x0040 }
            r0 = 60
            r6.position(r0)     // Catch:{ all -> 0x0040 }
            int r0 = r6.read(r8)     // Catch:{ all -> 0x0040 }
            if (r0 != r7) goto L_0x0038
            r8.rewind()     // Catch:{ all -> 0x0040 }
            int r0 = r8.getInt()     // Catch:{ all -> 0x0040 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r9, r1)
            return r0
        L_0x0038:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = "Bad database header, unable to read 4 bytes at offset 60"
            r0.<init>(r1)     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil.readVersion(java.io.File):int");
    }

    public static final CancellationSignal createCancellationSignal() {
        if (Build.VERSION.SDK_INT >= 16) {
            return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
        }
        CancellationSignal cancellationSignal = null;
        return null;
    }

    private static final String processForeignKeyCheckFailure(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int count = cursor.getCount();
        Map linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(cursor.getString(0)).append("'.\n");
            }
            String string = cursor.getString(3);
            if (!linkedHashMap.containsKey(string)) {
                Intrinsics.checkNotNullExpressionValue(string, "constraintIndex");
                String string2 = cursor.getString(2);
                Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(2)");
                linkedHashMap.put(string, string2);
            }
        }
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size()).append("\n");
        sb.append("Number of rows in violation: ");
        sb.append(count).append("\n");
        sb.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            sb.append("\tParent Table = ");
            sb.append((String) entry.getValue());
            sb.append(", Foreign Key Constraint Index = ");
            sb.append((String) entry.getKey()).append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
