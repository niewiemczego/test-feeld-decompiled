package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0095 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ba A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d9 A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ec A[Catch:{ all -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<androidx.work.impl.model.WorkSpec.WorkInfoPojo> getWorkInfoPojos(androidx.sqlite.db.SupportSQLiteQuery r22) {
        /*
            r21 = this;
            r1 = r21
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r2 = 1
            r3 = 0
            r4 = r22
            android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r4, r2, r3)
            java.lang.String r0 = "id"
            int r0 = androidx.room.util.CursorUtil.getColumnIndex(r2, r0)     // Catch:{ all -> 0x0102 }
            java.lang.String r4 = "state"
            int r4 = androidx.room.util.CursorUtil.getColumnIndex(r2, r4)     // Catch:{ all -> 0x0102 }
            java.lang.String r5 = "output"
            int r5 = androidx.room.util.CursorUtil.getColumnIndex(r2, r5)     // Catch:{ all -> 0x0102 }
            java.lang.String r6 = "run_attempt_count"
            int r6 = androidx.room.util.CursorUtil.getColumnIndex(r2, r6)     // Catch:{ all -> 0x0102 }
            java.lang.String r7 = "generation"
            int r7 = androidx.room.util.CursorUtil.getColumnIndex(r2, r7)     // Catch:{ all -> 0x0102 }
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0102 }
            r8.<init>()     // Catch:{ all -> 0x0102 }
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0102 }
            r9.<init>()     // Catch:{ all -> 0x0102 }
        L_0x0039:
            boolean r10 = r2.moveToNext()     // Catch:{ all -> 0x0102 }
            if (r10 == 0) goto L_0x0068
            java.lang.String r10 = r2.getString(r0)     // Catch:{ all -> 0x0102 }
            java.lang.Object r11 = r8.get(r10)     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x0102 }
            if (r11 != 0) goto L_0x0053
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r11.<init>()     // Catch:{ all -> 0x0102 }
            r8.put(r10, r11)     // Catch:{ all -> 0x0102 }
        L_0x0053:
            java.lang.String r10 = r2.getString(r0)     // Catch:{ all -> 0x0102 }
            java.lang.Object r11 = r9.get(r10)     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x0102 }
            if (r11 != 0) goto L_0x0039
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r11.<init>()     // Catch:{ all -> 0x0102 }
            r9.put(r10, r11)     // Catch:{ all -> 0x0102 }
            goto L_0x0039
        L_0x0068:
            r10 = -1
            r2.moveToPosition(r10)     // Catch:{ all -> 0x0102 }
            r1.__fetchRelationshipWorkTagAsjavaLangString(r8)     // Catch:{ all -> 0x0102 }
            r1.__fetchRelationshipWorkProgressAsandroidxWorkData(r9)     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            int r12 = r2.getCount()     // Catch:{ all -> 0x0102 }
            r11.<init>(r12)     // Catch:{ all -> 0x0102 }
        L_0x007b:
            boolean r12 = r2.moveToNext()     // Catch:{ all -> 0x0102 }
            if (r12 == 0) goto L_0x00fe
            if (r0 != r10) goto L_0x0085
        L_0x0083:
            r14 = r3
            goto L_0x0091
        L_0x0085:
            boolean r12 = r2.isNull(r0)     // Catch:{ all -> 0x0102 }
            if (r12 == 0) goto L_0x008c
            goto L_0x0083
        L_0x008c:
            java.lang.String r12 = r2.getString(r0)     // Catch:{ all -> 0x0102 }
            r14 = r12
        L_0x0091:
            if (r4 != r10) goto L_0x0095
            r15 = r3
            goto L_0x00a0
        L_0x0095:
            int r12 = r2.getInt(r4)     // Catch:{ all -> 0x0102 }
            androidx.work.impl.model.WorkTypeConverters r13 = androidx.work.impl.model.WorkTypeConverters.INSTANCE     // Catch:{ all -> 0x0102 }
            androidx.work.WorkInfo$State r12 = androidx.work.impl.model.WorkTypeConverters.intToState(r12)     // Catch:{ all -> 0x0102 }
            r15 = r12
        L_0x00a0:
            if (r5 != r10) goto L_0x00a5
            r16 = r3
            goto L_0x00b7
        L_0x00a5:
            boolean r12 = r2.isNull(r5)     // Catch:{ all -> 0x0102 }
            if (r12 == 0) goto L_0x00ad
            r12 = r3
            goto L_0x00b1
        L_0x00ad:
            byte[] r12 = r2.getBlob(r5)     // Catch:{ all -> 0x0102 }
        L_0x00b1:
            androidx.work.Data r12 = androidx.work.Data.fromByteArray(r12)     // Catch:{ all -> 0x0102 }
            r16 = r12
        L_0x00b7:
            r12 = 0
            if (r6 != r10) goto L_0x00bd
            r17 = r12
            goto L_0x00c3
        L_0x00bd:
            int r13 = r2.getInt(r6)     // Catch:{ all -> 0x0102 }
            r17 = r13
        L_0x00c3:
            if (r7 != r10) goto L_0x00c8
        L_0x00c5:
            r18 = r12
            goto L_0x00cd
        L_0x00c8:
            int r12 = r2.getInt(r7)     // Catch:{ all -> 0x0102 }
            goto L_0x00c5
        L_0x00cd:
            java.lang.String r12 = r2.getString(r0)     // Catch:{ all -> 0x0102 }
            java.lang.Object r12 = r8.get(r12)     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x0102 }
            if (r12 != 0) goto L_0x00de
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r12.<init>()     // Catch:{ all -> 0x0102 }
        L_0x00de:
            r19 = r12
            java.lang.String r12 = r2.getString(r0)     // Catch:{ all -> 0x0102 }
            java.lang.Object r12 = r9.get(r12)     // Catch:{ all -> 0x0102 }
            java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x0102 }
            if (r12 != 0) goto L_0x00f1
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x0102 }
            r12.<init>()     // Catch:{ all -> 0x0102 }
        L_0x00f1:
            r20 = r12
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r12 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x0102 }
            r13 = r12
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0102 }
            r11.add(r12)     // Catch:{ all -> 0x0102 }
            goto L_0x007b
        L_0x00fe:
            r2.close()
            return r11
        L_0x0102:
            r0 = move-exception
            r2.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.getWorkInfoPojos(androidx.sqlite.db.SupportSQLiteQuery):java.util.List");
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0096 A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0098 A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5 A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8 A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00c0 A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00ef A[Catch:{ all -> 0x0105 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x00f4 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<androidx.work.impl.model.WorkSpec.WorkInfoPojo> call() throws java.lang.Exception {
                /*
                    r21 = this;
                    r1 = r21
                    androidx.work.impl.model.RawWorkInfoDao_Impl r0 = androidx.work.impl.model.RawWorkInfoDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.sqlite.db.SupportSQLiteQuery r2 = r5
                    r3 = 1
                    r4 = 0
                    android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)
                    java.lang.String r0 = "id"
                    int r0 = androidx.room.util.CursorUtil.getColumnIndex(r2, r0)     // Catch:{ all -> 0x0105 }
                    java.lang.String r3 = "state"
                    int r3 = androidx.room.util.CursorUtil.getColumnIndex(r2, r3)     // Catch:{ all -> 0x0105 }
                    java.lang.String r5 = "output"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndex(r2, r5)     // Catch:{ all -> 0x0105 }
                    java.lang.String r6 = "run_attempt_count"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndex(r2, r6)     // Catch:{ all -> 0x0105 }
                    java.lang.String r7 = "generation"
                    int r7 = androidx.room.util.CursorUtil.getColumnIndex(r2, r7)     // Catch:{ all -> 0x0105 }
                    androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0105 }
                    r8.<init>()     // Catch:{ all -> 0x0105 }
                    androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0105 }
                    r9.<init>()     // Catch:{ all -> 0x0105 }
                L_0x0038:
                    boolean r10 = r2.moveToNext()     // Catch:{ all -> 0x0105 }
                    if (r10 == 0) goto L_0x0067
                    java.lang.String r10 = r2.getString(r0)     // Catch:{ all -> 0x0105 }
                    java.lang.Object r11 = r8.get(r10)     // Catch:{ all -> 0x0105 }
                    java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x0105 }
                    if (r11 != 0) goto L_0x0052
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
                    r11.<init>()     // Catch:{ all -> 0x0105 }
                    r8.put(r10, r11)     // Catch:{ all -> 0x0105 }
                L_0x0052:
                    java.lang.String r10 = r2.getString(r0)     // Catch:{ all -> 0x0105 }
                    java.lang.Object r11 = r9.get(r10)     // Catch:{ all -> 0x0105 }
                    java.util.ArrayList r11 = (java.util.ArrayList) r11     // Catch:{ all -> 0x0105 }
                    if (r11 != 0) goto L_0x0038
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
                    r11.<init>()     // Catch:{ all -> 0x0105 }
                    r9.put(r10, r11)     // Catch:{ all -> 0x0105 }
                    goto L_0x0038
                L_0x0067:
                    r10 = -1
                    r2.moveToPosition(r10)     // Catch:{ all -> 0x0105 }
                    androidx.work.impl.model.RawWorkInfoDao_Impl r11 = androidx.work.impl.model.RawWorkInfoDao_Impl.this     // Catch:{ all -> 0x0105 }
                    r11.__fetchRelationshipWorkTagAsjavaLangString(r8)     // Catch:{ all -> 0x0105 }
                    androidx.work.impl.model.RawWorkInfoDao_Impl r11 = androidx.work.impl.model.RawWorkInfoDao_Impl.this     // Catch:{ all -> 0x0105 }
                    r11.__fetchRelationshipWorkProgressAsandroidxWorkData(r9)     // Catch:{ all -> 0x0105 }
                    java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
                    int r12 = r2.getCount()     // Catch:{ all -> 0x0105 }
                    r11.<init>(r12)     // Catch:{ all -> 0x0105 }
                L_0x007e:
                    boolean r12 = r2.moveToNext()     // Catch:{ all -> 0x0105 }
                    if (r12 == 0) goto L_0x0101
                    if (r0 != r10) goto L_0x0088
                L_0x0086:
                    r14 = r4
                    goto L_0x0094
                L_0x0088:
                    boolean r12 = r2.isNull(r0)     // Catch:{ all -> 0x0105 }
                    if (r12 == 0) goto L_0x008f
                    goto L_0x0086
                L_0x008f:
                    java.lang.String r12 = r2.getString(r0)     // Catch:{ all -> 0x0105 }
                    r14 = r12
                L_0x0094:
                    if (r3 != r10) goto L_0x0098
                    r15 = r4
                    goto L_0x00a3
                L_0x0098:
                    int r12 = r2.getInt(r3)     // Catch:{ all -> 0x0105 }
                    androidx.work.impl.model.WorkTypeConverters r13 = androidx.work.impl.model.WorkTypeConverters.INSTANCE     // Catch:{ all -> 0x0105 }
                    androidx.work.WorkInfo$State r12 = androidx.work.impl.model.WorkTypeConverters.intToState(r12)     // Catch:{ all -> 0x0105 }
                    r15 = r12
                L_0x00a3:
                    if (r5 != r10) goto L_0x00a8
                    r16 = r4
                    goto L_0x00ba
                L_0x00a8:
                    boolean r12 = r2.isNull(r5)     // Catch:{ all -> 0x0105 }
                    if (r12 == 0) goto L_0x00b0
                    r12 = r4
                    goto L_0x00b4
                L_0x00b0:
                    byte[] r12 = r2.getBlob(r5)     // Catch:{ all -> 0x0105 }
                L_0x00b4:
                    androidx.work.Data r12 = androidx.work.Data.fromByteArray(r12)     // Catch:{ all -> 0x0105 }
                    r16 = r12
                L_0x00ba:
                    r12 = 0
                    if (r6 != r10) goto L_0x00c0
                    r17 = r12
                    goto L_0x00c6
                L_0x00c0:
                    int r13 = r2.getInt(r6)     // Catch:{ all -> 0x0105 }
                    r17 = r13
                L_0x00c6:
                    if (r7 != r10) goto L_0x00cb
                L_0x00c8:
                    r18 = r12
                    goto L_0x00d0
                L_0x00cb:
                    int r12 = r2.getInt(r7)     // Catch:{ all -> 0x0105 }
                    goto L_0x00c8
                L_0x00d0:
                    java.lang.String r12 = r2.getString(r0)     // Catch:{ all -> 0x0105 }
                    java.lang.Object r12 = r8.get(r12)     // Catch:{ all -> 0x0105 }
                    java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x0105 }
                    if (r12 != 0) goto L_0x00e1
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
                    r12.<init>()     // Catch:{ all -> 0x0105 }
                L_0x00e1:
                    r19 = r12
                    java.lang.String r12 = r2.getString(r0)     // Catch:{ all -> 0x0105 }
                    java.lang.Object r12 = r9.get(r12)     // Catch:{ all -> 0x0105 }
                    java.util.ArrayList r12 = (java.util.ArrayList) r12     // Catch:{ all -> 0x0105 }
                    if (r12 != 0) goto L_0x00f4
                    java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
                    r12.<init>()     // Catch:{ all -> 0x0105 }
                L_0x00f4:
                    r20 = r12
                    androidx.work.impl.model.WorkSpec$WorkInfoPojo r12 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x0105 }
                    r13 = r12
                    r13.<init>(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0105 }
                    r11.add(r12)     // Catch:{ all -> 0x0105 }
                    goto L_0x007e
                L_0x0101:
                    r2.close()
                    return r11
                L_0x0105:
                    r0 = move-exception
                    r2.close()
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.RawWorkInfoDao_Impl.AnonymousClass1.call():java.util.List");
            }
        });
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        String str;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap(999);
                int size = arrayMap.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    arrayMap2.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
                    i++;
                    i2++;
                    if (i2 == 999) {
                        __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                        arrayMap2 = new ArrayMap(999);
                        i2 = 0;
                    }
                }
                if (i2 > 0) {
                    __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = arrayMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (query.isNull(0)) {
                                str = null;
                            } else {
                                str = query.getString(0);
                            }
                            arrayList.add(str);
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> arrayMap) {
        byte[] bArr;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap(999);
                int size = arrayMap.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    arrayMap2.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
                    i++;
                    i2++;
                    if (i2 == 999) {
                        __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                        arrayMap2 = new ArrayMap(999);
                        i2 = 0;
                    }
                }
                if (i2 > 0) {
                    __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = arrayMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (query.isNull(0)) {
                                bArr = null;
                            } else {
                                bArr = query.getBlob(0);
                            }
                            arrayList.add(Data.fromByteArray(bArr));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }
}
