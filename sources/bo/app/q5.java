package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class q5 {
    private final n5 a;

    public q5(n5 n5Var) {
        Intrinsics.checkNotNullParameter(n5Var, "sealedSession");
        this.a = n5Var;
    }

    public final n5 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q5) && Intrinsics.areEqual((Object) this.a, (Object) ((q5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SessionSealedEvent(sealedSession=" + this.a + ')';
    }
}
