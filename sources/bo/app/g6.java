package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class g6 implements t2 {
    private static final String c = BrazeLogger.getBrazeLogTag((Class<?>) g6.class);
    c b;

    public g6(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("property_filters");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                arrayList2.add(new a4(jSONArray2.getJSONObject(i2)));
            }
            arrayList.add(new w3(arrayList2));
        }
        this.b = new c(arrayList);
    }

    public boolean a(u2 u2Var) {
        return this.b.a(u2Var);
    }

    public JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("property_filters", (Object) this.b.forJsonPut());
            jSONObject.put("data", (Object) jSONObject2);
        } catch (JSONException e) {
            BrazeLogger.e(c, "Caught exception creating Json.", e);
        }
        return jSONObject;
    }
}
