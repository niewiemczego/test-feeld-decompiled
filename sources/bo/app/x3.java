package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

public final class x3 implements IPutIntoJson, h2 {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final long b;
    private final boolean c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public x3(long j, boolean z) {
        this.b = j;
        this.c = z;
    }

    public boolean isEmpty() {
        return !this.c;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("config_time", this.b);
        return jSONObject;
    }
}
