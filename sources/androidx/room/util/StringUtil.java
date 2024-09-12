package androidx.room.util;

import android.util.Log;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0018\u0010\f\u001a\u0004\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u001a\u0006\u0010\u000f\u001a\u00020\t\u001a\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002\" \u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0005\u0012\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"EMPTY_STRING_ARRAY", "", "", "getEMPTY_STRING_ARRAY$annotations", "()V", "[Ljava/lang/String;", "appendPlaceholders", "", "builder", "Ljava/lang/StringBuilder;", "count", "", "joinIntoString", "input", "", "newStringBuilder", "splitToIntList", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: StringUtil.kt */
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final void appendPlaceholders(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "builder");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("?");
            if (i2 < i - 1) {
                sb.append(",");
            }
        }
    }

    public static final List<Integer> splitToIntList(String str) {
        List<String> split$default;
        Integer num;
        if (str == null || (split$default = StringsKt.split$default((CharSequence) str, new char[]{','}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (String parseInt : split$default) {
            try {
                num = Integer.valueOf(Integer.parseInt(parseInt));
            } catch (NumberFormatException e) {
                Log.e(Room.LOG_TAG, "Malformed integer list", e);
                Integer num2 = null;
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        return (List) arrayList;
    }

    public static final String joinIntoString(List<Integer> list) {
        if (list != null) {
            return CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return null;
    }
}
