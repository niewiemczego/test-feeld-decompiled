package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/room/util/CursorUtil$wrapMappedColumns$2", "Landroid/database/CursorWrapper;", "getColumnIndex", "", "columnName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CursorUtil.kt */
public final class CursorUtil$wrapMappedColumns$2 extends CursorWrapper {
    final /* synthetic */ String[] $columnNames;
    final /* synthetic */ int[] $mapping;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CursorUtil$wrapMappedColumns$2(Cursor cursor, String[] strArr, int[] iArr) {
        super(cursor);
        this.$columnNames = strArr;
        this.$mapping = iArr;
    }

    public int getColumnIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "columnName");
        String[] strArr = this.$columnNames;
        int[] iArr = this.$mapping;
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            if (StringsKt.equals(strArr[i], str, true)) {
                return iArr[i2];
            }
            i++;
            i2 = i3;
        }
        return super.getColumnIndex(str);
    }
}
