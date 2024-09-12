package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.DeviceKey;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.StringUtils;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class j0 extends a {
    public static final a f = new a((DefaultConstructorMarker) null);
    private final BrazeConfigurationProvider b;
    private final SharedPreferences c;
    private final SharedPreferences d;
    private i0 e;

    public static final class a {

        /* renamed from: bo.app.j0$a$a  reason: collision with other inner class name */
        static final class C0015a extends Lambda implements Function0 {
            public static final C0015a b = new C0015a();

            C0015a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught json exception while creating the diff. Returning null";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "shouldReportPushPermissionsAsGranted: Returning true given that push is permissible now and notifications enabled transitioned to true.";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "shouldReportPushPermissionsAsGranted: Returning true since notifications enabled is true and device has upgraded to Tiramisu or beyond.";
            }
        }

        static final class d extends Lambda implements Function0 {
            public static final d b = new d();

            d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Returning false for shouldReportPushPermissionsAsGranted.";
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
            JSONObject jSONObject3 = new JSONObject();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject2.opt(next);
                Object opt2 = jSONObject.opt(next);
                if (opt != null) {
                    try {
                        if (opt instanceof JSONObject) {
                            if (opt2 == null || !JsonUtils.areJsonObjectsEqual((JSONObject) opt, (JSONObject) opt2)) {
                                jSONObject3.put(next, opt);
                            }
                        } else if (!Intrinsics.areEqual(opt, opt2)) {
                            jSONObject3.put(next, opt);
                        }
                    } catch (JSONException e) {
                        BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) C0015a.b);
                        return null;
                    }
                }
            }
            return jSONObject3;
        }

        /* access modifiers changed from: private */
        public final JSONObject a(SharedPreferences sharedPreferences) {
            String str = "{}";
            String string = sharedPreferences.getString("cached_device", str);
            if (string != null) {
                str = string;
            }
            return new JSONObject(str);
        }

        public final boolean a(JSONObject jSONObject, JSONObject jSONObject2, int i, int i2) {
            boolean z;
            int i3;
            JSONObject jSONObject3 = jSONObject;
            JSONObject jSONObject4 = jSONObject2;
            Intrinsics.checkNotNullParameter(jSONObject3, "cachedDeviceJson");
            Intrinsics.checkNotNullParameter(jSONObject4, "liveDeviceJson");
            if (i2 >= 33) {
                i3 = i;
                z = true;
            } else {
                i3 = i;
                z = false;
            }
            boolean z2 = !(i3 >= 33) && z;
            DeviceKey deviceKey = DeviceKey.NOTIFICATIONS_ENABLED;
            boolean optBoolean = jSONObject4.optBoolean(deviceKey.getKey(), false);
            boolean z3 = optBoolean && !jSONObject3.optBoolean(deviceKey.getKey(), false);
            if (z && z3) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
                return true;
            } else if (!optBoolean || !z2) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) d.b, 2, (Object) null);
                return false;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
                return true;
            }
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception confirming and unlocking device cache.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sending full device on next export but keeping cache intact.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception confirming and unlocking JSON objects.";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to generate diff between the cached and live device. Returning the live device.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Remote Notification Enabled changed to true. Updating user subscription.";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(boolean z, boolean z2) {
            super(0);
            this.b = z;
            this.c = z2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exporting the full device due to either: shouldShouldFullDeviceOnNextExport: " + this.b + ", shouldReportPushPermissionsAsGranted: " + this.c;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(Context context, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final void a(i0 i0Var) {
        this.e = i0Var;
    }

    public final void e() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) c.b, 2, (Object) null);
        this.d.edit().putBoolean("sfone", true).apply();
    }

    /* renamed from: f */
    public i0 d() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = new JSONObject();
        i0 i0Var = this.e;
        if (i0Var == null || (jSONObject = i0Var.forJsonPut()) == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject3 = f.a(this.c);
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) d.b);
        }
        a aVar = f;
        SharedPreferences sharedPreferences = this.d;
        int i = Build.VERSION.SDK_INT;
        boolean a2 = aVar.a(jSONObject3, jSONObject, sharedPreferences.getInt("ldov", i), i);
        boolean z = this.d.getBoolean("sfone", false);
        if (z || a2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new g(z, a2), 3, (Object) null);
            jSONObject2 = aVar.a(new JSONObject(), jSONObject);
        } else {
            jSONObject2 = aVar.a(jSONObject3, jSONObject);
        }
        if (jSONObject2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) e.b, 3, (Object) null);
            return this.e;
        }
        i0 a3 = i0.o.a(this.b, jSONObject2);
        if (a2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) f.b, 2, (Object) null);
            a3.a(true);
        }
        return a3;
    }

    public j0(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = new BrazeConfigurationProvider(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.device_cache.v3" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.c = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.braze.storage.device_cache.metadata" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.d = sharedPreferences2;
    }

    /* renamed from: a */
    public void b(i0 i0Var, boolean z) {
        Intrinsics.checkNotNullParameter(i0Var, "outboundObject");
        if (z) {
            try {
                this.c.edit().putString("cached_device", JsonUtils.mergeJsonObjects(f.a(this.c), i0Var.forJsonPut()).toString()).apply();
                this.d.edit().putBoolean("sfone", false).putInt("ldov", Build.VERSION.SDK_INT).apply();
            } catch (JSONException e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) b.b);
            }
        }
    }
}
