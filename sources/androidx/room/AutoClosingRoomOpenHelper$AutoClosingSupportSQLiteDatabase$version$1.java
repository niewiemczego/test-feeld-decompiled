package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AutoClosingRoomOpenHelper.kt */
/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 extends MutablePropertyReference1Impl {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1() {
        super(SupportSQLiteDatabase.class, "version", "getVersion()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
    }

    public void set(Object obj, Object obj2) {
        ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
    }
}
