package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class i6 {
    private final a2 a;

    public i6(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        this.a = a2Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i6) && Intrinsics.areEqual((Object) this.a, (Object) ((i6) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "TriggerDispatchStartedEvent(request=" + this.a + ')';
    }
}
