package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class r6 implements z2 {
    public static final a g = new a((DefaultConstructorMarker) null);
    private final String b;
    private final q2 c;
    private final boolean d;
    private o6 e;
    private final List f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ r6 b;
        final /* synthetic */ u2 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(r6 r6Var, u2 u2Var) {
            super(0);
            this.b = r6Var;
            this.c = u2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action " + this.b.getId() + " not eligible to be triggered by " + this.c.d() + " event. Current device time outside triggered action time window.";
        }
    }

    protected r6(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        String string = jSONObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(ID)");
        this.b = string;
        this.c = new c5(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("trigger_condition");
        if (jSONArray.length() > 0) {
            p6 p6Var = p6.a;
            Intrinsics.checkNotNullExpressionValue(jSONArray, "triggers");
            arrayList.addAll(p6Var.a(jSONArray));
        }
        this.d = jSONObject.optBoolean("prefetch", true);
    }

    private final boolean v() {
        return this.c.p() == -1 || DateTimeUtils.nowInSeconds() < this.c.p();
    }

    private final boolean w() {
        return this.c.b() == -1 || DateTimeUtils.nowInSeconds() > this.c.b();
    }

    private final boolean x() {
        return w() && v();
    }

    public void a(o6 o6Var) {
        this.e = o6Var;
    }

    public boolean b(u2 u2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "event");
        if (!x()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(this, u2Var), 3, (Object) null);
            return false;
        }
        Iterator it = this.f.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((t2) it.next()).a(u2Var)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            return true;
        }
        return false;
    }

    public o6 c() {
        return this.e;
    }

    public final boolean d() {
        return this.d;
    }

    public final String getId() {
        return this.b;
    }

    public final q2 n() {
        return this.c;
    }

    public JSONObject u() {
        try {
            JSONObject jSONObject = (JSONObject) this.c.forJsonPut();
            if (jSONObject == null) {
                return null;
            }
            jSONObject.put("id", (Object) this.b);
            JSONArray jSONArray = new JSONArray();
            for (t2 forJsonPut : this.f) {
                jSONArray.put(forJsonPut.forJsonPut());
            }
            jSONObject.put("trigger_condition", (Object) jSONArray);
            jSONObject.put("prefetch", this.d);
            return jSONObject;
        } catch (JSONException unused) {
        }
    }
}
