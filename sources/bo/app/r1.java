package bo.app;

import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

public final class r1 extends r {
    public static final a v = new a((DefaultConstructorMarker) null);
    private final x1 t;
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
            return "GeofenceRefreshRequest executed successfully.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while creating geofence refresh request. Returning null.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r1(l5 l5Var, String str, IBrazeLocation iBrazeLocation) {
        super(new b5(str + "geofence/request"), (String) null, l5Var, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(str, "urlBase");
        Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
        this.t = j.h.a(iBrazeLocation);
    }

    public void a(i2 i2Var, i2 i2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
    }

    public boolean c() {
        return this.u;
    }

    public JSONObject e() {
        JSONObject e = super.e();
        if (e == null) {
            return null;
        }
        try {
            x1 x1Var = this.t;
            if (x1Var != null) {
                e.put("location_event", x1Var.forJsonPut());
            }
            return e;
        } catch (JSONException e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) c.b);
            return null;
        }
    }
}