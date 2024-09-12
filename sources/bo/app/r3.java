package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class r3 {
    private final q3 a;
    private final q3 b;

    public r3(q3 q3Var, q3 q3Var2) {
        Intrinsics.checkNotNullParameter(q3Var, "oldNetworkLevel");
        Intrinsics.checkNotNullParameter(q3Var2, "newNetworkLevel");
        this.a = q3Var;
        this.b = q3Var2;
    }

    public final q3 a() {
        return this.b;
    }

    public final q3 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r3)) {
            return false;
        }
        r3 r3Var = (r3) obj;
        return this.a == r3Var.a && this.b == r3Var.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "NetworkLevelChangeEvent(oldNetworkLevel=" + this.a + ", newNetworkLevel=" + this.b + ')';
    }
}
