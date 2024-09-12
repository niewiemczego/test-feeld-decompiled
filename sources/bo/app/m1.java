package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class m1 {
    private final n1 a;

    public m1(n1 n1Var) {
        Intrinsics.checkNotNullParameter(n1Var, "request");
        this.a = n1Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m1) && Intrinsics.areEqual((Object) this.a, (Object) ((m1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "FeatureFlagsRequestSuccessEvent(request=" + this.a + ')';
    }
}
