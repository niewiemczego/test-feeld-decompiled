package bo.app;

import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class c0 implements t2 {
    private String b;

    public c0(JSONObject jSONObject) {
        this.b = jSONObject.getJSONObject("data").getString(AnalyticsEventTypeAdapter.EVENT_NAME);
    }

    public boolean a(u2 u2Var) {
        if (!(u2Var instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) u2Var;
        return !StringUtils.isNullOrBlank(d0Var.f()) && d0Var.f().equals(this.b);
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "custom_event");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AnalyticsEventTypeAdapter.EVENT_NAME, (Object) this.b);
            jSONObject.put("data", (Object) jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
