package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class e4 extends g6 {
    private static final String e = BrazeLogger.getBrazeLogTag((Class<?>) e4.class);
    private String d;

    public e4(JSONObject jSONObject) {
        super(jSONObject);
        this.d = jSONObject.getJSONObject("data").getString("product_id");
    }

    public boolean a(u2 u2Var) {
        if (!(u2Var instanceof d4) || StringUtils.isNullOrBlank(this.d)) {
            return false;
        }
        d4 d4Var = (d4) u2Var;
        if (!StringUtils.isNullOrBlank(d4Var.f()) && d4Var.f().equals(this.d)) {
            return super.a(u2Var);
        }
        return false;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        JSONObject u = super.u();
        try {
            u.put("type", (Object) "purchase_property");
            JSONObject jSONObject = u.getJSONObject("data");
            jSONObject.put("product_id", (Object) this.d);
            u.put("data", (Object) jSONObject);
        } catch (JSONException e2) {
            BrazeLogger.e(e, "Caught exception creating Json.", e2);
        }
        return u;
    }
}
