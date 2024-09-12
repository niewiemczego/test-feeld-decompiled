package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.braze.enums.Gender;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.models.outgoing.AttributionData;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import com.facebook.appevents.UserDataStore;
import io.sentry.protocol.Device;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class w6 extends a {
    public static final a g = new a((DefaultConstructorMarker) null);
    private final l2 b;
    private final g5 c;
    private final SharedPreferences d;
    private final SharedPreferences e;
    private String f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No push token available to add to attributes object.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Couldn't add push token to outbound json";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not create custom attributes json object from preferences";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add merged custom attributes back to user object.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push token cache cleared.";
        }
    }

    static final class g extends Lambda implements Function1 {
        final /* synthetic */ w6 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(w6 w6Var) {
            super(1);
            this.b = w6Var;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            boolean unused = this.b.c("user_id", str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to load user object json from prefs with json string: " + this.b;
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ JSONObject c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(String str, JSONObject jSONObject) {
            super(0);
            this.b = str;
            this.c = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to write to user object json from prefs with key: [" + this.b + "] value: [" + this.c + "] ";
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not writing to user cache.";
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not write to custom attributes json object with key: [" + this.b + "] value: [" + this.c + ']';
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(String str, Object obj) {
            super(0);
            this.b = str;
            this.c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to write to user object json from prefs with key: [" + this.b + "] value: [" + this.c + ']';
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w6(Context context, l2 l2Var, g5 g5Var, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, l2Var, g5Var, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2);
    }

    private final JSONObject e() {
        JSONObject f2 = f();
        if (f2.has(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM)) {
            try {
                JSONObject jSONObject = f2.getJSONObject(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "userObjectFromCache.getJ…OM_ATTRIBUTES_OBJECT_KEY)");
                return jSONObject;
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) d.b);
            }
        }
        return new JSONObject();
    }

    public final synchronized boolean c(String str) {
        return c("email", str);
    }

    public final JSONObject f() {
        String string = this.d.getString("user_cache_attributes_object", (String) null);
        if (string == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new h(string));
            return new JSONObject();
        }
    }

    public final synchronized void g(String str) {
        c("last_name", str);
    }

    public final synchronized boolean h(String str) {
        return c("phone", str);
    }

    public final synchronized void i(String str) {
        this.f = str;
        c("user_id", str);
    }

    public final synchronized boolean j(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return b(ValidationUtils.ensureBrazeFieldLength(str), JSONObject.NULL);
    }

    public w6(Context context, l2 l2Var, g5 g5Var, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(l2Var, "pushRegistrationDataProvider");
        Intrinsics.checkNotNullParameter(g5Var, "sdkEnablementProvider");
        this.b = l2Var;
        this.c = g5Var;
        this.f = str;
        String cacheFileSuffix = StringUtils.getCacheFileSuffix(context, str, str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.user_cache.v3" + cacheFileSuffix, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.d = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.braze.storage.user_cache.push_token_store" + cacheFileSuffix, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.e = sharedPreferences2;
    }

    /* access modifiers changed from: private */
    public final boolean c(String str, Object obj) {
        Object obj2;
        JSONObject f2 = f();
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new l(str, obj));
                return false;
            }
        } else {
            obj2 = obj;
        }
        f2.put(str, obj2);
        return b(f2);
    }

    public final synchronized void a(Gender gender) {
        c(HintConstants.AUTOFILL_HINT_GENDER, gender != null ? gender.forJsonPut() : null);
    }

    public final synchronized boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return c("dob", str);
    }

    public final synchronized void d(String str) {
        c("first_name", str);
    }

    public final synchronized void g() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) f.b, 2, (Object) null);
        this.e.edit().clear().apply();
    }

    /* renamed from: h */
    public z3 d() {
        StringUtils.ifNonEmpty(this.f, new g(this));
        JSONObject f2 = f();
        a(f2);
        this.d.edit().clear().apply();
        return new z3(f2);
    }

    public final synchronized void a(String str) {
        c(UserDataStore.COUNTRY, str);
    }

    public final synchronized void a(NotificationSubscriptionType notificationSubscriptionType) {
        c("email_subscribe", notificationSubscriptionType != null ? notificationSubscriptionType.forJsonPut() : null);
    }

    public final synchronized void b(NotificationSubscriptionType notificationSubscriptionType) {
        c("push_subscribe", notificationSubscriptionType != null ? notificationSubscriptionType.forJsonPut() : null);
    }

    public final synchronized void a(AttributionData attributionData) {
        a("ab_install_attribution", attributionData != null ? attributionData.forJsonPut() : null);
    }

    private final boolean b(JSONObject jSONObject) {
        if (this.c.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) j.b, 2, (Object) null);
            return false;
        }
        this.d.edit().putString("user_cache_attributes_object", jSONObject.toString()).apply();
        return true;
    }

    public final synchronized boolean a(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        return b(str, obj);
    }

    public final void a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "outboundJson");
        try {
            String a2 = this.b.a();
            if (a2 == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
            } else if (!Intrinsics.areEqual((Object) a2, (Object) this.e.getString("push_token", (String) null))) {
                jSONObject.put("push_token", (Object) a2);
            }
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) c.b);
        }
    }

    public final synchronized void f(String str) {
        c(Device.JsonKeys.LANGUAGE, str);
    }

    public final synchronized void e(String str) {
        c("home_city", str);
    }

    public final boolean b(String str, Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject e2 = e();
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (JSONException e3) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e3, (Function0<String>) new k(str, obj));
                return false;
            }
        } else {
            obj2 = obj;
        }
        e2.put(str, obj2);
        return c(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM, e2);
    }

    /* renamed from: a */
    public void b(z3 z3Var, boolean z) {
        Intrinsics.checkNotNullParameter(z3Var, "outboundObject");
        JSONObject v = z3Var.v();
        if (!z) {
            JSONObject f2 = f();
            JSONObject plus = JsonUtils.plus(v, f2);
            plus.remove("push_token");
            JSONObject optJSONObject = f2.optJSONObject(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM);
            JSONObject optJSONObject2 = v.optJSONObject(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM);
            if (optJSONObject != null && optJSONObject2 != null) {
                try {
                    plus.put(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM, (Object) JsonUtils.plus(optJSONObject2, optJSONObject));
                } catch (JSONException e2) {
                    BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) e.b);
                }
            } else if (optJSONObject != null) {
                plus.put(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM, (Object) optJSONObject);
            } else if (optJSONObject2 != null) {
                plus.put(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM, (Object) optJSONObject2);
            }
            this.d.edit().putString("user_cache_attributes_object", plus.toString()).apply();
        } else if (v.has("push_token")) {
            this.e.edit().putString("push_token", v.optString("push_token")).apply();
        }
    }

    public final boolean a(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject f2 = f();
        if (jSONObject == null) {
            try {
                f2.put(str, JSONObject.NULL);
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new i(str, jSONObject));
                return false;
            }
        } else {
            JSONObject optJSONObject = f2.optJSONObject(str);
            if (optJSONObject != null) {
                f2.put(str, (Object) JsonUtils.plus(optJSONObject, jSONObject));
            } else {
                f2.put(str, (Object) jSONObject);
            }
        }
        return b(f2);
    }
}
