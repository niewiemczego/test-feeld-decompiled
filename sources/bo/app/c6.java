package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

public final class c6 implements t2 {
    public boolean a(u2 u2Var) {
        return u2Var instanceof d6;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "test");
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
