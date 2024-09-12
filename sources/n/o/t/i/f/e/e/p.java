package n.o.t.i.f.e.e;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class p implements o {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<q> b;
    public final EntityDeletionOrUpdateAdapter<q> c;
    public final SharedSQLiteStatement d;
    public final SharedSQLiteStatement e;

    public class a extends EntityInsertionAdapter<q> {
        public a(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            Integer num;
            q qVar = (q) obj;
            String str = qVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            byte[] bArr = qVar.b;
            if (bArr == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindBlob(2, bArr);
            }
            byte[] bArr2 = qVar.c;
            if (bArr2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindBlob(3, bArr2);
            }
            Boolean bool = qVar.d;
            if (bool == null) {
                num = null;
            } else {
                num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            if (num == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindLong(4, (long) num.intValue());
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `work_data` (`id`,`notification`,`trigger`,`with_alarm_manager`) VALUES (?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<q> {
        public b(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public void bind(SupportSQLiteStatement supportSQLiteStatement, Object obj) {
            Integer num;
            q qVar = (q) obj;
            String str = qVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            byte[] bArr = qVar.b;
            if (bArr == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindBlob(2, bArr);
            }
            byte[] bArr2 = qVar.c;
            if (bArr2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindBlob(3, bArr2);
            }
            Boolean bool = qVar.d;
            if (bool == null) {
                num = null;
            } else {
                num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            if (num == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindLong(4, (long) num.intValue());
            }
            String str2 = qVar.a;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str2);
            }
        }

        public String createQuery() {
            return "UPDATE OR REPLACE `work_data` SET `id` = ?,`notification` = ?,`trigger` = ?,`with_alarm_manager` = ? WHERE `id` = ?";
        }
    }

    public class c extends SharedSQLiteStatement {
        public c(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM work_data";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(p pVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM work_data WHERE id = ?";
        }
    }

    public p(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(this, roomDatabase);
        this.c = new b(this, roomDatabase);
        this.d = new c(this, roomDatabase);
        this.e = new d(this, roomDatabase);
    }

    public void a(q qVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(qVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void b(q qVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.c.handle(qVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public void a(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.e.release(acquire);
        }
    }

    public void b() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: n.o.t.i.f.e.e.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n.o.t.i.f.e.e.q b(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "SELECT * from work_data WHERE id = ?"
            r1 = 1
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            if (r10 != 0) goto L_0x000d
            r0.bindNull(r1)
            goto L_0x0010
        L_0x000d:
            r0.bindString(r1, r10)
        L_0x0010:
            androidx.room.RoomDatabase r10 = r9.a
            r10.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r10 = r9.a
            r2 = 0
            r3 = 0
            android.database.Cursor r10 = androidx.room.util.DBUtil.query(r10, r0, r2, r3)
            java.lang.String r4 = "id"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r10, r4)     // Catch:{ all -> 0x008d }
            java.lang.String r5 = "notification"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r10, r5)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "trigger"
            int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r10, r6)     // Catch:{ all -> 0x008d }
            java.lang.String r7 = "with_alarm_manager"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r10, r7)     // Catch:{ all -> 0x008d }
            boolean r8 = r10.moveToFirst()     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x0086
            boolean r8 = r10.isNull(r4)     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x0045
            r4 = r3
            goto L_0x0049
        L_0x0045:
            java.lang.String r4 = r10.getString(r4)     // Catch:{ all -> 0x008d }
        L_0x0049:
            boolean r8 = r10.isNull(r5)     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x0051
            r5 = r3
            goto L_0x0055
        L_0x0051:
            byte[] r5 = r10.getBlob(r5)     // Catch:{ all -> 0x008d }
        L_0x0055:
            boolean r8 = r10.isNull(r6)     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x005d
            r6 = r3
            goto L_0x0061
        L_0x005d:
            byte[] r6 = r10.getBlob(r6)     // Catch:{ all -> 0x008d }
        L_0x0061:
            boolean r8 = r10.isNull(r7)     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x0069
            r7 = r3
            goto L_0x0071
        L_0x0069:
            int r7 = r10.getInt(r7)     // Catch:{ all -> 0x008d }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x008d }
        L_0x0071:
            if (r7 != 0) goto L_0x0074
            goto L_0x0080
        L_0x0074:
            int r3 = r7.intValue()     // Catch:{ all -> 0x008d }
            if (r3 == 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r1 = r2
        L_0x007c:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x008d }
        L_0x0080:
            n.o.t.i.f.e.e.q r1 = new n.o.t.i.f.e.e.q     // Catch:{ all -> 0x008d }
            r1.<init>(r4, r5, r6, r3)     // Catch:{ all -> 0x008d }
            r3 = r1
        L_0x0086:
            r10.close()
            r0.release()
            return r3
        L_0x008d:
            r1 = move-exception
            r10.close()
            r0.release()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n.o.t.i.f.e.e.p.b(java.lang.String):n.o.t.i.f.e.e.q");
    }

    public List<q> a(Boolean bool) {
        Integer num;
        String str;
        byte[] bArr;
        byte[] bArr2;
        Integer num2;
        Boolean bool2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM work_data WHERE with_alarm_manager = ?", 1);
        if (bool == null) {
            num = null;
        } else {
            num = Integer.valueOf(bool.booleanValue() ? 1 : 0);
        }
        if (num == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindLong(1, (long) num.intValue());
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "notification");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "trigger");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "with_alarm_manager");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    bArr2 = null;
                } else {
                    bArr2 = query.getBlob(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(query.getInt(columnIndexOrThrow4));
                }
                if (num2 == null) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(num2.intValue() != 0);
                }
                arrayList.add(new q(str, bArr, bArr2, bool2));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<q> a() {
        String str;
        byte[] bArr;
        byte[] bArr2;
        Integer num;
        Boolean bool;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM work_data", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "notification");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "trigger");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "with_alarm_manager");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(columnIndexOrThrow)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow);
                }
                if (query.isNull(columnIndexOrThrow2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    bArr2 = null;
                } else {
                    bArr2 = query.getBlob(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(columnIndexOrThrow4));
                }
                if (num == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(num.intValue() != 0);
                }
                arrayList.add(new q(str, bArr, bArr2, bool));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void a(List<String> list) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM work_data WHERE id in (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (String next : list) {
            if (next == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, next);
            }
            i++;
        }
        this.a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
