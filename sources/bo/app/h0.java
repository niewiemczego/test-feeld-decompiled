package bo.app;

import bo.app.y3;
import com.braze.support.BrazeLogger;
import com.facebook.internal.ServerProtocol;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class h0 extends r {
    public static final a v = new a((DefaultConstructorMarker) null);
    private y3 t;
    private final boolean u;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "DataSyncRequest executed successfully.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while retrieving parameters. Returning null.";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(l5 l5Var, String str, y3 y3Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l5Var, str, (i & 4) != 0 ? new y3.a((String) null, (Boolean) null, (Boolean) null, (x3) null, 15, (DefaultConstructorMarker) null).a() : y3Var);
    }

    public void a(i2 i2Var, i2 i2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
    }

    public boolean c() {
        y3 f = f();
        return (f != null && f.isEmpty()) && super.c();
    }

    public JSONObject e() {
        JSONObject e = super.e();
        if (e == null) {
            return null;
        }
        try {
            y3 f = f();
            e.put("respond_with", (Object) f != null ? f.forJsonPut() : null);
            return e;
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) c.b);
            return null;
        }
    }

    public y3 f() {
        return this.t;
    }

    public boolean h() {
        return this.u;
    }

    public void a(Map map) {
        boolean z;
        Intrinsics.checkNotNullParameter(map, "existingHeaders");
        super.a(map);
        y3 f = f();
        boolean z2 = false;
        boolean z3 = true;
        if (!(f != null && f.isEmpty())) {
            y3 f2 = f();
            if (f2 != null && f2.w()) {
                map.put("X-Braze-FeedRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                z = true;
            } else {
                z = false;
            }
            y3 f3 = f();
            if (f3 != null && f3.x()) {
                z2 = true;
            }
            if (z2) {
                map.put("X-Braze-TriggersRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            } else {
                z3 = z;
            }
            if (z3) {
                map.put("X-Braze-DataRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(l5 l5Var, String str, y3 y3Var) {
        super(new b5(str + "data"), (String) null, l5Var, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(str, "urlBase");
        this.t = y3Var;
        this.u = true;
    }
}
