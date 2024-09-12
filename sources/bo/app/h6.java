package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class h6 {
    private final a2 a;

    public h6(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        this.a = a2Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h6) && Intrinsics.areEqual((Object) this.a, (Object) ((h6) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "TriggerDispatchCompletedEvent(request=" + this.a + ')';
    }
}
