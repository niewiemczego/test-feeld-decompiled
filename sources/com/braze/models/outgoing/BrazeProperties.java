package com.braze.models.outgoing;

import bo.app.q;
import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import com.braze.Constants;
import com.braze.enums.BrazeDateFormat;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\t\b\u0016¢\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001fB\u001b\b\u0016\u0012\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030 ¢\u0006\u0004\b\u001d\u0010\"J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/braze/models/outgoing/BrazeProperties;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "jsonObject", "", "doKeyValidation", "clean", "", "key", "", "value", "addProperty", "clone", "containsProperty", "removeProperty", "get", "forJsonPut", "propertiesJSONObject", "Lorg/json/JSONObject;", "", "getSize", "()I", "size", "isInvalid", "()Z", "", "getByteSize", "()J", "byteSize", "<init>", "()V", "(Lorg/json/JSONObject;)V", "", "map", "(Ljava/util/Map;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class BrazeProperties implements IPutIntoJson<JSONObject> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private JSONObject propertiesJSONObject = new JSONObject();

    public static final class a {

        /* renamed from: com.braze.models.outgoing.BrazeProperties$a$a  reason: collision with other inner class name */
        static final class C0032a extends Lambda implements Function0 {
            public static final C0032a b = new C0032a();

            C0032a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "The BrazeProperties key cannot be null or contain only whitespaces. Not adding property.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "The leading character in the key string may not be '$'. Not adding property.";
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            if (StringsKt.isBlank(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) C0032a.b, 2, (Object) null);
                return false;
            } else if (!StringsKt.startsWith$default(str, "$", false, 2, (Object) null)) {
                return true;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
                return false;
            }
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Value type is not supported. Cannot add property " + this.b + '.';
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught json exception trying to add property.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to clone BrazeProperties";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught json exception trying to get property.";
        }
    }

    public BrazeProperties() {
    }

    private final JSONObject clean(JSONObject jSONObject, boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "jsonObjectIterator.next()");
            arrayList.add(next);
        }
        for (String str : arrayList) {
            if (!z || Companion.a(str)) {
                Object obj = jSONObject.get(str);
                if (obj instanceof Date) {
                    jSONObject.put(str, (Object) DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, (TimeZone) null, 2, (Object) null));
                }
                if (obj instanceof JSONArray) {
                    jSONObject.put(str, (Object) q.a((JSONArray) obj));
                }
                if (obj instanceof JSONObject) {
                    jSONObject.put(str, (Object) clean((JSONObject) obj, false));
                }
            } else {
                jSONObject.remove(str);
            }
        }
        return jSONObject;
    }

    static /* synthetic */ JSONObject clean$default(BrazeProperties brazeProperties, JSONObject jSONObject, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return brazeProperties.clean(jSONObject, z);
    }

    @JvmStatic
    public static final boolean isValidKey(String str) {
        return Companion.a(str);
    }

    public final BrazeProperties addProperty(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!Companion.a(str)) {
            return this;
        }
        try {
            if (obj instanceof Long) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), ((Number) obj).intValue());
            } else if (obj instanceof Double) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), ((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), ((Boolean) obj).booleanValue());
            } else if (obj instanceof Date) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), (Object) DateTimeUtils.formatDate$default((Date) obj, BrazeDateFormat.LONG, (TimeZone) null, 2, (Object) null));
            } else if (obj instanceof String) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), (Object) ValidationUtils.ensureBrazeFieldLength((String) obj));
            } else if (obj instanceof JSONArray) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), (Object) q.a((JSONArray) obj));
            } else if (obj instanceof JSONObject) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), (Object) clean$default(this, (JSONObject) obj, false, 2, (Object) null));
            } else if (obj instanceof Map) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), (Object) clean$default(this, new JSONObject((Map<?, ?>) q.a((Map) obj)), false, 2, (Object) null));
            } else if (obj == null) {
                this.propertiesJSONObject.put(ValidationUtils.ensureBrazeFieldLength(str), JSONObject.NULL);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(str), 2, (Object) null);
            }
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) c.b);
        }
        return this;
    }

    public final BrazeProperties clone() {
        try {
            return new BrazeProperties(new JSONObject(forJsonPut().toString()));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) d.b);
            return null;
        }
    }

    public final boolean containsProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.propertiesJSONObject.has(str);
    }

    public final Object get(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return this.propertiesJSONObject.get(str);
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) e.b);
            return null;
        }
    }

    public final long getByteSize() {
        String jSONObject = this.propertiesJSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "propertiesJSONObject.toString()");
        return StringUtils.getByteSize(jSONObject);
    }

    public final int getSize() {
        return this.propertiesJSONObject.length();
    }

    public final boolean isInvalid() {
        return getByteSize() > Constants.EVENT_PROPERTIES_MAX_SIZE_BYTES;
    }

    public final Object removeProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.propertiesJSONObject.remove(str);
    }

    public JSONObject forJsonPut() {
        return this.propertiesJSONObject;
    }

    public BrazeProperties(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.propertiesJSONObject = clean$default(this, jSONObject, false, 2, (Object) null);
    }

    public BrazeProperties(Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(map, AdaptyImmutableMapTypeAdapterFactory.MAP);
        this.propertiesJSONObject = clean$default(this, new JSONObject((Map<?, ?>) q.a((Map) map)), false, 2, (Object) null);
    }
}
