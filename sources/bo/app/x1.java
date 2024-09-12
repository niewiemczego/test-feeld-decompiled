package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public interface x1 extends IPutIntoJson {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    h1 a();

    void a(p5 p5Var);

    void a(String str);

    String f() {
        String jSONObject = ((JSONObject) forJsonPut()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "forJsonPut().toString()");
        return jSONObject;
    }

    boolean m();

    JSONObject q();

    p5 s();

    String t();
}
