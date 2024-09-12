package bo.app;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

public final class z {
    public static final a e = new a((DefaultConstructorMarker) null);
    private final long a;
    private final long b;
    private final boolean c;
    private final JSONArray d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public z(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.a = jSONObject.optLong("last_card_updated_at", -1);
        this.b = jSONObject.optLong("last_full_sync_at", -1);
        this.c = jSONObject.optBoolean("full_sync", false);
        this.d = jSONObject.optJSONArray("cards");
    }

    public final JSONArray a() {
        return this.d;
    }

    public final long b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public z(String str) {
        Intrinsics.checkNotNullParameter(str, "serializedCardJson");
        this.c = false;
        this.a = -1;
        this.b = -1;
        this.d = new JSONArray().put((Object) new JSONObject(str));
    }
}
