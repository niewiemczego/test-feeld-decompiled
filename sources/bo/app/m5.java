package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class m5 {
    private final p2 a;

    public m5(p2 p2Var) {
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        this.a = p2Var;
    }

    public final p2 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m5) && Intrinsics.areEqual((Object) this.a, (Object) ((m5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ServerResponseErrorEvent(responseError=" + this.a + ')';
    }
}
