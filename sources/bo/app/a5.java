package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class a5 {
    private final a2 a;

    public a5(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        this.a = a2Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a5) && Intrinsics.areEqual((Object) this.a, (Object) ((a5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RequestNetworkSuccessEvent(request=" + this.a + ')';
    }
}
