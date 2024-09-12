package bo.app;

import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class q {

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(List list) {
            super(0);
            this.b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Removing non-string keys from map. Removed keys: " + this.b;
        }
    }

    public static final Map a(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Set keySet = map.keySet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : keySet) {
            if (next instanceof String) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        List list = (List) new Pair(arrayList, arrayList2).component2();
        if (!list.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) map, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(list), 2, (Object) null);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() instanceof String) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object value = entry2.getValue();
            if ((value instanceof Date) || (value instanceof Map) || (value instanceof Long) || (value instanceof Integer) || (value instanceof Double) || (value instanceof Boolean) || (value instanceof String) || (value instanceof JSONObject) || (value instanceof JSONArray) || value == null) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            Object key = entry3.getKey();
            Object value2 = entry3.getValue();
            if (value2 instanceof Date) {
                value2 = DateTimeUtils.formatDate$default((Date) value2, BrazeDateFormat.LONG, (TimeZone) null, 2, (Object) null);
            } else if (value2 instanceof JSONArray) {
                value2 = a((JSONArray) value2);
            } else if (value2 instanceof Map) {
                value2 = a((Map) value2);
            }
            linkedHashMap3.put(key, value2);
        }
        return linkedHashMap3;
    }

    public static final JSONArray a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof Date) {
                jSONArray2.put((Object) DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, (TimeZone) null, 2, (Object) null));
            } else if (obj instanceof JSONArray) {
                jSONArray2.put((Object) a((JSONArray) obj));
            } else if (obj instanceof Map) {
                jSONArray2.put((Object) a((Map) obj));
            } else {
                jSONArray2.put(obj);
            }
        }
        return jSONArray2;
    }
}
