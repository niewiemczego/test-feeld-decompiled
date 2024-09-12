package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class q0 {
    private final a2 a;

    public q0(a2 a2Var) {
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
        return (obj instanceof q0) && Intrinsics.areEqual((Object) this.a, (Object) ((q0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "DispatchSucceededEvent(request=" + this.a + ')';
    }
}
