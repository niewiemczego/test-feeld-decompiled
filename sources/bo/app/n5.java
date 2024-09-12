package bo.app;

import bo.app.p5;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public class n5 implements IPutIntoJson {
    public static final a f = new a((DefaultConstructorMarker) null);
    private final p5 b;
    private final double c;
    private volatile Double d;
    private volatile boolean e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ double b;
        final /* synthetic */ n5 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(double d, n5 n5Var) {
            super(0);
            this.b = d;
            this.c = n5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "End time '" + this.b + "' for session is less than the start time '" + this.c.x() + "' for this session.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating Session Json.";
        }
    }

    public n5(p5 p5Var, double d2, Double d3, boolean z) {
        Intrinsics.checkNotNullParameter(p5Var, "sessionId");
        this.b = p5Var;
        this.c = d2;
        a(d3);
        this.e = z;
    }

    /* access modifiers changed from: protected */
    public void a(Double d2) {
        this.d = d2;
    }

    public final p5 s() {
        return this.b;
    }

    public String toString() {
        return "\nSession(sessionId=" + this.b + ", startTime=" + this.c + ", endTime=" + w() + ", isSealed=" + this.e + ", duration=" + v() + ')';
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("session_id", (Object) this.b);
            jSONObject.put("start_time", this.c);
            jSONObject.put("is_sealed", this.e);
            if (w() != null) {
                jSONObject.put(SDKConstants.PARAM_TOURNAMENTS_END_TIME, (Object) w());
            }
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) c.b);
        }
        return jSONObject;
    }

    public final long v() {
        Double w = w();
        if (w == null) {
            return -1;
        }
        double doubleValue = w.doubleValue();
        long j = (long) (doubleValue - this.c);
        if (j < 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(doubleValue, this), 2, (Object) null);
        }
        return j;
    }

    public Double w() {
        return this.d;
    }

    public final double x() {
        return this.c;
    }

    public final boolean y() {
        return this.e;
    }

    public final n3 z() {
        return new n3(this.b, this.c, w(), this.e);
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        this.e = z;
    }

    public n5(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "sessionData");
        p5.a aVar = p5.d;
        String string = jSONObject.getString("session_id");
        Intrinsics.checkNotNullExpressionValue(string, "sessionData.getString(SESSION_ID_KEY)");
        this.b = aVar.a(string);
        this.c = jSONObject.getDouble("start_time");
        this.e = jSONObject.getBoolean("is_sealed");
        a(JsonUtils.getDoubleOrNull(jSONObject, SDKConstants.PARAM_TOURNAMENTS_END_TIME));
    }
}
