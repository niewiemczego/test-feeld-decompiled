package com.braze.support;

import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static final b a = new b();
    private static final List b = CollectionsKt.listOf("$add", "$remove", "$update", "$identifier_key", "$identifier_value", "$new_object");

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Object obj) {
            super(0);
            this.b = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error parsing date " + this.b;
        }
    }

    /* renamed from: com.braze.support.b$b  reason: collision with other inner class name */
    static final class C0034b extends Lambda implements Function0 {
        final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0034b(Object obj) {
            super(0);
            this.b = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "JSON Object size (" + this.b.toString().length() + " bytes) exceeds 76800";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Object obj) {
            super(0);
            this.b = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "JSON Array size (" + this.b.toString().length() + " bytes) exceeds 76800";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Object obj) {
            super(0);
            this.b = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not add unsupported custom attribute type with value: " + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "JSON Object nested too deep (limit 50). Returning null.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "JSON Object nested too deep (limit 50). Returning null.";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Nested Custom Attribute Key '" + this.b + "' is invalid.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be null.";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be blocklisted attribute: " + this.b + '.';
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute value cannot be null.";
        }
    }

    private b() {
    }

    public static final boolean a(String str, Set set) {
        Intrinsics.checkNotNullParameter(set, "blocklistedAttributes");
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) a, BrazeLogger.Priority.W, (Throwable) null, (Function0) h.b, 2, (Object) null);
            return false;
        } else if (!set.contains(str)) {
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) a, BrazeLogger.Priority.W, (Throwable) null, (Function0) new i(str), 2, (Object) null);
            return false;
        }
    }

    public static final boolean b(String str) {
        if (str != null) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) a, BrazeLogger.Priority.W, (Throwable) null, (Function0) j.b, 2, (Object) null);
        return false;
    }

    private final boolean a(String str) {
        return (!b.contains(str)) & (StringsKt.isBlank(str) | StringsKt.contains$default((CharSequence) str, (CharSequence) "$", false, 2, (Object) null) | StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null));
    }

    private final JSONObject a(JSONObject jSONObject, int i2) {
        if (i2 > 50) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) f.b, 3, (Object) null);
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            String ensureBrazeFieldLength = ValidationUtils.ensureBrazeFieldLength(next);
            b bVar = a;
            if (bVar.a(ensureBrazeFieldLength)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) bVar, BrazeLogger.Priority.W, (Throwable) null, (Function0) new g(next), 2, (Object) null);
            }
            if (!StringsKt.isBlank(ensureBrazeFieldLength)) {
                if (jSONObject.isNull(next)) {
                    jSONObject2.put(next, JSONObject.NULL);
                } else {
                    Object obj = jSONObject.get(next);
                    Intrinsics.checkNotNullExpressionValue(obj, "json.get(key)");
                    Object a2 = bVar.a(obj, i2);
                    if (a2 == null) {
                        return null;
                    }
                    jSONObject2.put(ensureBrazeFieldLength, a2);
                }
            }
        }
        return jSONObject2;
    }

    private final JSONArray a(JSONArray jSONArray, int i2) {
        if (i2 > 50) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) e.b, 3, (Object) null);
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = jSONArray.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj, "jsonArray.get(i)");
            Object a2 = a(obj, i2);
            if (a2 == null) {
                return null;
            }
            jSONArray2.put(a2);
        }
        return jSONArray2;
    }

    public static /* synthetic */ Object a(b bVar, Object obj, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return bVar.a(obj, i2);
    }

    public final Object a(Object obj, int i2) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (obj instanceof Boolean ? true : obj instanceof Integer ? true : obj instanceof Float ? true : obj instanceof Long ? true : obj instanceof Double) {
            return obj;
        }
        if (obj instanceof String) {
            return ValidationUtils.ensureBrazeFieldLength((String) obj);
        }
        if (obj instanceof Date) {
            try {
                return DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, (TimeZone) null, 2, (Object) null);
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new a(obj));
            }
        } else {
            if (obj instanceof JSONObject) {
                if (i2 != 0 || obj.toString().length() <= 76800) {
                    return a((JSONObject) obj, i2 + 1);
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new C0034b(obj), 2, (Object) null);
            } else if (!(obj instanceof JSONArray)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new d(obj), 2, (Object) null);
            } else if (i2 != 0 || obj.toString().length() <= 76800) {
                return a((JSONArray) obj, i2 + 1);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new c(obj), 2, (Object) null);
            }
            return null;
        }
    }

    public static final String[] a(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "values");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String ensureBrazeFieldLength : strArr) {
            arrayList.add(ValidationUtils.ensureBrazeFieldLength(ensureBrazeFieldLength));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
