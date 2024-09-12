package bo.app;

import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class e0 extends g6 {
    private static final String e = BrazeLogger.getBrazeLogTag((Class<?>) e0.class);
    private String d;

    public e0(JSONObject jSONObject) {
        super(jSONObject);
        this.d = jSONObject.getJSONObject("data").getString(AnalyticsEventTypeAdapter.EVENT_NAME);
    }

    public boolean a(u2 u2Var) {
        if (!(u2Var instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) u2Var;
        if (StringUtils.isNullOrBlank(d0Var.f()) || !d0Var.f().equals(this.d)) {
            return false;
        }
        return super.a(u2Var);
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        JSONObject u = super.u();
        try {
            u.put("type", (Object) "custom_event_property");
            JSONObject jSONObject = u.getJSONObject("data");
            jSONObject.put(AnalyticsEventTypeAdapter.EVENT_NAME, (Object) this.d);
            u.put("data", (Object) jSONObject);
        } catch (JSONException e2) {
            BrazeLogger.e(e, "Caught exception creating CustomEventWithPropertiesTriggerCondition Json.", e2);
        }
        return u;
    }
}
