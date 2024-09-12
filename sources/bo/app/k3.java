package bo.app;

import com.braze.support.BrazeLogger;
import java.util.List;
import org.json.JSONArray;

public abstract class k3 implements c2 {
    private static final String c = BrazeLogger.getBrazeLogTag((Class<?>) k3.class);
    protected final List b;

    protected k3(List list) {
        this.b = list;
    }

    /* renamed from: u */
    public JSONArray forJsonPut() {
        JSONArray jSONArray = new JSONArray();
        try {
            for (c2 forJsonPut : this.b) {
                jSONArray.put(forJsonPut.forJsonPut());
            }
        } catch (Exception e) {
            BrazeLogger.e(c, "Caught exception creating Json.", e);
        }
        return jSONArray;
    }
}
