package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"androidx/room/SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onOpen", "onUpgrade", "oldVersion", "", "newVersion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SQLiteCopyOpenHelper.kt */
public final class SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1 extends SupportSQLiteOpenHelper.Callback {
    final /* synthetic */ int $version;

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
    }

    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(int i, int i2) {
        super(i2);
        this.$version = i;
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        int i = this.$version;
        if (i < 1) {
            supportSQLiteDatabase.setVersion(i);
        }
    }
}
