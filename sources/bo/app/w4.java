package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class w4 {
    private final a2 a;

    public w4(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        this.a = a2Var;
    }

    public final a2 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w4) && Intrinsics.areEqual((Object) this.a, (Object) ((w4) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RequestDispatchStartedEvent(request=" + this.a + ')';
    }
}
