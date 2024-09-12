package bo.app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public abstract class t6 extends r6 {
    private Map h = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected t6(JSONObject jSONObject) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
    }

    public void a(Map map) {
        Intrinsics.checkNotNullParameter(map, "remoteAssetToLocalAssetPaths");
        this.h = new HashMap(map);
    }

    public Map y() {
        return MapsKt.toMap(this.h);
    }
}
