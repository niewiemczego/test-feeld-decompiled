package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0001J\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0001J\u0011\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001J\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000eH\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u0001¨\u0006\u0011"}, d2 = {"androidx/room/RoomSQLiteQuery$Companion$copyFrom$1", "Landroidx/sqlite/db/SupportSQLiteProgram;", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "", "clearBindings", "close", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoomSQLiteQuery.kt */
public final class RoomSQLiteQuery$Companion$copyFrom$1 implements SupportSQLiteProgram {
    private final /* synthetic */ RoomSQLiteQuery $$delegate_0;

    public void bindBlob(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "value");
        this.$$delegate_0.bindBlob(i, bArr);
    }

    public void bindDouble(int i, double d) {
        this.$$delegate_0.bindDouble(i, d);
    }

    public void bindLong(int i, long j) {
        this.$$delegate_0.bindLong(i, j);
    }

    public void bindNull(int i) {
        this.$$delegate_0.bindNull(i);
    }

    public void bindString(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.$$delegate_0.bindString(i, str);
    }

    public void clearBindings() {
        this.$$delegate_0.clearBindings();
    }

    public void close() {
        this.$$delegate_0.close();
    }

    RoomSQLiteQuery$Companion$copyFrom$1(RoomSQLiteQuery roomSQLiteQuery) {
        this.$$delegate_0 = roomSQLiteQuery;
    }
}
