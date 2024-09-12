package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class v4 {
    private final a2 a;

    public v4(a2 a2Var) {
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
        return (obj instanceof v4) && Intrinsics.areEqual((Object) this.a, (Object) ((v4) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RequestDispatchCompletedEvent(request=" + this.a + ')';
    }
}
