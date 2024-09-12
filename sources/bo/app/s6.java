package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class s6 {
    private final u2 a;
    private final z2 b;

    public s6(u2 u2Var, z2 z2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "originalTriggerEvent");
        Intrinsics.checkNotNullParameter(z2Var, "failedTriggeredAction");
        this.a = u2Var;
        this.b = z2Var;
    }

    public final u2 a() {
        return this.a;
    }

    public final z2 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s6)) {
            return false;
        }
        s6 s6Var = (s6) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) s6Var.a) && Intrinsics.areEqual((Object) this.b, (Object) s6Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "TriggeredActionRetryEvent(originalTriggerEvent=" + this.a + ", failedTriggeredAction=" + this.b + ')';
    }
}
