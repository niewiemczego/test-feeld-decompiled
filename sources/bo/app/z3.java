package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

public final class z3 implements IPutIntoJson, h2 {
    private final JSONObject b;
    private final JSONArray c;

    public z3(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "userObject");
        this.b = jSONObject;
        this.c = new JSONArray().put((Object) jSONObject);
    }

    public boolean isEmpty() {
        if (this.b.length() == 0) {
            return true;
        }
        if (this.b.length() != 1 || !this.b.has("user_id")) {
            return false;
        }
        return true;
    }

    /* renamed from: u */
    public JSONArray forJsonPut() {
        JSONArray jSONArray = this.c;
        Intrinsics.checkNotNullExpressionValue(jSONArray, "jsonArrayForJsonPut");
        return jSONArray;
    }

    public final JSONObject v() {
        return this.b;
    }
}
