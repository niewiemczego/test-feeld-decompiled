package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class l6 {
    private final u2 a;

    public l6(u2 u2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        this.a = u2Var;
    }

    public final u2 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l6) && Intrinsics.areEqual((Object) this.a, (Object) ((l6) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "TriggerEventEvent(triggerEvent=" + this.a + ')';
    }
}
