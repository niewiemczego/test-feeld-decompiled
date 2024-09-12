package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class r4 implements m2 {
    public static final a c = new a((DefaultConstructorMarker) null);
    private final int b;

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
            return "Could not convert ReEligibilityConfig to JSON";
        }
    }

    public r4(int i) {
        this.b = i;
    }

    public boolean e() {
        return this.b == 0;
    }

    public Integer g() {
        int i = this.b;
        if (i > 0) {
            return Integer.valueOf(i);
        }
        return null;
    }

    public boolean h() {
        return this.b == -1;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            return new JSONObject().put("re_eligibility", this.b);
        } catch (JSONException e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
            return null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public r4(JSONObject jSONObject) {
        this(jSONObject.optInt("re_eligibility", -1));
        Intrinsics.checkNotNullParameter(jSONObject, "json");
    }
}
