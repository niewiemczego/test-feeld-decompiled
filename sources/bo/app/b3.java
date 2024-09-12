package bo.app;

import com.braze.support.StringUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b3 implements t2 {
    private String b;
    private Set c = new HashSet();

    public b3(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        this.b = jSONObject2.getString("id");
        JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.c.add(optJSONArray.getString(i));
            }
        }
    }

    public boolean a(u2 u2Var) {
        if (u2Var instanceof c3) {
            c3 c3Var = (c3) u2Var;
            if (!StringUtils.isNullOrBlank(c3Var.g()) && c3Var.g().equals(this.b)) {
                if (this.c.size() <= 0) {
                    return StringUtils.isNullOrBlank(c3Var.f());
                }
                if (StringUtils.isNullOrBlank(c3Var.f()) || !this.c.contains(c3Var.f())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "iam_click");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", (Object) this.b);
            if (this.c.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : this.c) {
                    jSONArray.put((Object) put);
                }
                jSONObject2.put("buttons", (Object) jSONArray);
            }
            jSONObject.put("data", (Object) jSONObject2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
