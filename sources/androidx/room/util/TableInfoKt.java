package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.firebase.messaging.Constants;
import io.sentry.Session;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¨\u0006\u0017"}, d2 = {"readColumns", "", "", "Landroidx/room/util/TableInfo$Column;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readForeignKeyFieldMappings", "", "Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "cursor", "Landroid/database/Cursor;", "readForeignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "readIndex", "Landroidx/room/util/TableInfo$Index;", "name", "unique", "", "readIndices", "readTableInfo", "Landroidx/room/util/TableInfo;", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TableInfo.kt */
public final class TableInfoKt {
    public static final TableInfo readTableInfo(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        Intrinsics.checkNotNullParameter(str, "tableName");
        return new TableInfo(str, readColumns(supportSQLiteDatabase, str), readForeignKeys(supportSQLiteDatabase, str), readIndices(supportSQLiteDatabase, str));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Throwable th;
        Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        if (Build.VERSION.SDK_INT > 15) {
            Closeable closeable = query;
            try {
                Cursor cursor = (Cursor) closeable;
                int columnIndex = cursor.getColumnIndex("id");
                int columnIndex2 = cursor.getColumnIndex(Session.JsonKeys.SEQ);
                int columnIndex3 = cursor.getColumnIndex("table");
                int columnIndex4 = cursor.getColumnIndex("on_delete");
                int columnIndex5 = cursor.getColumnIndex("on_update");
                List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(cursor);
                cursor.moveToPosition(-1);
                Set createSetBuilder = SetsKt.createSetBuilder();
                while (cursor.moveToNext()) {
                    if (cursor.getInt(columnIndex2) == 0) {
                        int i = cursor.getInt(columnIndex);
                        List arrayList = new ArrayList();
                        List arrayList2 = new ArrayList();
                        Collection arrayList3 = new ArrayList();
                        for (Object next : readForeignKeyFieldMappings) {
                            int i2 = columnIndex2;
                            int i3 = columnIndex;
                            if (((TableInfo.ForeignKeyWithSequence) next).getId() == i) {
                                arrayList3.add(next);
                            }
                            columnIndex2 = i2;
                            columnIndex = i3;
                        }
                        int i4 = columnIndex2;
                        int i5 = columnIndex;
                        for (TableInfo.ForeignKeyWithSequence foreignKeyWithSequence : (List) arrayList3) {
                            arrayList.add(foreignKeyWithSequence.getFrom());
                            arrayList2.add(foreignKeyWithSequence.getTo());
                        }
                        String string = cursor.getString(columnIndex3);
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(tableColumnIndex)");
                        String string2 = cursor.getString(columnIndex4);
                        Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(onDeleteColumnIndex)");
                        String string3 = cursor.getString(columnIndex5);
                        Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(onUpdateColumnIndex)");
                        createSetBuilder.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                        columnIndex2 = i4;
                        columnIndex = i5;
                    }
                }
                Set<TableInfo.ForeignKey> build = SetsKt.build(createSetBuilder);
                CloseableKt.closeFinally(closeable, (Throwable) null);
                return build;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                CloseableKt.closeFinally(closeable, th);
                throw th3;
            }
        } else {
            try {
                int columnIndex6 = query.getColumnIndex("id");
                int columnIndex7 = query.getColumnIndex(Session.JsonKeys.SEQ);
                int columnIndex8 = query.getColumnIndex("table");
                int columnIndex9 = query.getColumnIndex("on_delete");
                int columnIndex10 = query.getColumnIndex("on_update");
                List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings2 = readForeignKeyFieldMappings(query);
                query.moveToPosition(-1);
                Set createSetBuilder2 = SetsKt.createSetBuilder();
                while (query.moveToNext()) {
                    if (query.getInt(columnIndex7) == 0) {
                        int i6 = query.getInt(columnIndex6);
                        List arrayList4 = new ArrayList();
                        List arrayList5 = new ArrayList();
                        Collection arrayList6 = new ArrayList();
                        for (Object next2 : readForeignKeyFieldMappings2) {
                            int i7 = columnIndex6;
                            int i8 = columnIndex7;
                            if (((TableInfo.ForeignKeyWithSequence) next2).getId() == i6) {
                                arrayList6.add(next2);
                            }
                            columnIndex6 = i7;
                            columnIndex7 = i8;
                        }
                        int i9 = columnIndex6;
                        int i10 = columnIndex7;
                        for (TableInfo.ForeignKeyWithSequence foreignKeyWithSequence2 : (List) arrayList6) {
                            arrayList4.add(foreignKeyWithSequence2.getFrom());
                            arrayList5.add(foreignKeyWithSequence2.getTo());
                        }
                        String string4 = query.getString(columnIndex8);
                        Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(tableColumnIndex)");
                        String string5 = query.getString(columnIndex9);
                        Intrinsics.checkNotNullExpressionValue(string5, "cursor.getString(onDeleteColumnIndex)");
                        String string6 = query.getString(columnIndex10);
                        Intrinsics.checkNotNullExpressionValue(string6, "cursor.getString(onUpdateColumnIndex)");
                        createSetBuilder2.add(new TableInfo.ForeignKey(string4, string5, string6, arrayList4, arrayList5));
                        columnIndex6 = i9;
                        columnIndex7 = i10;
                    }
                }
                return SetsKt.build(createSetBuilder2);
            } finally {
                query.close();
            }
        }
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(Session.JsonKeys.SEQ);
        int columnIndex3 = cursor.getColumnIndex(Constants.MessagePayloadKeys.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        List createListBuilder = CollectionsKt.createListBuilder();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i2 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(toColumnIndex)");
            createListBuilder.add(new TableInfo.ForeignKeyWithSequence(i, i2, string, string2));
        }
        return CollectionsKt.sorted(CollectionsKt.build(createListBuilder));
    }

    /* JADX INFO: finally extract failed */
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Throwable th;
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        if (Build.VERSION.SDK_INT > 15) {
            Closeable closeable = query;
            try {
                Cursor cursor = (Cursor) closeable;
                if (cursor.getColumnCount() <= 0) {
                    Map<String, TableInfo.Column> emptyMap = MapsKt.emptyMap();
                    CloseableKt.closeFinally(closeable, (Throwable) null);
                    return emptyMap;
                }
                int columnIndex = cursor.getColumnIndex("name");
                int columnIndex2 = cursor.getColumnIndex("type");
                int columnIndex3 = cursor.getColumnIndex("notnull");
                int columnIndex4 = cursor.getColumnIndex("pk");
                int columnIndex5 = cursor.getColumnIndex("dflt_value");
                Map createMapBuilder = MapsKt.createMapBuilder();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(columnIndex);
                    String string2 = cursor.getString(columnIndex2);
                    boolean z = cursor.getInt(columnIndex3) != 0;
                    int i = cursor.getInt(columnIndex4);
                    String string3 = cursor.getString(columnIndex5);
                    Intrinsics.checkNotNullExpressionValue(string, "name");
                    Intrinsics.checkNotNullExpressionValue(string2, "type");
                    TableInfo.Column column = r14;
                    TableInfo.Column column2 = new TableInfo.Column(string, string2, z, i, string3, 2);
                    createMapBuilder.put(string, column2);
                }
                Map<String, TableInfo.Column> build = MapsKt.build(createMapBuilder);
                CloseableKt.closeFinally(closeable, (Throwable) null);
                return build;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                CloseableKt.closeFinally(closeable, th);
                throw th3;
            }
        } else {
            try {
                if (query.getColumnCount() <= 0) {
                    return MapsKt.emptyMap();
                }
                int columnIndex6 = query.getColumnIndex("name");
                int columnIndex7 = query.getColumnIndex("type");
                int columnIndex8 = query.getColumnIndex("notnull");
                int columnIndex9 = query.getColumnIndex("pk");
                int columnIndex10 = query.getColumnIndex("dflt_value");
                Map createMapBuilder2 = MapsKt.createMapBuilder();
                while (query.moveToNext()) {
                    String string4 = query.getString(columnIndex6);
                    String string5 = query.getString(columnIndex7);
                    boolean z2 = query.getInt(columnIndex8) != 0;
                    int i2 = query.getInt(columnIndex9);
                    String string6 = query.getString(columnIndex10);
                    Intrinsics.checkNotNullExpressionValue(string4, "name");
                    Intrinsics.checkNotNullExpressionValue(string5, "type");
                    TableInfo.Column column3 = r12;
                    TableInfo.Column column4 = new TableInfo.Column(string4, string5, z2, i2, string6, 2);
                    createMapBuilder2.put(string4, column3);
                }
                Map<String, TableInfo.Column> build2 = MapsKt.build(createMapBuilder2);
                query.close();
                return build2;
            } finally {
                query.close();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        kotlin.io.CloseableKt.closeFinally(r13, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.Set<androidx.room.util.TableInfo.Index> readIndices(androidx.sqlite.db.SupportSQLiteDatabase r12, java.lang.String r13) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PRAGMA index_list(`"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r13 = r0.append(r13)
            java.lang.String r0 = "`)"
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.String r13 = r13.toString()
            android.database.Cursor r13 = r12.query((java.lang.String) r13)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            java.lang.String r2 = "c"
            java.lang.String r3 = "unique"
            java.lang.String r4 = "origin"
            r5 = 1
            java.lang.String r6 = "name"
            r7 = 0
            r8 = -1
            r9 = 15
            if (r0 <= r9) goto L_0x008d
            java.io.Closeable r13 = (java.io.Closeable) r13
            r0 = r13
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0086 }
            int r9 = r0.getColumnIndex(r6)     // Catch:{ all -> 0x0086 }
            int r4 = r0.getColumnIndex(r4)     // Catch:{ all -> 0x0086 }
            int r3 = r0.getColumnIndex(r3)     // Catch:{ all -> 0x0086 }
            if (r9 == r8) goto L_0x0082
            if (r4 == r8) goto L_0x0082
            if (r3 != r8) goto L_0x0047
            goto L_0x0082
        L_0x0047:
            java.util.Set r8 = kotlin.collections.SetsKt.createSetBuilder()     // Catch:{ all -> 0x0086 }
        L_0x004b:
            boolean r10 = r0.moveToNext()     // Catch:{ all -> 0x0086 }
            if (r10 == 0) goto L_0x007a
            java.lang.String r10 = r0.getString(r4)     // Catch:{ all -> 0x0086 }
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r10)     // Catch:{ all -> 0x0086 }
            if (r10 != 0) goto L_0x005c
            goto L_0x004b
        L_0x005c:
            java.lang.String r10 = r0.getString(r9)     // Catch:{ all -> 0x0086 }
            int r11 = r0.getInt(r3)     // Catch:{ all -> 0x0086 }
            if (r11 != r5) goto L_0x0068
            r11 = r5
            goto L_0x0069
        L_0x0068:
            r11 = r1
        L_0x0069:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r6)     // Catch:{ all -> 0x0086 }
            androidx.room.util.TableInfo$Index r10 = readIndex(r12, r10, r11)     // Catch:{ all -> 0x0086 }
            if (r10 != 0) goto L_0x0076
            kotlin.io.CloseableKt.closeFinally(r13, r7)
            return r7
        L_0x0076:
            r8.add(r10)     // Catch:{ all -> 0x0086 }
            goto L_0x004b
        L_0x007a:
            java.util.Set r12 = kotlin.collections.SetsKt.build(r8)     // Catch:{ all -> 0x0086 }
            kotlin.io.CloseableKt.closeFinally(r13, r7)
            return r12
        L_0x0082:
            kotlin.io.CloseableKt.closeFinally(r13, r7)
            return r7
        L_0x0086:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r13, r12)
            throw r0
        L_0x008d:
            int r0 = r13.getColumnIndex(r6)     // Catch:{ all -> 0x00df }
            int r4 = r13.getColumnIndex(r4)     // Catch:{ all -> 0x00df }
            int r3 = r13.getColumnIndex(r3)     // Catch:{ all -> 0x00df }
            if (r0 == r8) goto L_0x00db
            if (r4 == r8) goto L_0x00db
            if (r3 != r8) goto L_0x00a0
            goto L_0x00db
        L_0x00a0:
            java.util.Set r8 = kotlin.collections.SetsKt.createSetBuilder()     // Catch:{ all -> 0x00df }
        L_0x00a4:
            boolean r9 = r13.moveToNext()     // Catch:{ all -> 0x00df }
            if (r9 == 0) goto L_0x00d3
            java.lang.String r9 = r13.getString(r4)     // Catch:{ all -> 0x00df }
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r9)     // Catch:{ all -> 0x00df }
            if (r9 != 0) goto L_0x00b5
            goto L_0x00a4
        L_0x00b5:
            java.lang.String r9 = r13.getString(r0)     // Catch:{ all -> 0x00df }
            int r10 = r13.getInt(r3)     // Catch:{ all -> 0x00df }
            if (r10 != r5) goto L_0x00c1
            r10 = r5
            goto L_0x00c2
        L_0x00c1:
            r10 = r1
        L_0x00c2:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)     // Catch:{ all -> 0x00df }
            androidx.room.util.TableInfo$Index r9 = readIndex(r12, r9, r10)     // Catch:{ all -> 0x00df }
            if (r9 != 0) goto L_0x00cf
            r13.close()
            return r7
        L_0x00cf:
            r8.add(r9)     // Catch:{ all -> 0x00df }
            goto L_0x00a4
        L_0x00d3:
            java.util.Set r12 = kotlin.collections.SetsKt.build(r8)     // Catch:{ all -> 0x00df }
            r13.close()
            return r12
        L_0x00db:
            r13.close()
            return r7
        L_0x00df:
            r12 = move-exception
            r13.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfoKt.readIndices(androidx.sqlite.db.SupportSQLiteDatabase, java.lang.String):java.util.Set");
    }

    /* JADX INFO: finally extract failed */
    private static final TableInfo.Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        TableInfo.Index index;
        Throwable th;
        String str2;
        Cursor cursor;
        String str3;
        String str4 = str;
        boolean z2 = z;
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str4 + "`)");
        String str5 = "DESC";
        String str6 = "ASC";
        if (Build.VERSION.SDK_INT > 15) {
            Closeable closeable = query;
            try {
                Cursor cursor2 = (Cursor) closeable;
                int columnIndex = cursor2.getColumnIndex("seqno");
                int columnIndex2 = cursor2.getColumnIndex(com.braze.Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
                int columnIndex3 = cursor2.getColumnIndex("name");
                int columnIndex4 = cursor2.getColumnIndex("desc");
                if (!(columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1)) {
                    if (columnIndex4 != -1) {
                        TreeMap treeMap = new TreeMap();
                        TreeMap treeMap2 = new TreeMap();
                        while (cursor2.moveToNext()) {
                            if (cursor2.getInt(columnIndex2) >= 0) {
                                int i = cursor2.getInt(columnIndex);
                                String string = cursor2.getString(columnIndex3);
                                if (cursor2.getInt(columnIndex4) > 0) {
                                    cursor = cursor2;
                                    str3 = str5;
                                    str2 = str3;
                                } else {
                                    cursor = cursor2;
                                    str2 = str5;
                                    str3 = str6;
                                }
                                Integer valueOf = Integer.valueOf(i);
                                Intrinsics.checkNotNullExpressionValue(string, "columnName");
                                treeMap.put(valueOf, string);
                                treeMap2.put(Integer.valueOf(i), str3);
                                cursor2 = cursor;
                                str5 = str2;
                                str6 = str6;
                            }
                        }
                        Collection values = treeMap.values();
                        Intrinsics.checkNotNullExpressionValue(values, "columnsMap.values");
                        List list = CollectionsKt.toList(values);
                        Collection values2 = treeMap2.values();
                        Intrinsics.checkNotNullExpressionValue(values2, "ordersMap.values");
                        index = new TableInfo.Index(str4, z2, list, CollectionsKt.toList(values2));
                        CloseableKt.closeFinally(closeable, (Throwable) null);
                    }
                }
                CloseableKt.closeFinally(closeable, (Throwable) null);
                return null;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                CloseableKt.closeFinally(closeable, th);
                throw th3;
            }
        } else {
            String str7 = str5;
            String str8 = str6;
            try {
                int columnIndex5 = query.getColumnIndex("seqno");
                int columnIndex6 = query.getColumnIndex(com.braze.Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY);
                int columnIndex7 = query.getColumnIndex("name");
                int columnIndex8 = query.getColumnIndex("desc");
                if (!(columnIndex5 == -1 || columnIndex6 == -1 || columnIndex7 == -1)) {
                    if (columnIndex8 != -1) {
                        TreeMap treeMap3 = new TreeMap();
                        TreeMap treeMap4 = new TreeMap();
                        while (query.moveToNext()) {
                            if (query.getInt(columnIndex6) >= 0) {
                                int i2 = query.getInt(columnIndex5);
                                String string2 = query.getString(columnIndex7);
                                String str9 = query.getInt(columnIndex8) > 0 ? str7 : str8;
                                Integer valueOf2 = Integer.valueOf(i2);
                                Intrinsics.checkNotNullExpressionValue(string2, "columnName");
                                treeMap3.put(valueOf2, string2);
                                treeMap4.put(Integer.valueOf(i2), str9);
                                columnIndex5 = columnIndex5;
                            }
                        }
                        Collection values3 = treeMap3.values();
                        Intrinsics.checkNotNullExpressionValue(values3, "columnsMap.values");
                        List list2 = CollectionsKt.toList(values3);
                        Collection values4 = treeMap4.values();
                        Intrinsics.checkNotNullExpressionValue(values4, "ordersMap.values");
                        index = new TableInfo.Index(str4, z2, list2, CollectionsKt.toList(values4));
                        query.close();
                    }
                }
                query.close();
                return null;
            } catch (Throwable th4) {
                query.close();
                throw th4;
            }
        }
        return index;
    }
}
