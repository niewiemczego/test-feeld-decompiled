package bo.app;

import com.braze.support.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

public final class c4 implements t2 {
    String b;

    public c4(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && !optJSONObject.isNull("product_id")) {
            this.b = optJSONObject.optString("product_id", (String) null);
        }
    }

    public boolean a(u2 u2Var) {
        if (!(u2Var instanceof d4)) {
            return false;
        }
        if (StringUtils.isNullOrBlank(this.b)) {
            return true;
        }
        d4 d4Var = (d4) u2Var;
        if (StringUtils.isNullOrBlank(d4Var.f()) || !d4Var.f().equals(this.b)) {
            return false;
        }
        return true;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) FirebaseAnalytics.Event.PURCHASE);
            if (this.b != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("product_id", this.b);
                jSONObject.putOpt("data", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
