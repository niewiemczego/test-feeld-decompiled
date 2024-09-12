package bo.app;

import com.braze.support.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

public final class g4 implements t2 {
    private String b;

    public g4(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && !optJSONObject.isNull(FirebaseAnalytics.Param.CAMPAIGN_ID)) {
            this.b = optJSONObject.optString(FirebaseAnalytics.Param.CAMPAIGN_ID, (String) null);
        }
    }

    public boolean a(u2 u2Var) {
        if (!(u2Var instanceof h4)) {
            return false;
        }
        if (StringUtils.isNullOrBlank(this.b)) {
            return true;
        }
        h4 h4Var = (h4) u2Var;
        if (StringUtils.isNullOrBlank(h4Var.f()) || !h4Var.f().equals(this.b)) {
            return false;
        }
        return true;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "push_click");
            if (this.b != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(FirebaseAnalytics.Param.CAMPAIGN_ID, this.b);
                jSONObject.putOpt("data", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
