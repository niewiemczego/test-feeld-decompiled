package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class z4 {
    private final a2 a;

    public z4(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        this.a = a2Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof z4) && Intrinsics.areEqual((Object) this.a, (Object) ((z4) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RequestNetworkErrorEvent(request=" + this.a + ')';
    }
}
