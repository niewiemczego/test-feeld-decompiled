package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

public final class u3 implements t2 {
    public boolean a(u2 u2Var) {
        return u2Var instanceof v3;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) TtmlNode.TEXT_EMPHASIS_MARK_OPEN);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
