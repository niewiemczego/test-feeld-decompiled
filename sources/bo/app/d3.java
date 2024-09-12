package bo.app;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

public final class d3 {
    private final u2 a;
    private final z2 b;
    private final IInAppMessage c;
    private final String d;

    public d3(u2 u2Var, z2 z2Var, IInAppMessage iInAppMessage, String str) {
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        Intrinsics.checkNotNullParameter(z2Var, "triggeredAction");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        this.a = u2Var;
        this.b = z2Var;
        this.c = iInAppMessage;
        this.d = str;
    }

    public final u2 a() {
        return this.a;
    }

    public final z2 b() {
        return this.b;
    }

    public final IInAppMessage c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d3)) {
            return false;
        }
        d3 d3Var = (d3) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) d3Var.a) && Intrinsics.areEqual((Object) this.b, (Object) d3Var.b) && Intrinsics.areEqual((Object) this.c, (Object) d3Var.c) && Intrinsics.areEqual((Object) this.d, (Object) d3Var.d);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return StringsKt.trimIndent("\n             " + JsonUtils.getPrettyPrintedString((JSONObject) this.c.forJsonPut()) + "\n             Triggered Action Id: " + this.b.getId() + "\n             Trigger Event: " + this.a + "\n             User Id: " + this.d + "\n        ");
    }
}
