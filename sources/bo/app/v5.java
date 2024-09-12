package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.sentry.cache.EnvelopeCache;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class v5 implements r2 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final SharedPreferences a;

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
            return "Failed to set end time to now for session json data";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No stored open session in storage.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not create new mutable session for open session.";
        }
    }

    public v5(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context.getSharedPreferences("com.appboy.storage.session_storage" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
    }

    public n5 a() {
        String str = "";
        if (!this.a.contains("current_open_session")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
            return null;
        }
        try {
            String string = this.a.getString(this.a.getString("current_open_session", str), str);
            if (string != null) {
                str = string;
            }
            return new n5(new JSONObject(str));
        } catch (JSONException e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) d.b);
            return null;
        }
    }

    public void a(n5 n5Var) {
        Intrinsics.checkNotNullParameter(n5Var, EnvelopeCache.PREFIX_CURRENT_SESSION_FILE);
        String p5Var = n5Var.s().toString();
        JSONObject u = n5Var.forJsonPut();
        SharedPreferences.Editor edit = this.a.edit();
        a(u);
        edit.putString(p5Var, u.toString());
        if (!n5Var.y()) {
            edit.putString("current_open_session", p5Var);
        } else if (Intrinsics.areEqual((Object) this.a.getString("current_open_session", ""), (Object) p5Var)) {
            edit.remove("current_open_session");
        }
        edit.apply();
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        SharedPreferences.Editor edit = this.a.edit();
        edit.remove(str);
        if (Intrinsics.areEqual((Object) str, (Object) this.a.getString("current_open_session", (String) null))) {
            edit.remove("current_open_session");
        }
        edit.apply();
    }

    private final void a(JSONObject jSONObject) {
        if (!jSONObject.has(SDKConstants.PARAM_TOURNAMENTS_END_TIME)) {
            try {
                jSONObject.put(SDKConstants.PARAM_TOURNAMENTS_END_TIME, DateTimeUtils.nowInSecondsPrecise());
            } catch (JSONException e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
            }
        }
    }
}
