package bo.app;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class o0 {
    private final a2 a;
    private final JSONObject b;

    public o0(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        this.a = a2Var;
        this.b = a2Var.e();
    }

    public final a2 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o0) && Intrinsics.areEqual((Object) this.a, (Object) ((o0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "DispatchFailedEvent(request=" + this.a + ')';
    }
}
