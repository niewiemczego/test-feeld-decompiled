package com.braze.models;

import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0007\u0018\u0000 '2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001(B-\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u00048\u0000X\u0004¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a¨\u0006)"}, d2 = {"Lcom/braze/models/FeatureFlag;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "forJsonPut", "", "key", "getStringProperty", "", "getNumberProperty", "", "getBooleanProperty", "(Ljava/lang/String;)Ljava/lang/Boolean;", "deepcopy$android_sdk_base_release", "()Lcom/braze/models/FeatureFlag;", "deepcopy", "expectedPropertyType", "", "getValue$android_sdk_base_release", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "getValue", "doesKeyExist$android_sdk_base_release", "(Ljava/lang/String;)Z", "doesKeyExist", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "enabled", "Z", "getEnabled", "()Z", "properties", "Lorg/json/JSONObject;", "getProperties", "()Lorg/json/JSONObject;", "trackingString", "getTrackingString$android_sdk_base_release", "<init>", "(Ljava/lang/String;ZLorg/json/JSONObject;Ljava/lang/String;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class FeatureFlag implements IPutIntoJson<JSONObject> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String ENABLED = "enabled";
    public static final String ID = "id";
    public static final String PROPERTIES = "properties";
    public static final String PROPERTIES_TYPE = "type";
    public static final String PROPERTIES_TYPE_BOOLEAN = "boolean";
    public static final String PROPERTIES_TYPE_NUMBER = "number";
    public static final String PROPERTIES_TYPE_STRING = "string";
    public static final String PROPERTIES_VALUE = "value";
    public static final String TRACKING_STRING = "fts";
    private final boolean enabled;
    private final String id;
    private final JSONObject properties;
    private final String trackingString;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ FeatureFlag c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, FeatureFlag featureFlag) {
            super(0);
            this.b = str;
            this.c = featureFlag;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Key " + this.b + " does not exist in properties " + this.c.getProperties() + '.';
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating FeatureFlag Json.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Property is not of type " + this.b + ". It is " + this.c + '.';
        }
    }

    public FeatureFlag(String str, boolean z, JSONObject jSONObject, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jSONObject, PROPERTIES);
        this.id = str;
        this.enabled = z;
        this.properties = jSONObject;
        this.trackingString = str2;
    }

    public final FeatureFlag deepcopy$android_sdk_base_release() {
        return new FeatureFlag(this.id, this.enabled, JsonUtils.deepcopy(this.properties), this.trackingString);
    }

    public final boolean doesKeyExist$android_sdk_base_release(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (this.properties.has(str)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(str, this), 2, (Object) null);
        return false;
    }

    public final Boolean getBooleanProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object value$android_sdk_base_release = getValue$android_sdk_base_release(str, "boolean");
        if (value$android_sdk_base_release instanceof Boolean) {
            return (Boolean) value$android_sdk_base_release;
        }
        return null;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final Number getNumberProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object value$android_sdk_base_release = getValue$android_sdk_base_release(str, "number");
        if (value$android_sdk_base_release instanceof Number) {
            return (Number) value$android_sdk_base_release;
        }
        return null;
    }

    public final JSONObject getProperties() {
        return this.properties;
    }

    public final String getStringProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object value$android_sdk_base_release = getValue$android_sdk_base_release(str, "string");
        if (value$android_sdk_base_release instanceof String) {
            return (String) value$android_sdk_base_release;
        }
        return null;
    }

    public final String getTrackingString$android_sdk_base_release() {
        return this.trackingString;
    }

    public final Object getValue$android_sdk_base_release(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "expectedPropertyType");
        if (!doesKeyExist$android_sdk_base_release(str)) {
            return null;
        }
        Object obj = this.properties.get(str);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject jSONObject = (JSONObject) obj;
        Object obj2 = jSONObject.get("type");
        if (Intrinsics.areEqual(obj2, (Object) str2)) {
            return jSONObject.get("value");
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new d(str2, obj2), 2, (Object) null);
        return null;
    }

    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", (Object) this.id);
            jSONObject.put("enabled", this.enabled);
            jSONObject.put(PROPERTIES, (Object) this.properties);
            jSONObject.put(TRACKING_STRING, (Object) this.trackingString);
        } catch (JSONException e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) c.b);
        }
        return jSONObject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeatureFlag(String str, boolean z, JSONObject jSONObject, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, jSONObject, (i & 8) != 0 ? null : str2);
    }
}
