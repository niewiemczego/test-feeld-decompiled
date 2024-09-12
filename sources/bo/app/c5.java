package bo.app;

import com.braze.support.BrazeLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.sentry.ProfilingTraceData;
import io.sentry.protocol.SentryThread;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class c5 implements q2 {
    public static final a i = new a((DefaultConstructorMarker) null);
    private final long b;
    private final long c;
    private final int d;
    private final int e;
    private final int f;
    private final m2 g;
    private final int h;

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
            return "Could not convert ScheduleConfig to JSON";
        }
    }

    public c5(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        this.b = jSONObject.optLong("start_time", -1);
        this.c = jSONObject.optLong(SDKConstants.PARAM_TOURNAMENTS_END_TIME, -1);
        this.d = jSONObject.optInt(SentryThread.JsonKeys.PRIORITY, 0);
        this.h = jSONObject.optInt("min_seconds_since_last_trigger", -1);
        this.e = jSONObject.optInt("delay", 0);
        this.f = jSONObject.optInt(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, -1);
        this.g = new r4(jSONObject);
    }

    public long b() {
        return this.b;
    }

    public m2 i() {
        return this.g;
    }

    public int j() {
        return this.d;
    }

    public int k() {
        return this.f;
    }

    public int o() {
        return this.e;
    }

    public long p() {
        return this.c;
    }

    public int r() {
        return this.h;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = (JSONObject) i().forJsonPut();
            if (jSONObject == null) {
                return null;
            }
            jSONObject.put("start_time", b());
            jSONObject.put(SDKConstants.PARAM_TOURNAMENTS_END_TIME, p());
            jSONObject.put(SentryThread.JsonKeys.PRIORITY, j());
            jSONObject.put("min_seconds_since_last_trigger", r());
            jSONObject.put(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, k());
            jSONObject.put("delay", o());
            return jSONObject;
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) b.b);
            return null;
        }
    }
}
