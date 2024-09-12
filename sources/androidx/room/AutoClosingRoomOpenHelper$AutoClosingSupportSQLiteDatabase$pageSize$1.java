package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AutoClosingRoomOpenHelper.kt */
/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 extends MutablePropertyReference1Impl {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1() {
        super(SupportSQLiteDatabase.class, "pageSize", "getPageSize()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
    }

    public void set(Object obj, Object obj2) {
        ((SupportSQLiteDatabase) obj).setPageSize(((Number) obj2).longValue());
    }
}
