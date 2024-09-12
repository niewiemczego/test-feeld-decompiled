package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AutoClosingRoomOpenHelper.kt */
/* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 extends PropertyReference1Impl {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1();

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1() {
        super(SupportSQLiteDatabase.class, "maximumSize", "getMaximumSize()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
    }
}
