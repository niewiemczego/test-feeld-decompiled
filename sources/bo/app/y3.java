package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class y3 implements IPutIntoJson, h2 {
    public static final b f = new b((DefaultConstructorMarker) null);
    private final String b;
    private final Boolean c;
    private final Boolean d;
    private final x3 e;

    public static final class a {
        private String a;
        private Boolean b;
        private Boolean c;
        private x3 d;

        public a(String str, Boolean bool, Boolean bool2, x3 x3Var) {
            this.a = str;
            this.b = bool;
            this.c = bool2;
            this.d = x3Var;
        }

        public final void a(String str) {
            this.a = str;
        }

        public final Boolean b() {
            return this.b;
        }

        public final Boolean c() {
            return this.c;
        }

        public final a d() {
            this.b = Boolean.TRUE;
            return this;
        }

        public final a e() {
            this.c = Boolean.TRUE;
            return this;
        }

        public final a a(x3 x3Var) {
            Intrinsics.checkNotNullParameter(x3Var, "outboundConfigParams");
            this.d = x3Var;
            return this;
        }

        public final a b(String str) {
            this.a = str;
            return this;
        }

        public final y3 a() {
            return new y3(this.a, this.b, this.c, this.d, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(String str, Boolean bool, Boolean bool2, x3 x3Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : x3Var);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    public /* synthetic */ y3(String str, Boolean bool, Boolean bool2, x3 x3Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bool, bool2, x3Var);
    }

    public boolean isEmpty() {
        x3 x3Var;
        JSONObject u = forJsonPut();
        if (u.length() == 0) {
            return true;
        }
        if (this.c == null && this.d == null && (x3Var = this.e) != null) {
            return x3Var.isEmpty();
        }
        if (u.length() == 1) {
            return u.has("user_id");
        }
        return false;
    }

    /* renamed from: u */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        String str = this.b;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put("user_id", (Object) this.b);
        }
        Boolean bool = this.c;
        if (bool != null) {
            jSONObject.put("feed", bool.booleanValue());
        }
        Boolean bool2 = this.d;
        if (bool2 != null) {
            jSONObject.put("triggers", bool2.booleanValue());
        }
        x3 x3Var = this.e;
        if (x3Var != null) {
            jSONObject.put("config", (Object) x3Var.forJsonPut());
        }
        return jSONObject;
    }

    public final boolean v() {
        return this.e != null;
    }

    public final boolean w() {
        return this.c != null;
    }

    public final boolean x() {
        return this.d != null;
    }

    public final boolean y() {
        String str = this.b;
        return !(str == null || str.length() == 0);
    }

    private y3(String str, Boolean bool, Boolean bool2, x3 x3Var) {
        this.b = str;
        this.c = bool;
        this.d = bool2;
        this.e = x3Var;
    }
}
